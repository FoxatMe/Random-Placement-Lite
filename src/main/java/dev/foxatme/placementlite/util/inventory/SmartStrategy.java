package dev.foxatme.placementlite.util.inventory;

import net.minecraft.client.player.LocalPlayer;

public class SmartStrategy implements SlotStrategy {

    @Override
    public int select(LocalPlayer player, SlotContext ctx) {

        double[] weights = new double[9];
        double total = 0;

        for (int s : ctx.slots) {

            double w = 1.0;

            w *= baseHistory(ctx, s);
            w *= repeat(ctx, s);
            w *= gap(ctx, s);
            w *= blacklist(ctx, s);
            w *= cluster(ctx, s);
            w *= randomness();

            weights[s] = w;
            total += w;
        }

        int result = pick(ctx, weights, total);
        ctx.push(result);

        return result;
    }

    private double randomness() {
        return 1.5;
    }

    private double baseHistory(SlotContext ctx, int slot) {
        int c = ctx.slotCount[slot];
        return Math.max(0.2, 1.0 - c * 0.1);
    }

    private double repeat(SlotContext ctx, int slot) {
        if (slot == ctx.lastSlot && ctx.repeatCount > 3) {
            return 0.1;
        }
        return 1.0;
    }

    private double gap(SlotContext ctx, int slot) {

        for (int i = 0; i < 2; i++) {
            int idx = (ctx.historyPtr - 1 - i + ctx.history.length) % ctx.history.length;
            if (ctx.history[idx] == slot) return 0.2;
        }

        return 1.0;
    }

    private double blacklist(SlotContext ctx, int slot) {

        for (int i = 0; i < 3; i++) {
            int idx = (ctx.historyPtr - 1 - i + ctx.history.length) % ctx.history.length;
            if (ctx.history[idx] == slot) return 0.05;
        }

        return 1.0;
    }

    private double cluster(SlotContext ctx, int slot) {

        int c = ctx.slotCount[slot];
        return Math.max(0.3, 1.0 - c * 0.15);
    }

    private int pick(SlotContext ctx, double[] w, double total) {

        if (total <= 0) {
            return ctx.slots.get(ctx.random.nextInt(ctx.slots.size()));
        }

        double r = ctx.random.nextDouble() * total;
        double c = 0;

        for (int s : ctx.slots) {
            c += w[s];
            if (r <= c) return s;
        }

        return ctx.slots.get(ctx.random.nextInt(ctx.slots.size()));
    }
}

package dev.foxatme.placementlite.util;

import dev.foxatme.placementlite.util.inventory.SlotContext;
import dev.foxatme.placementlite.util.inventory.SmartStrategy;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.BlockItem;

import java.util.ArrayList;
import java.util.List;

public class InventoryUtils {

    private static final SlotContext context = new SlotContext();

    private static final SmartStrategy SMART = new SmartStrategy();

    public static int getNextSlot(LocalPlayer player) {

        context.slots = collect(player);

        if (context.slots.isEmpty()) return -1;

        return SMART.select(player, context);
    }

    private static List<Integer> collect(LocalPlayer player) {

        List<Integer> slots = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if (player.getInventory().getItem(i).getItem() instanceof BlockItem) {
                slots.add(i);
            }
        }

        return slots;
    }
}

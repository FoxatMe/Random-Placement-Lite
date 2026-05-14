package dev.foxatme.util.inventory;

import net.minecraft.client.player.LocalPlayer;

public interface SlotStrategy {
    int select(LocalPlayer player, SlotContext context);
}
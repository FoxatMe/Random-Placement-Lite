package dev.foxatme.client;

import dev.foxatme.util.InventoryUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;

public class PlacementManager {

    public static void onBlockPlaced() {

        if (!dev.foxatme.util.KeyMappings.enabled) return;

        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;

        if (player == null) return;

        int slot = InventoryUtils.getNextSlot(player);

        if (slot != -1) {
            player.getInventory().setSelectedSlot(slot);
        }
    }
}
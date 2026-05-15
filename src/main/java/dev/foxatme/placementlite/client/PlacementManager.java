package dev.foxatme.placementlite.client;

import dev.foxatme.placementlite.util.InventoryUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;

public class PlacementManager {

    public static void onBlockPlaced() {

        if (!dev.foxatme.placementlite.util.KeyMappings.enabled) return;

        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;

        if (player == null) return;

        int slot = InventoryUtils.getNextSlot(player);

        if (slot != -1) {
            player.getInventory().setSelectedSlot(slot);
        }
    }
}

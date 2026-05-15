package dev.foxatme.placementlite.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class KeyMappings {

    private static KeyMapping toggle;

    public static boolean enabled = true;

    public static void register() {

        toggle = KeyMappingHelper.registerKeyMapping(
                new KeyMapping(
                        "key.random-placement-lite.toggle",
                        GLFW.GLFW_KEY_R,
                        KeyMapping.Category.MISC
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggle.consumeClick()) {
                enabled = !enabled;
            }
        });
    }
}

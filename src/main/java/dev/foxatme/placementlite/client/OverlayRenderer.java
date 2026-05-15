package dev.foxatme.placementlite.client;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;

public class OverlayRenderer {

    public static void register() {

        HudElementRegistry.attachElementAfter(
                VanillaHudElements.CROSSHAIR,
                Identifier.parse("random-placement:icon"),
                (graphics, delta) -> {

                    if (!dev.foxatme.placementlite.util.KeyMappings.enabled) return;

                    Minecraft mc = Minecraft.getInstance();

                    if (mc.player == null) return;

                    int w = mc.getWindow().getGuiScaledWidth();
                    int h = mc.getWindow().getGuiScaledHeight();

                    int x = w / 2;
                    int y = h / 2 - 18;

                    Identifier tex = Identifier.parse(
                            "random-placement:textures/gui/rp_icon.png"
                    );

                    graphics.blit(
                            RenderPipelines.GUI_TEXTURED,
                            tex,
                            x - 8,
                            y - 8,
                            0, 0,
                            16, 16,
                            16, 16
                    );
                }
        );
    }
}

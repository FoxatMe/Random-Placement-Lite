package dev.foxatme.placementlite.client;

import dev.foxatme.placementlite.util.KeyMappings;
import net.fabricmc.api.ClientModInitializer;

public class RandomPlacementLiteClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyMappings.register();
        OverlayRenderer.register();
    }
}

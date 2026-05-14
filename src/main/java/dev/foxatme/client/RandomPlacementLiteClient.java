package dev.foxatme.client;

import dev.foxatme.util.KeyMappings;
import net.fabricmc.api.ClientModInitializer;

public class RandomPlacementLiteClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyMappings.register();
        OverlayRenderer.register();
    }
}
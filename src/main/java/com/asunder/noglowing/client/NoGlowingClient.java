package com.asunder.noglowing.client;

import com.asunder.noglowing.NoGlowing;
import net.fabricmc.api.ClientModInitializer;

public class NoGlowingClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        NoGlowing.LOGGER.info("Glowing remover client started successfully");
    }
}

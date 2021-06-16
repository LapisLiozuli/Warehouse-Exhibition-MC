package com.lapisliozuli.warex;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class WareXClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(WareX.TUPPERWARE_SCREEN_HANDLER, TupperwareScreen::new);
    }
}
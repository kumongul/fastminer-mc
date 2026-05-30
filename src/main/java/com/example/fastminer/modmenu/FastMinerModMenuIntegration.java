package com.example.fastminer.modmenu;

import com.example.fastminer.FastMinerClient;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class FastMinerModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return FastMinerClient::createConfigScreen;
    }
}

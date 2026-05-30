package com.example.fastminer;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FastMiner implements ModInitializer {
    public static final String MOD_ID = "fastminer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        FastMinerConfig.load();
        LOGGER.info("FastMiner loaded! enabled={}, multiplier={}x",
                FastMinerConfig.get().enabled,
                FastMinerConfig.get().speedMultiplier);
    }
}

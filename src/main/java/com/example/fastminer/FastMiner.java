package com.example.fastminer;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FastMiner implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("fastminer");

    @Override
    public void onInitialize() {
        LOGGER.info("FastMiner loaded! Mining speed x1.5");
    }
}

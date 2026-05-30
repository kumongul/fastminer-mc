package com.example.fastminer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class FastMinerConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance()
            .getConfigDir().resolve("fastminer.json");

    public boolean enabled = true;
    public float speedMultiplier = 1.5f;

    private static FastMinerConfig instance;

    public static FastMinerConfig get() {
        if (instance == null) load();
        return instance;
    }

    public static void load() {
        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                instance = GSON.fromJson(reader, FastMinerConfig.class);
                return;
            } catch (IOException e) {
                FastMiner.LOGGER.error("Failed to load config, using defaults", e);
            }
        }
        instance = new FastMinerConfig();
        instance.save();
    }

    public void save() {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(this, writer);
        } catch (IOException e) {
            FastMiner.LOGGER.error("Failed to save config", e);
        }
    }
}

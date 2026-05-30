package com.example.fastminer;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class FastMinerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

    }

    public static Screen createConfigScreen(Screen parent) {
        FastMinerConfig cfg = FastMinerConfig.get();

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal("Fast Miner — Settings"))
                .setSavingRunnable(() -> FastMinerConfig.get().save());

        ConfigCategory general = builder.getOrCreateCategory(
                Component.literal("General"));

        ConfigEntryBuilder entry = builder.entryBuilder();

        general.addEntry(entry
                .startBooleanToggle(Component.literal("Enabled"), cfg.enabled)
                .setDefaultValue(true)
                .setTooltip(Component.literal("Enable or disable the mining speed boost"))
                .setSaveConsumer(val -> cfg.enabled = val)
                .build());

        general.addEntry(entry
                .startFloatField(Component.literal("Speed Multiplier"), cfg.speedMultiplier)
                .setDefaultValue(1.5f)
                .setMin(1.0f)
                .setMax(10.0f)
                .setTooltip(Component.literal("Mining speed multiplier (1.0 = vanilla, 10.0 = maximum)"))
                .setSaveConsumer(val -> cfg.speedMultiplier = val)
                .build());

        return builder.build();
    }
}

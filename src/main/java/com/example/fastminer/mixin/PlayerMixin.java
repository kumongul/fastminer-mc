package com.example.fastminer.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Player.class)
public class PlayerMixin {

    @ModifyVariable(
        method = "getDestroySpeed",
        at = @At("RETURN"),
        ordinal = 0
    )
    private float fastminer_multiplySpeed(float speed) {
        return speed * 1.5f;
    }
}

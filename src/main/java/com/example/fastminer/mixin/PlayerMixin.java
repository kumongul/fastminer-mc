package com.example.fastminer.mixin;

import com.example.fastminer.FastMinerConfig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "getDestroySpeed", at = @At("RETURN"), cancellable = true)
    private void fastminer$multiplySpeed(BlockState state, CallbackInfoReturnable<Float> cir) {
        FastMinerConfig cfg = FastMinerConfig.get();
        if (cfg.enabled) {
            cir.setReturnValue(cir.getReturnValue() * cfg.speedMultiplier);
        }
    }
}

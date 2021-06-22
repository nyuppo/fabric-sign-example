package com.examplemod.mixin;

import com.examplemod.block.ModSignBlock;
import com.examplemod.block.ModWallSignBlock;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {
    @Inject(method = "supports", at = @At("HEAD"), cancellable = true)
    private void supports(BlockState state, CallbackInfoReturnable<Boolean> info) {
        if (BlockEntityType.SIGN.equals(this) && (state.getBlock() instanceof ModSignBlock || state.getBlock() instanceof ModWallSignBlock)) {
            info.setReturnValue(true);
        }
    }
}

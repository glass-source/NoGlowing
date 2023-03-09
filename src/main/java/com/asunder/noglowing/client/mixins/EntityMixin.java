package com.asunder.noglowing.client.mixins;

import net.minecraft.commands.CommandSource;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin implements Nameable, EntityAccess, CommandSource {

    @Shadow protected abstract void setSharedFlag(int i, boolean bl);


    @Inject(method = "setGlowingTag", at = @At("TAIL"), cancellable = true)
    private void setGlowing(boolean bl, CallbackInfo ci){
        ci.cancel();
        this.setSharedFlag(6, false);
    }

    @Inject(method = "isCurrentlyGlowing", at = @At("HEAD"), cancellable = true)
    private void isGlowing(CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(false);
        this.setSharedFlag(6, false);
    }
    @ModifyVariable(method = "setGlowingTag", at = @At("TAIL"), argsOnly = true)
    private boolean setGlowing(boolean value){
        this.setSharedFlag(6, false);
        return false;
    }


}

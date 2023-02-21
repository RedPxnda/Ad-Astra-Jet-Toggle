package com.redpxnda.astrajettoggle.mixin;

import earth.terrarium.ad_astra.common.item.armor.JetSuit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(JetSuit.class)
public class JetArmorMixin {
    @Inject(
        method = "fly",
        at = @At("HEAD"),
        remap = false,
        cancellable = true
    )
    private void injectFly(Player player, ItemStack stack, CallbackInfo ci) {
        if (!player.isShiftKeyDown()) ci.cancel();
    }

}

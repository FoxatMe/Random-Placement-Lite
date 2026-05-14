package dev.foxatme.mixin;

import dev.foxatme.client.PlacementManager;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {

    @Inject(method = "useItemOn", at = @At("RETURN"))
    private void onPlace(LocalPlayer player,
                         InteractionHand hand,
                         BlockHitResult hit,
                         CallbackInfoReturnable<InteractionResult> cir) {

        if (cir.getReturnValue().consumesAction()) {
            PlacementManager.onBlockPlaced();
        }
    }
}
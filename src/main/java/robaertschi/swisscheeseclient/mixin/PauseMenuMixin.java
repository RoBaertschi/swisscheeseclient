package robaertschi.swisscheeseclient.mixin;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import robaertschi.swisscheeseclient.gui.ClientModulesScreen;

@Mixin(GameMenuScreen.class)

public abstract class PauseMenuMixin extends Screen {
	protected PauseMenuMixin(Text title) {
		super(title);
	}

	@SuppressWarnings("DataFlowIssue")
	@Inject(method = "initWidgets", at = @At("TAIL"))
	private void initWidgets(CallbackInfo ci) {
		this.addDrawableChild(ButtonWidget.builder(Text.literal("Swisscheese Client"), buttonWidget -> client.setScreen(new ClientModulesScreen()))
				.width(204)
				.position(width / 2 - 102, 20)
				.build());
	}
}

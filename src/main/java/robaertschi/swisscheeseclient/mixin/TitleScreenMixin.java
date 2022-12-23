package robaertschi.swisscheeseclient.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
	protected TitleScreenMixin(Text title) {
		super(title);
	}

	@Inject(method = "init", at = @At("TAIL"))
	public void onInit(CallbackInfo ci) {

		var l = this.height / 4 + 48;
		this.addDrawableChild(new TexturedButtonWidget(
				this.width / 2 - 124,
				l,
				20,
				20,
				0,
				0,
				20,
				new Identifier("swisscheeseclient", "textures/config_button.png"),
				32,
				64,
				buttonWidget -> {/* Set Config Screen*/},
				Text.literal("Swiss Cheese Client Config")
		));
	}
}

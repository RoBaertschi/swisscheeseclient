package robaertschi.swisscheeseclient.module;

import net.minecraft.client.option.KeyBind;
import org.jetbrains.annotations.NotNull;

/**
 * {@link Activatable} with a KeyBind to activate the Module.
 */
@SuppressWarnings("unused")
public abstract class KeyActivated extends Activatable{
	private KeyBind keyBind;

	public @NotNull KeyBind getKeyBind() {
		return keyBind;
	}
	public void setKeyBind(@NotNull KeyBind keyBind) {
		this.keyBind = keyBind;
	}
	 public KeyActivated(@NotNull KeyBind keyBind) {
		this.keyBind = keyBind;
	 }
}

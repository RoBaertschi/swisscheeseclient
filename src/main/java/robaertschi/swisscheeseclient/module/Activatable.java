package robaertschi.swisscheeseclient.module;

/**
 * If your Module extends from Activatable, then the update Calls will only be called when it is activated.
 * It will also have a Button in the Module menu. If you want it to be activated by a KeyBinding then use {@link KeyActivated}
 */
public abstract class Activatable implements IModule {
	public boolean activated;

	abstract public void onActivated();
	abstract  public void onDeactivated();
	public void setActivated(boolean value) {
		activated = value;
		if(value) {
			onActivated();
		} else {
			onDeactivated();
		}
	}

	public void toogle() {
		activated = !activated;
		if(activated) {
			onActivated();
		} else {
			onDeactivated();
		}
	}

	public boolean isActivated() {
		return activated;
	}
}

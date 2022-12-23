package robaertschi.swisscheeseclient.test.modules;

import org.jetbrains.annotations.NotNull;
import robaertschi.swisscheeseclient.module.Activatable;
import robaertschi.swisscheeseclient.module.IModule;
import robaertschi.swisscheeseclient.test.TestMod;

public class TestModule extends Activatable implements IModule {
	@Override
	public void onEnable() {
		TestMod.LOGGER.info("TestMod module loaded.");
	}

	@Override
	public void onDisable() {
		TestMod.LOGGER.info("TestMod module disabled.");
	}

	@Override
	public @NotNull String getName() {
		return "Test Module";
	}

	@Override
	public @NotNull String getID() {
		return "testmodule";
	}

	@Override
	public void onActivated() {
		TestMod.LOGGER.info("Activated Module.");
	}

	@Override
	public void onDeactivated() {
		TestMod.LOGGER.info("Deactivated Module.");
	}
}

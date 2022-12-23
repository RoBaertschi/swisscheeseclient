package robaertschi.swisscheeseclient.test;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.entrypoint.PreLaunchEntrypoint;
import robaertschi.swisscheeseclient.module.ModuleRegistry;
import robaertschi.swisscheeseclient.test.modules.TestModule;

@SuppressWarnings("unused")
public class TestPrelaunch implements PreLaunchEntrypoint {
	@Override
	public void onPreLaunch(ModContainer mod) {
		ModuleRegistry.register(new TestModule());
	}
}

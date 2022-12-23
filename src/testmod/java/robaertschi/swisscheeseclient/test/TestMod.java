package robaertschi.swisscheeseclient.test;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Test Mod");
	@Override
	public void onInitializeClient(ModContainer mod) {
	}
}

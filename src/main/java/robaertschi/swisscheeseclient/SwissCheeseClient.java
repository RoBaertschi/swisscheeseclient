package robaertschi.swisscheeseclient;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientLifecycleEvents;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientWorldTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import robaertschi.swisscheeseclient.module.ModuleRegistry;

@ClientOnly
public class SwissCheeseClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Swiss Cheese Client");

	@Override
	public void onInitializeClient(ModContainer mod) {
		LOGGER.info("Starting!");
		ModuleRegistry.getInstance().enableAll();
		LOGGER.info("All Modules enabled.");
		ClientLifecycleEvents.STOPPING.register(client -> {
			ModuleRegistry.getInstance().disableAll();
			LOGGER.info("All Modules disabled.");
		});

		ClientTickEvents.END.register(client -> ModuleRegistry.getInstance().updateClient());

		ClientWorldTickEvents.END.register((client, world) -> ModuleRegistry.getInstance().updateWorld());

		HudRenderCallback.EVENT.register(ModuleRegistry::renderHud);
	}
}

package robaertschi.swisscheeseclient.module;

import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.FlowLayout;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import robaertschi.swisscheeseclient.SwissCheeseClient;

import java.util.ArrayList;

/**
 * Used for registring Modules in the pre_init entry point. If you register it in the client_init then it could habbend that the Module is Not enabled.
 */
@SuppressWarnings("unused")
public class ModuleRegistry {
	private final ArrayList<IModule> registeredItems;

	private static ModuleRegistry instance = null;
	@NotNull
	public static ModuleRegistry getInstance() {
		if (instance == null) {
			instance = new ModuleRegistry();
		}
		return instance;
	}

	private ModuleRegistry() {
		registeredItems = new ArrayList<>();
	}

	/**
	 * Only call in pre_init.
	 * @param module Module to be registered.
	 */
	public static void register(@NotNull IModule module) {
		getInstance().registeredItems.add(module);
	}

	public void enableAll() {
		for (IModule item:
			 registeredItems) {
			item.onEnable();
			SwissCheeseClient.LOGGER.info("Enabled Module: " + item.getName());
		}
	}

	public void disableAll() {
		for (IModule item :
				registeredItems) {
			item.onDisable();
		}
	}

	public void updateWorld() {
		for (IModule item :
				registeredItems) {
			item.updateWorld();
		}
	}

	public void updateClient() {
		for (IModule item :
				registeredItems) {
			item.updateClient();

			if (item instanceof KeyActivated) {
				if(((KeyActivated) item).getKeyBind().wasPressed()) {
					((KeyActivated) item).toogle();
				}
			}
		}


	}
	public IModule getModuleByID(@NotNull String id) {
		for (IModule item :
				registeredItems) {
			if (id.equals(item.getID())) {
				return item;
			}
		}
		return null;
	}

	public void renderModules(@NotNull FlowLayout rootComponent) {
		for (IModule item :
				registeredItems) {
			if(item instanceof Activatable activatable) {
				renderModuleButton(rootComponent, activatable);
			}
		}
	}

	private static void renderModuleButton(@NotNull FlowLayout rootComponent, @NotNull Activatable activatable) {
		var button_component = Components.button(
				Text.literal(activatable.getName() + ": " + (activatable.isActivated() ? "On" : "Off")),
				(ButtonComponent button) -> {
					activatable.setActivated(!activatable.isActivated());
					button.setMessage(Text.literal(activatable.getName() + ": " + (activatable.isActivated() ? "On" : "Off")));
				}
		);
		button_component.setWidth(200);
		rootComponent.child(button_component);
	}

	public static void renderHud(MatrixStack matrixStack, float tickDelta) {
		var textRenderer = MinecraftClient.getInstance().textRenderer;

		int y = 10;
		var color = 0xfcf003;
		for (IModule item : getInstance().registeredItems) {
			if (!(item instanceof Activatable)) continue;

			if (((Activatable) item).isActivated()) {
				textRenderer.draw(matrixStack, item.getName(), 10f, y, color);
				y += 10;
			}
		}
	}

}

package robaertschi.swisscheeseclient.module;

import org.jetbrains.annotations.NotNull;

/**
 * Basic Module which needs to be registerd by {@link ModuleRegistry#register(IModule)}.
 */
public interface IModule {
	/**
	 * Called once when it will be Enabled.
	 * This will be in the Initialization entry point.
	 */
	void onEnable();

	/**
	 * Called once when the Event {@link org.quiltmc.qsl.lifecycle.api.client.event.ClientLifecycleEvents#STOPPING} is called.
	 *
	 */
	void onDisable();

	/**
	 * Called each Tick in the Client.
	 */
	default void updateClient() {}

	/**
	 * Called Each Tick in the World.
	 */
	default void updateWorld() {}

	/**
	 * The Full name of the Module.
	 *
	 * @return String like that: "Test Module"
	 */

	@NotNull String getName();

	/**
	 * The ID of the Module. Pls don't use spaces.
	 * @return String like that: "testmodule"
	 */
	@NotNull String getID();
}

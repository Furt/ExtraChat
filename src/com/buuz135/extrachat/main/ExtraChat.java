package com.buuz135.extrachat.main;

import com.buuz135.extrachat.main.commands.ExtraChatCommand;
import com.buuz135.extrachat.main.config.ConfigLoader;
import com.buuz135.extrachat.main.events.PlayerChat;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.event.state.PostInitializationEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

@Plugin(id = "ExtraChat", name = "ExtraChat", version = "1.0")
public class ExtraChat {
    public static Logger logger;
    public static PluginContainer pluginContainer;
    public static Game game;


    @Subscribe
    public void preInit(PreInitializationEvent event) {
        pluginContainer = event.getGame().getPluginManager().getPlugin("ExtraChat").get();
        logger = event.getGame().getPluginManager().getLogger(pluginContainer);
        game = event.getGame();
    }

    @Subscribe
    public void init(InitializationEvent event) {
        ConfigLoader.initConfiguration();
        event.getGame().getEventManager().register(pluginContainer.getInstance(), new PlayerChat());
        event.getGame().getCommandDispatcher().register(pluginContainer.getInstance(), new ExtraChatCommand(), "ec");
    }

    @Subscribe
    public void postInit(PostInitializationEvent event) {

    }
}
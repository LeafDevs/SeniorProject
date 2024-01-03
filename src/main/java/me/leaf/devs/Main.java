 package me.leaf.devs;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        this.plugin = this;
        getLogger().info("Plugin enabled!");
        getLogger().info("Registering events...");
        getServer().getPluginManager().registerEvents(new me.leaf.devs.events.PlayerJoinEvent(), this);
        getLogger().info("Registered 1 Event with 0 Errors");

        getLogger().info("Registering commands...");
        getLogger().info("No Commands Found!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}

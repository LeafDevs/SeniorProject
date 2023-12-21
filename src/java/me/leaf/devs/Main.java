 package me.leaf.devs;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        this.plugin = this;
        getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}

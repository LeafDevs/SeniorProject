 package me.leaf.devs;

import java.util.HashMap;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.items.Item;
import me.leaf.devs.items.swords.BasicSword;
import me.leaf.devs.items.wands.BasicWand;

public class Main extends JavaPlugin {

    private static Plugin plugin;

    public static HashMap<String, Item> items = new HashMap<>();
    public static HashMap<String, EntityBuilder> entities = new HashMap<>();

    @Override
    public void onEnable() {
        this.plugin = this;
        getLogger().info("Registering events...");
        getServer().getPluginManager().registerEvents(new me.leaf.devs.events.PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new me.leaf.devs.events.MobDamageEvent(), this);
        getLogger().info("Registered 1 Event with 0 Errors");

        getLogger().info("Registering commands...");
        getCommand("item").setExecutor(new me.leaf.devs.commands.ItemCommand());
        getCommand("mob").setExecutor(new me.leaf.devs.commands.MobCommand());
        getLogger().info("Registered 2 Commands with 0 Errors");

        getLogger().info("Registering items...");
        items.put("basic_wand", BasicWand.getItem());
        items.put("basic_sword", BasicSword.getItem());
        getLogger().info("Registered 2 Items with 0 Errors");

        getLogger().info("Registering entities...");
        entities.put("zombie", new me.leaf.devs.entities.Entity.Zombie());
        getLogger().info("Registered 0 Entities with 0 Errors");


        getLogger().info("Plugin loaded!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}

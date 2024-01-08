 package me.leaf.devs;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.items.Armor;
import me.leaf.devs.items.Item;
import me.leaf.devs.items.armor.boots.HolyBoots;
import me.leaf.devs.items.swords.BasicSword;
import me.leaf.devs.items.wands.BasicWand;
import me.leaf.devs.utils.ActionBar;
import me.leaf.devs.utils.DataUtils;

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
        getServer().getPluginManager().registerEvents(new me.leaf.devs.events.ItemChangeEvent(), this);
        getServer().getPluginManager().registerEvents(new me.leaf.devs.events.ChatMessageSentEvent(), this);
        getServer().getPluginManager().registerEvents(new me.leaf.devs.events.MobDeathEvent(), this);
        getLogger().info("Registered 3 Event with 0 Errors");

        getLogger().info("Registering commands...");
        getCommand("item").setExecutor(new me.leaf.devs.commands.ItemCommand());
        getCommand("mob").setExecutor(new me.leaf.devs.commands.MobCommand());
        getCommand("nbt").setExecutor(new me.leaf.devs.commands.NBTCommand());
        getLogger().info("Registered 3 Commands with 0 Errors");

        getLogger().info("Registering items...");
        items.put("basic_wand", BasicWand.getItem());
        items.put("basic_sword", BasicSword.getItem());
        items.put("holy_boots", Armor.toItem(HolyBoots.getItem()));
        getLogger().info("Registered 2 Items with 0 Errors");

        getLogger().info("Registering entities...");
        entities.put("zombie", new me.leaf.devs.entities.Entity.Zombie());
        getLogger().info("Registered 0 Entities with 0 Errors");


        getLogger().info("Plugin loaded!");

        Bukkit.getOnlinePlayers().forEach((p) -> {
            DataUtils.loadPlayerData(p);
            new ActionBar(DataUtils.getPlayerData(p));
        });
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}

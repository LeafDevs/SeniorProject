 package me.leaf.devs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.leaf.devs.commands.*;
import me.leaf.devs.events.*;
import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.entities.Entity.Skeleton;
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
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new MobDamageEvent(), this);
        getServer().getPluginManager().registerEvents(new ItemChangeEvent(), this);
        getServer().getPluginManager().registerEvents(new ChatMessageSentEvent(), this);
        getServer().getPluginManager().registerEvents(new MobDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDamageEvent(), plugin);
        getLogger().info("Registered 3 Event with 0 Errors");

        getLogger().info("Registering commands...");
        getCommand("item").setExecutor(new ItemCommand());
        getCommand("mob").setExecutor(new MobCommand());
        getCommand("nbt").setExecutor(new NBTCommand());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("playsong").setExecutor(new PlaySongCommand());
        getCommand("class").setExecutor(new ClassCommand());
        getLogger().info("Registered 3 Commands with 0 Errors");

        getLogger().info("Registering items...");
        items.put("basic_wand", BasicWand.getItem());
        items.put("basic_sword", BasicSword.getItem());
        items.put("holy_boots", Armor.toItem(HolyBoots.getItem()));
        getLogger().info("Registered 2 Items with 0 Errors");

        getLogger().info("Registering entities...");
        entities.put("zombie", new me.leaf.devs.entities.Entity.Zombie());
        entities.put("skeleton", new Skeleton());
        getLogger().info("Registered 0 Entities with 0 Errors");

        File dataFolder = getDataFolder();
        File songsFolder = new File(dataFolder, "songs");

        getLogger().info("Creating Songs Folder");

        if(!songsFolder.exists()) {
            songsFolder.mkdirs();
            File[] files = songsFolder.listFiles();
            if (files != null) {
            for (File file : files) {
                File destination = new File(dataFolder, file.getName());
                try {
                    Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        } else {
            getLogger().info("Songs folder already exists skipping.");
        }


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

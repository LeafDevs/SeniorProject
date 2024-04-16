package me.leaf.devs;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

import me.leaf.devs.entities.Entity.Beginner.InfectedCitizen;
import me.leaf.devs.entities.Entity.Beginner.Knight;
import me.leaf.devs.entities.Entity.Beginner.KnightArcher;
import me.leaf.devs.entities.Entity.Boss.TheKing;
import me.leaf.devs.items.Armor;
import me.leaf.devs.items.armor.boots.HolyBoots;
import me.leaf.devs.items.armor.chestplate.HolyChestplate;
import me.leaf.devs.items.armor.helmet.HolyHelmet;
import me.leaf.devs.items.armor.leggings.HolyLeggings;
import me.leaf.devs.items.swords.BasicSword;
import me.leaf.devs.items.swords.GodSword;
import me.leaf.devs.items.wands.BasicWand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.leaf.devs.commands.*;
import me.leaf.devs.events.*;
import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.items.Item;
import me.leaf.devs.listeners.ArmorEquipEvent;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.Runnables.Player.ActionBar;
import me.leaf.devs.utils.Runnables.Player.Regen;

public class Main extends JavaPlugin {

    private static Plugin plugin;

    public static HashMap<String, Item> items = new HashMap<>();
    public static HashMap<String, EntityBuilder> entities = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("Registering events...");
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new MobDamageEvent(), this);
        getServer().getPluginManager().registerEvents(new ItemChangeEvent(), this);
        getServer().getPluginManager().registerEvents(new ChatMessageSentEvent(), this);
        getServer().getPluginManager().registerEvents(new MobDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDamageEvent(), this);
        getServer().getPluginManager().registerEvents(new NPCDeathEvent(), this);
        
        ArmorEquipEvent.registerListener(this);

        getLogger().info("Registered 3 Event with 0 Errors");

        getLogger().info("Registering commands...");
        getCommand("item").setExecutor(new ItemCommand());
        getCommand("mob").setExecutor(new MobCommand());
        getCommand("nbt").setExecutor(new NBTCommand());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("playsong").setExecutor(new PlaySongCommand());
        getCommand("class").setExecutor(new ClassCommand());
        getCommand("fixstats").setExecutor(new FixStatsCommand());


        getLogger().info("Registering items...");

        Armor.toItem(HolyLeggings.getItem()).registerItem();
        Armor.toItem(HolyChestplate.getItem()).registerItem();
        Armor.toItem(HolyHelmet.getItem()).registerItem();
        Armor.toItem(HolyBoots.getItem()).registerItem();
        BasicSword.getItem().registerItem();
        GodSword.getItem().registerItem();
        BasicWand.getItem().registerItem();
        getLogger().info("Registering entities...");
        entities.put("knight", new Knight());
        entities.put("knight_archer", new KnightArcher());
        entities.put("theking", new TheKing());
        entities.put("infectedcitizen", new InfectedCitizen());

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
            new Regen(DataUtils.getPlayerData(p));
        });
    }

    @Override
    public void onDisable() {getLogger().info("Plugin disabled!");
    }

    public static Plugin getPlugin() {return plugin;}
}

package me.leaf.devs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.leaf.devs.commands.*;
import me.leaf.devs.events.*;
import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.entities.Entity.Skeleton;
import me.leaf.devs.entities.Entity.TestPlayer;
import me.leaf.devs.entities.Entity.Boss.SkeletonKnight;
import me.leaf.devs.items.Armor;
import me.leaf.devs.items.Item;
import me.leaf.devs.items.armor.boots.HolyBoots;
import me.leaf.devs.items.swords.BasicSword;
import me.leaf.devs.items.swords.GodSword;
import me.leaf.devs.items.wands.BasicWand;
import me.leaf.devs.listeners.ArmorEquipEvent;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.Runnables.Player.ActionBar;
import me.leaf.devs.utils.Runnables.Player.Regen;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.reflections.Reflections;
import sun.nio.cs.UTF_8;

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
        Reflections reflections = new Reflections("me.leaf");
        Set<Class<? extends Item>> classes = reflections.getSubTypesOf(Item.class);
        int i = 0;
        for (Class<? extends Item> aClass : classes) {
            try {
                i++;
                Item instance = aClass.newInstance();
                getLogger().info("Registering Item with ID: " + instance.getName().toLowerCase().replace(" ", "_"));
                items.put(instance.getName().toLowerCase().replace(" ", "_"), instance);
            } catch (InstantiationException e) {
                getLogger().warning("Failed to register item with class: " + aClass.getName() + "\nInstantiationException");
            } catch (IllegalAccessException e) {
                getLogger().warning("Failed to register item with class: " + aClass.getName() +  "\nIllegalAccessException");
            }

        }

        getLogger().info("Registered a total of " + i + "Items!");
        getLogger().info("Registering entities...");
        entities.put("zombie", new me.leaf.devs.entities.Entity.Zombie());
        entities.put("skeleton", new Skeleton());
        entities.put("zomb_knight", new SkeletonKnight());
        entities.put("test_player", new TestPlayer());

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
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}

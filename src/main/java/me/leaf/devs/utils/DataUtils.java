package me.leaf.devs.utils;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.leaf.devs.Main;

public class DataUtils {

    private static HashMap<String, PClass> playerData = new HashMap<>();
    
    public static void log(String message) {
        System.out.println(message);
    }

    public static FileConfiguration fetchYml(String fileName) {
        File file = new File(Main.getPlugin().getDataFolder(), fileName);
        FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
        return fileConfiguration;
    }

    public static void loadFile(String fileName) {
        File file = new File(Main.getPlugin().getDataFolder(), fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            Main.getPlugin().saveResource(fileName, false);
        }
    }

    public static boolean hasPlayerData(Player plr) {
        File file = new File(Main.getPlugin().getDataFolder() + File.separator + "playerData" + File.separator + plr.getUniqueId().toString() + ".yml");
        return file.exists();
    }

    public static void loadPlayerData(Player plr) {
        File file = new File(Main.getPlugin().getDataFolder() + File.separator + "playerData" + File.separator + plr.getUniqueId().toString() + ".yml");
        if (file.exists()) {
            FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
            int health = fileConfiguration.getInt("health");
            int defense = fileConfiguration.getInt("defense");
            int strength = fileConfiguration.getInt("strength");
            int speed = fileConfiguration.getInt("speed");
            int mana = fileConfiguration.getInt("mana");
            int luck = fileConfiguration.getInt("luck");
            int level = fileConfiguration.getInt("level");
            int xp = fileConfiguration.getInt("xp");
            int crit_damage = fileConfiguration.getInt("crit_damage");
            int crit_chance = fileConfiguration.getInt("crit_chance");
            int magic_damage = fileConfiguration.getInt("magic_damage");
            int combat_xp = fileConfiguration.getInt("skills.combat.xp");
            int enchanting_xp = fileConfiguration.getInt("skills.enchanting.xp");
            int alchemy_xp = fileConfiguration.getInt("skills.alchemy.xp");
            int combat_level = fileConfiguration.getInt("skills.combat.level");
            int enchanting_level = fileConfiguration.getInt("skills.enchanting.level");
            int alchemy_level = fileConfiguration.getInt("skills.alchemy.level");
            String classType = fileConfiguration.getString("class");


            playerData.put(plr.getUniqueId().toString(), new PClass(health, defense, strength, speed, mana, luck, level, xp, crit_damage, crit_chance, magic_damage, combat_xp, enchanting_xp, alchemy_xp, combat_level, enchanting_level, alchemy_level, classType, plr));
        }
    }

    public static PClass getPlayerData(Player plr) {
        Main.getPlugin().getLogger().info(playerData.toString());
        if (playerData.containsKey(plr.getUniqueId().toString())) {
            return playerData.get(plr.getUniqueId().toString());
        } else {
            return null;
        }
    }

    public static void createPlayerData(Player plr) {
        File file = new File(Main.getPlugin().getDataFolder() + File.separator + "playerData" + File.separator + plr.getUniqueId().toString() + ".yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
            fileConfiguration.createSection("health");
            fileConfiguration.createSection("strength");
            fileConfiguration.createSection("defense");
            fileConfiguration.createSection("speed");
            fileConfiguration.createSection("mana");
            fileConfiguration.createSection("luck");
            fileConfiguration.createSection("level");
            fileConfiguration.createSection("xp");
            fileConfiguration.createSection("crit_damage");
            fileConfiguration.createSection("crit_chance");
            fileConfiguration.createSection("magic_damage");
            fileConfiguration.createSection("skills.combat.xp");
            fileConfiguration.createSection("skills.enchanting.xp");
            fileConfiguration.createSection("skills.alchemy.xp");
            fileConfiguration.createSection("skills.combat.level");
            fileConfiguration.createSection("skills.enchanting.level");
            fileConfiguration.createSection("skills.alchemy.level");

            fileConfiguration.set("health", 100);
            fileConfiguration.set("strength", 0);
            fileConfiguration.set("defense", 0);
            fileConfiguration.set("speed", 0);
            fileConfiguration.set("mana", 0);
            fileConfiguration.set("luck", 0);
            fileConfiguration.set("level", 1);
            fileConfiguration.set("xp", 0);
            fileConfiguration.set("crit_damage", 0);
            fileConfiguration.set("crit_chance", 0);
            fileConfiguration.set("magic_damage", 0);
            fileConfiguration.set("skills.combat.xp", 0);
            fileConfiguration.set("skills.enchanting.xp", 0);
            fileConfiguration.set("skills.alchemy.xp", 0);
            fileConfiguration.set("skills.combat.level", 1);
            fileConfiguration.set("skills.enchanting.level", 1);
            fileConfiguration.set("skills.alchemy.level", 1);
            fileConfiguration.set("class", "none");

            playerData.put(plr.getUniqueId().toString(), new PClass(100, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0, "NOT_PICKED", plr));

            try {
                fileConfiguration.save(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Main.getPlugin().saveResource("playerData" + File.separator + plr.getUniqueId().toString() + ".yml", false);
        }
    }
}
package me.leaf.devs.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.leaf.devs.Main;
import me.leaf.devs.items.abilities.Ability;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTItem;
import me.leaf.devs.items.ItemType;

import me.leaf.devs.utils.Rarity;

public class Item {
    public Item(String name, int damage, int strength, int crit_damage, int crit_chance, int luck, int health, int defense, int magic_damage, Rarity rarity, ItemStack item, ItemType type, ClassType classType, String... description) {
        this.name = name;
        this.damage = damage;
        this.strength = strength;
        this.crit_damage = crit_damage;
        this.crit_chance = crit_chance;
        this.luck = luck;
        this.health = health;
        this.defense = defense;
        this.magic_damage = magic_damage;
        this.rarity = rarity;
        this.item = item;
        this.description=description;
        this.classType = classType;
    }

    private String name;
    private int damage;
    private int strength;
    private int crit_damage;
    private int crit_chance;
    private int luck;
    private int health;
    private int defense;
    private int magic_damage;
    private Rarity rarity;
    private ItemStack item;
    private String[] description;
    private ClassType classType;

    private Ability ablty;

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getStrength() {
        return strength;
    }

    public int getCritDamage() {
        return crit_damage;
    }

    public int getCritChance() {
        return crit_chance;
    }

    public int getLuck() {
        return luck;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagicDamage() {
        return magic_damage;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public ClassType getClassType() {
        return classType;
    }


    public void registerItem() {
        Main.items.put(this.getName().toLowerCase().replace(" ", "_"), this);
    }

    public Item setAbility(Ability ablty) {
        this.ablty = ablty;
        return this;
    }

    public ItemStack createItem() {
        
        NBTItem nbt = new NBTItem(item);
        nbt.setString("damage", "" + damage);
        nbt.setString("strength", "" + strength);
        nbt.setString("crit_damage","" +  crit_damage);
        nbt.setString("crit_chance", "" + crit_chance);
        nbt.setString("luck", "" + luck);
        nbt.setString("health", "" + health);
        nbt.setString("defense", "" + defense);
        nbt.setString("magic_damage", "" + magic_damage);
        nbt.setString("ability", ablty.getName().toLowerCase());
        nbt.setString("UUID", java.util.UUID.randomUUID().toString());
        

        if(classType.getName() != "All") {
            nbt.setString("class", classType.getName());
        }

        ItemStack newItem = nbt.getItem();

        ItemMeta meta = newItem.getItemMeta();

        meta.setDisplayName(rarity.getColor() + name);

        List<String> lore = new ArrayList<>();

        if(damage != 0) {
            lore.add("§7Damage: §c+" + damage);
        }

        if(strength != 0) {
            lore.add("§7Strength: §c+" + strength);
        }

        if(crit_damage != 0) {
            lore.add("§7Crit Damage: §c+" + crit_damage);
        }

        if(crit_chance != 0) {
            lore.add("§7Crit Chance: §c+" + crit_chance);
        }

        if(luck != 0) {
            lore.add("§7Luck: §c+" + luck);
        }

        if(health != 0) {
            lore.add("§7Health: §c+" + health);
        }

        if(defense != 0) {
            lore.add("§7Defense: §c+" + defense);
        }

        if(magic_damage != 0) {
            lore.add("§7Magic Damage: §c+" + magic_damage);
        }


        lore.add("§7");
        for (int i = 0; i < description.length; i++) {
            lore.add("\u00a77" + description[i]);
        }
        
        lore.add("§7");
        lore.add(rarity.getColor() + rarity.getName());

        meta.setLore(lore);

        newItem.setItemMeta(meta);

        return newItem;


    }



}
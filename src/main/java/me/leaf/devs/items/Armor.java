package me.leaf.devs.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTItem;
import me.leaf.devs.items.ItemType;

import me.leaf.devs.utils.Rarity;

public class Armor {
    public Armor(String name, int strength, int crit_damage, int crit_chance, int luck, int health, int defense, int magic_damage, Rarity rarity, ItemStack item, ArmorType type, String... description) {
        this.name = name;
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
    }

    private String name;
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

    public String getName() {
        return name;
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

    public List<String> getDescription() {
        List<String> list = Arrays.asList(description);
        return list;
    }


    public ItemStack createItem() {
        
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(rarity.getColor() + name);

        List<String> lore = new ArrayList<>();

        if(health != 0) {
            lore.add("§7Health: §c+" + health);
        }

        if(defense != 0) {
            lore.add("§7Defense: §c+" + defense);
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

        if(magic_damage != 0) {
            lore.add("§7Magic Damage: §c+" + magic_damage);
        }


        lore.add("§7");
        for(int i = 0; i <= description.length; i++) {
            lore.add(description[i]);

        }
        lore.add("§7");
        lore.add(rarity.getColor() + rarity.getName());


        NBTItem nbt = new NBTItem(item);
        nbt.setInteger("strength", strength);
        nbt.setInteger("crit_damage", crit_damage);
        nbt.setInteger("crit_chance", crit_chance);
        nbt.setInteger("luck", luck);
        nbt.setInteger("health", health);
        nbt.setInteger("defense", defense);
        nbt.setInteger("magic_damage", magic_damage);



        nbt.setString("UUID", java.util.UUID.randomUUID().toString());

        meta.setLore(lore);

        ItemStack newItem = nbt.getItem();

        newItem.setItemMeta(meta);

        return newItem;


    }

    public Material getItemMaterial() {
        return item.getType();
    }

    public static Item toItem(Armor armor) {
        return new Item(armor.getName(), 0, armor.getStrength(), armor.getCritDamage(), armor.getCritChance(), armor.getLuck(), armor.getHealth(), armor.getDefense(), armor.getMagicDamage(), armor.getRarity(), new ItemStack(armor.getItemMaterial()), ItemType.ARMOR_ITEM, armor.description);
    }


}
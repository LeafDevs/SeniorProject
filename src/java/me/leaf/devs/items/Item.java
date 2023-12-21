package me.leaf.devs.items;

import java.util.List;

import org.bukkit.inventory.meta.ItemMeta;

import me.leaf.devs.utils.Rarity;

public static class Item {
    public Item(String name, int damage, int strength, int crit_damage, int crit_chance, int luck, int health, int defense, int magic_damage, Rarity rarity, ItemStack item, String... description) {
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
    private String description;

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

    public List<String> getDescription() {
        List<String> list = Arrays.asList(description);
        return list;
    }


    public Item createItem() {
        
        ItemMeta meta = item.getItemMeta();

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
        lore.add(getDescription());
        lore.add("§7");
        lore.add(rarity.getColor() + rarity.getName());

        meta.setLore(lore);

        item.setItemMeta(meta);


    }


}
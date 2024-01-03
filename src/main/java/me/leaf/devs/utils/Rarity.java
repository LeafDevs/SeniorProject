package me.leaf.devs.utils;

public enum Rarity {
    COMMON("§fCommon", "§f"),
    UNCOMMON("§aUncommon", "§a"),
    RARE("§9Rare", "§9"),
    EPIC("§5Epic", "§5"),
    LEGENDARY("§6Legendary", "§6"),
    MYTHIC("§dMythic", "§d"),
    FABLED("§cFabled", "§c"),
    SACRED("§bSacred", "§b"),
    ANCIENT("§5§lAncient", "§5§l"),
    BLESSED("§eBlessed", "§e"),
    ;

    private String name;
    private String color;

    Rarity(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}

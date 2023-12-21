package me.leaf.devs.utils;

public class PClass {
    
    public PClass(int health, int defense, int strength, int speed, int mana, int luck, int level, int xp, int crit_damage, int crit_chance, int magic_damage, int combat_xp, int enchanting_xp, int alchemy_xp, int combat_level, int enchanting_level, int alchemy_level) {
        this.health = health;
        this.defense = defense;
        this.strength = strength;
        this.speed = speed;
        this.mana = mana;
        this.luck = luck;
        this.level = level;
        this.xp = xp;
        this.crit_damage = crit_damage;
        this.crit_chance = crit_chance;
        this.magic_damage = magic_damage;
        this.combat_xp = combat_xp;
        this.enchanting_xp = enchanting_xp;
        this.alchemy_xp = alchemy_xp;
        this.combat_level = combat_level;
        this.enchanting_level = enchanting_level;
        this.alchemy_level = alchemy_level;
    }

    private int health;
    private int defense;
    private int strength;
    private int speed;
    private int mana;
    private int luck;
    private int level;
    private int xp;
    private int crit_damage;
    private int crit_chance;
    private int magic_damage;
    private int combat_xp;
    private int enchanting_xp;
    private int alchemy_xp;
    private int combat_level;
    private int enchanting_level;
    private int alchemy_level;

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMana() {
        return mana;
    }

    public int getLuck() {
        return luck;
    }

    public int getLevel() {
        return level;
    }

    public int getXP() {
        return xp;
    }

    public int getCritDamage() {
        return crit_damage;
    }

    public int getCritChance() {
        return crit_chance;
    }

    public int getMagicDamage() {
        return magic_damage;
    }


    public int getCombatXP() {
        return combat_xp;
    }

    public int getEnchantingXP() {
        return enchanting_xp;
    }

    public int getAlchemyXP() {
        return alchemy_xp;
    }

    public int getCombatLevel() {
        return combat_level;
    }

    public int getEnchantingLevel() {
        return enchanting_level;
    }

    public int getAlchemyLevel() {
        return alchemy_level;
    }

}

package me.leaf.devs.utils;

import org.bukkit.entity.Player;

import me.leaf.devs.items.ClassType;

public class PClass {
    
    public PClass(int health, int defense, int strength, int speed, int mana, int luck, int level, int xp, int crit_damage, int crit_chance, int magic_damage, int combat_xp, int enchanting_xp, int alchemy_xp, int combat_level, int enchanting_level, int alchemy_level, String classType, Player plr, PSpell spells) {
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
        this.plr = plr;
        this.classType = ClassType.getClassType(classType);
        this.spells = spells;
    }

    public PClass(int health, int defense, int strength, int speed, int mana, int luck, int level, int xp, int crit_damage, int crit_chance, int magic_damage, int combat_xp, int enchanting_xp, int alchemy_xp, int combat_level, int enchanting_level, int alchemy_level, String classType, Player plr) {
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
        this.plr = plr;
        this.classType = ClassType.getClassType(classType);
        this.spells = null;
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
    private Player plr;
    private ClassType classType;
    private PSpell spells;

    public Player getPlayer() {
        return plr;
    }

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

    public ClassType getClassType() {
        return classType;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public void addDefense(int defense) {
        this.defense += defense;
    }

    public void addStrength(int strength) {
        this.strength += strength;
    }

    public void addSpeed(int speed) {
        this.speed += speed;
    }

    public void addMana(int mana) {
        this.mana += mana;
    }

    public void addLuck(int luck) {
        this.luck += luck;
    }

    public void addLevel(int level) {
        this.level += level;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public void addCritDamage(int crit_damage) {
        this.crit_damage += crit_damage;
    }

    public void addCritChance(int crit_chance) {
        this.crit_chance += crit_chance;
    }

    public void addMagicDamage(int magic_damage) {
        this.magic_damage += magic_damage;
    }

    public void addCombatXP(int combat_xp) {
        this.combat_xp += combat_xp;
    }

    public void addEnchantingXP(int enchanting_xp) {
        this.enchanting_xp += enchanting_xp;
    }

    public void addAlchemyXP(int alchemy_xp) {
        this.alchemy_xp += alchemy_xp;
    }

    public void addCombatLevel(int combat_level) {
        this.combat_level += combat_level;
    }

    public void addEnchantingLevel(int enchanting_level) {
        this.enchanting_level += enchanting_level;
    }

    public void addAlchemyLevel(int alchemy_level) {
        this.alchemy_level += alchemy_level;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public void sendMessage(String message) {
        getPlayer().sendMessage(message.replace("&", "\u00a7"));
    }

    public void sendMessages(String... messages) {
        for(int i = 0; i >= messages.length; i++) {
            getPlayer().sendMessage(messages[i].replace("&", "\u00a7"));
        }
    }

}

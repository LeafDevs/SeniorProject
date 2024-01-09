package me.leaf.devs.utils;

import me.leaf.devs.items.ClassType;

public class Spell {

    public Spell(String name, int damage, ClassType clazz) {
        this.name = name;
        this.damage = damage;
        this.clazz = clazz;
    }

    private String name;
    private int damage;
    private ClassType clazz;

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public ClassType getClassType() {
        return this.clazz;
    }
    
}

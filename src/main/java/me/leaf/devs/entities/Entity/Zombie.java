package me.leaf.devs.entities.Entity;

import org.bukkit.entity.EntityType;

import me.leaf.devs.entities.EntityBuilder;

public class Zombie extends EntityBuilder {

    public Zombie() {
        super("Zombie", 100, 5, 2, EntityType.ZOMBIE);
    }
    
}

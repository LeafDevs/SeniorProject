package me.leaf.devs.entities.Entity;

import org.bukkit.entity.EntityType;

import me.leaf.devs.entities.EntityBuilder;

public class Skeleton extends EntityBuilder{

    public Skeleton() {
        super("Skeleton", 120, 5, 20, EntityType.SKELETON);
    }
    
}

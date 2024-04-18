package me.leaf.devs.entities.Entity.Beginner;

import me.leaf.devs.entities.EntityBuilder;
import org.bukkit.entity.EntityType;

public class Wolf extends EntityBuilder {
    public Wolf() {
        super("Wolf", 50, 5, 3, EntityType.WOLF);
    }
}

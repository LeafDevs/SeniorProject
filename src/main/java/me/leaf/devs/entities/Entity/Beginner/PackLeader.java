package me.leaf.devs.entities.Entity.Beginner;

import me.leaf.devs.entities.EntityBuilder;
import org.bukkit.entity.EntityType;

public class PackLeader extends EntityBuilder {
    public PackLeader() {
        super("Wolf Leader", 80, 8, 5, EntityType.WOLF, 25);
    }
}

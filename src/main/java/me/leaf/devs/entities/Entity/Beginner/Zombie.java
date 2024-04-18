package me.leaf.devs.entities.Entity.Beginner;

import me.leaf.devs.entities.EntityBuilder;
import org.bukkit.entity.EntityType;

public class Zombie extends EntityBuilder {
    public Zombie() {
        super("Zombie", 60, 8, 5, EntityType.ZOMBIE, 5);
    }
}

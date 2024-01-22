package me.leaf.devs.entities.Entity.Boss;

import javax.swing.text.html.parser.Entity;

import org.bukkit.entity.EntityType;

import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.utils.Attacks.TeleportHit;

public class SkeletonKnight extends EntityBuilder {

    public SkeletonKnight() {
        super("Zombie Knight", 250000, 250, 250, EntityType.ZOMBIE);
        this.setHealth(250000);
        this.setDefense(25000);
        this.isBoss();
    }


    @Override
    public void initRunnables() {
        new TeleportHit(this);
    
    }
    
}

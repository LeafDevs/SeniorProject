package me.leaf.devs.entities.Entity.Boss;

import javax.swing.text.html.parser.Entity;

import org.bukkit.entity.EntityType;

import me.leaf.devs.entities.Boss;
import me.leaf.devs.utils.Attacks.TeleportHit;

public class SkeletonKnight extends Boss{

    public SkeletonKnight() {
        super(EntityType.SKELETON, 50);
        this.setHealth(250000);
        this.setDamage(2500);
        this.setName("Skeleton Knight");
        this.setDefense(25000);
        

    }

    @Override
    public void initRunnables() {
        new TeleportHit(getArmorStand(), this.toEntityBuilder());
    
    }

    @Override
    public String getSpawnMessage() {
        return "A great evil has spawnned.";
    }
    
}

package me.leaf.devs.utils.Attacks;

import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import me.leaf.devs.entities.EntityBuilder;

public class AOEAttack extends BukkitRunnable {

    public AOEAttack(EntityBuilder eb) {
        this.eb = eb;
        this.ent = eb.getEntity();
    }

    private EntityBuilder eb;
    private Entity ent;

    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }


    /**
     * 
     * Get all players within 4 blocks
     * Damage them for 5% of their max HP every 2 seconds
     * Add an Exaust feature where the boss gets tired and stops doign AOE but he heals for 25% of his current HP
     * 
     */

    
}

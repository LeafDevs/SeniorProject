package me.leaf.devs.utils;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import me.leaf.devs.entities.EntityBuilder;

public class MobHealthUpdater extends BukkitRunnable{

    public MobHealthUpdater(Entity ent, EntityBuilder entityBuilder) {
        this.ent = ent;
        this.entGroup = entityBuilder;
        this.runTaskTimer(me.leaf.devs.Main.getPlugin(), 0, 2);
    }

    private Entity ent;
    private me.leaf.devs.entities.EntityBuilder entGroup;

    @Override
    public void run() {
        if (ent.isDead()) {
            entGroup.getArmorStand().remove();
            this.cancel();
        }
        entGroup.updateArmorStand();
    }
    
}

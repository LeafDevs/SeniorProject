package me.leaf.devs.utils;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import me.leaf.devs.entities.Boss;
import me.leaf.devs.entities.EntityBuilder;

public class MobHealthUpdater extends BukkitRunnable{

    public MobHealthUpdater(Entity ent, EntityBuilder entityBuilder) {
        this.ent = ent;
        this.entGroup = entityBuilder;
        this.runTaskTimer(me.leaf.devs.Main.getPlugin(), 0, 2);
    }

    public MobHealthUpdater(Entity ent, Boss boss) {
        this.ent = ent;
        this.boss = boss;
        this.runTaskTimer(me.leaf.devs.Main.getPlugin(), 0, 2);
    }

    private Entity ent;
    private me.leaf.devs.entities.EntityBuilder entGroup;
    private Boss boss;

    @Override
    public void run() {
        if(entGroup != null) {
            if (ent.isDead()) {
                entGroup.getArmorStand().remove();
                this.cancel();
            }
            entGroup.updateArmorStand();
        } else {
            if(ent.isDead()) {
                boss.getArmorStand().remove();
                this.cancel();
            }
        }
        
    }
    
}

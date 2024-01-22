package me.leaf.devs.utils.Attacks;


import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import me.leaf.devs.entities.EntityBuilder;

public class NextForm extends BukkitRunnable{

    public NextForm(EntityBuilder eb, int form) {
        this.eb = eb;
        this.ent = eb.getEntity();
        this.form = form;
    }

    private Entity ent;
    private EntityBuilder eb;
    private int form;

    @Override
    public void run() {
        if(form == 3) {
            this.cancel();
            return;
        }
        if(ent.isDead()) {
            this.cancel();
            int formNormal = form + 1;
            eb.setHealth(eb.getHealth() + (25000 * formNormal + 1));
            eb.spawn(eb.getEntity().getLocation());
            new NextForm(eb, form + 1);
            return;
        }
    } 


    
}

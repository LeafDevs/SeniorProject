package me.leaf.devs.utils.Attacks;

import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import me.leaf.devs.Main;
import me.leaf.devs.entities.EntityBuilder;

public class NextForm extends BukkitRunnable {

    private Entity ent;
    private EntityBuilder eb;
    private int form;
    private boolean taskScheduled; // Flag to check if the task has been scheduled
    private boolean dead;

    public NextForm(EntityBuilder eb, int form) {
        this.eb = eb;
        this.ent = eb.getEntity();
        this.form = form;
        this.dead = false;
        this.taskScheduled = false;

        this.runTaskTimer(Main.getPlugin(), 0L, 5L);
    }

    @Override
    public void run() {
        if (form >= 3) {
            this.cancel();
            return;
        }

        if(ent.isDead() && form == 3) {
            eb.setHealth(eb.getHealth() + 125000);
            eb.setDamage(125);
            eb.spawn(eb.getEntity().getLocation());
            
            return;
        }

        if (ent.isDead() && !taskScheduled && form < 3) {
            int formNormal = form + 1;
            System.out.println(form + " " + formNormal);
            eb.setHealth(eb.getHealth() + (25000 * formNormal));
            eb.spawn(eb.getEntity().getLocation());
            form++;
        }
    }
}

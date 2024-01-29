package me.leaf.devs.utils.Attacks;

import org.bukkit.Bukkit;
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

        this.runTaskTimer(Main.getPlugin(), 0L, 20L);
    }

    @Override
    public void run() {
        if(form >= 4) {
            new AOEAttack(eb);
            this.cancel();
            return;
        }
        if(this.ent.isDead()) {
            this.cancel();
            Bukkit.getServer().broadcastMessage("Is Canceled: " + this.isCancelled());
            this.eb.setHealth(eb.getHealth() + 125000);
            eb.respawn(ent.getLocation());
            new NextForm(eb, form + 1);
            return;
        }
    }
}

package me.leaf.devs.utils;

import org.bukkit.scheduler.BukkitRunnable;

import me.leaf.devs.Main;

public class Regen extends BukkitRunnable{


    public Regen(PClass plr) {
        this.plr = plr;
        this.runTaskTimer(Main.getPlugin(), 0, 20);
    }

    private PClass plr;

    @Override
    public void run() {
        if(plr.getPlayer() == null) {
            this.cancel();
        }
        if(plr.getHP() > plr.getHealth()) {
            plr.setHP(plr.getHealth());
        }
        if(plr.getHP() < plr.getHealth()) {
            plr.setHP((int) (plr.getHealth() * 0.01));
        }
    }
    
}

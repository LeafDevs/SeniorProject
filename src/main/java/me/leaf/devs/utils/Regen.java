package me.leaf.devs.utils;

import static me.leaf.devs.utils.DataUtils.log;

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
            log("Regening HP");
            int hp = (int) ((int) plr.getHP() + (plr.getHealth() * 0.05));
            plr.setHP(hp);
        }
    }
    
}

package me.leaf.devs.utils.Runnables.Entity;

import me.leaf.devs.Main;
import me.leaf.devs.entities.Boss;
import me.leaf.devs.entities.PlayerEnemy;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class BossBarUpdater extends BukkitRunnable {

    private Boss boss;
    public BossBarUpdater(PlayerEnemy ent) {
        if(ent instanceof Boss) {
            this.boss = (Boss) ent;
            this.runTaskTimer(Main.getPlugin(), 0, 20);
        } else {
            Main.getPlugin().getLogger().warning("Entity Registered as a boss does not extend the 'Boss' class.");
        }
    }
    @Override
    public void run() {
        giveUsersBossBar();
        if(boss.isDead()) {
            this.cancel();
            return;
        }
        boss.updateBossbar();
    }


    private void giveUsersBossBar() {
        ArrayList<Player> nearbyPlayers = new ArrayList<>(boss.getAllPlayers(boss.getEntity(), 55));
        ArrayList<Player> activePlayers = new ArrayList<>(boss.getBossBar().getPlayers());
        for(Player p : nearbyPlayers) {
            if(!activePlayers.contains(p)) {
                boss.getBossBar().addPlayer(p);
            }
        }
        for(Player p : activePlayers) {
            if(!nearbyPlayers.contains(p)) {
                boss.getBossBar().removePlayer(p);
            }
        }
    }
}

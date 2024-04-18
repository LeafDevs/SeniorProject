package me.leaf.devs.entities;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Boss extends PlayerEnemy {

    private BossBar bossbar;

    public Boss(String name, int level, int health, int damage, Skin skin) {
        super(name, level, health, damage, skin, true);
    }


    public void updateBossbar() {
        int maxhp = getHealth();
        int hp = (int) this.npc.getTrait().health;
        int percentage = hp / maxhp;
        bossbar.setProgress(percentage);

        if(bossbar.getProgress() <= 1) {
            bossbar.removeAll();
        }
    }


    public ArrayList<Player> getAllPlayers(Entity entity, double radius) {
        ArrayList<Player> playersInRadius = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld().equals(entity.getWorld())) {
                double distanceSquared = player.getLocation().distanceSquared(entity.getLocation());

                if(distanceSquared <= radius * radius){
                    playersInRadius.add(player);
                }
            }
        }

        return playersInRadius;
    }

    public void createBossBar() {
        bossbar = Bukkit.createBossBar(getName(), BarColor.RED, BarStyle.SOLID);
        bossbar.setProgress(1.0);
    }

    public BossBar getBossBar() {
        return this.bossbar;
    }
}

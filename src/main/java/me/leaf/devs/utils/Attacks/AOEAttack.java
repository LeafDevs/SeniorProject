package me.leaf.devs.utils.Attacks;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.scheduler.BukkitRunnable;

import me.leaf.devs.Main;
import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class AOEAttack extends BukkitRunnable {

    public AOEAttack(EntityBuilder eb) {
        this.eb = eb;
        this.ent = eb.getEntity();

        this.runTaskTimer(Main.getPlugin(), 0, 5);
    }

    private EntityBuilder eb;
    private Entity ent;

    private long lastExhaustion;
    private long exhaustedUntil; 
    private boolean exhausted;


    private long lastAttack = 0;


    
    private ArrayList<Player> players;

    @Override
    public void run() {
        players = getAllPlayers(ent, 4);
        
        if(exhausted && System.currentTimeMillis() >= exhaustedUntil) {

            exhausted = false;
          
          }

          if(System.currentTimeMillis() - lastExhaustion >= 10000) {
        
            exhausted = true;
            exhaustedUntil = System.currentTimeMillis() + 5000;

            int hpRegen = (int) (eb.getHealth() * 0.25);


            eb.setHealth(hpRegen + eb.getHealth());
        
            lastExhaustion = System.currentTimeMillis();
        
          }

        if(System.currentTimeMillis() - lastAttack < 2000) {
            return;
          }
        
          for(Player p : players) {
            PClass plr = DataUtils.getPlayerData(p);
            int damage = (int) (plr.getHealth() * 0.05);
            new EntityDamageEvent(p, DamageCause.DRAGON_BREATH, damage);
          }
        
          lastAttack = System.currentTimeMillis();

          
    }


    private ArrayList<Player> getAllPlayers(Entity entity, double radius) {
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

    
}

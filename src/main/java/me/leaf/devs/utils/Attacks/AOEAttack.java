package me.leaf.devs.utils.Attacks;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.scheduler.BukkitRunnable;
import static me.leaf.devs.utils.DataUtils.log;

import me.leaf.devs.Main;
import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;

public class AOEAttack extends BukkitRunnable {

    public AOEAttack(EntityBuilder eb) {
        this.eb = eb;
        this.ent = eb.getEntity();

        exhausted = false;
        lastExhaustion = 0;
        exhaustedUntil = 0;

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

        if(ent.isDead()) {
          this.cancel();
        }

        players = getAllPlayers(ent, 8);
        
        if(exhausted && System.currentTimeMillis() >= exhaustedUntil) {
            log("Exaustion Over");
            exhausted = false;
          
          }

          if(System.currentTimeMillis() - lastExhaustion >= 10000) {
            log("Exaustion Started");
            exhausted = true;
            exhaustedUntil = System.currentTimeMillis() + 5000;

            log("Health: " + eb.getHealth());

            int hpRegen = (int) (eb.getHealth() * 0.25);


            eb.setHealth(hpRegen + eb.getHealth());
        
            lastExhaustion = System.currentTimeMillis();
        
          }

        if(System.currentTimeMillis() - lastAttack < 2000) {
            return;
          }
        
          for(Player p : players) {
            log("Damaging Player: " + p.getDisplayName());
            PClass plr = DataUtils.getPlayerData(p);
            int damage = (int) (plr.getHP() * 0.05);
            plr.setHP(plr.getHP() - damage);
            ((CraftPlayer)p).damage(1);
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

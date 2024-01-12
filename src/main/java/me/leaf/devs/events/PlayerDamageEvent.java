package me.leaf.devs.events;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.leaf.devs.Main;
import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class PlayerDamageEvent implements Listener{

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            if(e instanceof EntityDamageByEntityEvent) {    
                EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) e;
                EntityBuilder damager = EntityBuilder.entityGroups.get(event.getDamager());

                if(damager == null) {
                    damager = new EntityBuilder("NULL", 0, 1, 1, EntityType.AREA_EFFECT_CLOUD);
                }
                int damage = damager.getDamage();


                PClass pClass = DataUtils.getPlayerData((Player) e.getEntity());

                int defense =  pClass.getDefense();
                int health = pClass.getHP();
 
                e.setDamage(0);

                int def100 = defense + 100;

                double damageReduction = (double) defense / def100; // percentage

                Main.getPlugin().getLogger().info("defense + 100 |" + (defense + 100) + "defense / (defense + 100)" + (defense / (defense + 100)));

                Main.getPlugin().getLogger().info("Damage Reduction: " + damageReduction + "%    Defense: " + defense);
                
                double negatedDmg = (int) (damage / damageReduction);

                Main.getPlugin().getLogger().info("{player} took {damage} Remaining HP: {hp}  Damage Negated: {negate}  Health: {health}".replace("{health}", "" + health).replace("{negate}","" + negatedDmg).replace("{player}", pClass.getPlayer().getDisplayName()).replace("{hp}", "" + (health - negatedDmg)).replace("{damage}", "" + damage));

                pClass.setHP((int) (health - negatedDmg));

                if(pClass.getHP() <= 0) {
                    pClass.sendMessages("&7You have died!", "&cYou were killed by a " + damager.getName());
                    pClass.getPlayer().teleport(new Location(pClass.getPlayer().getWorld(), 2,73,-22));
                    pClass.setHP(pClass.getHealth());
                }

            }
        }
    }
    
}

package me.leaf.devs.events;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import me.leaf.devs.Main;
import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class MobDeathEvent implements Listener{

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {

        LivingEntity ent = e.getEntity();


        if(ent.getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK && ent.getKiller() instanceof Player) {

            Player plr = ent.getKiller();
            
            PClass pClass = DataUtils.getPlayerData(plr);

            try {
                EntityBuilder eb = EntityBuilder.entityGroups.get((Entity) e.getEntity());
                    int xp = (int) 10*(eb.getLevel()-pClass.getLevel()+30);
                    if(xp <= 0) {
                        xp = 0;
                    }
                    pClass.addCombatXP(xp);
                    pClass.addXP(xp);
                    
                    ArmorStand user = ent.getWorld().spawn(ent.getLocation().add(0, 0, 0), ArmorStand.class);
                    user.setInvisible(true);
                    user.setCustomNameVisible(true);
                    user.setInvulnerable(true);
                    user.setGravity(false);
                    user.setCustomName("\u00a77[{player}]".replace("{player}", pClass.getPlayer().getDisplayName()));
            
                    ArmorStand XP = ent.getWorld().spawn(ent.getLocation().add(0, -0.5, 0), ArmorStand.class);
                    XP.setInvisible(true);
                    XP.setCustomNameVisible(true);
                    XP.setInvulnerable(true);
                    XP.setGravity(false);
                    XP.setCustomName("\u00a77+{XP} Combat XP".replace("{XP}", "" + xp));
            
                    org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            XP.remove();
                            user.remove();
                        }
                    }, 60L);

                    int totalLevels = xp / 100;
                    if(totalLevels >= 1) pClass.getPlayer().sendMessage("§aYou have gained: " + totalLevels + " Levels. You are now Level " + (pClass.getLevel() + totalLevels) + "§o(§6§o" + pClass.getLevel() + "§a§o>§6§o" + (pClass.getLevel() + totalLevels) + "§a§o)");
                    for(int i = 0; i <= totalLevels; i++) {
                        if(pClass.getXP() >= 100) {
                            pClass.addLevel(1);
                        }
                    }
                    return;

            } catch(Error err) {
                err.printStackTrace();
            }
        }

    }
    
}

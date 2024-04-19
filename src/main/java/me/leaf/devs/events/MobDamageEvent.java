package me.leaf.devs.events;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import de.tr7zw.nbtapi.NBTItem;
import me.leaf.devs.Main;
import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.items.ClassType;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class MobDamageEvent implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {

        if(e.getCause() == DamageCause.FIRE_TICK) e.setCancelled(true);

        if(e.getCause() != DamageCause.ENTITY_ATTACK) return;
        
        if(e.getEntity() instanceof org.bukkit.entity.ArmorStand) {
            e.setCancelled(true);
            return;
        }


        if (e instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) e;
            Entity damager = event.getDamager();
            if(e.getCause() == DamageCause.ENTITY_SWEEP_ATTACK) {
                e.setCancelled(true);
                event.setCancelled(true);
            }
            if (damager instanceof Player) {
                Player player = (Player) damager;
                PClass pClass = DataUtils.getPlayerData(player);

                org.bukkit.inventory.ItemStack item = player.getInventory().getItemInMainHand();
                if(item != null && item.getType() != Material.AIR && item.getAmount() > 0) {
                    NBTItem nbtItem = new NBTItem(item);

                    if(nbtItem.hasKey("class")) {
                        ClassType type = ClassType.getClassType(nbtItem.getString("class"));

                        assert pClass != null;
                        if(pClass.getClassType() != type) {
                            pClass.getPlayer().sendMessage("§cThis item is not for your class! You must be a " + type.getName() + " to use this item!");
                            e.setCancelled(true);
                            return;
                        }
                    }
                }

                int damage = (int) e.getDamage();

                int strength = pClass.getStrength();
                int crit_damage = pClass.getCritDamage();
                int crit_chance = pClass.getCritChance();
            
                int crit = (int) (Math.random() * 100);
                boolean critical = false;
                if(crit <= crit_chance) {
                    damage += (crit_damage * 3);
                }

                damage += (damage * (1 + (strength / 5)));

                e.setDamage(damage);

                org.bukkit.entity.ArmorStand aStand = (org.bukkit.entity.ArmorStand) e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), org.bukkit.entity.EntityType.ARMOR_STAND);
                aStand.setInvulnerable(true);
                aStand.setGravity(false);
                aStand.setVisible(false);
                aStand.setCustomNameVisible(true);
                aStand.setSmall(true);

                if(critical) {
                    aStand.setCustomName("§f✦ §e" + damage + " §f✦");
                } else {
                    aStand.setCustomName("§e" + damage);
                }


                // create a runnable to remove the armor stand after 1 second
                org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        aStand.remove();
                    }
                }, 20L);
            }
        }



    }
    
}

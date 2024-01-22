package me.leaf.devs.events;

import java.net.http.WebSocket.Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.nbtapi.NBTItem;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class ArmorEquipEvent implements Listener {

    @EventHandler
    public void onArmorEquip(me.leaf.devs.listeners.ArmorEquipEvent event) {
        ItemStack oldItem = event.getOldArmorPiece();
        ItemStack newitem = event.getNewArmorPiece();

        if(oldItem != null || oldItem.getType() != Material.AIR) {

            NBTItem item = new NBTItem(oldItem);

            if(item.hasKey("UUID")) {

                int strength = Integer.parseInt(item.getString("strength"));
                int health = Integer.parseInt(item.getString("health"));
                int defense = Integer.parseInt(item.getString("defense"));
                int luck = Integer.parseInt(item.getString("luck"));
                int crit_damage = Integer.parseInt(item.getString("crit_damage"));
                int crit_chance = Integer.parseInt(item.getString("crit_chance"));
                int magic_damage = Integer.parseInt(item.getString("magic_damage"));
    
                PClass plr = DataUtils.getPlayerData(event.getPlayer());
    
                plr.addStrength(strength / -1);
                plr.addHealth(health / -1);
                plr.addDefense(defense / -1);
                plr.addLuck(luck / -1);
                plr.addMagicDamage(magic_damage / -1);
                plr.addCritChance(crit_chance / -1);
                plr.addCritDamage(crit_damage / -1);
            }

        }


        if(newitem != null || newitem.getType() != Material.AIR) {

            NBTItem item = new NBTItem(newitem);

            if(item.hasKey("UUID")) {

                int strength = Integer.parseInt(item.getString("strength"));
                int health = Integer.parseInt(item.getString("health"));
                int defense = Integer.parseInt(item.getString("defense"));
                int luck = Integer.parseInt(item.getString("luck"));
                int crit_damage = Integer.parseInt(item.getString("crit_damage"));
                int crit_chance = Integer.parseInt(item.getString("crit_chance"));
                int magic_damage = Integer.parseInt(item.getString("magic_damage"));
    
                PClass plr = DataUtils.getPlayerData(event.getPlayer());
    
                plr.addStrength(strength);
                plr.addHealth(health);
                plr.addDefense(defense);
                plr.addLuck(luck);
                plr.addMagicDamage(magic_damage);
                plr.addCritChance(crit_chance);
                plr.addCritDamage(crit_damage);
            }

        }
    }
    
}

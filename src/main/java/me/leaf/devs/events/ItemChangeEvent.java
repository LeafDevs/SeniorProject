package me.leaf.devs.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.plugin.NBTAPI;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class ItemChangeEvent implements Listener {
    
    @EventHandler
    public void onItemSwap(PlayerItemHeldEvent e) {
        int lastSlot = e.getPreviousSlot();
        int newSlot = e.getNewSlot();

        ItemStack newItem = e.getPlayer().getInventory().getItem(newSlot);
        ItemStack lastItem = e.getPlayer().getInventory().getItem(lastSlot);

        boolean isLastSlotAir = false;
        boolean isNewSlotAir = false;

        if(lastItem.getType() == Material.AIR || lastItem == null) {
            isLastSlotAir = true;
        }
        if(newItem.getType() == Material.AIR || newItem == null) {
            isNewSlotAir = true;
        }

        PClass pClass = DataUtils.getPlayerData(e.getPlayer());

        if(!isLastSlotAir) {
            NBTItem lastNBT = new NBTItem(lastItem);

            int defense = Integer.parseInt(lastNBT.getString("defense"));
            int health = Integer.parseInt(lastNBT.getString("health"));
            int strength = Integer.parseInt(lastNBT.getString("strength"));
            int crit_damage = Integer.parseInt(lastNBT.getString("crit_damage"));
            int crit_chance = Integer.parseInt(lastNBT.getString("crit_chance"));
            int luck = Integer.parseInt(lastNBT.getString("luck"));
            int magic_damage = Integer.parseInt(lastNBT.getString("magic_damage"));

            pClass.addDefense(defense / -1);
            pClass.addHealth(health / -1);
            pClass.addStrength(strength / -1);
            pClass.addCritDamage(crit_damage / -1);
            pClass.addCritChance(crit_chance / -1);
            pClass.addLuck(luck / -1);
            pClass.addMagicDamage(magic_damage / -1);
        }


        if(!isNewSlotAir) {
            NBTItem lastNBT = new NBTItem(newItem);

            int defense = Integer.parseInt(lastNBT.getString("defense"));
            int health = Integer.parseInt(lastNBT.getString("health"));
            int strength = Integer.parseInt(lastNBT.getString("strength"));
            int crit_damage = Integer.parseInt(lastNBT.getString("crit_damage"));
            int crit_chance = Integer.parseInt(lastNBT.getString("crit_chance"));
            int luck = Integer.parseInt(lastNBT.getString("luck"));
            int magic_damage = Integer.parseInt(lastNBT.getString("magic_damage"));

            pClass.addDefense(defense);
            pClass.addHealth(health);
            pClass.addStrength(strength);
            pClass.addCritDamage(crit_damage);
            pClass.addCritChance(crit_chance);
            pClass.addLuck(luck);
            pClass.addMagicDamage(magic_damage);
        }



        
    }

}

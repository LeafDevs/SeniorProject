package me.leaf.devs.events;

import javax.xml.crypto.Data;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.nbtapi.NBTItem;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class ItemChangeEvent implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getClick() == ClickType.NUMBER_KEY || e.getClick() == ClickType.SWAP_OFFHAND) {
            e.setCancelled(true);
        }
    
        if(e.getClickedInventory().getType() == null) {
            return;
        }

        if (e.getClickedInventory().getType() == InventoryType.PLAYER) {
            ItemStack item = e.getCurrentItem();
    
            if (item == null || item.getType() == Material.AIR) {
                return;
            }
    
            Player plr = (Player) e.getWhoClicked();
            PClass pClass = DataUtils.getPlayerData(plr);
    
            NBTItem nbtItem = new NBTItem(item);
    
            if (nbtItem.hasKey("UUID") && e.getSlot() == plr.getInventory().getHeldItemSlot()) {
                modifyStatsBasedOnNBT(pClass, nbtItem, -1);
            }
        }
    }
    
    @EventHandler
    public void onItemSwap(PlayerItemHeldEvent e) {
        int lastSlot = e.getPreviousSlot();
        int newSlot = e.getNewSlot();
    
        ItemStack newItem = e.getPlayer().getInventory().getItem(newSlot);
        ItemStack lastItem = e.getPlayer().getInventory().getItem(lastSlot);
    
        PClass pClass = DataUtils.getPlayerData(e.getPlayer());
    
        // Check if the new slot is the main hand
        if (newSlot == e.getPlayer().getInventory().getHeldItemSlot()) {
            return;
        }
    
        if (lastItem != null) {
            NBTItem lastNBT = new NBTItem(lastItem);
            if (lastNBT.hasKey("UUID")) {
                modifyStatsBasedOnNBT(pClass, lastNBT, -1);
            }
        }
    
        if (newItem != null) {
            NBTItem newNBT = new NBTItem(newItem);
            if (newNBT.hasKey("UUID")) {
                modifyStatsBasedOnNBT(pClass, newNBT, 1);
            }
        }
    }
    
    // Add a method to reduce redundancy
    private void modifyStatsBasedOnNBT(PClass pClass, NBTItem nbtItem, int multiplier) {
        int defense = Integer.parseInt(nbtItem.getString("defense"));
        int health = Integer.parseInt(nbtItem.getString("health"));
        int strength = Integer.parseInt(nbtItem.getString("strength"));
        int crit_damage = Integer.parseInt(nbtItem.getString("crit_damage"));
        int crit_chance = Integer.parseInt(nbtItem.getString("crit_chance"));
        int luck = Integer.parseInt(nbtItem.getString("luck"));
        int magic_damage = Integer.parseInt(nbtItem.getString("magic_damage"));
    
        pClass.addDefense(defense * multiplier);
        pClass.addHealth(health * multiplier);
        pClass.addStrength(strength * multiplier);
        pClass.addCritDamage(crit_damage * multiplier);
        pClass.addCritChance(crit_chance * multiplier);
        pClass.addLuck(luck * multiplier);
        pClass.addMagicDamage(magic_damage * multiplier);
    }
    

}

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
        if(e.getClick() == ClickType.NUMBER_KEY || e.getClick() == ClickType.SWAP_OFFHAND) {
            e.setCancelled(true);
        }

        if(e.getClickedInventory().getType() == InventoryType.PLAYER) {
            ItemStack item = e.getCurrentItem();

            NBTItem nbtItem = new NBTItem(item);

            Player plr = (Player) e.getWhoClicked();

            PClass pClass = DataUtils.getPlayerData(plr);

            if(nbtItem.hasKey("UUID")) {
                int defense = Integer.parseInt(nbtItem.getString("defense"));
                int health = Integer.parseInt(nbtItem.getString("health"));
                int strength = Integer.parseInt(nbtItem.getString("strength"));
                int crit_damage = Integer.parseInt(nbtItem.getString("crit_damage"));
                int crit_chance = Integer.parseInt(nbtItem.getString("crit_chance"));
                int luck = Integer.parseInt(nbtItem.getString("luck"));
                int magic_damage = Integer.parseInt(nbtItem.getString("magic_damage"));
    
                pClass.addDefense(defense / -1);
                pClass.addHealth(health / -1);
                pClass.addStrength(strength / -1);
                pClass.addCritDamage(crit_damage / -1);
                pClass.addCritChance(crit_chance / -1);
                pClass.addLuck(luck / -1);
                pClass.addMagicDamage(magic_damage / -1);
            }

            ItemStack newItem = e.getInventory().getItem(e.getSlot());

            if(newItem == null || newItem.getType() == Material.AIR) {
                return;
            }

            NBTItem nbtItem2 = new NBTItem(newItem);

            if(nbtItem2.hasKey("UUID")) {
                int defense = Integer.parseInt(nbtItem2.getString("defense"));
                int health = Integer.parseInt(nbtItem2.getString("health"));
                int strength = Integer.parseInt(nbtItem2.getString("strength"));
                int crit_damage = Integer.parseInt(nbtItem2.getString("crit_damage"));
                int crit_chance = Integer.parseInt(nbtItem2.getString("crit_chance"));
                int luck = Integer.parseInt(nbtItem2.getString("luck"));
                int magic_damage = Integer.parseInt(nbtItem2.getString("magic_damage"));
    
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
    
    @EventHandler
    public void onItemSwap(PlayerItemHeldEvent e) {
        int lastSlot = e.getPreviousSlot();
        int newSlot = e.getNewSlot();

        ItemStack newItem = e.getPlayer().getInventory().getItem(newSlot);
        ItemStack lastItem = e.getPlayer().getInventory().getItem(lastSlot);

        boolean isLastSlotAir = false;
        boolean isNewSlotAir = false;

        if(lastItem == null) {
            isLastSlotAir = true;
        }
        if(newItem == null) {
            isNewSlotAir = true;
        }

        PClass pClass = DataUtils.getPlayerData(e.getPlayer());

        if(!isLastSlotAir) {
            NBTItem lastNBT = new NBTItem(lastItem);

            if(lastNBT.hasKey("UUID")) {
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

        }


        if(!isNewSlotAir) {
            NBTItem lastNBT = new NBTItem(newItem);

            if(lastNBT.hasKey("UUID")) {
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


    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        if(e.getItemDrop().getItemStack() == e.getPlayer().getInventory().getItemInMainHand()) {
            NBTItem lastNBT = new NBTItem(e.getItemDrop().getItemStack());

            PClass pClass = DataUtils.getPlayerData(e.getPlayer());

            if(lastNBT.hasKey("UUID")) {
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
        }
    }

}

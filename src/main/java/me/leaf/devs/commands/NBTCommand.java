package me.leaf.devs.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.tr7zw.nbtapi.NBTItem;

public class NBTCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player plr = (Player) sender;
        if(plr.getInventory().getItemInMainHand().getType() != null || plr.getInventory().getItemInMainHand().getType() != Material.AIR) {
            NBTItem nbtItem = new NBTItem(plr.getInventory().getItemInMainHand());
            nbtItem.getKeys().forEach(key -> {
                String value = nbtItem.getString(key);
                plr.sendMessage("\u00a76" + key + ":\u00a7e" + value);
            });
        }
        return false;
    }
    
}

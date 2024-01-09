package me.leaf.devs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.leaf.devs.Main;
import me.leaf.devs.items.swords.BasicSword;
import me.leaf.devs.items.wands.BasicWand;

import org.bukkit.inventory.ItemStack;

import de.tr7zw.nbtapi.NBTItem;

public class ItemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player plr = (Player) sender;
        if (args.length == 0) {
            sender.sendMessage("§cUsage: /item <item>");
            return true;
        }
        if(Main.items.containsKey(args[0])) {
            ItemStack item = Main.items.get(args[0]).createItem();
            NBTItem nbtItem = new NBTItem(item);
            System.out.println("NBT OF Item " + nbtItem.toString());
            plr.getInventory().addItem(item);
            sender.sendMessage("§aYou have been given the item §6" + item.getItemMeta().getDisplayName() + "§a!");
            return true;
        }
        return false;
    }
}
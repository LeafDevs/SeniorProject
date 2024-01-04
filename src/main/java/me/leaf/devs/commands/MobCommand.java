package me.leaf.devs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.leaf.devs.Main;

public class MobCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player plr = (Player) sender;
        if (args.length == 0) {
            sender.sendMessage("§cUsage: /mob <mob>");
            return true;
        }
        if(Main.entities.containsKey(args[0])) {
            me.leaf.devs.entities.EntityBuilder entity = Main.entities.get(args[0].toLowerCase());
            entity.spawn(plr.getLocation());
            sender.sendMessage("§aYou have spawned a §6" + entity.getName() + "§a!");
            return true;
        }
        return false;
    }

    
}

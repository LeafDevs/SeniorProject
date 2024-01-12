package me.leaf.devs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class FixStatsCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player plr = (Player) sender;
        plr.kickPlayer("Data Restored!");
        PClass player = DataUtils.getPlayerData(plr);
        return true;
    }
    
}

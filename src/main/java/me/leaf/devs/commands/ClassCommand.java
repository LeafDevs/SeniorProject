package me.leaf.devs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.leaf.devs.items.ClassType;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class ClassCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sender.sendMessage("\u00a7c/class <class>");
            return true;
        }

        Player plr = (Player) sender;

        PClass pClass = DataUtils.getPlayerData(plr);

        if(pClass.getClassType() == ClassType.NOT_PICKED) {
            pClass.sendMessage("&cYou already picked your class!");
            return true;
        }

        switch(args[0].toString().toLowerCase()) {
            case "mage":
                pClass.setClassType(ClassType.MAGE);
                break;
            case "warrior":
                pClass.setClassType(ClassType.WARRIOR);
                break;
            case "druid":
                pClass.setClassType(ClassType.DRUID);
                break;
            case "archer":
                pClass.setClassType(ClassType.ARCHER);
                break;
            case "summoner":
                pClass.setClassType(ClassType.SUMMONER);
                break;
            default:
                pClass.sendMessage("&cThis class does not exist.");
                break;
        }

        DataUtils.savePlayerData(pClass);
        return true;
    }
    
}

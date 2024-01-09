package me.leaf.devs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class StatsCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PClass pClass = DataUtils.getPlayerData((Player) sender);

        pClass.sendMessages(
            "&aStats for &6" + pClass.getPlayer().getDisplayName(),
            "&cStrength: &a" + pClass.getStrength(),
            "&cHealth: &6" +  pClass.getHealth(),
            "&aDefense: &a" + pClass.getDefense(),
            "&aLuck: &6" +  pClass.getLuck(),
            "&9Crit Damage: &a" + pClass.getCritDamage(),
            "&9Crit Chance: &6" +  pClass.getCritChance(),
            "&cMagic Damage: &a" + pClass.getMagicDamage(),
            "&eLevel: &a" + pClass.getLevel(),
            "&eXP: &6" +  pClass.getXP()
            );
        return true;
    }
    
}

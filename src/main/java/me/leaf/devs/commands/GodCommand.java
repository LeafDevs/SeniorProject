package me.leaf.devs.commands;

import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player plr) {
            PClass pClass = DataUtils.getPlayerData(plr);
            assert pClass != null;
            pClass.setGodMode(!(pClass.isGod()));
            if(pClass.isGod()) {
                pClass.sendMessage("&7You are currently in &cGod Mode&7!");
                return true;
            }
            pClass.sendMessage("&7You are currently not in &cGod Mode&7!");
            return true;
         }
        return false;
    }
}

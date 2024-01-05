package me.leaf.devs.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.leaf.devs.items.ClassType;
import me.leaf.devs.utils.ActionBar;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class PlayerJoinEvent implements Listener{
    
    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        org.bukkit.entity.Player plr = e.getPlayer();
        if (!plr.hasPlayedBefore()) {
            me.leaf.devs.utils.DataUtils.createPlayerData(plr);
        } else {
            me.leaf.devs.utils.DataUtils.loadPlayerData(plr);
        }

        PClass pClass = DataUtils.getPlayerData(plr);
        if(pClass.getClassType() == ClassType.NOT_PICKED || pClass.getClassType() == null) {
            plr.sendMessage("§cYou have not picked a class yet! Do /class to pick a class!");
        }

        e.setJoinMessage("§a+ §c" + plr.getName());
        plr.setHealth(20);

        new ActionBar(DataUtils.getPlayerData(plr));
    }

}
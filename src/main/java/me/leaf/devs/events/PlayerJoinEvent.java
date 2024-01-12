package me.leaf.devs.events;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.leaf.devs.items.ClassType;
import me.leaf.devs.utils.ActionBar;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class PlayerJoinEvent implements Listener{


    private HashMap<String, Boolean> kickedUsers = new HashMap<>();
    
    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        org.bukkit.entity.Player plr = e.getPlayer();
        if (!DataUtils.hasPlayerData(plr)) {
            me.leaf.devs.utils.DataUtils.createPlayerData(plr);
            plr.kickPlayer("\u00a7cPlayer Data Created. Please reconnect!");
        } else {
            me.leaf.devs.utils.DataUtils.loadPlayerData(plr);
        }

        if(kickedUsers.containsKey(e.getPlayer().getDisplayName())) {
            kickedUsers.remove(plr.getDisplayName());
        }

        PClass pClass = DataUtils.getPlayerData(plr);
        if(pClass.getClassType() == ClassType.NOT_PICKED || pClass.getClassType() == null) {
            plr.sendMessage("§cYou have not picked a class yet! Do /class to pick a class!");
        }

        pClass.setHP(pClass.getHealth());

        if(pClass.getClassType() == null) {
            System.out.println(pClass.getPlayer().getDisplayName() + " Joined Current Data: Level" + pClass.getLevel() + " XP:" + pClass.getXP() + " Class:" + "None");
        } else {
            System.out.println(pClass.getPlayer().getDisplayName() + " Joined Current Data: Level" + pClass.getLevel() + " XP:" + pClass.getXP() + " Class:" + pClass.getClassType().getName());
        }


        e.setJoinMessage("§a+ §c" + plr.getName());
        plr.setHealth(20);

        new ActionBar(DataUtils.getPlayerData(plr));
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent e) {
        kickedUsers.put(e.getPlayer().getDisplayName(), true);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player plr = e.getPlayer();
        
        PClass pClass = DataUtils.getPlayerData(plr);

        if(!kickedUsers.containsKey(e.getPlayer().getDisplayName())) {
            DataUtils.savePlayerData(pClass);
        }

        e.setQuitMessage("§a- §c" + plr.getName()); 
    }

}
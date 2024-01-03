package me.leaf.devs.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

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



        new ActionBar(DataUtils.getPlayerData(plr));
    }

}
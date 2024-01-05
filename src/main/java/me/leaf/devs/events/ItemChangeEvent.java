package me.leaf.devs.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class ItemChangeEvent implements Listener {
    
    @EventHandler
    public void onItemSwap(PlayerItemHeldEvent e) {
        e.getPlayer().sendMessage("Swapped Items");
    }

}

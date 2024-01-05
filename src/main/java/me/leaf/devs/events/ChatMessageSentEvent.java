package me.leaf.devs.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChatMessageSentEvent implements Listener {

    private String messageFormat = "§7[§c%player%§7] » §f%message%";


    @EventHandler
    public void onChat(org.bukkit.event.player.AsyncPlayerChatEvent e) {
        e.setFormat(messageFormat.replace("%player%", e.getPlayer().getName()).replace("%message%", e.getMessage()));
    }
    
}

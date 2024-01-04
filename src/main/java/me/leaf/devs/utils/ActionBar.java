package me.leaf.devs.utils;

import org.bukkit.scheduler.BukkitRunnable;

import me.leaf.devs.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.entity.Player;

public class ActionBar extends BukkitRunnable {

    private PClass plr;

    public ActionBar(PClass plr) {
        this.plr = plr;
        this.runTaskTimer(Main.getPlugin(), 0, 5);
    }

    @Override
    public void run() {
        String messageUnformatted = "§c{health}♥     §9{mana}✎      §6Level: {level}";
        Player player = plr.getPlayer();
        int health = plr.getHealth();
        int mana = plr.getMana();
        int level = plr.getLevel();

        String message = messageUnformatted.replace("{health}", String.valueOf(health)).replace("{mana}", String.valueOf(mana)).replace("{level}", String.valueOf(level));

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }


}

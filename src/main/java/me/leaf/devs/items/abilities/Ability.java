package me.leaf.devs.items.abilities;

import me.leaf.devs.Main;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Ability {

    private String name;
    private int manaCost, cooldown;

    public Ability(String name, int manaCost, int cooldown) {
        this.name = name;
        this.manaCost = manaCost;
        this.cooldown = cooldown;
    }

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getCooldown() {
        return cooldown;
    }

    public abstract void execute(PlayerInteractEvent e);


    public String getID() {
        return this.name.replace(" ", "").toLowerCase();
    }


}

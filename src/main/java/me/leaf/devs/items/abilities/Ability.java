package me.leaf.devs.items.abilities;

import org.bukkit.event.player.PlayerInteractEvent;

public abstract class Ability {

    private String name;
    private int manaCost;
    private long cooldown;

    public Ability(String name, int manaCost, int cooldown) {
        this.name = name;
        this.manaCost = manaCost;
        this.cooldown = (long) (cooldown * 1000L);
    }

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getCooldown() {
        return (int) cooldown;
    }

    public abstract void execute(PlayerInteractEvent e);


    public String getID() {
        return this.name.replace(" ", "").toLowerCase();
    }


}

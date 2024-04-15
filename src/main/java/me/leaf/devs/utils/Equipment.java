package me.leaf.devs.utils;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Equipment {

    private ItemStack helditem, helmet, chestplate, leggings, boots;

    public Equipment() {
        this.boots = null;
        this.helmet = null;
        this.chestplate = null;
        this.leggings = null;
        this.helditem = null;
    }


    public ItemStack getItem() {
        return helditem;
    }

    public @NotNull Equipment setItem(ItemStack helditem) {
        this.helditem = helditem;
        return this;
    }

    public ItemStack getHelmet() {
        return helmet;
    }

    public @NotNull Equipment setHelmet(ItemStack helmet) {
        this.helmet = helmet;
        return this;
    }

    public ItemStack getChestplate() {
        return chestplate;
    }

    public @NotNull Equipment setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
        return this;
    }

    public ItemStack getLeggings() {
        return leggings;
    }

    public @NotNull Equipment setLeggings(ItemStack leggings) {
        this.leggings = leggings;
        return this;
    }

    public ItemStack getBoots() {
        return boots;
    }

    public @NotNull Equipment setBoots(ItemStack boots) {
        this.boots = boots;
        return this;
    }
}

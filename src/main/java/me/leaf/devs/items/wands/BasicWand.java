package me.leaf.devs.items.wands;

import me.leaf.devs.items.Item;
import me.leaf.devs.items.ItemType;
import me.leaf.devs.utils.Rarity;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BasicWand {

    private Item item;

    public BasicWand() {
        ItemStack item = new ItemStack(Material.STICK);
        this.item = new Item("Basic Wand", 0, 0, 0, 0, 0, 0, 0, 10, Rarity.COMMON, item ,ItemType.WAND, "A basic wand.");
    }

    public static Item getItem() {
        Item item = new BasicWand().item;
        return item;
    }

} 
package me.leaf.devs.items.swords;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.leaf.devs.items.Item;
import me.leaf.devs.items.ItemType;
import me.leaf.devs.items.wands.BasicWand;
import me.leaf.devs.utils.Rarity;

public class GodSword {

    public Item item;

    public GodSword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        this.item = new Item("God Sword", 999, 999, 999, 999, 999, 999, 999, 999, Rarity.SACRED, item ,ItemType.SWORD, "Sword forged by the", "gods for their children.");
    }

    public static Item getItem() {
        Item item = new BasicWand().item;
        return item;
    }
}

package me.leaf.devs.items.swords;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.leaf.devs.items.Item;
import me.leaf.devs.items.ItemType;
import me.leaf.devs.utils.Rarity;

public class BasicSword {

    private Item item;
    
    public BasicSword() {
        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        this.item = new Item("Basic Sword", 10, 0, 0, 0, 0, 0, 0, 0, Rarity.COMMON, item,ItemType.SWORD, "A basic sword.");
    }

    public static Item getItem() {
        Item item = new BasicSword().item;
        return item;
    }


}

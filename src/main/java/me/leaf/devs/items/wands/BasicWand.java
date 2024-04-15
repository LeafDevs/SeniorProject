package me.leaf.devs.items.wands;

import me.leaf.devs.items.ClassType;
import me.leaf.devs.items.Item;
import me.leaf.devs.items.ItemType;
import me.leaf.devs.utils.Rarity;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BasicWand {

    public Item item;

    public BasicWand() {
        ItemStack item = new ItemStack(Material.STICK);
        this.item = new Item("Beating Stick", 4, 0, 0, 0, 0, 0, 0, 0, Rarity.COMMON, item,ItemType.WAND, ClassType.MAGE,"The stick you were beat with.", "Later acquired by you after escaping.");
    }

    public static Item getItem() {
        Item item = new BasicWand().item;
        return item;
    }

} 
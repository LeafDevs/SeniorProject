package me.leaf.devs.items.swords;

import me.leaf.devs.items.ClassType;
import me.leaf.devs.items.Item;
import me.leaf.devs.items.ItemType;
import me.leaf.devs.utils.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class WarAxe {

    public Item item;

    public WarAxe() {
        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        this.item = new Item("War Axe", 450, 325, 225, 100, 10, 0, 0, 250, Rarity.ANCIENT, item, ItemType.SWORD, ClassType.ALL, "Forged by The War God Himself.");
    }

    public static Item getItem() {
        return new WarAxe().item;
    }

}

package me.leaf.devs.items.misc;

import me.leaf.devs.items.ClassType;
import me.leaf.devs.items.Item;
import me.leaf.devs.items.ItemType;
import me.leaf.devs.utils.Rarity;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DogStick {

    public Item item;

    public DogStick() {
        ItemStack item = new ItemStack(Material.STICK);
        this.item = new Item("Dog Stick", 4, 0, 0, 0, 0, 0, 0, 0, Rarity.SACRED, item,ItemType.MISC_ITEM, ClassType.ALL,"Spawns a wolf pack when you right click.");
    }

    public static Item getItem() {
        return new DogStick().item;
    }

}
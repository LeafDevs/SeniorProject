package me.leaf.devs.items.misc;

import me.leaf.devs.items.ClassType;
import me.leaf.devs.items.Item;
import me.leaf.devs.items.ItemType;
import me.leaf.devs.items.swords.WarAxe;
import me.leaf.devs.utils.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class WarpStaff {

    public Item item;

    public WarpStaff() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        this.item = new Item("Warp Staff", 0, 0, 0, 0, 0, 0, 0, 0, Rarity.EPIC, item, ItemType.MISC_ITEM, ClassType.ALL,"Teleports you 4 blocks in any direction");
    }

    public static Item getItem() {
        return new WarpStaff().item;
    }
}

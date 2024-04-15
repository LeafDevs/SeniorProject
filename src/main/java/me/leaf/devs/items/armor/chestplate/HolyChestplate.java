package me.leaf.devs.items.armor.chestplate;

import me.leaf.devs.items.Armor;
import me.leaf.devs.items.ArmorType;
import me.leaf.devs.items.ClassType;
import me.leaf.devs.items.armor.boots.HolyBoots;
import me.leaf.devs.utils.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class HolyChestplate{
    private Armor armor;
    public HolyChestplate() {
        this.armor = new Armor("Holy Chestplate", 210, 325, 10, 0, 1250, 525, 0, Rarity.BLESSED, new ItemStack(Material.IRON_CHESTPLATE), ArmorType.CHESTPLATE, ClassType.ALL, "For those who wish to protect.");
    }

    public static Armor getItem() {
        Armor item = new HolyChestplate().armor;
        return item;
    }
}

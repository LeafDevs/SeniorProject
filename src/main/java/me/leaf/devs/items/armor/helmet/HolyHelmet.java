package me.leaf.devs.items.armor.helmet;

import me.leaf.devs.items.Armor;
import me.leaf.devs.items.ArmorType;
import me.leaf.devs.items.ClassType;
import me.leaf.devs.items.armor.boots.HolyBoots;
import me.leaf.devs.utils.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class HolyHelmet {

    private Armor armor;

    public HolyHelmet() {
        this.armor = new Armor("Holy Helmet", 210, 325, 10, 0, 1150, 525, 0, Rarity.BLESSED, new ItemStack(Material.GOLDEN_HELMET), ArmorType.HELMET, ClassType.ALL, "For those who wish to protect.");
    }

    public static Armor getItem() {
        Armor item = new HolyHelmet().armor;
        return item;
    }
}

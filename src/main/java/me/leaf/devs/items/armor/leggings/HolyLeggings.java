package me.leaf.devs.items.armor.leggings;

import me.leaf.devs.items.Armor;
import me.leaf.devs.items.ArmorType;
import me.leaf.devs.items.ClassType;
import me.leaf.devs.items.armor.helmet.HolyHelmet;
import me.leaf.devs.utils.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class HolyLeggings {
    private Armor armor;

    public HolyLeggings() {
        this.armor = new Armor("Holy Leggings", 210, 325, 10, 0, 1200, 525, 0, Rarity.BLESSED, new ItemStack(Material.CHAINMAIL_LEGGINGS), ArmorType.LEGGINGS, ClassType.ALL, "For those who wish to protect.");
    }

    public static Armor getItem() {
        Armor item = new HolyLeggings().armor;
        return item;
    }
}

package me.leaf.devs.items.armor.boots;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.leaf.devs.items.Armor;
import me.leaf.devs.items.ArmorType;
import me.leaf.devs.items.ClassType;
import me.leaf.devs.items.Item;
import me.leaf.devs.items.ItemType;
import me.leaf.devs.items.wands.BasicWand;
import me.leaf.devs.utils.Rarity;

public class HolyBoots{

    private Armor armor;

    public HolyBoots() {
        this.armor = new Armor("Holy Boots", 125, 250, 0, 10, 1225, 300, 120, Rarity.BLESSED, new ItemStack(Material.IRON_BOOTS), ArmorType.BOOTS, ClassType.ALL, "Boots that were blessed by", "the Almighty God");
    }

    public static Armor getItem() {
        Armor item = new HolyBoots().armor;
        return item;
    }

    
    
}

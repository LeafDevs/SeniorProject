package me.leaf.devs.items.swords;

import me.leaf.devs.items.Item;

public class BasicSword {

    private Item item;
    
    public BasicSword() {
        this.item = new Item("Basic Sword", 10, 0, 0, 0, 0, 0, 0, 0, Rarity.COMMON, "A basic sword.");
    }

    public static Item getItem() {
        Item item = new BasicSword().item;
        return item;
    }


}

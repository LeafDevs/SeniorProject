package me.leaf.devs.items.wands;

import me.leaf.devs.items.Item;

public class BasicWand {

    private Item item;

    public BasicWand() {
        this.item = new Item("Basic Wand", 0, 0, 0, 0, 0, 0, 0, 10, Rarity.COMMON, "A basic wand.");
    }

    public static Item getItem() {
        Item item = new BasicWand().item;
        return item;
    }

}
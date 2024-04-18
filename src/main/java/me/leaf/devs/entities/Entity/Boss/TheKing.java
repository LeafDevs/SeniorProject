package me.leaf.devs.entities.Entity.Boss;

import me.leaf.devs.entities.*;
import me.leaf.devs.utils.Equipment;
import me.leaf.devs.utils.Runnables.Entity.BossBarUpdater;
import me.leaf.devs.utils.Runnables.Entity.UpdateNPC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class TheKing extends Boss {

    public TheKing() {
        super("King Caesar", 45, 22500, 250, Skins.KING.asSkin());
    }

    @Override
    public Entity spawn(Location loc) {
        NPC entity = new NPC(this.getName(), loc);

        entity.createNPC();

        entity.setNPCSkin(skin);
        entity.spawnNPC();
        entity.setEnemy();
        entity.setDamage(getDamage());
        entity.setHealth(getHealth());
        entity.setEquipment(
                new Equipment().setItem(new ItemStack(Material.DIAMOND_SWORD))
        );
        this.npc = entity;

        this.ent = entity.asEntity();
        this.createBossBar();

        new BossBarUpdater(this);


        EntityBuilder.entityGroups.put(ent, this);

        new UpdateNPC(this);

        return this.ent;
    }

}

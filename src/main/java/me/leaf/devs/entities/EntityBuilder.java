package me.leaf.devs.entities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import me.leaf.devs.utils.MobHealthUpdater;

public class EntityBuilder {

    public EntityBuilder(String name, int health, int level, int damage, EntityType type) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.damage = damage;
        this.type = type;
    }

    private String name;
    private int health;
    private int level;
    private int damage;
    private EntityType type;
    private Entity ent;

    private ArmorStand armorStand;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public ArmorStand getArmorStand() {
        return armorStand;
    }

    public void createArmorStand(World world) {
        ArmorStand aStand = (ArmorStand) world.spawnEntity(ent.getLocation(), EntityType.ARMOR_STAND);
        aStand.setGravity(false);
        aStand.setVisible(false);
        aStand.setInvulnerable(true);
        aStand.setCustomNameVisible(true);

        String n = "§6{name} | §4[§c{health}§4] | §2[§6{level}§2]";
        aStand.setCustomName(n.replace("{name}", name).replace("{health}", String.valueOf(health)).replace("{level}", String.valueOf(level)));

        this.armorStand = aStand;
    }

    public void updateArmorStand() {
        armorStand.teleport(ent.getLocation().add(0, .2, 0));
        String n = "§6{name} | §4[§c{health}§4] | §2[§6{level}§2]";
        armorStand.setCustomName(n.replace("{name}", name).replace("{health}", String.valueOf((int) ((LivingEntity) ent).getHealth())).replace("{level}", String.valueOf(level)));
        
    }

    public void removeArmorStand() {
        armorStand.remove();
    }
    
    public void setHealth(int health) {
        this.health = health;
    }

    public void spawn(Location loc) {
        Entity ent = loc.getWorld().spawnEntity(loc, type);
        ((LivingEntity) ent).setMaxHealth(health);
        ((LivingEntity) ent).setHealth(health);
        ent.setFireTicks(0);
        this.ent = ent;
        createArmorStand(loc.getWorld());
        new MobHealthUpdater(ent, this);
        
    }

}

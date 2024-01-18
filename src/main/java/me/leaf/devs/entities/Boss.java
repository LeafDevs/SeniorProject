package me.leaf.devs.entities;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;

import me.leaf.devs.utils.MobHealthUpdater;

public abstract class Boss {

    /**
     * 
     * FIX THE MobHealthUpdater(); SO THAT ENTITY ISNT NULL FOR SOME REASON IT IS REGISTERING IT AS NULL
     * 
     * maybe turn this into the EntityBuilder early and spawn it through that?
     * disable the part if it has boss as true where it is giving the equipment to the mob based on its health.
     * 
     * also fix the teleport attack ability. i dont think it works.
     * 
     */

    public static HashMap<Entity, Boss> bosses = new HashMap<>();
    
    public Boss(EntityType ent, int level) {
        this.entType = ent;
        this.level = level;
    }
    private EntityType entType;
    private Entity ent;
    private int level;
    private ArmorStand armorStand;

    private String name;

    private int health, currentHealth, damage, defense;


    public void spawn(Location spawn) {
        Entity ent = spawn.getWorld().spawnEntity(spawn, entType);
        bosses.put(ent, this);
        ((LivingEntity) ent).setMaxHealth(health);
        ((LivingEntity) ent).setHealth(health);
        LivingEntity livingEnt = (LivingEntity) ent;
        ent.setFireTicks(0);

        if(ent instanceof Zombie) {
            ((Zombie) ent).setAdult();
        }

        livingEnt.getEquipment().clear();

        this.ent = ent;
        createArmorStand(spawn.getWorld());
        EntityBuilder eb = this.toEntityBuilder();
        EntityBuilder.entityGroups.put(ent, eb);
        new MobHealthUpdater(ent, eb);

        initRunnables();
    }

    public abstract void initRunnables();

    public abstract String getSpawnMessage();

    public Boss setName(String name) {
        this.name = name;
        return this;
    }

    public Boss setHealth(int hp) {
        this.health = hp;
        this.currentHealth = hp;
        return this;
    }

    public Boss setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public Boss setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHP() {
        return this.currentHealth;
    }

    public int getHealth() {
        return this.health;
    }

    public Boss removeHP(int hp) {
        this.currentHealth -= hp;
        return this;
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


    public EntityBuilder toEntityBuilder() {
        return new EntityBuilder(name, health, level, damage, entType);
    }



}

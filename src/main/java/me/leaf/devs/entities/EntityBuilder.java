package me.leaf.devs.entities;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;

import me.leaf.devs.entities.Entity.Default;
import me.leaf.devs.utils.Runnables.Entity.MobHealthUpdater;

public abstract class EntityBuilder {

    public static EntityBuilder def = new Default();


    public static HashMap<Entity, EntityBuilder> entityGroups = new HashMap<>();

    public EntityBuilder(String name, int health, int level, int damage, EntityType type) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.damage = damage;
        this.type = type;
        this.defense = 0;
    }

    public EntityBuilder(String name, int health, int level, int damage, EntityType type, int defense) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.damage = damage;
        this.type = type;
        this.defense = defense;
    }

    private String name;
    private int health;
    private int level;
    private int damage;
    private EntityType type;
    private Entity ent;
    private int defense;

    private boolean boss = false;

    private ArmorStand armorStand;

    public Entity getEntity() {
        return ent;
    }

    public EntityBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
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

    public EntityBuilder setBoss() {
        this.boss = true;
        return this;
    }

    public boolean isBoss() {
        return boss;
    }

    public EntityBuilder setDefense(int def) {
        this.defense = def;
        return this;
    }

    public EntityBuilder setMaxHealth(int hp) {
        this.health = hp;
        return this;
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
    
    public EntityBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public EntityBuilder setLevel(int level) {
        this.level = level;
        return this;
    }


    public void initRunnables() {
        return;
    }

    public Entity spawn(Location loc) {
        Entity ent = loc.getWorld().spawnEntity(loc, type);
        entityGroups.put(ent, this);
        ((LivingEntity) ent).setMaxHealth(health);
        ((LivingEntity) ent).setHealth(health);
        LivingEntity livingEnt = (LivingEntity) ent;
        ent.setFireTicks(0);




        if(ent instanceof Zombie) {
            ((Zombie) ent).setAdult();
        }
        if(this.level >= 11 && this.level <= 25) {
            livingEnt.getEquipment().setHelmet(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_HELMET));
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.STONE_SWORD));
        }
        if(this.level >= 26 && this.level <= 35) {
            livingEnt.getEquipment().setHelmet(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_HELMET));
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.CHAINMAIL_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.CHAINMAIL_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.CHAINMAIL_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_SWORD));
        }
        if(this.level >= 36 && this.level <= 60) {
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.GOLDEN_SWORD));
        }
        if(this.level >= 61 && this.level <= 80) {
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD));
        }
        if(this.level >= 81 && this.level <= 100) {
            livingEnt.getEquipment().setHelmet(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_HELMET));
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.NETHERITE_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD));
        }
        this.ent = ent;
        createArmorStand(loc.getWorld());
        new MobHealthUpdater(ent, this);
        this.initRunnables();
        

        return this.ent;
    }


    public Entity respawn(Location loc) {
        Entity ent = loc.getWorld().spawnEntity(loc, type);
        entityGroups.put(ent, this);
        ((LivingEntity) ent).setMaxHealth(health);
        ((LivingEntity) ent).setHealth(health);
        LivingEntity livingEnt = (LivingEntity) ent;
        ent.setFireTicks(0);

        if(ent instanceof Zombie) {
            ((Zombie) ent).setAdult();
        }
        if(this.level >= 11 && this.level <= 25) {
            livingEnt.getEquipment().setHelmet(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_HELMET));
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.STONE_SWORD));
        }
        if(this.level >= 26 && this.level <= 35) {
            livingEnt.getEquipment().setHelmet(new org.bukkit.inventory.ItemStack(org.bukkit.Material.LEATHER_HELMET));
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.CHAINMAIL_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.CHAINMAIL_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.CHAINMAIL_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_SWORD));
        }
        if(this.level >= 36 && this.level <= 60) {
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.GOLDEN_SWORD));
        }
        if(this.level >= 61 && this.level <= 80) {
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.IRON_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD));
        }
        if(this.level >= 81 && this.level <= 100) {
            livingEnt.getEquipment().setHelmet(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_HELMET));
            livingEnt.getEquipment().setChestplate(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_CHESTPLATE));
            livingEnt.getEquipment().setLeggings(new org.bukkit.inventory.ItemStack(org.bukkit.Material.NETHERITE_LEGGINGS));
            livingEnt.getEquipment().setBoots(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_BOOTS));
            livingEnt.getEquipment().setItemInMainHand(new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD));
        }
        this.ent = ent;
        createArmorStand(loc.getWorld());
        new MobHealthUpdater(ent, this);
        

        return this.ent;
    }

}

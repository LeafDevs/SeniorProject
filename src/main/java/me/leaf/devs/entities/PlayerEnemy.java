package me.leaf.devs.entities;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import me.leaf.devs.utils.Utils;
import me.leaf.devs.utils.Runnables.Entity.UpdateNPC;

public class PlayerEnemy extends EntityBuilder {

    protected Skin skin;
    protected NPC npc;
    protected Entity ent;
    private String name;
    private int level;



    private boolean dead = false;


    public PlayerEnemy(String name, int level, int health, int damage, Skin skin) {
        super(name, health, level, damage, null);
        this.name = name;
        this.level = level;
        this.skin = skin;
    }

    public PlayerEnemy(String name, int level, int health, int damage, Skin skin, boolean isBoss) {
        super(name, health, level, damage, null);
        this.name = name;
        this.level = level;
        this.skin = skin;
        this.setBoss();
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
        this.npc = entity;

        this.ent = entity.asEntity();

        EntityBuilder.entityGroups.put(ent, this);

        new UpdateNPC(this);

        return this.ent;
    }


    @Override
    public Entity getEntity() {
        return this.ent;
    }



    public void updateName() {
        this.npc.setNPCName("§6{name} | §4[§c{health}§4] | §2[§6{level}§2]".replace("{level}", String.valueOf(level)).replace("{name}", name).replace("{health}", Utils.formatNumber(npc.getTrait().health)));
    }

    public void setDead(boolean dead) {
        this.dead = dead;
        this.npc.getNPC().destroy();
    }

    public boolean isDead() {
        return dead;
    }
    
    
}

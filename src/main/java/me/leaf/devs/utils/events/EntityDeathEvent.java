package me.leaf.devs.utils.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.utils.PClass;

public class EntityDeathEvent extends Event{


    public EntityDeathEvent(Entity ent, PClass who, EntityBuilder entityBuilder) {
        this.ent = ent;
        this.who = who;
        this.entGroup = entityBuilder;
    }

    private Entity ent;
    private PClass who;
    private EntityBuilder entGroup;


    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Entity getEntity() {
        return ent;
    }

    public PClass getKiller() {
        return who;
    }

    public EntityBuilder getEntityGroup() {
        return entGroup;
    }
    
}

package me.leaf.devs.entities;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.trait.LookClose;
import me.leaf.devs.entities.traits.SkinTrait;

public class NPC {

    public NPC(String display, Location loc) {
        this.display = display;
        this.loc = loc;
    }

    private String display;
    private Location loc;
    private net.citizensnpcs.api.npc.NPC npc;

    public NPC createNPC() {
        this.npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, display);
        this.npc.setAlwaysUseNameHologram(true);
        this.npc.setProtected(true);
        return this;
    }

    public NPC removeNPC() {
        this.npc.destroy();
        return this;
    }

    public NPC spawnNPC() {
        this.npc.spawn(loc);
        return this;
    }

    public NPC despawnNPC() {
        this.npc.despawn();
        return this;
    }

    public NPC setNPCName(String name) {
        this.npc.setName(name);
        return this;
    }
    public NPC setNPCSkin(Skin skin) {
        npc.getOrAddTrait(SkinTrait.class).setSkinPersistent(skin.getName(), skin.getSigniture(), skin.getTexture());
        return this;
    }


    public NPC lookClose() {
        this.npc.getOrAddTrait(LookClose.class).setRange(5);
        return this;
    }





}

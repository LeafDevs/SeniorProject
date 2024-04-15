package me.leaf.devs.entities;

import me.leaf.devs.utils.Equipment;
import net.citizensnpcs.api.trait.trait.Inventory;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.mcmonkey.sentinel.SentinelTrait;
import org.mcmonkey.sentinel.targeting.SentinelTargetingHelper.TargetListType;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.trait.LookClose;
import net.citizensnpcs.trait.SheepTrait;
import net.citizensnpcs.trait.SkinTrait;

public class NPC {

    public NPC(String display, Location loc) {
        this.display = display;
        this.loc = loc;
    }

    private String display;
    private Location loc;
    private net.citizensnpcs.api.npc.NPC npc;


    private SentinelTrait trait;

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

    public NPC setEnemy() {
        SentinelTrait sentinelTrait = npc.getOrAddTrait(SentinelTrait.class);
        trait = sentinelTrait;
        trait.disableTeleporting = true;
        trait.addTarget("Player");
        return this;
    }

    public NPC setNPCName(String name) {
        this.npc.setName(name);
        return this;
    }
    public NPC setNPCSkin(Skin skin) {
        SkinTrait trait = npc.getOrAddTrait(SkinTrait.class);
        trait.setSkinPersistent(skin.getName(), skin.getSigniture(), skin.getTexture());
        return this;
    }


    public NPC lookClose() {
        this.npc.getOrAddTrait(LookClose.class).setRange(5);
        return this;
    }

    public Entity asEntity() {
        return this.npc.getEntity();
    }

    public net.citizensnpcs.api.npc.NPC getNPC() {
        return npc;
    }

    public SentinelTrait getTrait() {
        return trait;
    }

    public SentinelTrait setHealth(int health) {
        trait.health = health;
        trait.allowKnockback = false;
        trait.accuracy = 85;
        return trait;
    }

    public SentinelTrait setDamage(int damage) {
        trait.damage = damage;
        return trait;
    }

    public SentinelTrait setTarget(Entity target) {
        trait.targetingHelper.shouldTarget((LivingEntity) target);
        return trait;
    }


    public NPC setEquipment(@NotNull Equipment equipment) {
        npc.getOrAddTrait(Inventory.class);
        net.citizensnpcs.api.trait.trait.Equipment equip =
                npc.getOrAddTrait(net.citizensnpcs.api.trait.trait.Equipment.class);
        equip.set(0, equipment.getHelmet());
        equip.set(2, equipment.getChestplate());
        equip.set(3, equipment.getLeggings());
        equip.set(4, equipment.getBoots());



        return this;

    }




}

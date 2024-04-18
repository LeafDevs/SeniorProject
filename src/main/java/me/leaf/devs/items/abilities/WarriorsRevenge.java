package me.leaf.devs.items.abilities;

import de.tr7zw.nbtapi.NBTItem;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;
import me.leaf.devs.utils.Utils;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftItem;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class WarriorsRevenge extends Ability {
    public WarriorsRevenge() {
        super("warrior", 0, 0);
    }

    @Override
    public void execute(PlayerInteractEvent e) {
        ArrayList<Entity> ents = Utils.getAllEntities((Entity) e.getPlayer(), 5,3,5);
        PClass plr = DataUtils.getPlayerData(e.getPlayer());
        Random rand = new Random();
        int strength = plr.getStrength();
        int critd = plr.getCritDamage();
        int critc = plr.getCritChance();
        int magicdmg = plr.getMagicDamage();

        NBTItem nbt = new NBTItem(Objects.requireNonNull(e.getItem()));
        int damage = nbt.getInteger("damage");


        boolean isCrit = (rand.nextInt(100) <= critc);

        // str 300 magic dmg 300 damage 300 crit dmg 300
        // b damage: 7,200
        // m damage: 45,460
        // c damage: 8,700


        // total dmg no crit: 52,660
        // total dmg crit: 63,535

        int basedmg = (
                (strength / 75) *
                strength + (damage*3)
        );

        int cdmg = basedmg + (critd * 5);

        int mdmg = (int) ((magicdmg / 75) *
                                (magicdmg*1.2558)+ basedmg);

        int totaldmg = mdmg + basedmg;

        if(isCrit) {
            totaldmg += (int) (cdmg * 1.25);
        }


        plr.sendMessage(
                "&7You used your &cWarrior's Revenge &7ability and dealt &c%1 &7to &c%2&7!"
                .replace("%1", Utils.formatNumber(totaldmg * ents.size()))
                .replace("%2", String.valueOf(ents.size()))
        );

        plr.getPlayer().playSound(e.getPlayer().getLocation(), "entity.generic.explode", 1, 1);
        int finalDmg = totaldmg;
        ents.forEach(ent -> {
            if(!(ent instanceof CraftItem) || ent == e.getPlayer()) {
                if(!(ent instanceof Player && !ent.hasMetadata("NPC"))) {
                    ((LivingEntity) ent).damage(finalDmg);
                }
            }
        });
    }
}

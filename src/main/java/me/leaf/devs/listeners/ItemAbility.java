package me.leaf.devs.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.leaf.devs.Main;
import me.leaf.devs.items.abilities.Ability;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;


public class ItemAbility implements Listener {

    @EventHandler
    public static void abilityUse(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            NBTItem nbt = new NBTItem(Objects.requireNonNull(e.getItem()));

            if(nbt.hasNBTData() && nbt.getString("ability") != null) {
                PClass plr = DataUtils.getPlayerData(e.getPlayer());
                Ability ability = Main.abilities.get(nbt.getString("ability").toLowerCase().replace(" ", ""));
                assert plr != null;
                long seconds = ability.getCooldown();

                if (plr.getCooldowns().containsKey(ability.getID())) {
                    long cooldownEnd = plr.getCooldowns().get(ability.getID());
                    long currentTime = System.currentTimeMillis();

                    if (currentTime < cooldownEnd) {
                        long remainingCooldown = (cooldownEnd - currentTime) / 1000;
                        plr.sendMessage("&cYou are too exhausted to use this ability! &c(%s)"
                                .replace("%s", "" + remainingCooldown));
                        return;
                    }
                }
                if(ability.getManaCost() <= plr.getCurrentMana() || ability.getManaCost() == 0) {
                    plr.setCurrentMana(plr.getCurrentMana() - ability.getManaCost());
                    ability.execute(e);
                    if(ability.getCooldown() != 0) {
                        plr.removeCooldown(ability.getID());
                        plr.addCooldown(ability.getName().toLowerCase().replace(" ", ""), ability.getCooldown());
                    }
                    return;
                }

                plr.sendMessage("&cNot enough mana.");




            }
        }
    }

}

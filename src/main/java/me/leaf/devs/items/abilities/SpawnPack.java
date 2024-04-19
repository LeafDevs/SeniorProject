package me.leaf.devs.items.abilities;

import me.leaf.devs.Main;
import me.leaf.devs.entities.Entity.Beginner.PackLeader;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class SpawnPack extends Ability{
    public SpawnPack() {
        super("Spawn Pack", 0, 0);
    }

    @Override
    public void execute(PlayerInteractEvent e) {
        Block block = e.getPlayer().getTargetBlockExact(25);

        Location loc;

        if (block == null) {
            // Player is targeting air
            loc = e.getPlayer().getLocation().add(e.getPlayer().getLocation().getDirection().multiply(4));
        } else {
            // Player is targeting a block
            loc = block.getLocation().add(0, 1, 0);
        }

        // Spawn wolves
        Wolf leader = (Wolf) Main.entities.get("packleader").spawn(loc);
        leader.setTarget(e.getPlayer());
        leader.setAngry(true);

        for (int i = 0; i <= new Random().nextInt(10); i++) {
            Wolf w1 = (Wolf) Main.entities.get("wolf").spawn(loc);
            w1.setTarget(e.getPlayer());
            w1.setAngry(true);
            w1.setBaby();
        }
    }





}

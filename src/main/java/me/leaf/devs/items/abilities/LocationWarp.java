package me.leaf.devs.items.abilities;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;

public class LocationWarp extends Ability {
    public LocationWarp() {
        super("Warp", 0, 0);
    }

    @Override
    public void execute(PlayerInteractEvent e) {
        Block block = e.getPlayer().getTargetBlockExact(5);

        Location loc;

        if (block == null) {
            // Player is targeting air
            loc = e.getPlayer().getLocation().add(e.getPlayer().getLocation().getDirection().multiply(4));
        } else {
            // Player is targeting a block
            loc = block.getLocation().add(0, 1, 0);
        }

        e.getPlayer().teleport(loc);
        e.getPlayer().playSound(e.getPlayer().getLocation(), "entity.enderman.teleport", 1, 1);
    }
}

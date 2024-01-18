package me.leaf.devs.utils.Attacks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.scheduler.BukkitRunnable;

import me.leaf.devs.entities.EntityBuilder;

public class TeleportHit extends BukkitRunnable {

    private Entity ent;
    private EntityBuilder eb;

    public TeleportHit(Entity ent, EntityBuilder eb) {
        this.ent = ent;
        this.eb = eb;
    }

    @Override
    public void run() {
        if (Math.random() < 0.25) {
            Player closestPlayer = getClosestPlayer(ent, 15);

            if (closestPlayer != null) {
                Location newLocation = getRandomLocationAroundPlayer(closestPlayer);
                ent.teleport(newLocation);

                new EntityDamageEvent(closestPlayer, DamageCause.ENTITY_ATTACK, eb.getDamage());
            }
        }
    }

    private Player getClosestPlayer(Entity entity, double radius) {
        Player closestPlayer = null;
        double closestDistanceSquared = Double.MAX_VALUE;

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld().equals(entity.getWorld())) {
                double distanceSquared = player.getLocation().distanceSquared(entity.getLocation());

                if (distanceSquared < closestDistanceSquared && distanceSquared <= radius * radius) {
                    closestPlayer = player;
                    closestDistanceSquared = distanceSquared;
                }
            }
        }

        return closestPlayer;
    }

    private Location getRandomLocationAroundPlayer(Player player) {
        Location playerLocation = player.getLocation();
        double angle = Math.random() * 2 * Math.PI;
        double distance = Math.random() * 5; // Adjust the distance as needed

        double x = playerLocation.getX() + distance * Math.cos(angle);
        double y = playerLocation.getY();
        double z = playerLocation.getZ() + distance * Math.sin(angle);

        return new Location(player.getWorld(), x, y, z);
    }
}

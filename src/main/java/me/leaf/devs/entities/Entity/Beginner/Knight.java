package me.leaf.devs.entities.Entity.Beginner;

import me.leaf.devs.entities.EntityBuilder;
import me.leaf.devs.entities.NPC;
import me.leaf.devs.entities.PlayerEnemy;
import me.leaf.devs.entities.Skin;
import me.leaf.devs.utils.Equipment;
import me.leaf.devs.utils.Runnables.Entity.UpdateNPC;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class Knight extends PlayerEnemy {

    public Knight() {
        super("Imperial Knight", 3, 125, 5, new Skin("Steve", "ewogICJ0aW1lc3RhbXAiIDogMTcwNjA5MTYwNDM1OCwKICAicHJvZmlsZUlkIiA6ICI1NzgzZWMxNDgxMDI0ZDJmOTk4N2JhNGZhNWNlMmFmOCIsCiAgInByb2ZpbGVOYW1lIiA6ICJCbHVlUGhlbml4NDMiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThhMWQyNjBiODFlYWQxMGI2ZWE5NzRkMDIxZGZhODA3NTIyNDU2YThiYjRiNTU5ZTFmYWNhOTdlZjVmODFmNSIKICAgIH0KICB9Cn0=", "G+VRB/BjC+GzMvyuUHKOZjIG0DM5h+zsxKisjWx4Txy6MBjvarVD65fi8dz2nPG2wK1Xml2OWbmNqNETHmjZrs+W8DyGs/Ol86wJXR2gKhptwTrFo78cwTbr3BLAfxmzt8ot6snkDDwYqe1IX0UkfuAsdx6bMbbAjR05KbdvN7GP9CC9LJpK2Yadsl+fPhT318vX3VHyv3Z4h9rnSF3+fuVC6CWhG4+20XBTDiPm+rw4tceu6qPXI53rfDpgAND5IfQcHagnkpwU3p562diaZ5W6dvWxSDyVvX+l7bgvS5dYrFI1IjyllGvoMCscfSW13zyOR4Mmk1IiWfekHnoDps1dYfmHkOPS76vPWZk9dh/fXoR8UFLSYmtlirX4oW108ITbRqYju8g6V3jwVaj2GYmj67ONeglqTRhSdt5mVEJv5kr148GR+9njhgMjqAx9t5d1tS3AxCJP7JVPFRzwRsHrDa3IQtQBHz5TeTyi4akUITPvRjnie/SBmLNKPuwcaqmuy2ycx4sOhNwuoQBFnnZP9P06rlckVv16eCFaQjMM7wwL1HDufO6uLwC9+M7KKF2kua6HJxw1se3hY9uMYML9xH7/VyBkNIr1i4kT/ls3agzebhBLOxCY0ifS/HSpTowGw/hV5JLcnN3lA/z+yhaFek8HFtwPEtvNb2l1Hbw="));
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
        entity.setEquipment(
                new Equipment().setItem(new ItemStack(Material.IRON_SWORD))
        );
        this.npc = entity;

        this.ent = entity.asEntity();

        EntityBuilder.entityGroups.put(ent, this);

        new UpdateNPC(this);

        return this.ent;
    }
}

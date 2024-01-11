package me.leaf.devs.items;

public enum ClassType {
    MAGE("Mage"), // Wand User
    DRUID("Mage"), // Sword User
    ARCHER("Archer"), // Bow User
    SUMMONER("Summoner"), // Tome User
    WARRIOR("Warrior"), // Spear User
    NOT_PICKED("NOT_PICKED"), // Not Picked a class yet
    ALL("All"),
    ;

    ClassType(String name) {

    }

    private String name;

    public static ClassType getClassType(String name) {
        for (ClassType type : ClassType.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

}

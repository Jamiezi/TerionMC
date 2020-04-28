package Enchantments;

import org.bukkit.Material;

public enum Enc {

    NIGHT_VISION("Night Vision", 1, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Gives night vision
    FLIGHT("Flight", 1, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Gives flight
    LASER("Laser", 1, new Material[]{Material.DIAMOND_PICKAXE}), //Ranged mining
    GOLD_BOOST("Gold Boost", 10000, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Boosts the amount of gold you get from each lucky
    XP_BOOST("XP Boost", 1000, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //More XP from mining
    SPEED("Speed", 2, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Gives speed potion effect
    JUMP("Jump", 2, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Gives jump potion effect
    GREED("Greed", 1000, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Higher sell price
    KEY_FINDER("Key Finder", 10, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Increaes chances of finding keys
    LUCK("Luck", 10000, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Increases chances of finding luckies
    KEY_COMPACTOR("Key Compactor", 1, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Automatically combines keys
    AUTOSELL("Autosell", 1, new Material[]{Material.DIAMOND_PICKAXE, Material.FISHING_ROD}), //Automatically sells items mined
    CHEST_UPGRADER("Chest Upgrader", 1, new Material[]{Material.DIAMOND_PICKAXE}), //Automatically upgrades all chests in inventory
    DUMMY("Dummy", 1, new Material[]{Material.DIAMOND_PICKAXE, Material.DIAMOND_SWORD, Material.FISHING_ROD}), //This is what returns if nothing is found
    VERTICAL("Vertical", 1, new Material[]{Material.DIAMOND_PICKAXE}), //Increases the vertical mining area
    HORIZONTAL("Horizontal", 1, new Material[]{Material.DIAMOND_PICKAXE}), //Increases the horizontal mining area
    REGAL("Regal", 100, new Material[]{Material.DIAMOND_PICKAXE}), //Increases gold found and sell prices based off of prestige
    FRUGAL("Frugal", 1000, new Material[]{Material.DIAMOND_PICKAXE}), //Rankups cost less money
    EFFICIENCY("Efficiency", 10000, new Material[]{Material.DIAMOND_PICKAXE}), //Rankups cost less money
    UNBREAKABLE("Unbreakable", 1, new Material[]{Material.DIAMOND_PICKAXE, Material.DIAMOND_SWORD, Material.FISHING_ROD}), //Rankups cost less money
    FORTUNE("Fortune", 10000, new Material[]{Material.DIAMOND_PICKAXE}); //Rankups cost less money

    public final String label;
    public final int maxLevel;
    public final Material[] mats;

    private Enc(String label, int maxLevel, Material[] mats){
        this.label = label;
        this.maxLevel = maxLevel;
        this.mats = mats;
    }
}

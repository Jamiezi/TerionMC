package Enchantments;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnchantmentHandler {

    public void addEnchantLevel(ItemStack is, Enc enchant, int amount){
        if(containsEnc(is, enchant)) {
            if(willBeMax(getLevel(is, enchant), amount, enchant)){
                editEnc(is, enchant, enchant.maxLevel);
            }
            else{
                editEnc(is, enchant, amount + getLevel(is, enchant));
            }
        }
        else{
            if(willBeMax(getLevel(is, enchant), amount, enchant)){
                addEnc(is, enchant, enchant.maxLevel);
            }
            else{
                addEnc(is, enchant, amount);
            }
        }
        ItemMeta im = is.getItemMeta();
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addEnchant(Enchantment.DEPTH_STRIDER, 1, true);
        is.setItemMeta(im);
    }


    public HashMap<Enc, Integer> enchants(ItemStack pick){
        List<String> lore = pick.getItemMeta().getLore();
        HashMap<Enc, Integer> enchants = new HashMap<Enc, Integer>();
        HashMap<String, Integer> stringEnc = new HashMap<String, Integer>();
        for(int i = 0; i < lore.size(); i++){
            String[] temp = lore.get(i).split(":");
            Enc encType = stringToEnchant(temp[0]);
            if(encType != Enc.DUMMY){
                int tempInt = Integer.parseInt(temp[1]);
                enchants.put(encType, tempInt);
            }
        }


        return enchants;
    }

    private void editEnc(ItemStack pick, Enc enchant, int i){
        ItemMeta im = pick.getItemMeta();
        List<String> lore = pick.getItemMeta().getLore();
        if(enchant == Enc.FORTUNE){
            im.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, i, true);
        }
        else if(enchant == Enc.EFFICIENCY){
            im.addEnchant(Enchantment.DIG_SPEED, i, true);
        }
        for(int in = 0; in < lore.size(); in++){
            String[] temp = lore.get(in).split(":");
            Enc encType = stringToEnchant(ChatColor.stripColor(temp[0]).toLowerCase().replaceAll(" ", ""));
            if(encType == enchant){
                lore.set(in,ChatColor.AQUA + enchant.label + ": " + i);
            }
        }
        im.setLore(lore);
        pick.setItemMeta(im);
    }

    public int getLevel(ItemStack pick, Enc enchant){
        List<String> lore = pick.getItemMeta().getLore();
        int level = 0;

        int line = getLine(pick, enchant);
        if(line != -1){
            String[] temp = ChatColor.stripColor(lore.get(line)).replaceAll(" ", "").split(":");
            level = Integer.parseInt(temp[1]);
        }

        return level;
    }

    private void addEnc(ItemStack pick, Enc enchant, int amount){
        List<String> lore = new ArrayList<String>();
        ItemMeta im = pick.getItemMeta();
        if(pick.getItemMeta().getLore() != null){
            lore = pick.getItemMeta().getLore();
        }
        if(enchant == Enc.FORTUNE){
            im.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, amount, true);
        }
        else if(enchant == Enc.EFFICIENCY){
            im.addEnchant(Enchantment.DIG_SPEED, amount, true);
        }
        lore.add(ChatColor.AQUA + enchant.label + ": " + amount);

        im.setLore(lore);
        pick.setItemMeta(im);
    }

    private boolean containsEnc(ItemStack pick, Enc enchant){
        if(getLine(pick, enchant) == -1){
            return false;
        }
        return true;
    }

    private int getLine(ItemStack pick, Enc enchant){
        if(pick.getItemMeta().getLore() == null){
            return -1;
        }
        List<String> lore = pick.getItemMeta().getLore();
        int line = -1;
        for(int i = 0; i < lore.size(); i++){
            String[] bunk = lore.get(i).split(":");
            String temp = ChatColor.stripColor(bunk[0].replaceAll(" ", "")).toLowerCase();
            Enc encType = stringToEnchant(temp);
            if(encType == enchant){
                line = i;
            }
        }
        return line;
    }

    public boolean isMax(int currentLevel, int addLevel, Enc enchant){
        if(currentLevel >= enchant.maxLevel){
            return true;
        }
        return false;
    }

    public boolean willBeMax(int currentLevel, int addLevel, Enc enchant){
        if(currentLevel + addLevel >= enchant.maxLevel || currentLevel >= enchant.maxLevel){
            return true;
        }
        return false;
    }


    public Enc stringToEnchant(String s){
        String newS = ChatColor.stripColor(s).toLowerCase().replaceAll("_", "").replaceAll(" ","");
        if(newS.equalsIgnoreCase("luck")){
            return Enc.LUCK;
        }
        else if(newS.equalsIgnoreCase("nightvision")){
            return Enc.NIGHT_VISION;
        }
        else if(newS.equalsIgnoreCase("autosell")){
            return Enc.AUTOSELL;
        }
        else if(newS.equalsIgnoreCase("chestupgrader")){
            return Enc.CHEST_UPGRADER;
        }
        else if(newS.equalsIgnoreCase("flight")){
            return Enc.FLIGHT;
        }
        else if(newS.equalsIgnoreCase("goldboost")){
            return Enc.GOLD_BOOST;
        }
        else if(newS.equalsIgnoreCase("greed")){
            return Enc.GREED;
        }
        else if(newS.equalsIgnoreCase("horizontal")){
            return Enc.HORIZONTAL;
        }
        else if(newS.equalsIgnoreCase("vertical")){
            return Enc.VERTICAL;
        }
        else if(newS.equalsIgnoreCase("laser")){
            return Enc.LASER;
        }
        else if(newS.equalsIgnoreCase("jump")){
            return Enc.JUMP;
        }
        else if(newS.equalsIgnoreCase("speed")){
            return Enc.SPEED;
        }
        else if(newS.equalsIgnoreCase("xpboost")){
            return Enc.XP_BOOST;
        }
        else if(newS.equalsIgnoreCase("keyfinder")){
            return Enc.KEY_FINDER;
        }
        else if(newS.equalsIgnoreCase("keycompactor")){
            return Enc.KEY_COMPACTOR;
        }
        else if(newS.equalsIgnoreCase("regal")){
            return Enc.REGAL;
        }
        else if(newS.equalsIgnoreCase("frugal")){
            return Enc.FRUGAL;
        }
        else if(newS.equalsIgnoreCase("fortune")){
            return Enc.FORTUNE;
        }
        else if(newS.equalsIgnoreCase("efficiency")){
            return Enc.FORTUNE;
        }
        else{
            return Enc.DUMMY;
        }
    }
}

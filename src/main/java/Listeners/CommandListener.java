package Listeners;

import Core.Main;
import Enchantments.Enc;
import Enchantments.EnchantmentHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class CommandListener implements CommandExecutor {
    private Main plugin;
    public CommandListener(Main plugin){
        this.plugin = plugin;
    }


    private String noPerm = ChatColor.RED + "You don't have permission to do this.";
// /ce add <enchant> <level>
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("cenchant") || cmd.getName().equalsIgnoreCase("ce") || cmd.getName().equalsIgnoreCase("customenchant")){

                if(args.length < 3){
                    p.sendMessage(Main.prefix + ChatColor.RED + "Correct usage: /ce <set/add/remove> <enchant> [Level]");
                }
                else{
                    if(isInt(args[1])){
                            EnchantmentHandler enc = new EnchantmentHandler();
                            Enc encType = enc.stringToEnchant(args[0]);
                            List<Material> mats = Arrays.asList(encType.mats);
                            if(mats.contains(p.getInventory().getItemInMainHand().getType())) {
                                if (enc.isMax(enc.getLevel(p.getInventory().getItemInMainHand(), encType), Integer.parseInt(args[1]), encType)) {
                                    p.sendMessage(Main.prefix + ChatColor.RED + encType.label + " on this pick is max level.");
                                } else if (encType != Enc.DUMMY) {
                                    enc.addEnchantLevel(p.getInventory().getItemInMainHand(), encType, Integer.parseInt(args[1]));
                                } else {
                                    p.sendMessage(Main.prefix + ChatColor.RED + "Invalid enchantment.");
                                }
                            }
                            else{
                                p.sendMessage(Main.prefix + ChatColor.RED + encType.label + " cannot be applied to this item.");
                            }
                            }
                    else{
                        p.sendMessage(Main.prefix + ChatColor.RED + "The level must be a number.");
                    }
                }
            }
        }
        else{

        }
        return false;
    }

    private boolean isInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}

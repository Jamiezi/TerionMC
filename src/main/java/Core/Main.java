package Core;

import Listeners.CommandListener;
import User.PlayerHandler;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static PlayerHandler playerHandler;
    public static double serverGoldBoost;
    public static double serverSellBoost;
    public final static String prefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "Terion" + ChatColor.GRAY + "]" + ChatColor.RESET + " ";

    public void onEnable(){
        registerListeners();
        registerCommands();
        playerHandler = new PlayerHandler();

        if(this.getConfig().contains("ServerBoosts.Gold")){
            serverGoldBoost = getConfig().getDouble("ServerBoosts.Gold");
        }
        else{
            serverGoldBoost = 1.0;
            getConfig().set("ServerBoosts.Gold", Double.valueOf(1.0));
            saveConfig();
        }

        if(this.getConfig().contains("ServerBoosts.Sell")){
            serverSellBoost = getConfig().getDouble("ServerBoosts.Sell");
        }
        else{
            serverSellBoost = 1.0;
            getConfig().set("ServerBoosts.Sell", Double.valueOf(1.0));
            saveConfig();
        }
    }

    public void registerCommands(){
        getCommand("ce").setExecutor(new CommandListener(this));
//        getCommand("customenchant").setExecutor(new CommandListener(this));
//        getCommand("cenchant").setExecutor(new CommandListener(this));
    }

    public void registerListeners(){

    }
}

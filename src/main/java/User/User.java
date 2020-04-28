package User;

import Core.Main;
import Misc.BasePet;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class User {
    //Store their level, past names, uuid
    private UUID uuid;
    private String[] pastNames;
    private File userFile;
    private Main plugin;
    private Player p;
    private FileConfiguration config;

    public User(Player p, Main plugin){
        this.uuid = p.getUniqueId();
        this.p = p;
        loadPlayerFile();
    }

    private void loadPlayerFile(){
        userFile = new File(plugin.getDataFolder() + "/Users/" + uuid +".yml");
        if(!userFile.exists()){
            //Create the default file
            defaultPlayerFile();
        }
        else{
            //Load money

            //Load level

            //Load xp

            //Load talent choices

            //Load past names

            //Load pets

            //Load boosts

            //Load tokens

        }
    }

    private void savePlayerFile(){

    }


    private void defaultPlayerFile(){
        FileConfiguration config = YamlConfiguration.loadConfiguration(userFile);

        //Set money
        config.set("Money", Integer.valueOf(0));
        //Set level
        config.set("Level", Integer.valueOf(0));
        //Set xp
        config.set("Xp", Integer.valueOf(0));
        //Set talent choices
        config.set("Talents", Integer.valueOf(0));
        //Set past names
        config.set("PastNames", "");
        //Set pets
        config.set("Pets", new ArrayList<BasePet>());
        //Set boosts
        config.set("SellBoost", "1");
        config.set("GoldBoost", "1");
        //Set tokens
        config.set("Gold", Integer.valueOf(0));
    }

    private void saveConfig(){
        
    }

    public Player getPlayer(){
        return p;
    }

}

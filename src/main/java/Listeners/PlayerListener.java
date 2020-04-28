package Listeners;

import Core.Main;
import User.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private Main plugin;
    public PlayerListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Main.playerHandler.addUser(e.getPlayer(), new User(e.getPlayer(), plugin));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE){

        }
//        else if(){
//
//        }
    }

}

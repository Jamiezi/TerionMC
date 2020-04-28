package User;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerHandler {
    private HashMap<Player, User> users = new HashMap<Player, User>();

    public User getUser(Player p){
        if(users.containsKey(p)){
            return users.get(p);
        }
        return null;
    }

    public void addUser(Player p, User user){
        users.put(p,user);
    }

    public void removeUser(Player p){

    }
}

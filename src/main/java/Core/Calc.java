package Core;

import User.User;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Calc {

    private User user;

    public Calc(User user) {
        this.user = user;
    }

    public void calcBlockDrops(){
        ItemStack is = user.getPlayer().getInventory().getItemInMainHand();

        int fortune = is.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);

    }

}

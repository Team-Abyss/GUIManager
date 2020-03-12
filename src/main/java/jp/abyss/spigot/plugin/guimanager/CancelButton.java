package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class CancelButton extends DefaultButton {

    public CancelButton(int index, ItemStack itemStack) {
        super(index, itemStack);
    }

    @Override
    public void click(GUI gui, Player player, ClickType type){
        GUI parent = gui.getParent();
        if (parent != null){
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1f,1.5f);
            parent.openInventory(player);
        }
    }
}

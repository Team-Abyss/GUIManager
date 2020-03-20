package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BackButton extends DefaultButton {

    public BackButton(int index, ItemStack itemStack) {
        super(index, itemStack);
    }

    @Override
    public void click(@NotNull GUI gui, @NotNull Player player, @NotNull ClickType type){
        GUI parent = gui.getParent();
        if (parent != null){
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1f,1.5f);
            gui.openLinkedGUI(parent,player);
        }
    }
}

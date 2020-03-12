package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public interface Button {

    int getIndex();


    /**
     * @return ItemStack of GUI(Material is never changer)
     */
    Material getMaterial();

    /**
     *
     * @param player GUI holder
     * @return ItemStack of GUI(Material is never changer)
     */
    ItemStack getItemStack(Player player);

    void click(GUI gui, Player player, ClickType type);

}

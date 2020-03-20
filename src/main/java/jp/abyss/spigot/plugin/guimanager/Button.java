package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface Button {

    int getIndex();


    /**
     * @return ItemStack of GUI(Material is never changed)
     */
    Material getMaterial();

    /**
     *
     * @param player GUI holder
     * @return ItemStack of GUI(Material is never changed)
     */
    ItemStack getItemStack(@NotNull Player player);

    void click(@NotNull GUI gui,@NotNull Player player,@NotNull ClickType type);

}

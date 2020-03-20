package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DefaultButton implements Button {
    public DefaultButton(int index, ItemStack itemStack){
        this.index = index;
        this.material = itemStack.getType();
        this.itemStack = itemStack;
    }
    private int index;
    private Material material;
    private ItemStack itemStack;

    @Override
    public int getIndex(){
        return index;
    }

    @Override
    public Material getMaterial(){
        return material;
    }

    @Override
    public ItemStack getItemStack(@NotNull Player player){
        return itemStack;
    }

    @Override
    public void click(@NotNull GUI gui, @NotNull Player player, @NotNull ClickType type){
    }
}

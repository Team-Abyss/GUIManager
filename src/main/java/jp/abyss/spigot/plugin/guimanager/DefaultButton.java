package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class DefaultButton implements Button {
    DefaultButton(int index, ItemStack itemStack){
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
    public ItemStack getItemStack(Player player){
        return itemStack;
    }

    @Override
    public void click(GUI gui, Player player, ClickType type){
    }
}

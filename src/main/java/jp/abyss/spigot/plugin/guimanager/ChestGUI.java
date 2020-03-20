package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ChestGUI extends GUI {

    public ChestGUI(GUI parent,String name, int size, Button...buttons){
        for (Button button: buttons){
            buttonMap.put(button.getIndex(),button);
        }
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.buttons = buttons;
    }

    private GUI parent;
    private String name;
    private int size;
    private Button[] buttons;

    private Map<Integer, Button> buttonMap = new HashMap<>();

    @Override
    public GUI getParent(){
        return parent;
    }

    @Override
    public Inventory getInventory(@NotNull Player player){
        Inventory inv = Bukkit.createInventory(null,size,name);
        for (Button button :buttons){
            inv.setItem(button.getIndex(),button.getItemStack(player));
        }
        return inv;
    }

    @Override
    public void openInventory(@NotNull Player player){
        player.openInventory(getInventory(player));
    }

    @Override
    public void upDataInventory(@NotNull Player player){
        if (same(player.getOpenInventory())){
            Inventory top = player.getOpenInventory().getTopInventory();
            for (Button button :buttons){
                top.setItem(button.getIndex(),button.getItemStack(player));
            }
        }
    }

    @Override
    public Material getMaterial(int index){
        Button button = buttonMap.get(index);
        if (button == null){
            return null;
        }else {
            return button.getMaterial();
        }
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public ItemStack getItem(@NotNull Player player, int index){
        return buttonMap.get(index).getItemStack(player);
    }

    @Override
    public void clickButton(@NotNull Player player, int index, @NotNull ClickType type){
        Button button = buttonMap.get(index);
        if (button != null){
            button.click(this,player,type);
        }
    }

    @Override
    public InventoryType getType(){
        return InventoryType.CHEST;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void onClose(@NotNull Player player){}

}

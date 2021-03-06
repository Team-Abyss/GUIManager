package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class GUI {

    public GUI(){
        entry();
    }

    protected static Set<GUI> guiEntrySet = new HashSet<>();
    static List<Player> exclude = new ArrayList<Player>();

    static GUI getGui(InventoryView view){
        for (GUI entry : guiEntrySet){
            if (entry.same(view)){
                return entry;
            }
        }
        return null;
    }

    public boolean same(InventoryView view){
        if (view == null) return false;
        if (getType() != view.getType()) return false;
        if (! getName().equals(view.getTitle())) return false;
        Inventory top = view.getTopInventory();
        if (getSize() != top.getSize()) return false;
        for (int i = 0;i < getSize();i++){
            Material material = getMaterial(i);
            ItemStack itemStack = top.getItem(i);
            if (itemStack == null){
                if (material != null){
                    return false;
                }
            }else {
                if (itemStack.getType() != material){
                    return false;
                }
            }
        }
        return true;
    }

    public final void entry(){
        guiEntrySet.add(this);
    }

    public abstract GUI getParent();

    public abstract Inventory getInventory(@NotNull Player player);

    public abstract void openInventory(@NotNull Player player);

    public abstract void upDataInventory(@NotNull Player player);

    public final void openLinkedGUI(@NotNull GUI gui,@NotNull Player player){
        exclude.add(player);
        gui.openInventory(player);
    }

    public abstract void onClose(@NotNull Player player);

    /**
     * @param index The index of the Slot's ItemStack to return
     */
    public abstract Material getMaterial(int index);

    public abstract String getName();

    public abstract ItemStack getItem(@NotNull Player player, int index);

    public abstract void clickButton(@NotNull Player player, int index,@NotNull ClickType type);

    public abstract InventoryType getType();

    /**
     *Returns the size of the inventory
     * @return  The size of the inventory
     */
    public abstract int getSize();
}

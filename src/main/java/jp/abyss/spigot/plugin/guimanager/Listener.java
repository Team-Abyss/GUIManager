package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void click(InventoryClickEvent event){
        if (! event.getClickedInventory().equals(event.getView().getTopInventory())){
            return;
        }

        GUI gui = GUI.getGui(event.getView());
        if (gui !=null){
            gui.clickButton((Player) event.getWhoClicked(),event.getSlot(),event.getClick());
        }
    }
}

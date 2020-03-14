package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class CloseListener implements Listener {
    @EventHandler
    public void onClose(InventoryCloseEvent event){
        if (! GUI.exclude.contains((Player) event.getPlayer())){
            GUI gui = GUI.getGui(event.getView());
            if (gui != null){
                gui.onClose((Player) event.getPlayer());
            }
        }
    }
}

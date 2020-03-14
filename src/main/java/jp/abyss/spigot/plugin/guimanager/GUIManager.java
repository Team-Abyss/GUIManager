package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.plugin.java.JavaPlugin;

public final class GUIManager extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("GUIManager is enabled");
        getServer().getPluginManager().registerEvents(new Listener(),this);
        getServer().getPluginManager().registerEvents(new CloseListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

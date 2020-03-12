package jp.abyss.spigot.plugin.guimanager;

import org.bukkit.plugin.java.JavaPlugin;

public final class GUImanager extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("GUImanager is enabled");
        getServer().getPluginManager().registerEvents(new Listener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

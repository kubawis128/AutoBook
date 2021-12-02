package pl.zs1.autobook;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.zs1.autobook.command.Pomoc;

import java.util.Objects;


public class Main extends JavaPlugin {
    public static Object BookJSON;
    // Enable login for plugin
    //public String BookJSON;

    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();
        saveConfig();
        BookJSON = getConfig().getString("book.JSON");
        // Get plugin manager and register events (required for onPlayerJoin etc.)
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new EventListener(), this); // Register our own event listener
        this.getCommand("pomoc").setExecutor(new Pomoc());// You need to set command in plugin.yml too
        //Objects.requireNonNull(this.getCommand("pomoc")).setExecutor(new Pomoc()); // Your IDE would be happy if you use this
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}

package autoopen_book.autoopen_book;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

// You need this if you want to open book after TexturePack
//import org.bukkit.event.player.PlayerResourcePackStatusEvent;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoOpen_Book extends JavaPlugin implements Listener {

    // Enable login for plugin
    @Override
    public void onEnable() {
        // Get plugin manager and register events (required for onPlayerJoin etc.)
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(this, this);
        this.getCommand("pomoc").setExecutor(new CommandPomoc()); // You need to set command in plugin.yml too
    }

    // Execute on player join after all plugins
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
            // Get player of event and open book for him
            Player p = event.getPlayer();
            OpenBook(p); 
        }, 100L); //Schedule event to execute in 100 ticks (5 seconds)
    }
    /*
    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerResourcePack(PlayerResourcePackStatusEvent e){
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
            e.getStatus(); // Get status of event
            if(PlayerResourcePackStatusEvent.Status.ACCEPTED != null){ // If texture pack accepted open book
                OpenBook(e.getPlayer()); // Get player of event and open book for him
            }
        }, 100L); //Schedule event to execute in 100 ticks (5 seconds)
    }
    */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static void OpenBook(Player p)
    {
        // Create the book
        Book book = new Book();

        // Set JSON for book
        // TODO: Read JSON from config.yml
        // Problem: \n are not escaped
        book.setJSON("{pages:[\"[\\\"\\\",\\\"        \\\",{\\\"text\\\":\\\"Witamy!\\\",\\\"bold\\\":true,\\\"underlined\\\":true,\\\"color\\\":\\\"gold\\\",\\\"insertion\\\":\\\"tesech\\\"},\\\"\\\\n\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"Strona Szkoły\\\",\\\"underlined\\\":true,\\\"color\\\":\\\"dark_blue\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"open_url\\\",\\\"value\\\":\\\"https://zs1.nowotarski.edu.pl/\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij aby otworzyć stronę\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\"\\\\n\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"Spis treści:\\\",\\\"bold\\\":true,\\\"underlined\\\":true,\\\"color\\\":\\\"dark_green\\\"},\\\"\\\\n\\\",{\\\"text\\\":\\\"1. Autorzy\\\",\\\"underlined\\\":true,\\\"color\\\":\\\"light_purple\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"change_page\\\",\\\"value\\\":\\\"2\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij by otworzyć stronę\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\"\\\\n\\\",{\\\"text\\\":\\\"2. Komendy\\\",\\\"underlined\\\":true,\\\"color\\\":\\\"light_purple\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"change_page\\\",\\\"value\\\":\\\"3\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij aby otworzyć stronę\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"/pomoc\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"/pomoc\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij aby uruchomić\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\" - Wyświetla tą książkę\\\"]\",\"[\\\"\\\",{\\\"text\\\":\\\"Majster:\\\",\\\"bold\\\":true,\\\"color\\\":\\\"aqua\\\"},\\\"\\\\n\\\",{\\\"text\\\":\\\"Damian Polak\\\",\\\"color\\\":\\\"black\\\"},\\\"\\\\n\\\",{\\\"text\\\":\\\"Technicy:\\\",\\\"bold\\\":true,\\\"color\\\":\\\"gold\\\"},\\\"\\\\n\\\",{\\\"text\\\":\\\"Kacper Łapka \\\\nJakub Wiśniewski\\\",\\\"color\\\":\\\"black\\\"},\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"Powrót do menu\\\",\\\"bold\\\":true,\\\"underlined\\\":true,\\\"color\\\":\\\"dark_blue\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"change_page\\\",\\\"value\\\":\\\"0\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Kliknij, aby powrócić do menu\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}}]\",\"[\\\"\\\",{\\\"text\\\":\\\"Komendy:\\\",\\\"bold\\\":true,\\\"color\\\":\\\"light_purple\\\"},\\\"\\\\n\\\",{\\\"text\\\":\\\"/dzien\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"/dzien\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij aby uruchomić\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\" - Dzień\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"/noc\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"/noc\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij aby uruchomić\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\" - Noc\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"/pomoc\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"/pomoc\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij aby uruchomić\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\" - Wyświetla tą książkę\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"/slonce\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"/slonce\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij aby uruchomić\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\" - Słońce\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"/deszcz\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"/deszcz\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij aby uruchomić\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\" - Deszcz\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"/lobby\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"/lobby\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Naciśnij aby uruchomić\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}},\\\" - Lobby\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",\\\"\\\\n\\\",{\\\"text\\\":\\\"Powrót do menu\\\",\\\"bold\\\":true,\\\"underlined\\\":true,\\\"color\\\":\\\"dark_blue\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"change_page\\\",\\\"value\\\":\\\"0\\\"},\\\"hoverEvent\\\":{\\\"action\\\":\\\"show_text\\\",\\\"contents\\\":[{\\\"text\\\":\\\"Kliknij, aby powrócić do menu\\\",\\\"italic\\\":true,\\\"color\\\":\\\"gray\\\"}]}}]\"],title:\"Powitanie\",author:Sokol}");

        // And finally open book for player
        book.openBookToPlayer(p);
    }
}

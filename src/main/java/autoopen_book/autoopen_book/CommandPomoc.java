package autoopen_book.autoopen_book;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPomoc implements CommandExecutor {

    // This is called when somebody uses command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // If sender is Player
        if (sender instanceof Player) {

            // Get player from sender
            Player player = (Player) sender;

            // And open book for him
            AutoOpen_Book.OpenBook(player);

            return true; // Completed successfully

        }else{

            return true; // Failed

        }

    }
}
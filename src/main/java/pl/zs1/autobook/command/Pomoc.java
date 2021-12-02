package pl.zs1.autobook.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static pl.zs1.autobook.Book.OpenBook;

public class Pomoc implements CommandExecutor {

    // This is called when somebody uses command
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        // If sender is Player
        if (sender instanceof Player) {

            // Get player from sender
            Player player = (Player) sender;

            // And open book for him
            OpenBook(player);
            return true; // Completed successfully
        }
        return false; // Failed

    }
}
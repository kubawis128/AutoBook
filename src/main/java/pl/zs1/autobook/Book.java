package pl.zs1.autobook;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// Custom class for Book
public class Book
{
    // Create ItemStack of Written Book
    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
    // Unsafely modify JSON
    public void setJSON(String JSON) {
        Bukkit.getUnsafe().modifyItemStack(book, JSON);
    }

    // UNUSED: Give player the book to the first unused slot
    /*
    public void giveBook(Player p)
    {
        if (p.getInventory().firstEmpty() != -1)
        {
            p.getInventory().addItem(book);
        }
    }
    */
    // Just open book
    public void openBookToPlayer(Player p) {
        p.openBook(book);
    }

    public static void OpenBook(Player p)
    {
        // Create the book
        Book book = new Book();

        // Set JSON for book
        // TODO: Read JSON from config.yml
        // Problem: \n are not escaped
        String JSON = Main.BookJSON.toString();
        book.setJSON(JSON);
        // And finally open book for player
        book.openBookToPlayer(p);
    }
}
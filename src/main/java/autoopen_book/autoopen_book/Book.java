package autoopen_book.autoopen_book;

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
    public void giveBook(Player p)
    {
        if (p.getInventory().firstEmpty() != -1)
        {
            p.getInventory().addItem(book);
        }
    }

    // Just open book
    public void openBookToPlayer(Player p) {
        p.openBook(book);
    }

}
package net.aerulion.bannerabc.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class Menu {

  public Inventory inv;
  public String invName;

  public Menu(String name, int size) {
    inv = Bukkit.createInventory(null, size, name);
    invName = name;
    registerItems();
  }

  public abstract void registerItems();

  public abstract void click(ItemStack item, Player p);

}
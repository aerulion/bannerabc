package net.aerulion.bannerabc.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class Menu {

  public Inventory inv;
  public String invName;

  public Menu(final @NotNull String name, final int size) {
    inv = Bukkit.createInventory(null, size, name);
    invName = name;
    registerItems();
  }

  public abstract void registerItems();

  public abstract void click(ItemStack item, Player p);

}
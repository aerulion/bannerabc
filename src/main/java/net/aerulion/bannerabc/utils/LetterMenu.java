package net.aerulion.bannerabc.utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class LetterMenu extends Menu {

  public LetterMenu(final @NotNull String name, final int size) {
    super(name, size);
  }

  @Override
  public void registerItems() {

    final @NotNull ItemStack c1 = new ItemStack(Material.BLACK_DYE);
    final ItemMeta c1m = c1.getItemMeta();
    c1m.setDisplayName("§7§l§oSchwarz");
    c1.setItemMeta(c1m);
    inv.addItem(c1);
    final @NotNull ItemStack c2 = new ItemStack(Material.RED_DYE);
    final ItemMeta c2m = c2.getItemMeta();
    c2m.setDisplayName("§7§l§oRot");
    c2.setItemMeta(c2m);
    inv.addItem(c2);
    final @NotNull ItemStack c3 = new ItemStack(Material.GREEN_DYE);
    final ItemMeta c3m = c3.getItemMeta();
    c3m.setDisplayName("§7§l§oGrün");
    c3.setItemMeta(c3m);
    inv.addItem(c3);
    final @NotNull ItemStack c4 = new ItemStack(Material.BROWN_DYE);
    final ItemMeta c4m = c4.getItemMeta();
    c4m.setDisplayName("§7§l§oBraun");
    c4.setItemMeta(c4m);
    inv.addItem(c4);
    final @NotNull ItemStack c5 = new ItemStack(Material.BLUE_DYE);
    final ItemMeta c5m = c5.getItemMeta();
    c5m.setDisplayName("§7§l§oBlau");
    c5.setItemMeta(c5m);
    inv.addItem(c5);
    final @NotNull ItemStack c6 = new ItemStack(Material.PURPLE_DYE);
    final ItemMeta c6m = c6.getItemMeta();
    c6m.setDisplayName("§7§l§oViolett");
    c6.setItemMeta(c6m);
    inv.addItem(c6);
    final @NotNull ItemStack c7 = new ItemStack(Material.CYAN_DYE);
    final ItemMeta c7m = c7.getItemMeta();
    c7m.setDisplayName("§7§l§oTürkis");
    c7.setItemMeta(c7m);
    inv.addItem(c7);
    final @NotNull ItemStack c8 = new ItemStack(Material.LIGHT_GRAY_DYE);
    final ItemMeta c8m = c8.getItemMeta();
    c8m.setDisplayName("§7§l§oHellgrau");
    c8.setItemMeta(c8m);
    inv.addItem(c8);
    final @NotNull ItemStack c9 = new ItemStack(Material.GRAY_DYE);
    final ItemMeta c9m = c9.getItemMeta();
    c9m.setDisplayName("§7§l§oGrau");
    c9.setItemMeta(c9m);
    inv.addItem(c9);
    final @NotNull ItemStack c10 = new ItemStack(Material.PINK_DYE);
    final ItemMeta c10m = c10.getItemMeta();
    c10m.setDisplayName("§7§l§oRosa");
    c10.setItemMeta(c10m);
    inv.addItem(c10);
    final @NotNull ItemStack c11 = new ItemStack(Material.LIME_DYE);
    final ItemMeta c11m = c11.getItemMeta();
    c11m.setDisplayName("§7§l§oHellgrün");
    c11.setItemMeta(c11m);
    inv.addItem(c11);
    final @NotNull ItemStack c12 = new ItemStack(Material.YELLOW_DYE);
    final ItemMeta c12m = c12.getItemMeta();
    c12m.setDisplayName("§7§l§oGelb");
    c12.setItemMeta(c12m);
    inv.addItem(c12);
    final @NotNull ItemStack c13 = new ItemStack(Material.LIGHT_BLUE_DYE);
    final ItemMeta c13m = c13.getItemMeta();
    c13m.setDisplayName("§7§l§oHellblau");
    c13.setItemMeta(c13m);
    inv.addItem(c13);
    final @NotNull ItemStack c14 = new ItemStack(Material.MAGENTA_DYE);
    final ItemMeta c14m = c14.getItemMeta();
    c14m.setDisplayName("§7§l§oMagenta");
    c14.setItemMeta(c14m);
    inv.addItem(c14);
    final @NotNull ItemStack c15 = new ItemStack(Material.ORANGE_DYE);
    final ItemMeta c15m = c15.getItemMeta();
    c15m.setDisplayName("§7§l§oOrange");
    c15.setItemMeta(c15m);
    inv.addItem(c15);
    final @NotNull ItemStack c16 = new ItemStack(Material.WHITE_DYE);
    final ItemMeta c16m = c16.getItemMeta();
    c16m.setDisplayName("§7§l§oWeiß");
    c16.setItemMeta(c16m);
    inv.addItem(c16);
  }

  @Override
  public void click(final @NotNull ItemStack item, final @NotNull Player p) {
    if (item.hasItemMeta()) {
      if (item.getItemMeta().hasDisplayName()) {
        final @NotNull String m = item.getItemMeta().getDisplayName();
        if (m.equals("§7§l§oSchwarz")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.BLACK);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oRot")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.RED);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oGrün")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.GREEN);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oBraun")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.BROWN);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oBlau")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.BLUE);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oViolett")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.PURPLE);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oTürkis")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.CYAN);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oHellgrau")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.LIGHT_GRAY);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oGrau")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.GRAY);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oRosa")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.PINK);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oHellgrün")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.LIME);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oGelb")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.YELLOW);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oHellblau")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.LIGHT_BLUE);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oMagenta")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.MAGENTA);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oOrange")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.ORANGE);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oWeiß")) {
          Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.WHITE);
          p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
              Utils.BACKGROUND_COLORS.get(p.getUniqueId())));
        }
      }
    }
  }
}
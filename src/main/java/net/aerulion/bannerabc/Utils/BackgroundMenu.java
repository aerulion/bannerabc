package net.aerulion.bannerabc.Utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BackgroundMenu extends Menu {

  public BackgroundMenu(String name, int size) {
    super(name, size);
  }

  @Override
  public void registerItems() {

    ItemStack c1 = new ItemStack(Material.BLACK_DYE);
    ItemMeta c1m = c1.getItemMeta();
    c1m.setDisplayName("§7§l§oSchwarz");
    c1.setItemMeta(c1m);
    inv.addItem(c1);
    ItemStack c2 = new ItemStack(Material.RED_DYE);
    ItemMeta c2m = c2.getItemMeta();
    c2m.setDisplayName("§7§l§oRot");
    c2.setItemMeta(c2m);
    inv.addItem(c2);
    ItemStack c3 = new ItemStack(Material.GREEN_DYE);
    ItemMeta c3m = c3.getItemMeta();
    c3m.setDisplayName("§7§l§oGrün");
    c3.setItemMeta(c3m);
    inv.addItem(c3);
    ItemStack c4 = new ItemStack(Material.BROWN_DYE);
    ItemMeta c4m = c4.getItemMeta();
    c4m.setDisplayName("§7§l§oBraun");
    c4.setItemMeta(c4m);
    inv.addItem(c4);
    ItemStack c5 = new ItemStack(Material.BLUE_DYE);
    ItemMeta c5m = c5.getItemMeta();
    c5m.setDisplayName("§7§l§oBlau");
    c5.setItemMeta(c5m);
    inv.addItem(c5);
    ItemStack c6 = new ItemStack(Material.PURPLE_DYE);
    ItemMeta c6m = c6.getItemMeta();
    c6m.setDisplayName("§7§l§oViolett");
    c6.setItemMeta(c6m);
    inv.addItem(c6);
    ItemStack c7 = new ItemStack(Material.CYAN_DYE);
    ItemMeta c7m = c7.getItemMeta();
    c7m.setDisplayName("§7§l§oTürkis");
    c7.setItemMeta(c7m);
    inv.addItem(c7);
    ItemStack c8 = new ItemStack(Material.LIGHT_GRAY_DYE);
    ItemMeta c8m = c8.getItemMeta();
    c8m.setDisplayName("§7§l§oHellgrau");
    c8.setItemMeta(c8m);
    inv.addItem(c8);
    ItemStack c9 = new ItemStack(Material.GRAY_DYE);
    ItemMeta c9m = c9.getItemMeta();
    c9m.setDisplayName("§7§l§oGrau");
    c9.setItemMeta(c9m);
    inv.addItem(c9);
    ItemStack c10 = new ItemStack(Material.PINK_DYE);
    ItemMeta c10m = c10.getItemMeta();
    c10m.setDisplayName("§7§l§oRosa");
    c10.setItemMeta(c10m);
    inv.addItem(c10);
    ItemStack c11 = new ItemStack(Material.LIME_DYE);
    ItemMeta c11m = c11.getItemMeta();
    c11m.setDisplayName("§7§l§oHellgrün");
    c11.setItemMeta(c11m);
    inv.addItem(c11);
    ItemStack c12 = new ItemStack(Material.YELLOW_DYE);
    ItemMeta c12m = c12.getItemMeta();
    c12m.setDisplayName("§7§l§oGelb");
    c12.setItemMeta(c12m);
    inv.addItem(c12);
    ItemStack c13 = new ItemStack(Material.LIGHT_BLUE_DYE);
    ItemMeta c13m = c13.getItemMeta();
    c13m.setDisplayName("§7§l§oHellblau");
    c13.setItemMeta(c13m);
    inv.addItem(c13);
    ItemStack c14 = new ItemStack(Material.MAGENTA_DYE);
    ItemMeta c14m = c14.getItemMeta();
    c14m.setDisplayName("§7§l§oMagenta");
    c14.setItemMeta(c14m);
    inv.addItem(c14);
    ItemStack c15 = new ItemStack(Material.ORANGE_DYE);
    ItemMeta c15m = c15.getItemMeta();
    c15m.setDisplayName("§7§l§oOrange");
    c15.setItemMeta(c15m);
    inv.addItem(c15);
    ItemStack c16 = new ItemStack(Material.WHITE_DYE);
    ItemMeta c16m = c16.getItemMeta();
    c16m.setDisplayName("§7§l§oWeiß");
    c16.setItemMeta(c16m);
    inv.addItem(c16);
  }

  @Override
  public void click(ItemStack item, Player p) {
    if (item.hasItemMeta()) {
      if (item.getItemMeta().hasDisplayName()) {
        String m = item.getItemMeta().getDisplayName();
        if (m.equals("§7§l§oSchwarz")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.BLACK);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oRot")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.RED);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oGrün")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.GREEN);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oBraun")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.BROWN);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oBlau")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.BLUE);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oViolett")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.PURPLE);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oTürkis")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.CYAN);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oHellgrau")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.LIGHT_GRAY);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oGrau")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.GRAY);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oRosa")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.PINK);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oHellgrün")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.LIME);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oGelb")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.YELLOW);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oHellblau")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.LIGHT_BLUE);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oMagenta")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.MAGENTA);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oOrange")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.ORANGE);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
        if (m.equals("§7§l§oWeiß")) {
          Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.WHITE);
          p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
              Utils.backgroundcolors.get(p.getUniqueId())));
        }
      }
    }
  }
}
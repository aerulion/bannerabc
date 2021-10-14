package net.aerulion.bannerabc.Utils.Search;

import java.util.ArrayList;
import java.util.List;
import net.aerulion.bannerabc.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Search {

  public static void SearchInv(Player p) {
    String search = Utils.latestsearch.get(p.getUniqueId());
    int page = Utils.searchpage.get(p.getUniqueId());
    List<ItemStack> banners = new ArrayList<>();
    for (ItemStack is : Utils.banners.keySet()) {
      if (is.getItemMeta().getDisplayName().toLowerCase().contains(search.toLowerCase())) {
        banners.add(is);
      }
    }

    if (banners.size() < 1) {
      p.sendMessage("§8[§a§l§oBD-Suche§8] §7Keine Übereinstimmungen gefunden!");
      return;
    }

    boolean next = true;
    int epp = 45;
    int si = (page - 1) * epp;
    int ei = si + epp;
    if (ei > banners.size()) {
      ei = banners.size();
      next = false;
    }

    Inventory inventory = Bukkit.createInventory(null, 54, "§c§l§oSuchergebnisse | " + page);
    ItemStack mainmenu = new ItemStack(Material.DARK_OAK_DOOR, 1);
    ItemMeta mmainmenu = mainmenu.getItemMeta();
    mmainmenu.setDisplayName("§e§l§oZurück zum Hauptmenü");
    mainmenu.setItemMeta(mmainmenu);
    inventory.setItem(49, mainmenu);

    for (ItemStack is : banners.subList(si, ei)) {
      inventory.addItem(is);
    }

    if (next) {
      ItemStack ni = new ItemStack(Material.LIME_DYE);
      ItemMeta nim = ni.getItemMeta();
      nim.setDisplayName("§a§lNächste Seite");
      ni.setItemMeta(nim);
      inventory.setItem(50, ni);
    }

    if (page != 1) {
      ItemStack pi = new ItemStack(Material.RED_DYE);
      ItemMeta pim = pi.getItemMeta();
      pim.setDisplayName("§a§lVorherige Seite");
      pi.setItemMeta(pim);
      inventory.setItem(48, pi);
    }
    p.openInventory(inventory);
  }
}
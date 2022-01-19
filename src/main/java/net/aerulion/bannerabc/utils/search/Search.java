package net.aerulion.bannerabc.utils.search;

import java.util.ArrayList;
import java.util.List;
import net.aerulion.bannerabc.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class Search {

  public static void searchInv(final @NotNull Player p) {
    final String search = Utils.LATEST_SEARCH.get(p.getUniqueId());
    final int page = Utils.SEARCH_PAGE.get(p.getUniqueId());
    final @NotNull List<ItemStack> banners = new ArrayList<>();
    for (final @NotNull ItemStack is : Utils.BANNERS.keySet()) {
      if (is.getItemMeta().getDisplayName().toLowerCase().contains(search.toLowerCase())) {
        banners.add(is);
      }
    }

    if (banners.size() < 1) {
      p.sendMessage("§8[§a§l§oBD-Suche§8] §7Keine Übereinstimmungen gefunden!");
      return;
    }

    boolean next = true;
    final int epp = 45;
    final int si = (page - 1) * epp;
    int ei = si + epp;
    if (ei > banners.size()) {
      ei = banners.size();
      next = false;
    }

    final @NotNull Inventory inventory = Bukkit.createInventory(null, 54, "§c§l§oSuchergebnisse | " + page);
    final @NotNull ItemStack mainmenu = new ItemStack(Material.DARK_OAK_DOOR, 1);
    final ItemMeta mmainmenu = mainmenu.getItemMeta();
    mmainmenu.setDisplayName("§e§l§oZurück zum Hauptmenü");
    mainmenu.setItemMeta(mmainmenu);
    inventory.setItem(49, mainmenu);

    for (final ItemStack is : banners.subList(si, ei)) {
      inventory.addItem(is);
    }

    if (next) {
      final @NotNull ItemStack ni = new ItemStack(Material.LIME_DYE);
      final ItemMeta nim = ni.getItemMeta();
      nim.setDisplayName("§a§lNächste Seite");
      ni.setItemMeta(nim);
      inventory.setItem(50, ni);
    }

    if (page != 1) {
      final @NotNull ItemStack pi = new ItemStack(Material.RED_DYE);
      final ItemMeta pim = pi.getItemMeta();
      pim.setDisplayName("§a§lVorherige Seite");
      pi.setItemMeta(pim);
      inventory.setItem(48, pi);
    }
    p.openInventory(inventory);
  }
}
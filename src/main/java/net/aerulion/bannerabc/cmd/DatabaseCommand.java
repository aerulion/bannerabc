package net.aerulion.bannerabc.cmd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.aerulion.bannerabc.utils.FileManager;
import net.aerulion.bannerabc.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.jetbrains.annotations.NotNull;

public class DatabaseCommand implements CommandExecutor, TabCompleter {

  @Override
  public boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String label, final String @NotNull [] args) {

    if (!(sender instanceof final @NotNull Player p)) {
      sender.sendMessage(
          "§8[§a§l§oBannerABC§8] §cDieses Command kann nur von Spieler ausgeführt werden!");
      return true;
    }

    if (!(sender.hasPermission("bannerabc.database"))) {
      sender.sendMessage(
          "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
      return true;

    }

    try {
      if (args.length > 0) {
        if (args[0].equalsIgnoreCase("add")) {
          if (!(sender.hasPermission("bannerabc.addbanners"))) {
            sender.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
            return true;
          }
          if (args.length == 3) {
            if (Utils.BANNER_ITEMS.contains(p.getInventory().getItemInMainHand().getType())) {
              final @NotNull String name = args[1].replaceAll("#", " ");
              if (FileManager.bannerNameExists(name)) {
                p.sendMessage("§8[§a§l§oBannerABC§8] §cDieser Name wird bereits verwendet!");
                return true;
              }
              if (!FileManager.categoryExists(args[2].replaceAll("#", " "), true)) {
                p.sendMessage("§8[§a§l§oBannerABC§8] §cKeine gültige Kategorie!");
                return true;
              }
              final @NotNull ItemStack i = new ItemStack(p.getInventory().getItemInMainHand());
              i.setAmount(1);
              final @NotNull BannerMeta im = (BannerMeta) i.getItemMeta();
              im.setLore(Collections.singletonList(
                  "§7Dieses Banner aus der Datenbank entfernen: §aSTRG + Q"));
              im.setDisplayName("§a§l" + name);
              im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
              i.setItemMeta(im);
              FileManager.addBanner(name, i, args[2].replaceAll("#", " "));
              sender.sendMessage(
                  "§8[§a§l§oBannerABC§8] §aDer Banner wurde mit folgendem Namen hinzugefügt '§7"
                      + name + "§a'.");
              return true;
            }
            p.sendMessage("§8[§a§l§oBannerABC§8] §cDu musst ein Banner in der Hand halten!");
            return true;
          }
          if (args.length == 2) {
            if (Utils.BANNER_ITEMS.contains(p.getInventory().getItemInMainHand().getType())) {
              final @NotNull String name = args[1].replaceAll("#", " ");
              if (FileManager.bannerNameExists(name)) {
                p.sendMessage("§8[§a§l§oBannerABC§8] §cDieser Name wird bereits verwendet!");
                return true;
              }
              final @NotNull ItemStack i = new ItemStack(p.getInventory().getItemInMainHand());
              i.setAmount(1);
              final @NotNull BannerMeta im = (BannerMeta) i.getItemMeta();
              im.setLore(Collections.singletonList(
                  "§7Dieses Banner aus der Datenbank entfernen: §aSTRG + Q"));
              im.setDisplayName("§a§l" + name);
              im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
              i.setItemMeta(im);
              FileManager.addBanner(name, i, "Unsortiert");
              sender.sendMessage(
                  "§8[§a§l§oBannerABC§8] §aDer Banner wurde mit folgendem Namen hinzugefügt '§7"
                      + name + "§a'.");
              return true;
            }
            p.sendMessage("§8[§a§l§oBannerABC§8] §cDu musst ein Banner in der Hand halten!");
            return true;
          }
          p.sendMessage(
              "§8[§a§l§oBannerABC§8] §cBitte nutze /bd add <Name> um Banner hinzuzufügen.");
          return true;
        }

        p.sendMessage("§8[§a§l§oBannerABC§8] §cZu viele Argumente!");
        return true;
      }

      if (Utils.BANNERS.size() == 0) {
        p.sendMessage("§8[§a§l§oBannerABC§8] §7Bisher wurden keine Banner gespeichert!");
        return true;
      }

      if (Utils.CURRENT_CAT.get(p.getUniqueId()) == null) {
        p.openInventory(Utils.categoryMenu());
        return true;
      }
      p.openInventory(Utils.categoryBanner(Utils.CURRENT_CAT.get(p.getUniqueId()),
          Utils.PAGE.get(p.getUniqueId())));
      return true;
    } catch (final Exception e) {
      FileManager.setStandard();
      sender.sendMessage("§8[§a§l§oBannerABC§8] §cEin interner Fehler ist aufgetreten!");
      return true;
    }

  }

  @Override
  public List<String> onTabComplete(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String alias,
      final String @NotNull [] args) {
    if (args.length == 1) {
      return Collections.singletonList("add");
    } else if (args.length == 2) {
      return Collections.singletonList("<BannerName>");
    } else if (args.length == 3) {
      return new ArrayList<>(Utils.CATEGORIES.keySet());
    }
    return Collections.emptyList();
  }
}
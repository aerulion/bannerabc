package net.aerulion.bannerabc.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.aerulion.bannerabc.utils.FileManager;
import net.aerulion.bannerabc.utils.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DatabaseCategoryCommand implements CommandExecutor, TabCompleter {

  @Override
  public boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String label, final String @NotNull [] args) {

    if (!(sender instanceof final @NotNull Player p)) {
      sender.sendMessage(
          "§8[§a§l§oBannerABC§8] §cDieses Command kann nur von Spieler ausgeführt werden!");
      return true;
    }

    try {

      if (args.length == 2) {
        if (args[0].equalsIgnoreCase("add")) {
          if (!(p.hasPermission("bannerabc.addcategory"))) {
            p.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
            return true;
          }
          if (Utils.CATEGORIES.size() >= 54) {
            sender.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Du hast die maximale Anzahl an Kategorien erstellt!");
            return true;
          }
          if (p.getInventory().getItemInMainHand().getType() == Material.AIR) {
            sender.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Du musst ein Item in der Hand halten!");
            return true;
          }
          if (FileManager.categoryExists(args[1].replaceAll("#", " "), false)) {
            sender.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Es existiert bereits eine Kategorie mit diesem Namen!");
            return true;
          }
          final @NotNull ItemStack displayItem = p.getInventory().getItemInMainHand();
          FileManager.addCategory(args[1].replaceAll("#", " "), displayItem);
          sender.sendMessage("§8[§a§l§oBannerABC§8] §7Folgende Kategorie wurde hinzugefügt: §a§l"
              + args[1].replaceAll("#", " "));
          return true;
        }

        if (args[0].equalsIgnoreCase("remove")) {
          if (!(p.hasPermission("bannerabc.removecategory"))) {
            p.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
            return true;
          }
          if (FileManager.categoryExists(args[1].replaceAll("#", " "), true)) {
            if (args[1].replaceAll("#", " ").equals("Unsortiert")) {
              sender.sendMessage(
                  "§8[§a§l§oBannerABC§8] §cFehler: Die Standart Kategorie kann nicht entfernt werden!");
              return true;
            }
            FileManager.removeCategory(args[1].replaceAll("#", " "));
            sender.sendMessage("§8[§a§l§oBannerABC§8] §7Folgende Kategorie wurde entfernt: §a§l"
                + args[1].replaceAll("#", " "));
            return true;
          }
          sender.sendMessage(
              "§8[§a§l§oBannerABC§8] §cEs wurde keine Kategorie mit diesem Namen gefunden!");
          return true;
        }

        if (args[0].equalsIgnoreCase("setitem")) {
          if (!(p.hasPermission("bannerabc.setcategoryitem"))) {
            p.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
            return true;
          }
          if (!FileManager.categoryExists(args[1].replaceAll("#", " "), true)) {
            sender.sendMessage("§8[§a§l§oBannerABC§8] §cFehler: Kein gültige Kategorie!");
            return true;
          }
          if (p.getInventory().getItemInMainHand().getType() == Material.AIR) {
            sender.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Du musst ein Item in der Hand halten!");
            return true;
          }
          sender.sendMessage("§8[§a§l§oBannerABC§8] §7Das Katergorie-Item wurde geändert.");
          FileManager.setCatItem(args[1].replaceAll("#", " "),
              p.getInventory().getItemInMainHand());
          return true;
        }

        sender.sendMessage("§8[§a§l§oBannerABC§8] §cFalsche Argumente.");
        return true;
      }

      if (args.length == 3) {
        if (args[0].equalsIgnoreCase("set")) {
          if (!(p.hasPermission("bannerabc.changebannercategory"))) {
            p.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
            return true;
          }
          if (!FileManager.bannerNameExists(args[1].replaceAll("#", " "))) {
            sender.sendMessage("§8[§a§l§oBannerABC§8] §cFehler: Kein gültiges Banner!");
            return true;
          }
          if (!FileManager.categoryExists(args[2].replaceAll("#", " "), true)) {
            sender.sendMessage("§8[§a§l§oBannerABC§8] §cFehler: Kein gültige Kategorie!");
            return true;
          }
          sender.sendMessage(
              "§8[§a§l§oBannerABC§8] §7Das Banner §a§l" + args[1].replaceAll("#", " ")
                  + "§7 ist jetzt in der Kategorie §a§l" + args[2].replaceAll("#", " ") + "§7.");
          FileManager.setBannerCategory(args[1].replaceAll("#", " "), args[2].replaceAll("#", " "));
          return true;
        }

        if (args[0].equalsIgnoreCase("rename")) {
          if (!(p.hasPermission("bannerabc.renamecategory"))) {
            p.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
            return true;
          }
          if (!FileManager.categoryExists(args[1].replaceAll("#", " "), true)) {
            sender.sendMessage("§8[§a§l§oBannerABC§8] §cFehler: Kein gültige Kategorie!");
            return true;
          }
          if (FileManager.categoryExists(args[2].replaceAll("#", " "), false)) {
            sender.sendMessage(
                "§8[§a§l§oBannerABC§8] §cFehler: Es existiert bereits eine Kategorie mit diesem Namen!");
            return true;
          }
          sender.sendMessage(
              "§8[§a§l§oBannerABC§8] §7Die Kategorie §a§l" + args[1].replaceAll("#", " ")
                  + "§7 heißt jetzt §a§l" + args[2].replaceAll("#", " ") + "§7.");
          FileManager.renameCat(args[1].replaceAll("#", " "), args[2].replaceAll("#", " "));
          return true;
        }

        sender.sendMessage("§8[§a§l§oBannerABC§8] §cFalsche Argumente.");
        return true;
      }

      sender.sendMessage("§8[§a§l§oBannerABC§8] §cFalsche Argumente.");
      return true;

    } catch (final Exception e) {
      sender.sendMessage("§8[§a§l§oBannerABC§8] §cEin interner Fehler ist aufgetreten!");
      return true;
    }
  }

  @Override
  public List<String> onTabComplete(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String alias,
      final String @NotNull [] args) {
    if (args.length == 1) {
      return Arrays.asList("add", "remove", "set", "setitem", "rename");
    } else if (args.length == 2) {
      if (args[0].equalsIgnoreCase("add")) {
        return Collections.singletonList("<BannerName>");
      } else if (args[0].equalsIgnoreCase("remove")) {
        return new ArrayList<>(Utils.CATEGORIES.keySet());
      } else if (args[0].equalsIgnoreCase("set")) {
        return FileManager.getAllBannerNamesWithoutSpaces();
      } else if (args[0].equalsIgnoreCase("setitem")) {
        return new ArrayList<>(Utils.CATEGORIES.keySet());
      } else if (args[0].equalsIgnoreCase("rename")) {
        return new ArrayList<>(Utils.CATEGORIES.keySet());
      }
    } else if (args.length == 3) {
      if (args[0].equalsIgnoreCase("set")) {
        return new ArrayList<>(Utils.CATEGORIES.keySet());
      } else if (args[0].equalsIgnoreCase("rename")) {
        return Collections.singletonList("<NewName>");
      }
    }
    return Collections.emptyList();
  }
}
package net.aerulion.bannerabc.cmd;

import java.util.Collections;
import java.util.List;
import net.aerulion.bannerabc.utils.Utils;
import org.bukkit.DyeColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AbcCommand implements CommandExecutor, TabCompleter {

  @Override
  public boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String label, final String @NotNull [] args) {

    if (!(sender instanceof final @NotNull Player p)) {
      sender.sendMessage(
          "§8[§a§l§oBannerABC§8] §cDieses Command kann nur von Spieler ausgeführt werden!");
      return true;
    }

    if (!(sender.hasPermission("bannerabc.use"))) {
      sender.sendMessage(
          "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
      return true;

    }

    if (args.length != 0) {
      sender.sendMessage("§8[§a§l§oBannerABC§8] §7Zu viele Argumente.");
      return true;
    }

    if (!Utils.LETTER_COLORS.containsKey(p.getUniqueId())) {
      Utils.LETTER_COLORS.put(p.getUniqueId(), DyeColor.BLACK);
    }

    if (!Utils.BACKGROUND_COLORS.containsKey(p.getUniqueId())) {
      Utils.BACKGROUND_COLORS.put(p.getUniqueId(), DyeColor.WHITE);
    }

    p.openInventory(Utils.alphabetInv(Utils.LETTER_COLORS.get(p.getUniqueId()),
        Utils.BACKGROUND_COLORS.get(p.getUniqueId())));

    return true;
  }

  @Override
  public List<String> onTabComplete(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String alias,
      final String[] args) {
    return Collections.emptyList();
  }
}
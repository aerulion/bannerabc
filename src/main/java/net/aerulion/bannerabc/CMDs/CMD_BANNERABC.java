package net.aerulion.bannerabc.CMDs;

import java.util.Collections;
import java.util.List;
import net.aerulion.bannerabc.Utils.Utils;
import org.bukkit.DyeColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class CMD_BANNERABC implements CommandExecutor, TabCompleter {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    if (!(sender instanceof Player)) {
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

    Player p = (Player) sender;

    if (!Utils.lettercolors.containsKey(p.getUniqueId())) {
      Utils.lettercolors.put(p.getUniqueId(), DyeColor.BLACK);
    }

    if (!Utils.backgroundcolors.containsKey(p.getUniqueId())) {
      Utils.backgroundcolors.put(p.getUniqueId(), DyeColor.WHITE);
    }

    p.openInventory(Utils.AlphabetInv(Utils.lettercolors.get(p.getUniqueId()),
        Utils.backgroundcolors.get(p.getUniqueId())));

    return true;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label,
      String[] args) {
    return Collections.emptyList();
  }
}
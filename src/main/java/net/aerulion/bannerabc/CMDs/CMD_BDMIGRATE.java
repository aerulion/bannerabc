package net.aerulion.bannerabc.CMDs;

import java.util.Collections;
import java.util.List;
import net.aerulion.bannerabc.Main;
import net.aerulion.bannerabc.Utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CMD_BDMIGRATE implements CommandExecutor, TabCompleter {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    if (!(sender.hasPermission("bannerabc.migrate"))) {
      sender.sendMessage(
          "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
      return true;
    }

    Bukkit.getScheduler().runTaskAsynchronously(Main.plugin, () -> {
      FileManager.migrateBanners();
      sender.sendMessage("§8[§a§l§oBannerABC§8] §7Die BannerDatenbank wurde migriert");
    });
    return true;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label,
      String[] args) {
    return Collections.emptyList();
  }
}
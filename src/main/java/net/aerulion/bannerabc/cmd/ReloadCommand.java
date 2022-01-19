package net.aerulion.bannerabc.cmd;

import java.util.Collections;
import java.util.List;
import net.aerulion.bannerabc.utils.FileManager;
import net.aerulion.bannerabc.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor, TabCompleter {

  @Override
  public boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String label, final String[] args) {

    if (!(sender.hasPermission("bannerabc.reload"))) {
      sender.sendMessage(
          "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
      return true;
    }

    Utils.CATEGORIES.clear();
    Utils.BANNERS.clear();
    FileManager.setStandard();
    FileManager.loadCategories();
    FileManager.loadBanners();
    sender.sendMessage("§8[§a§l§oBannerABC§8] §7Die BannerDatenbank wurde reloadet");
    return true;
  }

  @Override
  public List<String> onTabComplete(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String alias,
      final String[] args) {
    return Collections.emptyList();
  }
}
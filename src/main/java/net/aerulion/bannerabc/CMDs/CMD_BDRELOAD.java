package net.aerulion.bannerabc.CMDs;

import net.aerulion.bannerabc.Utils.FileManager;
import net.aerulion.bannerabc.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CMD_BDRELOAD implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender.hasPermission("bannerabc.reload"))) {
            sender.sendMessage("§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
            return true;
        }

        Utils.categories.clear();
        Utils.banners.clear();
        FileManager.setStandard();
        FileManager.loadCategories();
        FileManager.loadBanners();
        sender.sendMessage("§8[§a§l§oBannerABC§8] §7Die BannerDatenbank wurde reloadet");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return Collections.emptyList();
    }
}
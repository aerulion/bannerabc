package net.aerulion.bannerabc.CMDs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Collections;
import java.util.List;

public class CMD_BDHELP implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender.hasPermission("bannerabc.help"))) {
            sender.sendMessage("§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
            return true;
        }

        sender.sendMessage("§a§l*§8--------------- §a§lBannerABC §8---------------§a§l*");
        sender.sendMessage("§a§l*§8--> §a§o/abc");
        sender.sendMessage("§a§l*§8--> §a§o/bd");
        sender.sendMessage("§a§l*§8--> §a§o/bd add <Name> [Kategorie]");
        sender.sendMessage("§a§l*§8--> §a§o/bdc add <Name>");
        sender.sendMessage("§a§l*§8--> §a§o/bdc remove <Name>");
        sender.sendMessage("§a§l*§8--> §a§o/bdc set <Banner> <Kategorie>");
        sender.sendMessage("§a§l*§8--> §a§o/bdc setitem <Kategorie>");
        sender.sendMessage("§a§l*§8--> §a§o/bdc rename <AlterName> <NeuerName>");
        sender.sendMessage("§a§l*§8--> §a§o/bdreload");
        sender.sendMessage("§a§l*§8------------------------------------------§a§l*");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return Collections.emptyList();
    }
}
package net.aerulion.bannerabc.CMDs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import net.aerulion.bannerabc.Utils.FileManager;
import net.aerulion.bannerabc.Utils.Utils;

public class CMD_BANNERDATABASE implements CommandExecutor, TabCompleter {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("§8[§a§l§oBannerABC§8] §cDieses Command kann nur von Spieler ausgeführt werden!");
			return true;
		}

		if (!(sender.hasPermission("bannerabc.database"))) {
			sender.sendMessage("§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
			return true;

		}

		Player p = (Player) sender;

		try {
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("add")) {
					if (!(sender.hasPermission("bannerabc.addbanners"))) {
						sender.sendMessage("§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
						return true;
					}
					if (args.length == 3) {
						if (Utils.BannerItems.contains(p.getInventory().getItemInMainHand().getType())) {
							String name = args[1].replaceAll("#", " ");
							if (FileManager.BannerNameExists(name)) {
								p.sendMessage("§8[§a§l§oBannerABC§8] §cDieser Name wird bereits verwendet!");
								return true;
							}
							if (!FileManager.CategoryExists(args[2].replaceAll("#", " "), true)) {
								p.sendMessage("§8[§a§l§oBannerABC§8] §cKeine gültige Kategorie!");
								return true;
							}
							ItemStack i = new ItemStack(p.getInventory().getItemInMainHand());
							i.setAmount(1);
							BannerMeta im = (BannerMeta) i.getItemMeta();
							im.setLore(Arrays.asList("§7Dieses Banner aus der Datenbank entfernen: §aSTRG + Q"));
							im.setDisplayName("§a§l" + name);
							im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
							i.setItemMeta(im);
							FileManager.addBanner(name, i, args[2].replaceAll("#", " "));
							sender.sendMessage("§8[§a§l§oBannerABC§8] §aDer Banner wurde mit folgendem Namen hinzugefügt '§7" + name + "§a'.");
							return true;
						}
						p.sendMessage("§8[§a§l§oBannerABC§8] §cDu musst ein Banner in der Hand halten!");
						return true;
					}
					if (args.length == 2) {
						if (Utils.BannerItems.contains(p.getInventory().getItemInMainHand().getType())) {
							String name = args[1].replaceAll("#", " ");
							if (FileManager.BannerNameExists(name)) {
								p.sendMessage("§8[§a§l§oBannerABC§8] §cDieser Name wird bereits verwendet!");
								return true;
							}
							ItemStack i = new ItemStack(p.getInventory().getItemInMainHand());
							i.setAmount(1);
							BannerMeta im = (BannerMeta) i.getItemMeta();
							im.setLore(Arrays.asList("§7Dieses Banner aus der Datenbank entfernen: §aSTRG + Q"));
							im.setDisplayName("§a§l" + name);
							im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
							i.setItemMeta(im);
							FileManager.addBanner(name, i, "Unsortiert");
							sender.sendMessage("§8[§a§l§oBannerABC§8] §aDer Banner wurde mit folgendem Namen hinzugefügt '§7" + name + "§a'.");
							return true;
						}
						p.sendMessage("§8[§a§l§oBannerABC§8] §cDu musst ein Banner in der Hand halten!");
						return true;
					}
					p.sendMessage("§8[§a§l§oBannerABC§8] §cBitte nutze /bd add <Name> um Banner hinzuzufügen.");
					return true;
				}

				p.sendMessage("§8[§a§l§oBannerABC§8] §cZu viele Argumente!");
				return true;
			}

			if (Utils.banners.size() == 0) {
				p.sendMessage("§8[§a§l§oBannerABC§8] §7Bisher wurden keine Banner gespeichert!");
				return true;
			}

			if (Utils.CurrentCat.get(p.getUniqueId()) == null) {
				p.openInventory(Utils.CategoryMenu());
				return true;
			}
			p.openInventory(Utils.CategoryBanner(Utils.CurrentCat.get(p.getUniqueId()), Utils.page.get(p.getUniqueId())));
			return true;
		} catch (Exception e) {
			FileManager.setStandard();
			sender.sendMessage("§8[§a§l§oBannerABC§8] §cEin interner Fehler ist aufgetreten!");
			return true;
		}

	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 1) {
			return Arrays.asList("add");
		} else if (args.length == 2) {
			return Arrays.asList("<BannerName>");
		} else if (args.length == 3) {
			return new ArrayList<String>(Utils.categories.keySet());
		}
		return Arrays.asList();
	}

}

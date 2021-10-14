package net.aerulion.bannerabc.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.aerulion.bannerabc.Main;
import net.aerulion.bannerabc.Utils.Search.Search;
import net.aerulion.bannerabc.Utils.Search.SearchConversation;
import org.bukkit.Material;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.conversations.ConversationPrefix;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class MenuManager implements Listener {

  private static final Map<String, Menu> menus = new HashMap<>();

  public MenuManager() {
    registerMenu("BannerABCLetter", new LetterMenu("§2§oBuchstabenfarbe wählen", 18));
    registerMenu("BannerABCBackground", new BackgroundMenu("§2§oHintergrundfarbe wählen", 18));
  }

  public static Menu getMenu(String id) {
    return menus.get(id);
  }

  public void registerMenu(String id, Menu menu) {
    menus.put(id, menu);
  }

  @EventHandler
  public void onPlayerClick(InventoryClickEvent e) {

    if (e.getWhoClicked() instanceof Player) {
      if (e.getView().getTitle() != null && e.getCurrentItem() != null
          && e.getCurrentItem().getType() != Material.AIR) {
        for (Menu m : menus.values()) {
          if (e.getView().getTitle().equals(m.invName)) {
            m.click(e.getCurrentItem(), (Player) e.getWhoClicked());
            e.setCancelled(true);
          }
        }
        if (e.getView().getTitle().equals("§c§l§oBannerABC")) {
          if ((e.getView().getTopInventory().getSize() == 45) && (e.getRawSlot() >= 0
              && e.getRawSlot() <= 44)) {
            if (Utils.BannerItems.contains(e.getCurrentItem().getType())) {
              if (e.getClick() == ClickType.LEFT) {
                e.setCancelled(true);
                ItemStack Banner = new ItemStack(e.getCurrentItem());
                BannerMeta metaBanner = (BannerMeta) Banner.getItemMeta();
                metaBanner.setLore(new ArrayList<>());
                metaBanner.setDisplayName(null);
                Banner.setItemMeta(metaBanner);
                e.getWhoClicked().getInventory().addItem(Banner);
              }
              if (e.getClick() == ClickType.SHIFT_RIGHT) {
                e.setCancelled(true);
                e.getWhoClicked().openInventory(getMenu("BannerABCBackground").inv);
              }
              if (e.getClick() == ClickType.SHIFT_LEFT) {
                e.setCancelled(true);
                e.getWhoClicked().openInventory(getMenu("BannerABCLetter").inv);
              } else {
                e.setCancelled(true);
              }
            }
          }

        }
        if (e.getView().getTitle().equals("§c§l§oBannerDatabase Kategorien")) {
          e.setCancelled(true);
          if ((e.getView().getTopInventory().getSize() == Utils.CatInvSize()) && (
              e.getRawSlot() >= 0 && e.getRawSlot() <= Utils.CatInvSize() - 1)) {
            e.setCancelled(true);
            Utils.page.put(e.getWhoClicked().getUniqueId(), 1);
            Utils.CurrentCat.put(e.getWhoClicked().getUniqueId(),
                e.getCurrentItem().getItemMeta().getDisplayName().substring(4));
            e.getWhoClicked().openInventory(
                Utils.CategoryBanner(e.getCurrentItem().getItemMeta().getDisplayName().substring(4),
                    1));

          }

        }
        if (e.getView().getTitle().contains("§c§l§oBannerDatabase")) {
          if ((e.getView().getTopInventory().getSize() == 54) && (e.getRawSlot() >= 0
              && e.getRawSlot() <= 53)) {
            if (Utils.BannerItems.contains(e.getCurrentItem().getType())) {
              if (e.getClick() == ClickType.CONTROL_DROP) {
                e.setCancelled(true);
                if (!(e.getWhoClicked().hasPermission("bannerabc.removebanner"))) {
                  e.getWhoClicked().sendMessage(
                      "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
                  return;
                }
                FileManager.removeBanner(e.getCurrentItem());
                e.getWhoClicked().sendMessage(
                    "§8[§a§l§oBannerABC§8] §7Das Banner mit folgendem Namen wurde aus der Datenbank entfernt: "
                        + e.getCurrentItem().getItemMeta().getDisplayName());
                e.getWhoClicked().openInventory(
                    Utils.CategoryBanner(Utils.CurrentCat.get(e.getWhoClicked().getUniqueId()),
                        Utils.page.get(e.getWhoClicked().getUniqueId())));
                return;
              }
              e.setCancelled(true);
              ItemStack Banner = new ItemStack(e.getCurrentItem());
              BannerMeta metaBanner = (BannerMeta) Banner.getItemMeta();
              metaBanner.setLore(new ArrayList<>());
              metaBanner.setDisplayName(null);
              Banner.setItemMeta(metaBanner);
              e.getWhoClicked().getInventory().addItem(Banner);
            }
            if (e.getCurrentItem().getType().equals(Material.RED_DYE) || e.getCurrentItem()
                .getType().equals(Material.LIME_DYE)) {
              if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lNächste Seite")) {
                e.setCancelled(true);
                e.getWhoClicked().openInventory(
                    Utils.CategoryBanner(Utils.CurrentCat.get(e.getWhoClicked().getUniqueId()),
                        Utils.page.get(e.getWhoClicked().getUniqueId()) + 1));
                Utils.page.put(e.getWhoClicked().getUniqueId(),
                    Utils.page.get(e.getWhoClicked().getUniqueId()) + 1);
              }
              if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lVorherige Seite")) {
                e.setCancelled(true);
                e.getWhoClicked().openInventory(
                    Utils.CategoryBanner(Utils.CurrentCat.get(e.getWhoClicked().getUniqueId()),
                        Utils.page.get(e.getWhoClicked().getUniqueId()) - 1));
                Utils.page.put(e.getWhoClicked().getUniqueId(),
                    Utils.page.get(e.getWhoClicked().getUniqueId()) - 1);
              }
            }
            if (e.getCurrentItem().getType().equals(Material.DARK_OAK_DOOR)) {
              if (e.getCurrentItem().getItemMeta().getDisplayName()
                  .equals("§e§l§oZurück zum Hauptmenü")) {
                e.setCancelled(true);
                e.getWhoClicked().openInventory(Utils.CategoryMenu());
                Utils.CurrentCat.put(e.getWhoClicked().getUniqueId(), null);
                Utils.page.put(e.getWhoClicked().getUniqueId(), 1);
              }
            }
            if (e.getCurrentItem().getType().equals(Material.TRIPWIRE_HOOK)) {
              if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§e§l§oSuche...")) {
                e.setCancelled(true);
                ConversationFactory cf = new ConversationFactory(Main.plugin);
                ConversationPrefix cp = prefix -> "§8[§a§l§oBD-Suche§8] §7";
                Conversation c = cf.withFirstPrompt(new SearchConversation())
                    .withEscapeSequence("stop").withPrefix(cp).withTimeout(30)
                    .buildConversation((Player) e.getWhoClicked());
                c.begin();
              }
            }
          }

        }

        if (e.getView().getTitle().contains("§c§l§oSuchergebnisse")) {
          if ((e.getView().getTopInventory().getSize() == 54) && (e.getRawSlot() >= 0
              && e.getRawSlot() <= 53)) {
            if (Utils.BannerItems.contains(e.getCurrentItem().getType())) {
              if (e.getClick() == ClickType.CONTROL_DROP) {
                e.setCancelled(true);
                if (!(e.getWhoClicked().hasPermission("bannerabc.removebanner"))) {
                  e.getWhoClicked().sendMessage(
                      "§8[§a§l§oBannerABC§8] §cFehler: Du hast nicht die erforderlichen Rechte!");
                  return;
                }
                FileManager.removeBanner(e.getCurrentItem());
                e.getWhoClicked().sendMessage(
                    "§8[§a§l§oBannerABC§8] §7Das Banner mit folgendem Namen wurde aus der Datenbank entfernt: "
                        + e.getCurrentItem().getItemMeta().getDisplayName());
                Search.SearchInv((Player) e.getWhoClicked());
                return;
              }
              e.setCancelled(true);
              ItemStack Banner = new ItemStack(e.getCurrentItem());
              BannerMeta metaBanner = (BannerMeta) Banner.getItemMeta();
              metaBanner.setLore(new ArrayList<>());
              Banner.setItemMeta(metaBanner);
              e.getWhoClicked().getInventory().addItem(Banner);
            }
            if (e.getCurrentItem().getType().equals(Material.RED_DYE) || e.getCurrentItem()
                .getType().equals(Material.LIME_DYE)) {
              if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lNächste Seite")) {
                e.setCancelled(true);
                Utils.searchpage.put(e.getWhoClicked().getUniqueId(),
                    Utils.searchpage.get(e.getWhoClicked().getUniqueId()) + 1);
                Search.SearchInv((Player) e.getWhoClicked());
              }
              if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lVorherige Seite")) {
                e.setCancelled(true);
                Utils.searchpage.put(e.getWhoClicked().getUniqueId(),
                    Utils.searchpage.get(e.getWhoClicked().getUniqueId()) - 1);
                Search.SearchInv((Player) e.getWhoClicked());
              }
            }
            if (e.getCurrentItem().getType().equals(Material.DARK_OAK_DOOR)) {
              if (e.getCurrentItem().getItemMeta().getDisplayName()
                  .equals("§e§l§oZurück zum Hauptmenü")) {
                e.setCancelled(true);
                e.getWhoClicked().openInventory(Utils.CategoryMenu());
                Utils.searchpage.put(e.getWhoClicked().getUniqueId(), 1);
              }
            }
          }

        }
      }
    }
  }
}
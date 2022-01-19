package net.aerulion.bannerabc.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FileManager {

  public static void setStandard() {
    final @NotNull File defaultFile = new File("plugins/BannerABC/BannerDatabase", "Unsortiert.yml");
    final @NotNull FileConfiguration cfg = YamlConfiguration.loadConfiguration(defaultFile);
    cfg.options().copyDefaults(true);
    cfg.addDefault("§CATEGORYITEM§", new ItemStack(Material.GRASS_BLOCK));
    try {
      cfg.save(defaultFile);
    } catch (final IOException ignored) {
    }
  }

  public static void addCategory(final String categoryName, final @NotNull ItemStack catItem) {
    final @NotNull File file = new File("plugins/BannerABC/BannerDatabase", categoryName + ".yml");
    final @NotNull FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    catItem.setAmount(1);
    cfg.set("§CATEGORYITEM§", catItem);
    Utils.CATEGORIES.put(categoryName, file);
    try {
      cfg.save(file);
    } catch (final IOException ignored) {
    }
  }

  public static void removeCategory(final String categoryName) {
    final @NotNull File target = new File("plugins/BannerABC/BannerDatabase", categoryName + ".yml");
    if (target.exists()) {
      if (target.isFile()) {
        for (final Entry<UUID, String> entry : Utils.CURRENT_CAT.entrySet()) {
          if (entry.getValue().equalsIgnoreCase(categoryName)) {
            Utils.CURRENT_CAT.put(entry.getKey(), null);
          }
        }
        deleteAllBannersInCategory(categoryName);
        target.delete();
        Utils.CATEGORIES.remove(categoryName);
      }
    }
  }

  public static void deleteAllBannersInCategory(final String categoryName) {
    final @NotNull List<ItemStack> toBeDeleted = new ArrayList<>();
    for (final Entry<ItemStack, String> entry : Utils.BANNERS.entrySet()) {
      if (entry.getValue().equalsIgnoreCase(categoryName)) {
        toBeDeleted.add(entry.getKey());
      }
    }
    for (final ItemStack del : toBeDeleted) {
      Utils.BANNERS.remove(del);
    }
  }

  public static @Nullable ItemStack categoryItem(final @NotNull File category) {
    if (category.exists()) {
      if (category.isFile()) {
        final @NotNull FileConfiguration cfg = YamlConfiguration.loadConfiguration(category);
        return cfg.getItemStack("§CATEGORYITEM§");
      }
    }
    return null;
  }

  public static void setCatItem(final String category, final ItemStack itemStack) {
    final @NotNull File defaultCat = new File("plugins/BannerABC/BannerDatabase", category + ".yml");
    final @NotNull FileConfiguration cfg = YamlConfiguration.loadConfiguration(defaultCat);
    cfg.set("§CATEGORYITEM§", itemStack);
    try {
      cfg.save(defaultCat);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  public static void loadCategories() {
    final @NotNull File folder = new File("plugins/BannerABC/BannerDatabase");
    final File @Nullable [] listOfFiles = folder.listFiles();
    for (final @NotNull File file : listOfFiles) {
      if (file.isFile()) {
        Utils.CATEGORIES.put(file.getName().replaceAll(".yml", ""), file);
      }
    }
  }

  public static void loadBanners() {
    for (final String category : Utils.CATEGORIES.keySet()) {
      if (categoryFileExists(category)) {
        final @NotNull File catFile = new File("plugins/BannerABC/BannerDatabase", category + ".yml");
        final @NotNull FileConfiguration cfg = YamlConfiguration.loadConfiguration(catFile);
        for (final @NotNull String s : cfg.getKeys(false)) {
          if (!s.equals("§CATEGORYITEM§")) {
            final @Nullable ItemStack is = cfg.getItemStack(s);
            if (Utils.BANNER_ITEMS.contains(is.getType())) {
              Utils.BANNERS.put(is, category);
            }
          }
        }
      }
    }
  }

  public static void setBannerCategory(final @NotNull String name, final String newCat) {
    @Nullable ItemStack target = null;
    for (final @NotNull ItemStack is : Utils.BANNERS.keySet()) {
      if (is.getItemMeta().getDisplayName().substring(4).equalsIgnoreCase(name)) {
        target = is;
      }
    }
    final String oldCat = Utils.BANNERS.get(target);
    final File oldCatFile = Utils.CATEGORIES.get(oldCat);
    final File newCatFile = Utils.CATEGORIES.get(newCat);
    final @NotNull FileConfiguration oldCatCFG = YamlConfiguration.loadConfiguration(oldCatFile);
    final @NotNull FileConfiguration newCatCFG = YamlConfiguration.loadConfiguration(newCatFile);
    final @Nullable ItemStack changedBanner = oldCatCFG.getItemStack(name);
    oldCatCFG.set(name, null);
    newCatCFG.set(name, changedBanner);
    Utils.BANNERS.put(changedBanner, newCat);
    try {
      oldCatCFG.save(oldCatFile);
      newCatCFG.save(newCatFile);
    } catch (final IOException ignored) {
    }

  }

  public static void addBanner(final @NotNull String name, final ItemStack is, final String category) {
    final @NotNull File defaultCat = new File("plugins/BannerABC/BannerDatabase", category + ".yml");
    final @NotNull FileConfiguration cfg = YamlConfiguration.loadConfiguration(defaultCat);
    cfg.set(name, is);
    Utils.BANNERS.put(is, category);
    try {
      cfg.save(defaultCat);
    } catch (final IOException ignored) {
    }

  }

  public static void removeBanner(final @NotNull ItemStack is) {
    final File targetFile = Utils.CATEGORIES.get(Utils.BANNERS.get(is));
    final @NotNull FileConfiguration cfg = YamlConfiguration.loadConfiguration(targetFile);
    cfg.set(is.getItemMeta().getDisplayName().substring(4), null);
    Utils.BANNERS.remove(is);
    try {
      cfg.save(targetFile);
    } catch (final IOException ignored) {
    }

  }

  public static @NotNull List<String> getAllBannerNamesWithoutSpaces() {
    final @NotNull ArrayList<String> bannerNames = new ArrayList<>();
    for (final @NotNull ItemStack is : Utils.BANNERS.keySet()) {
      bannerNames.add(ChatColor.stripColor(is.getItemMeta().getDisplayName().replaceAll(" ", "#")));
    }
    return bannerNames;
  }

  public static boolean bannerNameExists(final String name) {
    for (final @NotNull ItemStack is : Utils.BANNERS.keySet()) {
      if (is.getItemMeta().getDisplayName().substring(4).equalsIgnoreCase(name)) {
        return true;
      }
    }
    return false;
  }

  public static boolean categoryExists(final String name, final boolean exact) {
    for (final @NotNull String s : Utils.CATEGORIES.keySet()) {
      if (exact) {
        if (s.equals(name)) {
          return true;
        }
      } else {
        if (s.equalsIgnoreCase(name)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean categoryFileExists(final String categoryName) {
    final @NotNull File target = new File("plugins/BannerABC/BannerDatabase", categoryName + ".yml");
    if (target.exists()) {
      return target.isFile();
    }
    return false;
  }

  public static void renameCat(final String oldname, final String newname) {
    for (final Entry<ItemStack, String> entry : Utils.BANNERS.entrySet()) {
      if (entry.getValue().equals(oldname)) {
        Utils.BANNERS.put(entry.getKey(), newname);
      }
    }
    for (final Entry<UUID, String> entry : Utils.CURRENT_CAT.entrySet()) {
      if (entry.getValue().equals(oldname)) {
        Utils.CURRENT_CAT.put(entry.getKey(), newname);
      }
    }
    final @NotNull File oldCat = new File("plugins/BannerABC/BannerDatabase", oldname + ".yml");
    final @NotNull File newCat = new File("plugins/BannerABC/BannerDatabase", newname + ".yml");
    oldCat.renameTo(newCat);
    Utils.CATEGORIES.remove(oldname);
    Utils.CATEGORIES.put(newname, newCat);
  }

  public static void migrateBanners() {
    for (final String category : Utils.CATEGORIES.keySet()) {
      if (categoryFileExists(category)) {
        final @NotNull File catFile = new File("plugins/BannerABC/BannerDatabase", category + ".yml");
        final @NotNull FileConfiguration cfg = YamlConfiguration.loadConfiguration(catFile);
        for (final @NotNull String s : cfg.getKeys(false)) {
          if (s.equals("§CATEGORYITEM§")) {
            final @Nullable ItemStack is = cfg.getItemStack(s);
            final @NotNull File defaultCat = new File("plugins/BannerABC/BannerDatabase/MigratedData",
                category + ".yml");
            final @NotNull FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(defaultCat);
            cfg2.set("§CATEGORYITEM§", is);
            try {
              cfg2.save(defaultCat);
            } catch (final IOException ignored) {
            }
          }
        }
      }
    }
    for (final Entry<ItemStack, String> entry : Utils.BANNERS.entrySet()) {
      final @NotNull ItemStack is = entry.getKey();
      final @NotNull File defaultCat = new File("plugins/BannerABC/BannerDatabase/MigratedData",
          entry.getValue() + ".yml");
      final @NotNull FileConfiguration cfg = YamlConfiguration.loadConfiguration(defaultCat);
      cfg.set(is.getItemMeta().getDisplayName().substring(4), is);
      try {
        cfg.save(defaultCat);
      } catch (final IOException ignored) {
      }
    }
  }
}
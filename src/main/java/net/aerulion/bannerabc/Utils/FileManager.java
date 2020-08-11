package net.aerulion.bannerabc.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileManager {

    public static void setStandard() {
        File defaultFile = new File("plugins/BannerABC/BannerDatabase", "Unsortiert.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(defaultFile);
        cfg.options().copyDefaults(true);
        cfg.addDefault("§CATEGORYITEM§", new ItemStack(Material.GRASS_BLOCK));
        try {
            cfg.save(defaultFile);
        } catch (IOException ignored) {
        }
    }

    public static void addCategory(String CategoryName, ItemStack CatItem) {
        File file = new File("plugins/BannerABC/BannerDatabase", CategoryName + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        CatItem.setAmount(1);
        cfg.set("§CATEGORYITEM§", CatItem);
        Utils.categories.put(CategoryName, file);
        try {
            cfg.save(file);
        } catch (IOException ignored) {
        }
    }

    public static void removeCategory(String CategoryName) {
        File target = new File("plugins/BannerABC/BannerDatabase", CategoryName + ".yml");
        if (target.exists()) {
            if (target.isFile()) {
                for (UUID id : Utils.CurrentCat.keySet()) {
                    if (Utils.CurrentCat.get(id).equalsIgnoreCase(CategoryName)) {
                        Utils.CurrentCat.put(id, null);
                    }
                }
                deleteAllBannersInCategory(CategoryName);
                target.delete();
                Utils.categories.remove(CategoryName);
            }
        }
    }

    public static void deleteAllBannersInCategory(String CategoryName) {
        List<ItemStack> toBeDeleted = new ArrayList<>();
        for (ItemStack is : Utils.banners.keySet()) {
            if (Utils.banners.get(is).equalsIgnoreCase(CategoryName)) {
                toBeDeleted.add(is);
            }
        }
        for (ItemStack del : toBeDeleted) {
            Utils.banners.remove(del);
        }
    }

    public static ItemStack CategoryItem(File Category) {
        if (Category.exists()) {
            if (Category.isFile()) {
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(Category);
                return cfg.getItemStack("§CATEGORYITEM§");
            }
        }
        return null;
    }

    public static void setCatItem(String Category, ItemStack is) {
        File DefaultCat = new File("plugins/BannerABC/BannerDatabase", Category + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(DefaultCat);
        cfg.set("§CATEGORYITEM§", is);
        try {
            cfg.save(DefaultCat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadCategories() {
        File folder = new File("plugins/BannerABC/BannerDatabase");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                Utils.categories.put(file.getName().replaceAll(".yml", ""), file);
            }
        }
    }

    public static void loadBanners() {
        for (String category : Utils.categories.keySet()) {
            if (CategoryFileExists(category)) {
                File catFile = new File("plugins/BannerABC/BannerDatabase", category + ".yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(catFile);
                for (String s : cfg.getKeys(false)) {
                    if (!s.equals("§CATEGORYITEM§")) {
                        ItemStack is = cfg.getItemStack(s);
                        if (Utils.BannerItems.contains(is.getType())) {
                            Utils.banners.put(is, category);
                        }
                    }
                }
            }
        }
    }

    public static void setBannerCategory(String Name, String newCat) {
        ItemStack target = null;
        for (ItemStack is : Utils.banners.keySet()) {
            if (is.getItemMeta().getDisplayName().substring(4).equalsIgnoreCase(Name)) {
                target = is;
            }
        }
        String oldCat = Utils.banners.get(target);
        File oldCatFile = Utils.categories.get(oldCat);
        File newCatFile = Utils.categories.get(newCat);
        FileConfiguration oldCatCFG = YamlConfiguration.loadConfiguration(oldCatFile);
        FileConfiguration newCatCFG = YamlConfiguration.loadConfiguration(newCatFile);
        ItemStack changedBanner = oldCatCFG.getItemStack(Name);
        oldCatCFG.set(Name, null);
        newCatCFG.set(Name, changedBanner);
        Utils.banners.put(changedBanner, newCat);
        try {
            oldCatCFG.save(oldCatFile);
            newCatCFG.save(newCatFile);
        } catch (IOException ignored) {
        }

    }

    public static void addBanner(String Name, ItemStack is, String Category) {
        File DefaultCat = new File("plugins/BannerABC/BannerDatabase", Category + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(DefaultCat);
        cfg.set(Name, is);
        Utils.banners.put(is, Category);
        try {
            cfg.save(DefaultCat);
        } catch (IOException ignored) {
        }

    }

    public static void removeBanner(ItemStack is) {
        File targetFile = Utils.categories.get(Utils.banners.get(is));
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(targetFile);
        cfg.set(is.getItemMeta().getDisplayName().substring(4), null);
        Utils.banners.remove(is);
        try {
            cfg.save(targetFile);
        } catch (IOException ignored) {
        }

    }

    public static List<String> getAllBannerNamesWithoutSpaces() {
        ArrayList<String> BannerNames = new ArrayList<>();
        for (ItemStack is : Utils.banners.keySet()) {
            BannerNames.add(ChatColor.stripColor(is.getItemMeta().getDisplayName().replaceAll(" ", "#")));
        }
        return BannerNames;
    }

    public static boolean BannerNameExists(String Name) {
        for (ItemStack is : Utils.banners.keySet()) {
            if (is.getItemMeta().getDisplayName().substring(4).equalsIgnoreCase(Name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean CategoryExists(String Name, boolean Exact) {
        for (String s : Utils.categories.keySet()) {
            if (Exact) {
                if (s.equals(Name)) {
                    return true;
                }
            } else {
                if (s.equalsIgnoreCase(Name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean CategoryFileExists(String CategoryName) {
        File target = new File("plugins/BannerABC/BannerDatabase", CategoryName + ".yml");
        if (target.exists()) {
            return target.isFile();
        }
        return false;
    }

    public static void renameCat(String oldname, String newname) {
        for (ItemStack i : Utils.banners.keySet()) {
            if (Utils.banners.get(i).equals(oldname)) {
                Utils.banners.put(i, newname);
            }
        }
        for (UUID u : Utils.CurrentCat.keySet()) {
            if (Utils.CurrentCat.get(u).equals(oldname)) {
                Utils.CurrentCat.put(u, newname);
            }
        }
        File oldCat = new File("plugins/BannerABC/BannerDatabase", oldname + ".yml");
        File newCat = new File("plugins/BannerABC/BannerDatabase", newname + ".yml");
        oldCat.renameTo(newCat);
        Utils.categories.remove(oldname);
        Utils.categories.put(newname, newCat);
    }

    public static void migrateBanners() {
        for (String category : Utils.categories.keySet()) {
            if (CategoryFileExists(category)) {
                File catFile = new File("plugins/BannerABC/BannerDatabase", category + ".yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(catFile);
                for (String s : cfg.getKeys(false)) {
                    if (s.equals("§CATEGORYITEM§")) {
                        ItemStack is = cfg.getItemStack(s);
                        File DefaultCat = new File("plugins/BannerABC/BannerDatabase/MigratedData", category + ".yml");
                        FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(DefaultCat);
                        cfg2.set("§CATEGORYITEM§", is);
                        try {
                            cfg2.save(DefaultCat);
                        } catch (IOException ignored) {
                        }
                    }
                }
            }
        }
        for (ItemStack is : Utils.banners.keySet()) {
            File DefaultCat = new File("plugins/BannerABC/BannerDatabase/MigratedData", Utils.banners.get(is) + ".yml");
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(DefaultCat);
            cfg.set(is.getItemMeta().getDisplayName().substring(4), is);
            try {
                cfg.save(DefaultCat);
            } catch (IOException ignored) {
            }
        }
    }
}
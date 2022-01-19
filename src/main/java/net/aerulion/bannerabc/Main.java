package net.aerulion.bannerabc;

import net.aerulion.bannerabc.cmd.AbcCommand;
import net.aerulion.bannerabc.cmd.DatabaseCommand;
import net.aerulion.bannerabc.cmd.DatabaseCategoryCommand;
import net.aerulion.bannerabc.cmd.HelpCommand;
import net.aerulion.bannerabc.cmd.MigrateCommand;
import net.aerulion.bannerabc.cmd.ReloadCommand;
import net.aerulion.bannerabc.utils.FileManager;
import net.aerulion.bannerabc.utils.MenuManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  public static Main plugin;

  @Override
  public void onEnable() {
    plugin = this;
    FileManager.setStandard();
    FileManager.loadCategories();
    FileManager.loadBanners();

    getCommand("bannerabc").setExecutor(new AbcCommand());
    getCommand("bannerabc").setTabCompleter(new AbcCommand());

    getCommand("bannerdatabase").setExecutor(new DatabaseCommand());
    getCommand("bannerdatabase").setTabCompleter(new DatabaseCommand());

    getCommand("bannerdatabasecategory").setExecutor(new DatabaseCategoryCommand());
    getCommand("bannerdatabasecategory").setTabCompleter(new DatabaseCategoryCommand());

    getCommand("bdreload").setExecutor(new ReloadCommand());
    getCommand("bdreload").setTabCompleter(new ReloadCommand());

    getCommand("bdhelp").setExecutor(new HelpCommand());
    getCommand("bdhelp").setTabCompleter(new HelpCommand());

    getCommand("bdmigrate").setExecutor(new MigrateCommand());
    getCommand("bdmigrate").setTabCompleter(new MigrateCommand());

    getServer().getPluginManager().registerEvents(new MenuManager(), this);
  }

}
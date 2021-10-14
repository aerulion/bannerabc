package net.aerulion.bannerabc;

import net.aerulion.bannerabc.CMDs.CMD_BANNERABC;
import net.aerulion.bannerabc.CMDs.CMD_BANNERDATABASE;
import net.aerulion.bannerabc.CMDs.CMD_BANNERDATABASECATEGORY;
import net.aerulion.bannerabc.CMDs.CMD_BDHELP;
import net.aerulion.bannerabc.CMDs.CMD_BDMIGRATE;
import net.aerulion.bannerabc.CMDs.CMD_BDRELOAD;
import net.aerulion.bannerabc.Utils.FileManager;
import net.aerulion.bannerabc.Utils.MenuManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  public static Main plugin;

  @Override
  public void onEnable() {
    plugin = this;
    FileManager.setStandard();
    FileManager.loadCategories();
    FileManager.loadBanners();

    getCommand("bannerabc").setExecutor(new CMD_BANNERABC());
    getCommand("bannerabc").setTabCompleter(new CMD_BANNERABC());

    getCommand("bannerdatabase").setExecutor(new CMD_BANNERDATABASE());
    getCommand("bannerdatabase").setTabCompleter(new CMD_BANNERDATABASE());

    getCommand("bannerdatabasecategory").setExecutor(new CMD_BANNERDATABASECATEGORY());
    getCommand("bannerdatabasecategory").setTabCompleter(new CMD_BANNERDATABASECATEGORY());

    getCommand("bdreload").setExecutor(new CMD_BDRELOAD());
    getCommand("bdreload").setTabCompleter(new CMD_BDRELOAD());

    getCommand("bdhelp").setExecutor(new CMD_BDHELP());
    getCommand("bdhelp").setTabCompleter(new CMD_BDHELP());

    getCommand("bdmigrate").setExecutor(new CMD_BDMIGRATE());
    getCommand("bdmigrate").setTabCompleter(new CMD_BDMIGRATE());

    getServer().getPluginManager().registerEvents(new MenuManager(), this);
  }

}
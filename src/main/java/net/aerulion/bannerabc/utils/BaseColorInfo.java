package net.aerulion.bannerabc.utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public enum BaseColorInfo {

  BLACK(DyeColor.BLACK, Material.BLACK_BANNER),
  BLUE(DyeColor.BLUE, Material.BLUE_BANNER),
  BROWN(DyeColor.BROWN, Material.BROWN_BANNER),
  CYAN(DyeColor.CYAN, Material.CYAN_BANNER),
  GRAY(DyeColor.GRAY, Material.GRAY_BANNER),
  GREEN(DyeColor.GREEN, Material.GREEN_BANNER),
  LIGHT_BLUE(DyeColor.LIGHT_BLUE, Material.LIGHT_BLUE_BANNER),
  LIME(DyeColor.LIME, Material.LIME_BANNER),
  MAGENTA(DyeColor.MAGENTA, Material.MAGENTA_BANNER),
  ORANGE(DyeColor.ORANGE, Material.ORANGE_BANNER),
  PINK(DyeColor.PINK, Material.PINK_BANNER),
  PURPLE(DyeColor.PURPLE, Material.PURPLE_BANNER),
  RED(DyeColor.RED, Material.RED_BANNER),
  LIGHT_GRAY(DyeColor.LIGHT_GRAY, Material.LIGHT_GRAY_BANNER),
  WHITE(DyeColor.WHITE, Material.WHITE_BANNER),
  YELLOW(DyeColor.YELLOW, Material.YELLOW_BANNER),

  DEFAULT(DyeColor.WHITE, Material.WHITE_BANNER);

  private final DyeColor dyeColor;
  private final Material material;

  BaseColorInfo(final DyeColor dyeColor, final Material material) {
    this.dyeColor = dyeColor;
    this.material = material;
  }

  public static @NotNull BaseColorInfo getBaseColorFromDyeColor(final DyeColor dyeColor) {
    for (final @NotNull BaseColorInfo baseColorInfo : values()) {
      if (baseColorInfo.getDyeColor() == dyeColor) {
        return baseColorInfo;
      }
    }
    return DEFAULT;
  }

  public DyeColor getDyeColor() {
    return this.dyeColor;
  }

  public Material getMaterial() {
    return this.material;
  }

}
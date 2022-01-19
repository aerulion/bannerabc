package net.aerulion.bannerabc.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Utils {

  public static final List<Material> BANNER_ITEMS = Arrays.asList(Material.BLACK_BANNER,
      Material.BLUE_BANNER, Material.BROWN_BANNER, Material.CYAN_BANNER, Material.GREEN_BANNER,
      Material.GRAY_BANNER, Material.LIGHT_BLUE_BANNER, Material.LIGHT_GRAY_BANNER,
      Material.LIME_BANNER, Material.MAGENTA_BANNER, Material.ORANGE_BANNER, Material.PINK_BANNER,
      Material.PURPLE_BANNER, Material.RED_BANNER, Material.WHITE_BANNER, Material.YELLOW_BANNER);
  public static final @NotNull Map<UUID, DyeColor> LETTER_COLORS = new HashMap<>();
  public static final @NotNull Map<UUID, DyeColor> BACKGROUND_COLORS = new HashMap<>();
  public static final @NotNull Map<UUID, Integer> PAGE = new HashMap<>();
  public static final @NotNull Map<UUID, Integer> SEARCH_PAGE = new HashMap<>();
  public static final @NotNull Map<UUID, String> LATEST_SEARCH = new HashMap<>();
  public static final @NotNull Map<UUID, String> CURRENT_CAT = new HashMap<>();
  public static final @NotNull Map<String, File> CATEGORIES = new HashMap<>();
  public static final @NotNull Map<ItemStack, String> BANNERS = new HashMap<>();

  public static @NotNull Inventory alphabetInv(final @NotNull DyeColor letter,
      final @NotNull DyeColor background) {
    final @NotNull Inventory babc = Bukkit.createInventory(null, 45, "§c§l§oBannerABC");

    final @NotNull ItemStack a = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());

    final @NotNull BannerMeta am = (BannerMeta) a.getItemMeta();
    final @NotNull List<Pattern> apatterns = new ArrayList<>();
    apatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    apatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    apatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    apatterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    apatterns.add(new Pattern(background, PatternType.BORDER));
    am.setPatterns(apatterns);
    am.setDisplayName("§a§lA");
    am.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    am.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    a.setItemMeta(am);

    final @NotNull ItemStack b = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta bm = (BannerMeta) b.getItemMeta();
    final @NotNull List<Pattern> bpatterns = new ArrayList<>();
    bpatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    bpatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    bpatterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    bpatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    bpatterns.add(new Pattern(background, PatternType.CURLY_BORDER));
    bpatterns.add(new Pattern(letter, PatternType.SQUARE_TOP_LEFT));
    bpatterns.add(new Pattern(letter, PatternType.SQUARE_BOTTOM_LEFT));
    bpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    bpatterns.add(new Pattern(background, PatternType.BORDER));
    bm.setPatterns(bpatterns);
    bm.setDisplayName("§a§lB");
    bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    bm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    b.setItemMeta(bm);

    final @NotNull ItemStack c = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta cm = (BannerMeta) c.getItemMeta();
    final @NotNull List<Pattern> cpatterns = new ArrayList<>();
    cpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    cpatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    cpatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    cpatterns.add(new Pattern(background, PatternType.BORDER));
    cm.setPatterns(cpatterns);
    cm.setDisplayName("§a§lC");
    cm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    cm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    c.setItemMeta(cm);

    final @NotNull ItemStack d = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta dm = (BannerMeta) d.getItemMeta();
    final @NotNull List<Pattern> dpatterns = new ArrayList<>();
    dpatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    dpatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    dpatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    dpatterns.add(new Pattern(background, PatternType.CURLY_BORDER));
    dpatterns.add(new Pattern(letter, PatternType.SQUARE_TOP_LEFT));
    dpatterns.add(new Pattern(letter, PatternType.SQUARE_BOTTOM_LEFT));
    dpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    dpatterns.add(new Pattern(background, PatternType.BORDER));
    dm.setPatterns(dpatterns);
    dm.setDisplayName("§a§lD");
    dm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    dm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    d.setItemMeta(dm);

    final @NotNull ItemStack e = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta em = (BannerMeta) e.getItemMeta();
    final @NotNull List<Pattern> epatterns = new ArrayList<>();
    epatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    epatterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    epatterns.add(new Pattern(background, PatternType.STRIPE_RIGHT));
    epatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    epatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    epatterns.add(new Pattern(background, PatternType.BORDER));
    em.setPatterns(epatterns);
    em.setDisplayName("§a§lE");
    em.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    em.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    e.setItemMeta(em);

    final @NotNull ItemStack f = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta fm = (BannerMeta) f.getItemMeta();
    final @NotNull List<Pattern> fpatterns = new ArrayList<>();
    fpatterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    fpatterns.add(new Pattern(background, PatternType.STRIPE_RIGHT));
    fpatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    fpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    fpatterns.add(new Pattern(background, PatternType.BORDER));
    fm.setPatterns(fpatterns);
    fm.setDisplayName("§a§lF");
    fm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    fm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    f.setItemMeta(fm);

    final @NotNull ItemStack g = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta gm = (BannerMeta) g.getItemMeta();
    final @NotNull List<Pattern> gpatterns = new ArrayList<>();
    gpatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    gpatterns.add(new Pattern(background, PatternType.HALF_HORIZONTAL));
    gpatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    gpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    gpatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    gpatterns.add(new Pattern(background, PatternType.BORDER));
    gm.setPatterns(gpatterns);
    gm.setDisplayName("§a§lG");
    gm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    gm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    g.setItemMeta(gm);

    final @NotNull ItemStack h = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta hm = (BannerMeta) h.getItemMeta();
    final @NotNull List<Pattern> hpatterns = new ArrayList<>();
    hpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    hpatterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    hpatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    hpatterns.add(new Pattern(background, PatternType.BORDER));
    hm.setPatterns(hpatterns);
    hm.setDisplayName("§a§lH");
    hm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    hm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    h.setItemMeta(hm);

    final @NotNull ItemStack i = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta im = (BannerMeta) i.getItemMeta();
    final @NotNull List<Pattern> ipatterns = new ArrayList<>();
    ipatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    ipatterns.add(new Pattern(letter, PatternType.STRIPE_CENTER));
    ipatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    ipatterns.add(new Pattern(background, PatternType.BORDER));
    im.setPatterns(ipatterns);
    im.setDisplayName("§a§lI");
    im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    im.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    i.setItemMeta(im);

    final @NotNull ItemStack j = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta jm = (BannerMeta) j.getItemMeta();
    final @NotNull List<Pattern> jpatterns = new ArrayList<>();
    jpatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    jpatterns.add(new Pattern(letter, PatternType.STRIPE_CENTER));
    jpatterns.add(new Pattern(letter, PatternType.SQUARE_BOTTOM_LEFT));
    jpatterns.add(new Pattern(background, PatternType.BORDER));
    jm.setPatterns(jpatterns);
    jm.setDisplayName("§a§lJ");
    jm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    jm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    j.setItemMeta(jm);

    final @NotNull ItemStack k = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta km = (BannerMeta) k.getItemMeta();
    final @NotNull List<Pattern> kpatterns = new ArrayList<>();
    kpatterns.add(new Pattern(letter, PatternType.CROSS));
    kpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    kpatterns.add(new Pattern(letter, PatternType.HALF_VERTICAL));
    kpatterns.add(new Pattern(background, PatternType.BORDER));
    km.setPatterns(kpatterns);
    km.setDisplayName("§a§lK");
    km.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    km.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    k.setItemMeta(km);

    final @NotNull ItemStack l = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta lm = (BannerMeta) l.getItemMeta();
    final @NotNull List<Pattern> lpatterns = new ArrayList<>();
    lpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    lpatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    lpatterns.add(new Pattern(background, PatternType.BORDER));
    lm.setPatterns(lpatterns);
    lm.setDisplayName("§a§lL");
    lm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    lm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    l.setItemMeta(lm);

    final @NotNull ItemStack m = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta mm = (BannerMeta) m.getItemMeta();
    final @NotNull List<Pattern> mpatterns = new ArrayList<>();
    mpatterns.add(new Pattern(letter, PatternType.TRIANGLE_TOP));
    mpatterns.add(new Pattern(background, PatternType.TRIANGLES_TOP));
    mpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    mpatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    mpatterns.add(new Pattern(background, PatternType.BORDER));
    mm.setPatterns(mpatterns);
    mm.setDisplayName("§a§lM");
    mm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    mm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    m.setItemMeta(mm);

    final @NotNull ItemStack n = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta nm = (BannerMeta) n.getItemMeta();
    final @NotNull List<Pattern> npatterns = new ArrayList<>();
    npatterns.add(new Pattern(letter, PatternType.STRIPE_DOWNRIGHT));
    npatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    npatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    npatterns.add(new Pattern(background, PatternType.BORDER));
    nm.setPatterns(npatterns);
    nm.setDisplayName("§a§lN");
    nm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    nm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    n.setItemMeta(nm);

    final @NotNull ItemStack o = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta om = (BannerMeta) o.getItemMeta();
    final @NotNull List<Pattern> opatterns = new ArrayList<>();
    opatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    opatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    opatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    opatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    opatterns.add(new Pattern(background, PatternType.BORDER));
    om.setPatterns(opatterns);
    om.setDisplayName("§a§lO");
    om.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    om.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    o.setItemMeta(om);

    final @NotNull ItemStack p = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta pm = (BannerMeta) p.getItemMeta();
    final @NotNull List<Pattern> ppatterns = new ArrayList<>();
    ppatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    ppatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    ppatterns.add(new Pattern(background, PatternType.HALF_HORIZONTAL_MIRROR));
    ppatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    ppatterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    ppatterns.add(new Pattern(background, PatternType.BORDER));
    pm.setPatterns(ppatterns);
    pm.setDisplayName("§a§lP");
    pm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    pm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    p.setItemMeta(pm);

    final @NotNull ItemStack q = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(letter).getMaterial());
    final @NotNull BannerMeta qm = (BannerMeta) q.getItemMeta();
    final @NotNull List<Pattern> qpatterns = new ArrayList<>();
    qpatterns.add(new Pattern(background, PatternType.RHOMBUS_MIDDLE));
    qpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    qpatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    qpatterns.add(new Pattern(letter, PatternType.SQUARE_BOTTOM_RIGHT));
    qpatterns.add(new Pattern(background, PatternType.BORDER));
    qm.setPatterns(qpatterns);
    qm.setDisplayName("§a§lQ");
    qm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    qm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    q.setItemMeta(qm);

    final @NotNull ItemStack r = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta rm = (BannerMeta) r.getItemMeta();
    final @NotNull List<Pattern> rpatterns = new ArrayList<>();
    rpatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    rpatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    rpatterns.add(new Pattern(background, PatternType.HALF_HORIZONTAL_MIRROR));
    rpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    rpatterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    rpatterns.add(new Pattern(letter, PatternType.STRIPE_DOWNRIGHT));
    rpatterns.add(new Pattern(background, PatternType.BORDER));
    rm.setPatterns(rpatterns);
    rm.setDisplayName("§a§lR");
    rm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    rm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    r.setItemMeta(rm);

    final @NotNull ItemStack s = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta sm = (BannerMeta) s.getItemMeta();
    final @NotNull List<Pattern> spatterns = new ArrayList<>();
    spatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    spatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    spatterns.add(new Pattern(background, PatternType.RHOMBUS_MIDDLE));
    spatterns.add(new Pattern(letter, PatternType.STRIPE_DOWNRIGHT));
    spatterns.add(new Pattern(background, PatternType.BORDER));
    spatterns.add(new Pattern(background, PatternType.CURLY_BORDER));
    sm.setPatterns(spatterns);
    sm.setDisplayName("§a§lS");
    sm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    sm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    s.setItemMeta(sm);

    final @NotNull ItemStack t = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta tm = (BannerMeta) t.getItemMeta();
    final @NotNull List<Pattern> tpatterns = new ArrayList<>();
    tpatterns.add(new Pattern(letter, PatternType.STRIPE_CENTER));
    tpatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    tpatterns.add(new Pattern(background, PatternType.BORDER));
    tm.setPatterns(tpatterns);
    tm.setDisplayName("§a§lT");
    tm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    tm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    t.setItemMeta(tm);

    final @NotNull ItemStack u = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta um = (BannerMeta) u.getItemMeta();
    final @NotNull List<Pattern> upatterns = new ArrayList<>();
    upatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    upatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    upatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    upatterns.add(new Pattern(background, PatternType.BORDER));
    um.setPatterns(upatterns);
    um.setDisplayName("§a§lU");
    um.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    um.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    u.setItemMeta(um);

    final @NotNull ItemStack v = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta vm = (BannerMeta) v.getItemMeta();
    final @NotNull List<Pattern> vpatterns = new ArrayList<>();
    vpatterns.add(new Pattern(letter, PatternType.DIAGONAL_LEFT_MIRROR));
    vpatterns.add(new Pattern(letter, PatternType.DIAGONAL_RIGHT));
    vpatterns.add(new Pattern(background, PatternType.RHOMBUS_MIDDLE));
    vpatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    vpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    vpatterns.add(new Pattern(background, PatternType.BORDER));
    vm.setPatterns(vpatterns);
    vm.setDisplayName("§a§lV");
    vm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    vm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    v.setItemMeta(vm);

    final @NotNull ItemStack w = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta wm = (BannerMeta) w.getItemMeta();
    final @NotNull List<Pattern> wpatterns = new ArrayList<>();
    wpatterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    wpatterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    wpatterns.add(new Pattern(letter, PatternType.TRIANGLE_BOTTOM));
    wpatterns.add(new Pattern(background, PatternType.TRIANGLES_BOTTOM));
    wpatterns.add(new Pattern(background, PatternType.BORDER));
    wm.setPatterns(wpatterns);
    wm.setDisplayName("§a§lW");
    wm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    wm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    w.setItemMeta(wm);

    final @NotNull ItemStack x = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta xm = (BannerMeta) x.getItemMeta();
    final @NotNull List<Pattern> xpatterns = new ArrayList<>();
    xpatterns.add(new Pattern(letter, PatternType.CROSS));
    xpatterns.add(new Pattern(background, PatternType.BORDER));
    xm.setPatterns(xpatterns);
    xm.setDisplayName("§a§lX");
    xm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    xm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    x.setItemMeta(xm);

    final @NotNull ItemStack y = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta ym = (BannerMeta) y.getItemMeta();
    final @NotNull List<Pattern> ypatterns = new ArrayList<>();
    ypatterns.add(new Pattern(letter, PatternType.STRIPE_DOWNRIGHT));
    ypatterns.add(new Pattern(background, PatternType.DIAGONAL_RIGHT));
    ypatterns.add(new Pattern(letter, PatternType.STRIPE_DOWNLEFT));
    ypatterns.add(new Pattern(background, PatternType.BORDER));
    ym.setPatterns(ypatterns);
    ym.setDisplayName("§a§lY");
    ym.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    ym.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    y.setItemMeta(ym);

    final @NotNull ItemStack z = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta zm = (BannerMeta) z.getItemMeta();
    final @NotNull List<Pattern> zpatterns = new ArrayList<>();
    zpatterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    zpatterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    zpatterns.add(new Pattern(letter, PatternType.STRIPE_DOWNLEFT));
    zpatterns.add(new Pattern(background, PatternType.BORDER));
    zm.setPatterns(zpatterns);
    zm.setDisplayName("§a§lZ");
    zm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    zm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z.setItemMeta(zm);

    final @NotNull ItemStack z0 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z0m = (BannerMeta) z0.getItemMeta();
    final @NotNull List<Pattern> z0patterns = new ArrayList<>();
    z0patterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    z0patterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    z0patterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    z0patterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    z0patterns.add(new Pattern(background, PatternType.BORDER));
    z0m.setPatterns(z0patterns);
    z0m.setDisplayName("§a§l0");
    z0m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z0m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z0.setItemMeta(z0m);

    final @NotNull ItemStack z1 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z1m = (BannerMeta) z1.getItemMeta();
    final @NotNull List<Pattern> z1patterns = new ArrayList<>();
    z1patterns.add(new Pattern(letter, PatternType.SQUARE_TOP_LEFT));
    z1patterns.add(new Pattern(letter, PatternType.STRIPE_CENTER));
    z1patterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    z1patterns.add(new Pattern(background, PatternType.BORDER));
    z1m.setPatterns(z1patterns);
    z1m.setDisplayName("§a§l1");
    z1m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z1m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z1.setItemMeta(z1m);

    final @NotNull ItemStack z2 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z2m = (BannerMeta) z2.getItemMeta();
    final @NotNull List<Pattern> z2patterns = new ArrayList<>();
    z2patterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    z2patterns.add(new Pattern(background, PatternType.RHOMBUS_MIDDLE));
    z2patterns.add(new Pattern(letter, PatternType.STRIPE_DOWNLEFT));
    z2patterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    z2patterns.add(new Pattern(background, PatternType.BORDER));
    z2m.setPatterns(z2patterns);
    z2m.setDisplayName("§a§l2");
    z2m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z2m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z2.setItemMeta(z2m);

    final @NotNull ItemStack z3 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z3m = (BannerMeta) z3.getItemMeta();
    final @NotNull List<Pattern> z3patterns = new ArrayList<>();
    z3patterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    z3patterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    z3patterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    z3patterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    z3patterns.add(new Pattern(background, PatternType.BORDER));
    z3m.setPatterns(z3patterns);
    z3m.setDisplayName("§a§l3");
    z3m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z3m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z3.setItemMeta(z3m);

    final @NotNull ItemStack z4 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z4m = (BannerMeta) z4.getItemMeta();
    final @NotNull List<Pattern> z4patterns = new ArrayList<>();
    z4patterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    z4patterns.add(new Pattern(background, PatternType.HALF_HORIZONTAL_MIRROR));
    z4patterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    z4patterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    z4patterns.add(new Pattern(background, PatternType.BORDER));
    z4m.setPatterns(z4patterns);
    z4m.setDisplayName("§a§l4");
    z4m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z4m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z4.setItemMeta(z4m);

    final @NotNull ItemStack z5 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z5m = (BannerMeta) z5.getItemMeta();
    final @NotNull List<Pattern> z5patterns = new ArrayList<>();
    z5patterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    z5patterns.add(new Pattern(background, PatternType.RHOMBUS_MIDDLE));
    z5patterns.add(new Pattern(letter, PatternType.STRIPE_DOWNRIGHT));
    z5patterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    z5patterns.add(new Pattern(background, PatternType.BORDER));
    z5m.setPatterns(z5patterns);
    z5m.setDisplayName("§a§l5");
    z5m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z5m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z5.setItemMeta(z5m);

    final @NotNull ItemStack z6 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z6m = (BannerMeta) z6.getItemMeta();
    final @NotNull List<Pattern> z6patterns = new ArrayList<>();
    z6patterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    z6patterns.add(new Pattern(background, PatternType.HALF_HORIZONTAL));
    z6patterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    z6patterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    z6patterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    z6patterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    z6patterns.add(new Pattern(background, PatternType.BORDER));
    z6m.setPatterns(z6patterns);
    z6m.setDisplayName("§a§l6");
    z6m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z6m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z6.setItemMeta(z6m);

    final @NotNull ItemStack z7 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z7m = (BannerMeta) z7.getItemMeta();
    final @NotNull List<Pattern> z7patterns = new ArrayList<>();
    z7patterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    z7patterns.add(new Pattern(background, PatternType.DIAGONAL_RIGHT));
    z7patterns.add(new Pattern(letter, PatternType.STRIPE_DOWNLEFT));
    z7patterns.add(new Pattern(background, PatternType.BORDER));
    z7m.setPatterns(z7patterns);
    z7m.setDisplayName("§a§l7");
    z7m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z7m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z7.setItemMeta(z7m);

    final @NotNull ItemStack z8 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z8m = (BannerMeta) z8.getItemMeta();
    final @NotNull List<Pattern> z8patterns = new ArrayList<>();
    z8patterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    z8patterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    z8patterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    z8patterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    z8patterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    z8patterns.add(new Pattern(background, PatternType.BORDER));
    z8m.setPatterns(z8patterns);
    z8m.setDisplayName("§a§l8");
    z8m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z8m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z8.setItemMeta(z8m);

    final @NotNull ItemStack z9 = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta z9m = (BannerMeta) z9.getItemMeta();
    final @NotNull List<Pattern> z9patterns = new ArrayList<>();
    z9patterns.add(new Pattern(letter, PatternType.STRIPE_LEFT));
    z9patterns.add(new Pattern(background, PatternType.HALF_HORIZONTAL_MIRROR));
    z9patterns.add(new Pattern(letter, PatternType.STRIPE_TOP));
    z9patterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    z9patterns.add(new Pattern(letter, PatternType.STRIPE_BOTTOM));
    z9patterns.add(new Pattern(letter, PatternType.STRIPE_RIGHT));
    z9patterns.add(new Pattern(background, PatternType.BORDER));
    z9m.setPatterns(z9patterns);
    z9m.setDisplayName("§a§l9");
    z9m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z9m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z9.setItemMeta(z9m);

    final @NotNull ItemStack zminus = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta zminusm = (BannerMeta) zminus.getItemMeta();
    final @NotNull List<Pattern> zminuspatterns = new ArrayList<>();
    zminuspatterns.add(new Pattern(letter, PatternType.STRIPE_MIDDLE));
    zminuspatterns.add(new Pattern(background, PatternType.BORDER));
    zminusm.setPatterns(zminuspatterns);
    zminusm.setDisplayName("§a§l-");
    zminusm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    zminusm.setLore(Arrays.asList("§7Zeichenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    zminus.setItemMeta(zminusm);

    final @NotNull ItemStack zexcla = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(background).getMaterial());
    final @NotNull BannerMeta zexclam = (BannerMeta) zexcla.getItemMeta();
    final @NotNull List<Pattern> zexclapatterns = new ArrayList<>();
    zexclapatterns.add(new Pattern(background, PatternType.STRIPE_DOWNLEFT));
    zexclapatterns.add(new Pattern(background, PatternType.STRIPE_DOWNRIGHT));
    zexclapatterns.add(new Pattern(background, PatternType.STRIPE_MIDDLE));
    zexclapatterns.add(new Pattern(letter, PatternType.HALF_HORIZONTAL));
    zexclapatterns.add(new Pattern(background, PatternType.STRIPE_LEFT));
    zexclapatterns.add(new Pattern(background, PatternType.STRIPE_RIGHT));
    zexclapatterns.add(new Pattern(background, PatternType.BORDER));
    zexclam.setPatterns(zexclapatterns);
    zexclam.setDisplayName("§a§l!");
    zexclam.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    zexclam.setLore(Arrays.asList("§7Zeichenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    zexcla.setItemMeta(zexclam);

    babc.addItem(a);
    babc.addItem(b);
    babc.addItem(c);
    babc.addItem(d);
    babc.addItem(e);
    babc.addItem(f);
    babc.addItem(g);
    babc.addItem(h);
    babc.addItem(i);
    babc.addItem(j);
    babc.addItem(k);
    babc.addItem(l);
    babc.addItem(m);
    babc.addItem(n);
    babc.addItem(o);
    babc.addItem(p);
    babc.addItem(q);
    babc.addItem(r);
    babc.addItem(s);
    babc.addItem(t);
    babc.addItem(u);
    babc.addItem(v);
    babc.addItem(w);
    babc.addItem(x);
    babc.addItem(y);
    babc.addItem(z);

    babc.setItem(27, z0);
    babc.setItem(28, z1);
    babc.setItem(29, z2);
    babc.setItem(30, z3);
    babc.setItem(31, z4);
    babc.setItem(32, z5);
    babc.setItem(33, z6);
    babc.setItem(34, z7);
    babc.setItem(35, z8);
    babc.setItem(36, z9);
    babc.setItem(38, zminus);
    babc.setItem(39, zexcla);

    return babc;
  }

  public static @NotNull Inventory categoryMenu() {
    final @NotNull Inventory inv = Bukkit.createInventory(null, catInvSize(),
        "§c§l§oBannerDatabase Kategorien");
    for (final Entry<String, File> entry : CATEGORIES.entrySet()) {
      final @Nullable ItemStack cat = FileManager.categoryItem(entry.getValue());
      final ItemMeta catm = cat.getItemMeta();
      catm.setDisplayName("§a§l" + entry.getKey());
      catm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
      catm.setLore(Collections.emptyList());
      cat.setItemMeta(catm);
      inv.addItem(cat);
    }
    return inv;
  }

  public static int catInvSize() {
    return (CATEGORIES.keySet().size() + 8) / 9 * 9;
  }

  public static @NotNull Inventory categoryBanner(final String category, final int page) {
    final @NotNull List<ItemStack> banners = new ArrayList<>();
    for (final Entry<ItemStack, String> entry : Utils.BANNERS.entrySet()) {
      if (entry.getValue().equalsIgnoreCase(category)) {
        banners.add(entry.getKey());
      }
    }
    boolean next = true;
    final int epp = 45;
    final int si = (page - 1) * epp;
    int ei = si + epp;
    if (ei > banners.size()) {
      ei = banners.size();
      next = false;
    }
    final @NotNull Inventory inventory = Bukkit.createInventory(null, 54,
        "§c§l§oBannerDatabase | " + page);
    final @NotNull ItemStack mainmenu = new ItemStack(Material.DARK_OAK_DOOR, 1);
    final ItemMeta mmainmenu = mainmenu.getItemMeta();
    mmainmenu.setDisplayName("§e§l§oZurück zum Hauptmenü");
    mainmenu.setItemMeta(mmainmenu);
    inventory.setItem(49, mainmenu);
    final @NotNull ItemStack search = new ItemStack(Material.TRIPWIRE_HOOK, 1);
    final ItemMeta msearch = search.getItemMeta();
    msearch.setDisplayName("§e§l§oSuche...");
    search.setItemMeta(msearch);
    inventory.setItem(53, search);

    for (final ItemStack is : banners.subList(si, ei)) {
      inventory.addItem(is);
    }
    if (next) {
      final @NotNull ItemStack ni = new ItemStack(Material.LIME_DYE);
      final ItemMeta nim = ni.getItemMeta();
      nim.setDisplayName("§a§lNächste Seite");
      ni.setItemMeta(nim);
      inventory.setItem(50, ni);
    }
    if (page != 1) {
      final @NotNull ItemStack pi = new ItemStack(Material.RED_DYE);
      final ItemMeta pim = pi.getItemMeta();
      pim.setDisplayName("§a§lVorherige Seite");
      pi.setItemMeta(pim);
      inventory.setItem(48, pi);
    }
    return inventory;
  }
}
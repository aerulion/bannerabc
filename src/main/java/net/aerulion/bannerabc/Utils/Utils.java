package net.aerulion.bannerabc.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class Utils {

  public final static List<Material> BannerItems = Arrays.asList(Material.BLACK_BANNER,
      Material.BLUE_BANNER, Material.BROWN_BANNER, Material.CYAN_BANNER, Material.GREEN_BANNER,
      Material.GRAY_BANNER, Material.LIGHT_BLUE_BANNER, Material.LIGHT_GRAY_BANNER,
      Material.LIME_BANNER, Material.MAGENTA_BANNER, Material.ORANGE_BANNER, Material.PINK_BANNER,
      Material.PURPLE_BANNER, Material.RED_BANNER, Material.WHITE_BANNER, Material.YELLOW_BANNER);
  public static Map<UUID, DyeColor> lettercolors = new HashMap<>();
  public static Map<UUID, DyeColor> backgroundcolors = new HashMap<>();
  public static Map<UUID, Integer> page = new HashMap<>();
  public static Map<UUID, Integer> searchpage = new HashMap<>();
  public static Map<UUID, String> latestsearch = new HashMap<>();
  public static Map<UUID, String> CurrentCat = new HashMap<>();
  public static Map<String, File> categories = new HashMap<>();
  public static Map<ItemStack, String> banners = new HashMap<>();

  public static Inventory AlphabetInv(DyeColor Letter, DyeColor Background) {
    Inventory babc = Bukkit.createInventory(null, 45, "§c§l§oBannerABC");

    ItemStack a = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());

    BannerMeta am = (BannerMeta) a.getItemMeta();
    List<Pattern> apatterns = new ArrayList<>();
    apatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    apatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    apatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    apatterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    apatterns.add(new Pattern(Background, PatternType.BORDER));
    am.setPatterns(apatterns);
    am.setDisplayName("§a§lA");
    am.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    am.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    a.setItemMeta(am);

    ItemStack b = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta bm = (BannerMeta) b.getItemMeta();
    List<Pattern> bpatterns = new ArrayList<>();
    bpatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    bpatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    bpatterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    bpatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    bpatterns.add(new Pattern(Background, PatternType.CURLY_BORDER));
    bpatterns.add(new Pattern(Letter, PatternType.SQUARE_TOP_LEFT));
    bpatterns.add(new Pattern(Letter, PatternType.SQUARE_BOTTOM_LEFT));
    bpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    bpatterns.add(new Pattern(Background, PatternType.BORDER));
    bm.setPatterns(bpatterns);
    bm.setDisplayName("§a§lB");
    bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    bm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    b.setItemMeta(bm);

    ItemStack c = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta cm = (BannerMeta) c.getItemMeta();
    List<Pattern> cpatterns = new ArrayList<>();
    cpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    cpatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    cpatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    cpatterns.add(new Pattern(Background, PatternType.BORDER));
    cm.setPatterns(cpatterns);
    cm.setDisplayName("§a§lC");
    cm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    cm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    c.setItemMeta(cm);

    ItemStack d = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta dm = (BannerMeta) d.getItemMeta();
    List<Pattern> dpatterns = new ArrayList<>();
    dpatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    dpatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    dpatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    dpatterns.add(new Pattern(Background, PatternType.CURLY_BORDER));
    dpatterns.add(new Pattern(Letter, PatternType.SQUARE_TOP_LEFT));
    dpatterns.add(new Pattern(Letter, PatternType.SQUARE_BOTTOM_LEFT));
    dpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    dpatterns.add(new Pattern(Background, PatternType.BORDER));
    dm.setPatterns(dpatterns);
    dm.setDisplayName("§a§lD");
    dm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    dm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    d.setItemMeta(dm);

    ItemStack e = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta em = (BannerMeta) e.getItemMeta();
    List<Pattern> epatterns = new ArrayList<>();
    epatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    epatterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    epatterns.add(new Pattern(Background, PatternType.STRIPE_RIGHT));
    epatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    epatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    epatterns.add(new Pattern(Background, PatternType.BORDER));
    em.setPatterns(epatterns);
    em.setDisplayName("§a§lE");
    em.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    em.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    e.setItemMeta(em);

    ItemStack f = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta fm = (BannerMeta) f.getItemMeta();
    List<Pattern> fpatterns = new ArrayList<>();
    fpatterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    fpatterns.add(new Pattern(Background, PatternType.STRIPE_RIGHT));
    fpatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    fpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    fpatterns.add(new Pattern(Background, PatternType.BORDER));
    fm.setPatterns(fpatterns);
    fm.setDisplayName("§a§lF");
    fm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    fm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    f.setItemMeta(fm);

    ItemStack g = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta gm = (BannerMeta) g.getItemMeta();
    List<Pattern> gpatterns = new ArrayList<>();
    gpatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    gpatterns.add(new Pattern(Background, PatternType.HALF_HORIZONTAL));
    gpatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    gpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    gpatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    gpatterns.add(new Pattern(Background, PatternType.BORDER));
    gm.setPatterns(gpatterns);
    gm.setDisplayName("§a§lG");
    gm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    gm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    g.setItemMeta(gm);

    ItemStack h = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta hm = (BannerMeta) h.getItemMeta();
    List<Pattern> hpatterns = new ArrayList<>();
    hpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    hpatterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    hpatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    hpatterns.add(new Pattern(Background, PatternType.BORDER));
    hm.setPatterns(hpatterns);
    hm.setDisplayName("§a§lH");
    hm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    hm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    h.setItemMeta(hm);

    ItemStack i = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta im = (BannerMeta) i.getItemMeta();
    List<Pattern> ipatterns = new ArrayList<>();
    ipatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    ipatterns.add(new Pattern(Letter, PatternType.STRIPE_CENTER));
    ipatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    ipatterns.add(new Pattern(Background, PatternType.BORDER));
    im.setPatterns(ipatterns);
    im.setDisplayName("§a§lI");
    im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    im.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    i.setItemMeta(im);

    ItemStack j = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta jm = (BannerMeta) j.getItemMeta();
    List<Pattern> jpatterns = new ArrayList<>();
    jpatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    jpatterns.add(new Pattern(Letter, PatternType.STRIPE_CENTER));
    jpatterns.add(new Pattern(Letter, PatternType.SQUARE_BOTTOM_LEFT));
    jpatterns.add(new Pattern(Background, PatternType.BORDER));
    jm.setPatterns(jpatterns);
    jm.setDisplayName("§a§lJ");
    jm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    jm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    j.setItemMeta(jm);

    ItemStack k = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta km = (BannerMeta) k.getItemMeta();
    List<Pattern> kpatterns = new ArrayList<>();
    kpatterns.add(new Pattern(Letter, PatternType.CROSS));
    kpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    kpatterns.add(new Pattern(Letter, PatternType.HALF_VERTICAL));
    kpatterns.add(new Pattern(Background, PatternType.BORDER));
    km.setPatterns(kpatterns);
    km.setDisplayName("§a§lK");
    km.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    km.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    k.setItemMeta(km);

    ItemStack l = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta lm = (BannerMeta) l.getItemMeta();
    List<Pattern> lpatterns = new ArrayList<>();
    lpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    lpatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    lpatterns.add(new Pattern(Background, PatternType.BORDER));
    lm.setPatterns(lpatterns);
    lm.setDisplayName("§a§lL");
    lm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    lm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    l.setItemMeta(lm);

    ItemStack m = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta mm = (BannerMeta) m.getItemMeta();
    List<Pattern> mpatterns = new ArrayList<>();
    mpatterns.add(new Pattern(Letter, PatternType.TRIANGLE_TOP));
    mpatterns.add(new Pattern(Background, PatternType.TRIANGLES_TOP));
    mpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    mpatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    mpatterns.add(new Pattern(Background, PatternType.BORDER));
    mm.setPatterns(mpatterns);
    mm.setDisplayName("§a§lM");
    mm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    mm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    m.setItemMeta(mm);

    ItemStack n = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta nm = (BannerMeta) n.getItemMeta();
    List<Pattern> npatterns = new ArrayList<>();
    npatterns.add(new Pattern(Letter, PatternType.STRIPE_DOWNRIGHT));
    npatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    npatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    npatterns.add(new Pattern(Background, PatternType.BORDER));
    nm.setPatterns(npatterns);
    nm.setDisplayName("§a§lN");
    nm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    nm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    n.setItemMeta(nm);

    ItemStack o = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta om = (BannerMeta) o.getItemMeta();
    List<Pattern> opatterns = new ArrayList<>();
    opatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    opatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    opatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    opatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    opatterns.add(new Pattern(Background, PatternType.BORDER));
    om.setPatterns(opatterns);
    om.setDisplayName("§a§lO");
    om.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    om.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    o.setItemMeta(om);

    ItemStack p = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta pm = (BannerMeta) p.getItemMeta();
    List<Pattern> ppatterns = new ArrayList<>();
    ppatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    ppatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    ppatterns.add(new Pattern(Background, PatternType.HALF_HORIZONTAL_MIRROR));
    ppatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    ppatterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    ppatterns.add(new Pattern(Background, PatternType.BORDER));
    pm.setPatterns(ppatterns);
    pm.setDisplayName("§a§lP");
    pm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    pm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    p.setItemMeta(pm);

    ItemStack q = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Letter).getMaterial());
    BannerMeta qm = (BannerMeta) q.getItemMeta();
    List<Pattern> qpatterns = new ArrayList<>();
    qpatterns.add(new Pattern(Background, PatternType.RHOMBUS_MIDDLE));
    qpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    qpatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    qpatterns.add(new Pattern(Letter, PatternType.SQUARE_BOTTOM_RIGHT));
    qpatterns.add(new Pattern(Background, PatternType.BORDER));
    qm.setPatterns(qpatterns);
    qm.setDisplayName("§a§lQ");
    qm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    qm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    q.setItemMeta(qm);

    ItemStack r = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta rm = (BannerMeta) r.getItemMeta();
    List<Pattern> rpatterns = new ArrayList<>();
    rpatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    rpatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    rpatterns.add(new Pattern(Background, PatternType.HALF_HORIZONTAL_MIRROR));
    rpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    rpatterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    rpatterns.add(new Pattern(Letter, PatternType.STRIPE_DOWNRIGHT));
    rpatterns.add(new Pattern(Background, PatternType.BORDER));
    rm.setPatterns(rpatterns);
    rm.setDisplayName("§a§lR");
    rm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    rm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    r.setItemMeta(rm);

    ItemStack s = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta sm = (BannerMeta) s.getItemMeta();
    List<Pattern> spatterns = new ArrayList<>();
    spatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    spatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    spatterns.add(new Pattern(Background, PatternType.RHOMBUS_MIDDLE));
    spatterns.add(new Pattern(Letter, PatternType.STRIPE_DOWNRIGHT));
    spatterns.add(new Pattern(Background, PatternType.BORDER));
    spatterns.add(new Pattern(Background, PatternType.CURLY_BORDER));
    sm.setPatterns(spatterns);
    sm.setDisplayName("§a§lS");
    sm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    sm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    s.setItemMeta(sm);

    ItemStack t = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta tm = (BannerMeta) t.getItemMeta();
    List<Pattern> tpatterns = new ArrayList<>();
    tpatterns.add(new Pattern(Letter, PatternType.STRIPE_CENTER));
    tpatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    tpatterns.add(new Pattern(Background, PatternType.BORDER));
    tm.setPatterns(tpatterns);
    tm.setDisplayName("§a§lT");
    tm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    tm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    t.setItemMeta(tm);

    ItemStack u = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta um = (BannerMeta) u.getItemMeta();
    List<Pattern> upatterns = new ArrayList<>();
    upatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    upatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    upatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    upatterns.add(new Pattern(Background, PatternType.BORDER));
    um.setPatterns(upatterns);
    um.setDisplayName("§a§lU");
    um.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    um.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    u.setItemMeta(um);

    ItemStack v = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta vm = (BannerMeta) v.getItemMeta();
    List<Pattern> vpatterns = new ArrayList<>();
    vpatterns.add(new Pattern(Letter, PatternType.DIAGONAL_LEFT_MIRROR));
    vpatterns.add(new Pattern(Letter, PatternType.DIAGONAL_RIGHT));
    vpatterns.add(new Pattern(Background, PatternType.RHOMBUS_MIDDLE));
    vpatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    vpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    vpatterns.add(new Pattern(Background, PatternType.BORDER));
    vm.setPatterns(vpatterns);
    vm.setDisplayName("§a§lV");
    vm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    vm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    v.setItemMeta(vm);

    ItemStack w = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta wm = (BannerMeta) w.getItemMeta();
    List<Pattern> wpatterns = new ArrayList<>();
    wpatterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    wpatterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    wpatterns.add(new Pattern(Letter, PatternType.TRIANGLE_BOTTOM));
    wpatterns.add(new Pattern(Background, PatternType.TRIANGLES_BOTTOM));
    wpatterns.add(new Pattern(Background, PatternType.BORDER));
    wm.setPatterns(wpatterns);
    wm.setDisplayName("§a§lW");
    wm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    wm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    w.setItemMeta(wm);

    ItemStack x = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta xm = (BannerMeta) x.getItemMeta();
    List<Pattern> xpatterns = new ArrayList<>();
    xpatterns.add(new Pattern(Letter, PatternType.CROSS));
    xpatterns.add(new Pattern(Background, PatternType.BORDER));
    xm.setPatterns(xpatterns);
    xm.setDisplayName("§a§lX");
    xm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    xm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    x.setItemMeta(xm);

    ItemStack y = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta ym = (BannerMeta) y.getItemMeta();
    List<Pattern> ypatterns = new ArrayList<>();
    ypatterns.add(new Pattern(Letter, PatternType.STRIPE_DOWNRIGHT));
    ypatterns.add(new Pattern(Background, PatternType.DIAGONAL_RIGHT));
    ypatterns.add(new Pattern(Letter, PatternType.STRIPE_DOWNLEFT));
    ypatterns.add(new Pattern(Background, PatternType.BORDER));
    ym.setPatterns(ypatterns);
    ym.setDisplayName("§a§lY");
    ym.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    ym.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    y.setItemMeta(ym);

    ItemStack z = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta zm = (BannerMeta) z.getItemMeta();
    List<Pattern> zpatterns = new ArrayList<>();
    zpatterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    zpatterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    zpatterns.add(new Pattern(Letter, PatternType.STRIPE_DOWNLEFT));
    zpatterns.add(new Pattern(Background, PatternType.BORDER));
    zm.setPatterns(zpatterns);
    zm.setDisplayName("§a§lZ");
    zm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    zm.setLore(Arrays.asList("§7Buchstabenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z.setItemMeta(zm);

    ItemStack z0 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z0m = (BannerMeta) z0.getItemMeta();
    List<Pattern> z0patterns = new ArrayList<>();
    z0patterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    z0patterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    z0patterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    z0patterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    z0patterns.add(new Pattern(Background, PatternType.BORDER));
    z0m.setPatterns(z0patterns);
    z0m.setDisplayName("§a§l0");
    z0m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z0m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z0.setItemMeta(z0m);

    ItemStack z1 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z1m = (BannerMeta) z1.getItemMeta();
    List<Pattern> z1patterns = new ArrayList<>();
    z1patterns.add(new Pattern(Letter, PatternType.SQUARE_TOP_LEFT));
    z1patterns.add(new Pattern(Letter, PatternType.STRIPE_CENTER));
    z1patterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    z1patterns.add(new Pattern(Background, PatternType.BORDER));
    z1m.setPatterns(z1patterns);
    z1m.setDisplayName("§a§l1");
    z1m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z1m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z1.setItemMeta(z1m);

    ItemStack z2 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z2m = (BannerMeta) z2.getItemMeta();
    List<Pattern> z2patterns = new ArrayList<>();
    z2patterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    z2patterns.add(new Pattern(Background, PatternType.RHOMBUS_MIDDLE));
    z2patterns.add(new Pattern(Letter, PatternType.STRIPE_DOWNLEFT));
    z2patterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    z2patterns.add(new Pattern(Background, PatternType.BORDER));
    z2m.setPatterns(z2patterns);
    z2m.setDisplayName("§a§l2");
    z2m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z2m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z2.setItemMeta(z2m);

    ItemStack z3 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z3m = (BannerMeta) z3.getItemMeta();
    List<Pattern> z3patterns = new ArrayList<>();
    z3patterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    z3patterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    z3patterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    z3patterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    z3patterns.add(new Pattern(Background, PatternType.BORDER));
    z3m.setPatterns(z3patterns);
    z3m.setDisplayName("§a§l3");
    z3m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z3m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z3.setItemMeta(z3m);

    ItemStack z4 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z4m = (BannerMeta) z4.getItemMeta();
    List<Pattern> z4patterns = new ArrayList<>();
    z4patterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    z4patterns.add(new Pattern(Background, PatternType.HALF_HORIZONTAL_MIRROR));
    z4patterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    z4patterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    z4patterns.add(new Pattern(Background, PatternType.BORDER));
    z4m.setPatterns(z4patterns);
    z4m.setDisplayName("§a§l4");
    z4m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z4m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z4.setItemMeta(z4m);

    ItemStack z5 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z5m = (BannerMeta) z5.getItemMeta();
    List<Pattern> z5patterns = new ArrayList<>();
    z5patterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    z5patterns.add(new Pattern(Background, PatternType.RHOMBUS_MIDDLE));
    z5patterns.add(new Pattern(Letter, PatternType.STRIPE_DOWNRIGHT));
    z5patterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    z5patterns.add(new Pattern(Background, PatternType.BORDER));
    z5m.setPatterns(z5patterns);
    z5m.setDisplayName("§a§l5");
    z5m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z5m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z5.setItemMeta(z5m);

    ItemStack z6 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z6m = (BannerMeta) z6.getItemMeta();
    List<Pattern> z6patterns = new ArrayList<>();
    z6patterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    z6patterns.add(new Pattern(Background, PatternType.HALF_HORIZONTAL));
    z6patterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    z6patterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    z6patterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    z6patterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    z6patterns.add(new Pattern(Background, PatternType.BORDER));
    z6m.setPatterns(z6patterns);
    z6m.setDisplayName("§a§l6");
    z6m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z6m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z6.setItemMeta(z6m);

    ItemStack z7 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z7m = (BannerMeta) z7.getItemMeta();
    List<Pattern> z7patterns = new ArrayList<>();
    z7patterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    z7patterns.add(new Pattern(Background, PatternType.DIAGONAL_RIGHT));
    z7patterns.add(new Pattern(Letter, PatternType.STRIPE_DOWNLEFT));
    z7patterns.add(new Pattern(Background, PatternType.BORDER));
    z7m.setPatterns(z7patterns);
    z7m.setDisplayName("§a§l7");
    z7m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z7m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z7.setItemMeta(z7m);

    ItemStack z8 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z8m = (BannerMeta) z8.getItemMeta();
    List<Pattern> z8patterns = new ArrayList<>();
    z8patterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    z8patterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    z8patterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    z8patterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    z8patterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    z8patterns.add(new Pattern(Background, PatternType.BORDER));
    z8m.setPatterns(z8patterns);
    z8m.setDisplayName("§a§l8");
    z8m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z8m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z8.setItemMeta(z8m);

    ItemStack z9 = new ItemStack(BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta z9m = (BannerMeta) z9.getItemMeta();
    List<Pattern> z9patterns = new ArrayList<>();
    z9patterns.add(new Pattern(Letter, PatternType.STRIPE_LEFT));
    z9patterns.add(new Pattern(Background, PatternType.HALF_HORIZONTAL_MIRROR));
    z9patterns.add(new Pattern(Letter, PatternType.STRIPE_TOP));
    z9patterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    z9patterns.add(new Pattern(Letter, PatternType.STRIPE_BOTTOM));
    z9patterns.add(new Pattern(Letter, PatternType.STRIPE_RIGHT));
    z9patterns.add(new Pattern(Background, PatternType.BORDER));
    z9m.setPatterns(z9patterns);
    z9m.setDisplayName("§a§l9");
    z9m.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    z9m.setLore(Arrays.asList("§7Zahlenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    z9.setItemMeta(z9m);

    ItemStack zminus = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta zminusm = (BannerMeta) zminus.getItemMeta();
    List<Pattern> zminuspatterns = new ArrayList<>();
    zminuspatterns.add(new Pattern(Letter, PatternType.STRIPE_MIDDLE));
    zminuspatterns.add(new Pattern(Background, PatternType.BORDER));
    zminusm.setPatterns(zminuspatterns);
    zminusm.setDisplayName("§a§l-");
    zminusm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    zminusm.setLore(Arrays.asList("§7Zeichenfarbe wählen: §aShift Linksklick",
        "§7Hintergrundfarbe wählen: §aShift Rechtsklick"));
    zminus.setItemMeta(zminusm);

    ItemStack zexcla = new ItemStack(
        BaseColorInfo.getBaseColorFromDyeColor(Background).getMaterial());
    BannerMeta zexclam = (BannerMeta) zexcla.getItemMeta();
    List<Pattern> zexclapatterns = new ArrayList<>();
    zexclapatterns.add(new Pattern(Background, PatternType.STRIPE_DOWNLEFT));
    zexclapatterns.add(new Pattern(Background, PatternType.STRIPE_DOWNRIGHT));
    zexclapatterns.add(new Pattern(Background, PatternType.STRIPE_MIDDLE));
    zexclapatterns.add(new Pattern(Letter, PatternType.HALF_HORIZONTAL));
    zexclapatterns.add(new Pattern(Background, PatternType.STRIPE_LEFT));
    zexclapatterns.add(new Pattern(Background, PatternType.STRIPE_RIGHT));
    zexclapatterns.add(new Pattern(Background, PatternType.BORDER));
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

  public static Inventory CategoryMenu() {
    Inventory inv = Bukkit.createInventory(null, CatInvSize(), "§c§l§oBannerDatabase Kategorien");
    for (String key : Utils.categories.keySet()) {
      ItemStack cat = FileManager.CategoryItem(Utils.categories.get(key));
      ItemMeta catm = cat.getItemMeta();
      catm.setDisplayName("§a§l" + key);
      catm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
      catm.setLore(Collections.emptyList());
      cat.setItemMeta(catm);
      inv.addItem(cat);
    }
    return inv;
  }

  public static int CatInvSize() {
    return (Utils.categories.keySet().size() + 8) / 9 * 9;
  }

  public static Inventory CategoryBanner(String category, int page) {
    List<ItemStack> banners = new ArrayList<>();
    for (ItemStack is : Utils.banners.keySet()) {
      if (Utils.banners.get(is).equalsIgnoreCase(category)) {
        banners.add(is);
      }
    }
    boolean next = true;
    int epp = 45;
    int si = (page - 1) * epp;
    int ei = si + epp;
    if (ei > banners.size()) {
      ei = banners.size();
      next = false;
    }
    Inventory inventory = Bukkit.createInventory(null, 54, "§c§l§oBannerDatabase | " + page);
    ItemStack mainmenu = new ItemStack(Material.DARK_OAK_DOOR, 1);
    ItemMeta mmainmenu = mainmenu.getItemMeta();
    mmainmenu.setDisplayName("§e§l§oZurück zum Hauptmenü");
    mainmenu.setItemMeta(mmainmenu);
    inventory.setItem(49, mainmenu);
    ItemStack search = new ItemStack(Material.TRIPWIRE_HOOK, 1);
    ItemMeta msearch = search.getItemMeta();
    msearch.setDisplayName("§e§l§oSuche...");
    search.setItemMeta(msearch);
    inventory.setItem(53, search);

    for (ItemStack is : banners.subList(si, ei)) {
      inventory.addItem(is);
    }
    if (next) {
      ItemStack ni = new ItemStack(Material.LIME_DYE);
      ItemMeta nim = ni.getItemMeta();
      nim.setDisplayName("§a§lNächste Seite");
      ni.setItemMeta(nim);
      inventory.setItem(50, ni);
    }
    if (page != 1) {
      ItemStack pi = new ItemStack(Material.RED_DYE);
      ItemMeta pim = pi.getItemMeta();
      pim.setDisplayName("§a§lVorherige Seite");
      pi.setItemMeta(pim);
      inventory.setItem(48, pi);
    }
    return inventory;
  }
}
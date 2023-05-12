package me.jsinco.customitemspaper.items;

import me.jsinco.customitemspaper.util.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class ItemManager {
    public static ItemStack BoomBow;
    public static ItemStack Leer;
    public static ItemStack HiPoweredExplosives;
    public static ItemStack PhantomStar;
    public static ItemStack superPickaxe;
    public static ItemStack Satchel;

    public static void callItem(){
        createBoomBow();
        createLeer();
        createHiPoweredExplosives();
        createPhantomStar();
        createSuperPickaxe();
        createSatchel();
    }

    private static void createBoomBow(){
        ItemStack item = new ItemStack(Material.CROSSBOW, 1);
        CrossbowMeta meta = (CrossbowMeta) item.getItemMeta();
        meta.setDisplayName("§4§lBoomBow");
        List<String> lore = new ArrayList<>(List.of("§c§lExplosives","","§c\"It smells like gunpowder...\"","","","§41 TNT per shot","§4This weapon requires at least 1 arrow in your inventory to fire"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.QUICK_CHARGE, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        item.setItemMeta(meta);
        BoomBow = item;
    }
    private static void createLeer(){
        ItemStack item = new ItemStack(Material.ENDER_EYE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§d§lLeer");
        List<String> lore = new ArrayList<>(List.of("§eWatchful","","§d\"I see anything, I see everything\"","","","§5All entities within 20 blocks of this being thrown will glow for 5 secs"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        item.setItemMeta(meta);
        Leer = item;
    }
    private static void createHiPoweredExplosives(){
        ItemStack item = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a§lHi-Powered §eXplosives");
        List<String> lore = new ArrayList<>(List.of("§2Hi-Explosives","","§a\"This can't be legal...\""));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
        item.setItemMeta(meta);
        HiPoweredExplosives = item;
    }
    private static void createPhantomStar(){
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§b§lPhantom §f§lStar");
        List<String> lore = new ArrayList<>(List.of("§9Phantom","","§f\"HELP ME\""));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        PhantomStar = item;
    }
    private static void createSuperPickaxe(){
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§b§lSuper Pickaxe");
        List<String> lore = new ArrayList<>(List.of("§9Super","","§9§l\"inactive\""));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        item.setItemMeta(meta);
        superPickaxe = item;
    }
    private static void createSatchel(){
        ItemStack item = new ItemStack(Material.SNOWBALL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&#fb4b2a&lS&#fb5735&la&#fc6440&lt&#fc704b&lc&#fc7c56&lh&#fd8961&le&#fd956c&ll"));
        meta.setLore(List.of(ColorUtils.translateColorCodes("&#ffa500Launch"),"",""));
        meta.addEnchant(Enchantment.THORNS, 2, true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        item.setItemMeta(meta);
        Satchel = item;
    }
}

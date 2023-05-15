package me.jsinco.customitemspaper.items;

import me.jsinco.customitemspaper.util.ColorUtils;
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
    public static ItemStack Satchel;
    public static ItemStack PropellerCap;

    public static void callItem(){
        createBoomBow();
        createLeer();
        createHiPoweredExplosives();
        createPhantomStar();
        createSatchel();
        createPropellerCap();
    }

    private static void createBoomBow(){
        ItemStack item = new ItemStack(Material.CROSSBOW, 1);
        CrossbowMeta meta = (CrossbowMeta) item.getItemMeta();
        meta.setDisplayName("§4§lBoomBow");
        List<String> lore = new ArrayList<>(List.of("§cExplosives","","§c\"It smells like gunpowder...\"","","","§41 TNT per shot","§4This weapon requires at least 1 arrow in your inventory to fire"));
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
    private static void createSatchel(){
        ItemStack item = new ItemStack(Material.SNOWBALL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.translateColorCodes("&#7d51fb&lL&#8357fb&lu&#885dfb&lc&#8e63fb&li&#9469fb&lf&#9a6ffc&li&#9f75fc&le&#a57bfc&ln&#ab81fc&le&#b087fc&l'&#b68dfc&ls &#bc93fc&lS&#c199fc&la&#c79ffd&lt&#cda5fd&lc&#d3abfd&lh&#d8b1fd&le&#deb7fd&ll"));
        meta.setLore(List.of(ColorUtils.translateColorCodes("&#fb9ab7L&#fba8c1a&#fcb6cau&#fcc5d4n&#fcd3dec&#fde1e7h &#fdeff1I")
                ,ColorUtils.translateColorCodes("&#6865fbE&#686dfbx&#6975fbp&#697dfcl&#6985fco&#6a8efcs&#6a96fci&#6a9efdv&#6ba6fde &#6baefdI"), ""
        ,ColorUtils.translateColorCodes("&#c684fbW&#c483fbh&#c281fbe&#bf80fbn &#bd7ffbf&#bb7dfba&#b97cfbl&#b67bfbl&#b479fbi&#b278fbn&#b077fbg&#ad75fb, &#ab74fct&#a973fch&#a771fci&#a470fcs &#a26ffcs&#a06dfca&#9e6cfct&#9b6bfcc&#9969fch&#9768fce&#9567fcl &#9265fcw&#9064fci&#8e63fcl&#8c61fcl &#8960fca&#875ffcc&#855dfct&#835cfci&#805bfcv&#7e59fca&#7c58fct&#7a57fde")
        ,ColorUtils.translateColorCodes("&#7755fda&#7554fdf&#7353fdt&#7151fde&#6e50fdr &#6c4ffd5 &#6a4dfdt&#684cfdi&#654bfdc&#6349fdk&#6148fds")));
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        item.setItemMeta(meta);
        Satchel = item;
    }
    private static void createPropellerCap(){
        ItemStack item = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Debug");
        item.setItemMeta(meta);
        PropellerCap = item;
    }

}

package me.jsinco.customitemspaper.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack BoomBow;
    public static ItemStack Leer;

    public static void callItem(){
        createBoomBow();
        createLeer();
    }

    private static void createBoomBow(){
        ItemStack item = new ItemStack(Material.CROSSBOW, 1);
        CrossbowMeta meta = (CrossbowMeta) item.getItemMeta();
        meta.setDisplayName("§4§lBoomBow");
        List<String> lore = new ArrayList<>();
        lore.add("§cExplosives");
        lore.add("");
        lore.add("§c\"It smells like gunpowder...\"");
        lore.add("");
        lore.add("");
        lore.add("§41 TNT per shot");
        lore.add("§4This weapon requires at least 1 arrow in your inventory to fire");
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
        List<String> lore = new ArrayList<>();
        lore.add("§eWatchful");
        lore.add("");
        lore.add("\"I see anything, I see everything\"");
        lore.add("");
        lore.add("");
        lore.add("All entities within 20 blocks of this being thrown will glow for 5 secs");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        item.setItemMeta(meta);
        Leer = item;
    }
}

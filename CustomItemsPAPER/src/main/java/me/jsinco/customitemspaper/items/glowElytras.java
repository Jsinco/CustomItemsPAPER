package me.jsinco.customitemspaper.items;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import java.util.List;

@SuppressWarnings("deprecation")
public class glowElytras {

    public static ItemStack getElytra(String color){
        if (color.equalsIgnoreCase("green")){
            return Green;
        } else if (color.equalsIgnoreCase("red")){
            return Red;
        } else if (color.equalsIgnoreCase("aqua")){
            return Aqua;
        } else if (color.equalsIgnoreCase("blue")){
            return Blue;
        } else if (color.equalsIgnoreCase("gold")){
            return Gold;
        } else if (color.equalsIgnoreCase("purple")){
            return Purple;
        } else if (color.equalsIgnoreCase("yellow")){
            return Yellow;
        } else {
            return null;
        }
    }
    public static ItemStack Green;
    public static ItemStack Red;
    public static ItemStack Aqua;
    public static ItemStack Blue;
    public static ItemStack Gold;
    public static ItemStack Purple;
    public static ItemStack Yellow;


    public static void callGlowElytras(){
        createGreenGlowElytra();
        createRedGlowElytra();
        createAquaGlowElytra();
        createBlueGlowElytra();
        createGoldGlowElytra();
        createPurpleGlowElytra();
        createYellowGlowElytra();
    }

    private static void createGreenGlowElytra(){
        ItemStack item = new ItemStack(Material.ELYTRA,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§2§lJsinco's Green Wings");
        List<String> lore = new ArrayList<>(List.of("§7Glow","","","§aGreen"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 9, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        item.setItemMeta(meta);
        Green = item;
    }
    private static void createRedGlowElytra(){
        ItemStack item = new ItemStack(Material.ELYTRA,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4§lJsinco's Red Wings");
        List<String> lore = new ArrayList<>(List.of("§7Glow","","","§cRed"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 9, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        item.setItemMeta(meta);
        Red = item;
    }
    private static void createAquaGlowElytra(){
        ItemStack item = new ItemStack(Material.ELYTRA,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§3§lJsinco's Aqua Wings");
        List<String> lore = new ArrayList<>(List.of("§7Glow","","","§bAqua"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 9, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        item.setItemMeta(meta);
        Aqua = item;
    }
    private static void createBlueGlowElytra(){
        ItemStack item = new ItemStack(Material.ELYTRA,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§1§lJsinco's Blue Wings");
        List<String> lore = new ArrayList<>(List.of("§7Glow","","","§9Blue"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 9, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        item.setItemMeta(meta);
        Blue = item;
    }
    private static void createGoldGlowElytra(){
        ItemStack item = new ItemStack(Material.ELYTRA,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6§lJsinco's Gold Wings");
        List<String> lore = new ArrayList<>(List.of("§7Glow","","","§eGold"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 9, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        item.setItemMeta(meta);
        Gold = item;
    }
    private static void createPurpleGlowElytra(){
        ItemStack item = new ItemStack(Material.ELYTRA,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5§lJsinco's Purple Wings");
        List<String> lore = new ArrayList<>(List.of("§7Glow","","","§dPurple"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 9, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        item.setItemMeta(meta);
        Purple = item;
    }
    private static void createYellowGlowElytra(){
        ItemStack item = new ItemStack(Material.ELYTRA,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§e§lShan's Peep Plushy Wings");
        List<String> lore = new ArrayList<>(List.of("§7Glow","","§6Wow it's so fluffy!","§eYellow"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 9, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        item.setItemMeta(meta);
        Yellow = item;
    }
}

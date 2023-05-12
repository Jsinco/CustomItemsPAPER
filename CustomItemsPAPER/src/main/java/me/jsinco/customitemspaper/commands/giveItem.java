package me.jsinco.customitemspaper.commands;

import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public class giveItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            ItemStack[] ItemManagement = new ItemStack[]{ItemManager.BoomBow,ItemManager.Leer,
                    ItemManager.PhantomStar,ItemManager.HiPoweredExplosives,ItemManager.Satchel,ItemManager.superPickaxe};
            String[] ItemNames = new String[]{"Boombow","Leer","PhantomStar","Hi-PoweredExplosives","Satchel","superpickaxe"};
            for (int i = 0; i < ItemNames.length; i++) {
                if (args[0].equalsIgnoreCase(ItemNames[i])){
                    p.getInventory().addItem(ItemManagement[i]);
                    return true;
                }
            }
            p.sendMessage("§7Not a valid item.");
        }
        return true;
    }
}


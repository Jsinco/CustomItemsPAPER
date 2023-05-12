package me.jsinco.customitemspaper.commands;

import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class giveItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 1){
                if (args[0].equalsIgnoreCase("boombow")){
                    p.getInventory().addItem(ItemManager.BoomBow);
                    return true;
                } else if (args[0].equalsIgnoreCase("leer")){
                    p.getInventory().addItem(ItemManager.Leer);
                    return true;
                } else if (args[0].equalsIgnoreCase("phantomstar")){
                    p.getInventory().addItem(ItemManager.PhantomStar);
                    return true;
                } else if (args[0].equalsIgnoreCase("hi-poweredexplosives")){
                    p.getInventory().addItem(ItemManager.HiPoweredExplosives);
                    return true;
                } else if (args[0].equalsIgnoreCase("superpickaxe")) {
                    p.getInventory().addItem(ItemManager.superPickaxe);
                    return true;
                } else if (args[0].equalsIgnoreCase("satchel")) {
                    p.getInventory().addItem(ItemManager.Satchel);
                    return true;
                }
                p.sendMessage("§7Not a valid item.");
            } else {
                p.sendMessage("§7Please specify an item to give.");
            }
        }
        return true;
    }
}

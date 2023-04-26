package me.jsinco.customitemspaper.commands;

import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class giveItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player){
            Player p = (Player) commandSender;
            p.getInventory().addItem(ItemManager.BoomBow);
        }
        return true;
    }
}
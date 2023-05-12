package me.jsinco.customitemspaper.commands;

import me.jsinco.customitemspaper.items.glowElytras;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class cEly implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 1){
                String[] color = new String[]{"aqua", "blue", "gold", "green", "red", "purple" ,"yellow"};
                for (int i = 0; i < color.length; i++) {
                    if (args[0].equalsIgnoreCase(color[i])){
                        p.getInventory().addItem(Objects.requireNonNull(glowElytras.getElytra(color[i])));
                        return true;
                    }
                }
                p.sendMessage("§7Not a valid item.");
            } else {
                p.sendMessage("§7Please specify an item to give.");
            }
        }

        return true;
    }
}

package me.jsinco.customitemspaper.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("giveitem")) {
            if (args.length == 1) {
                return List.of("boombow", "leer", "phantomstar", "hi-poweredexplosives", "satchel");
            }
        } else if (command.getName().equalsIgnoreCase("cely")) {
            if (args.length == 1){
                return List.of("aqua", "blue", "gold", "green", "red", "purple" ,"yellow");
            }
        }
        return null;
    }
}


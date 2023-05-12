package me.jsinco.customitemspaper.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class tabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("giveitem")) {
            if (args.length == 1) {
                return List.of("boombow", "leer", "phantomstar", "hi-poweredexplosives", "superpickaxe","ggely","rgely");
            }
        } else if (command.getName().equalsIgnoreCase("cely")) {
            if (args.length == 1){
                return List.of("green", "red", "aqua", "blue", "gold", "purple" ,"yellow");
            }
        }
        return null;
    }
}


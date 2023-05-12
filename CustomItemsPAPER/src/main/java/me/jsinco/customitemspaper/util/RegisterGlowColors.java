package me.jsinco.customitemspaper.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;

public class RegisterGlowColors {
    static public final String[] colors = new String[]{"aqua", "blue", "gold", "green", "red", "yellow", "purple"};
    public static void registerGlowColors() {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        ChatColor[] chatColors = new ChatColor[]{ChatColor.AQUA, ChatColor.BLUE, ChatColor.GOLD, ChatColor.GREEN, ChatColor.RED, ChatColor.YELLOW, ChatColor.LIGHT_PURPLE};
        for (int i = 0; i < colors.length; i++) {
            if (board.getTeam(colors[i]) == null) {
                board.registerNewTeam(colors[i]).setColor(chatColors[i]);
            }
        }

    }
}

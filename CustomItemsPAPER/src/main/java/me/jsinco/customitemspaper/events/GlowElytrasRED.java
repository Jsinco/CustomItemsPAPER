package me.jsinco.customitemspaper.events;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import me.jsinco.customitemspaper.CustomItemsPAPER;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class GlowElytrasRED implements Listener {
    int taskIDr;

    @EventHandler
    public void playerArmor(PlayerArmorChangeEvent event){
        if (event.getSlotType().equals(PlayerArmorChangeEvent.SlotType.CHEST)){
            Player player = event.getPlayer();
            if (event.getOldItem().getLore().get(0).equals("§4Glow R")) {
                if (event.getNewItem().getType().isAir() || !event.getNewItem().getLore().get(0).equals("§4Glow R")){
                    Bukkit.getServer().getScheduler().cancelTask(taskIDr);
                    player.removePotionEffect(PotionEffectType.GLOWING);
                    event.getOldItem().getLore().set(0, "no");
                    Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
                    try {
                        Team team = board.getTeam("R_GLOWELYTRAS");
                        team.removeEntry(player.getName());
                    } catch (Exception exception) {
                        //no existing team!
                    }
                }
            }
        }
    }

    @EventHandler
    public void playerArmorAdd(PlayerArmorChangeEvent event){
        Player player = event.getPlayer();
        if (event.getNewItem().getLore().get(0).equals("§4Glow R")){
            taskIDr = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
                player.addPotionEffect(PotionEffectType.GLOWING.createEffect(400, 0));
            }, 0, 100);
            Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
            try {
                Team team = board.getTeam("R_GLOWELYTRAS");
                team.addEntry(player.getName());
            } catch (Exception exception) {
                Team team = board.registerNewTeam("R_GLOWELYTRAS");
                team.setColor(ChatColor.RED);
                team.addEntry(player.getName());
            }
        }
    }
}

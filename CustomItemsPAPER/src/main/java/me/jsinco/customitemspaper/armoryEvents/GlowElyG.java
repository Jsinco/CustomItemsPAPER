package me.jsinco.customitemspaper.armoryEvents;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import me.jsinco.customitemspaper.CustomItemsPAPER;
import me.jsinco.customitemspaper.util.RegisterGlowColors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class GlowElyG implements Listener {
    static List<Player> glowPlayers = new ArrayList<>();
    Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
    Player player;
    String WingType;

    @EventHandler
    public void onPlayerAddGlowWings(PlayerArmorChangeEvent e) {
        try{
            if (e.getSlotType().equals(PlayerArmorChangeEvent.SlotType.CHEST) && e.getNewItem().getItemMeta().hasLore()){
                if (e.getNewItem().getLore().get(0).equals("§7Glow") && !glowPlayers.contains(player)) {
                    player = e.getPlayer();
                    glowPlayers.add(player);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 350,0, false, false), true);
                    WingType = e.getNewItem().getLore().get(3).toString().substring(2).toLowerCase();
                    addGlowColors();
                }
            }
        } catch (Exception exception){
            //Bukkit.getLogger().warning(":(");
        }
    }

    @EventHandler
    public void onPlayerSwitchArmor(PlayerArmorChangeEvent event) {
        try{
            if (event.getSlotType().equals(PlayerArmorChangeEvent.SlotType.CHEST) && Objects.requireNonNull(event.getOldItem()).getItemMeta().hasLore()) {
                if (event.getOldItem().getLore().get(0).equals("§7Glow") && glowPlayers.contains(player)) {
                    if (event.getNewItem().getType().isAir() || !event.getNewItem().getItemMeta().hasLore()
                            || !event.getNewItem().getLore().get(3).equals(event.getOldItem().getLore().get(3))) {
                        player = event.getPlayer();
                        glowPlayers.remove(player);
                        try {
                            board.getTeam(WingType).removeEntry(player.getName());
                        } catch (Exception ignored) {/*No existing team!*/}
                        player.removePotionEffect(PotionEffectType.GLOWING);
                    }
                }
            }
        } catch (Exception exception){
            //Bukkit.getLogger().warning(":(");
        }

    }

    @EventHandler
    public void addGlowPlayerJoin(PlayerJoinEvent event) {
        if (glowPlayers.contains(player)) {
            player = event.getPlayer();
            addGlowColors();
        }
    }

    public static void addGlow() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
            for (int i = 0; i < glowPlayers.size(); i++) {
                glowPlayers.get(i).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 350,0, false, false), true);
            }
        }, 0, 75);
    }

    public void addGlowColors(){
        try {
            board.getTeam(WingType).addEntry(player.getName());
        } catch (Exception e) {
            RegisterGlowColors.registerGlowColors();
            board.getTeam(WingType).addEntry(player.getName());
        }
    }
}


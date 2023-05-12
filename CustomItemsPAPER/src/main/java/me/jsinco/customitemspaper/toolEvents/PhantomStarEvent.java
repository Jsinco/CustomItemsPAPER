package me.jsinco.customitemspaper.toolEvents;

import me.jsinco.customitemspaper.CustomItemsPAPER;
import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PhantomStarEvent implements Listener {
    Player player;
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.PhantomStar.getItemMeta())) {
                player = event.getPlayer();
                GameMode gameMode = player.getGameMode();
                player.getInventory().removeItem(ItemManager.PhantomStar);
                player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 5000, 1));
                player.setGameMode(GameMode.SPECTATOR);
                Bukkit.getScheduler().scheduleSyncDelayedTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
                    try {
                        player.setGameMode(gameMode);
                        player.removePotionEffect(PotionEffectType.DARKNESS);
                    } catch (Exception e) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.removePotionEffect(PotionEffectType.DARKNESS);
                    }
                    checkPlayerGM();
                }, 70L);

            }

        }
    }

    public void checkPlayerGM(){
        Bukkit.getScheduler().scheduleSyncDelayedTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
            if (player.getGameMode().equals(GameMode.SPECTATOR)) {
                player.setGameMode(GameMode.SURVIVAL);
            }
        }, 1L);
    }
}

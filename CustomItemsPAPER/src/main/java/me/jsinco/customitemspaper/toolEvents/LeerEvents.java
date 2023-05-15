package me.jsinco.customitemspaper.toolEvents;

import me.jsinco.customitemspaper.CustomItemsPAPER;
import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class LeerEvents implements Listener {
    List<String> cooldownplayers = new ArrayList<>();
    @EventHandler
    public void EnderEyeEvent(PlayerInteractEvent event){
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.Leer.getItemMeta())
                    && !cooldownplayers.contains(event.getPlayer().getName())) {
                cooldownplayers.add(event.getPlayer().getName());
                Bukkit.getScheduler().scheduleSyncDelayedTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
                    Collection<Entity> nearestLeer = event.getPlayer().getLocation().getWorld().getNearbyEntities(event.getPlayer().getLocation(), 3, 3, 3);
                    nearestLeer.forEach(entity -> {
                        if (entity.getType().equals(EntityType.ENDER_SIGNAL)) {


                            Collection<Entity> nearbys = event.getPlayer().getLocation().getWorld().getNearbyEntities(event.getPlayer().getLocation(), 20, 20, 20);
                            nearbys.forEach(nearbyentitys -> nearbyentitys.setGlowing(true));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
                                nearbys.forEach(nearbyentitys -> nearbyentitys.setGlowing(false));

                                entity.remove();
                                if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)){event.getPlayer().getInventory().addItem(ItemManager.Leer);}
                            }, 60L);
                        }
                    });
                }, 1L);

                Bukkit.getScheduler().scheduleSyncDelayedTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> cooldownplayers.remove(event.getPlayer().getName()),10L);
            } else if (cooldownplayers.contains(event.getPlayer().getName())){
                event.getPlayer().sendMessage("§cYou can't use this item right now!");
                event.setCancelled(true);
            }

        }
    }
}

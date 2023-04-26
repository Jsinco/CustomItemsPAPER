package me.jsinco.customitemspaper.events;

import me.jsinco.customitemspaper.CustomItemsPAPER;
import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

import java.util.Collection;


public class LeerEvents implements Listener {
    boolean Leer = false;

    @EventHandler
    public void SwapTo(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getPlayer().getInventory().getItemInMainHand().getLore().get(0).equals("§eWatchful")){
                Leer = true;
            } else {
                Leer = false;
            }
        }
    }
    //fix for tomorrow, "Leer" must stay true until leer.forEach is complete
    @EventHandler
    public void EnderEyeListener(PlayerStatisticIncrementEvent event) {
        Collection<Entity> nearbys = event.getPlayer().getLocation().getWorld().getNearbyEntities(event.getPlayer().getLocation(),20,20,20);
        Collection<Entity> leer = event.getPlayer().getLocation().getWorld().getNearbyEntities(event.getPlayer().getLocation(),100,100,100);
        if (event.getMaterial().equals(Material.ENDER_EYE) && Leer){
            nearbys.forEach(entity -> entity.setGlowing(true));
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
                nearbys.forEach(entity -> entity.setGlowing(false));
                leer.forEach(entity -> {
                    if (entity.getType().equals(EntityType.ENDER_SIGNAL) && Leer){
                        entity.remove();
                        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)){ event.getPlayer().getInventory().addItem(ItemManager.Leer); }
                        Leer = false;
                        event.setCancelled(true);
                    }
                });
            }, 60L);
        }
    }

}

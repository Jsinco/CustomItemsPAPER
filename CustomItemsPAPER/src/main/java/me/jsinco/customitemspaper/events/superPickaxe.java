package me.jsinco.customitemspaper.events;

import me.jsinco.customitemspaper.CustomItemsPAPER;
import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;



public class superPickaxe implements Listener {
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (event.getItem().getItemMeta().equals(ItemManager.superPickaxe.getItemMeta())) {
                Player player = event.getPlayer();
                Location blockLocation = event.getClickedBlock().getLocation();
                for (int i = 0; i < 2; i++) {


                    player.getWorld().getBlockAt(blockLocation.add(i, 0, 0)).breakNaturally();
                    player.getWorld().getBlockAt(blockLocation.add(0, 0, -i)).breakNaturally();
                }

            }

        }
    }

}

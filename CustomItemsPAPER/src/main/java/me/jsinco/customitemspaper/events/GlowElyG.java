package me.jsinco.customitemspaper.events;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GlowElyG implements Listener {
    @EventHandler
    public void onPlayerSwitchArmor(PlayerArmorChangeEvent event) {




            if (event.getOldItem().lore().get(0).equals(ItemManager.GreenGlowElytra.lore().get(0))){
                Bukkit.broadcastMessage("GREEN GLOW WINGS OFF!");
                if (event.getNewItem().getType().isAir() || !event.getNewItem().getItemMeta().hasLore()
                        || !event.getNewItem().lore().get(0).equals(ItemManager.GreenGlowElytra.lore().get(0))){
                    Bukkit.broadcastMessage("GREEN GLOW WINGS off!");
                } else {
                    Bukkit.broadcastMessage("GREEN GLOW WINGS on!");
                }
            }

    }

}

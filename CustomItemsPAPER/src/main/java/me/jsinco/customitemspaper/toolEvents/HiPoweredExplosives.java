package me.jsinco.customitemspaper.toolEvents;

import me.jsinco.customitemspaper.CustomItemsPAPER;
import me.jsinco.customitemspaper.util.RegisterGlowColors;
import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scoreboard.Scoreboard;


public class HiPoweredExplosives implements Listener {
    @EventHandler
    public void PlayerFireHIEXPLOSIVE(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.HiPoweredExplosives.getItemMeta())) {
                Player p = event.getPlayer();
                Location location = p.getLocation().add(0,15,0);
                p.getInventory().removeItem(ItemManager.HiPoweredExplosives);
                for (int i = 0; i < 10; i++){
                    Bukkit.getScheduler().scheduleSyncDelayedTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
                        Entity arrow1 = p.getWorld().spawnEntity(location.add(1,0,0), EntityType.ARROW);
                        Entity arrow2 = p.getWorld().spawnEntity(location.add(-1,0,0), EntityType.ARROW);
                        Entity arrow3 = p.getWorld().spawnEntity(location.add(0,0,1), EntityType.ARROW);
                        Entity arrow4 = p.getWorld().spawnEntity(location.add(0,0,-1), EntityType.ARROW);
                        Entity[] arrows = {arrow1,arrow2,arrow3,arrow4};
                        for (int n = 0; n < 4; n++){
                            arrows[n].setVelocity(p.getLocation().getDirection().multiply(3));
                            arrows[n].setCustomName("HI-EXPLOSIVE");
                            Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
                            try {
                                board.getTeam("aqua").addEntry(arrows[n].getUniqueId().toString());
                            } catch (Exception exception) {
                                RegisterGlowColors.registerGlowColors();
                                board.getTeam("aqua").addEntry(arrows[n].getUniqueId().toString());
                            }
                            arrows[n].setGlowing(true);
                            arrows[n].setVisualFire(true);
                        }
                    },i+10L);

                }
            }

        }
    }

    @EventHandler
    public void HIEXPLOSIVELand(ProjectileHitEvent event){
        if (event.getEntity().getName().equals("HI-EXPLOSIVE")){
            event.getEntity().getLocation().getWorld().createExplosion(event.getEntity().getLocation(), 3);
            event.getEntity().remove();
        }
    }


}

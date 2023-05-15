package me.jsinco.customitemspaper.toolEvents;

import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import me.jsinco.customitemspaper.util.RegisterGlowColors;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

public class BoombowEvents implements Listener {

    @EventHandler
    public void BoomBowLoad(EntityLoadCrossbowEvent event){
        Player p = (Player) event.getEntity();
        if (p.getInventory().getItemInMainHand().getLore().get(0).equals("§cExplosives")){
            if (!p.getGameMode().equals(GameMode.CREATIVE)){
                if (p.getInventory().contains(Material.TNT)){
                    p.getInventory().removeItem(new ItemStack(Material.TNT, 1));
                    p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                    p.updateInventory();
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void BoomBowFire(ProjectileLaunchEvent e){
        if (e.getEntity().getShooter() instanceof Player){
            Player p = (Player) e.getEntity().getShooter();
            if (!p.getInventory().getItemInMainHand().getType().equals(Material.CROSSBOW)) return;
            if (p.getInventory().getItemInMainHand().getItemMeta().hasLore() && p.getInventory().getItemInMainHand().getLore().get(0).equals("§cExplosives")){
                Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
                try {
                    board.getTeam("red").addEntry(e.getEntity().getUniqueId().toString());
                } catch (Exception exception) {
                    RegisterGlowColors.registerGlowColors();
                    board.getTeam("red").addEntry(e.getEntity().getUniqueId().toString());
                }
                e.getEntity().setGlowing(true);
                e.getEntity().setCustomName("EXPLOSIVE");
                //Add particles
            }
        }
    }
    @EventHandler
    public void BoomBowLand(ProjectileHitEvent event){
        if (event.getEntity().getName().equals("EXPLOSIVE")){
            event.getEntity().getLocation().getWorld().createExplosion(event.getEntity().getLocation(), 3);
            event.getEntity().remove();
        }
    }
}

package me.jsinco.customitemspaper.events;

import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

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
        Player p = (Player) e.getEntity().getShooter();
        if (p.getInventory().getItemInMainHand().getLore().get(0).equals("§cExplosives")){
            Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
            try {
                Team team = board.getTeam("EXPLOSIVE");
                team.addEntry(e.getEntity().getUniqueId().toString());
            } catch (Exception exception) {
                Team team = board.registerNewTeam("EXPLOSIVE");
                team.setColor(ChatColor.RED);
                team.addEntry(e.getEntity().getUniqueId().toString());
            }
            e.getEntity().setGlowing(true);
            e.getEntity().setCustomName("EXPLOSIVE");
            //Add particles
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

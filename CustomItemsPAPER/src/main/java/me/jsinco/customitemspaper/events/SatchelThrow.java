package me.jsinco.customitemspaper.events;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;
import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Collection;

public class SatchelThrow implements Listener {
    @EventHandler
    public void playerThrowSatchel(PlayerLaunchProjectileEvent event) {
        if (event.getItemStack().isSimilar(ItemManager.Satchel)){
            event.getProjectile().setCustomName("Satchel");
            try{
                Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
                board.getTeam("gold").addEntry(event.getProjectile().getName());
            } catch (Exception ignored) {/*No existing team!*/}
            event.getProjectile().setGlowing(true);
        }
    }

    @EventHandler
    public void satchelLands(ProjectileHitEvent event){
        if (event.getEntity().getName().equals("Satchel") && event.getHitBlock() != null){
            Collection<Entity> nearbyEntities = event.getEntity().getWorld().getNearbyEntities(event.getEntity().getLocation(), 5, 5, 5);
            Location hitLoc = event.getHitBlock().getLocation();

            event.getEntity().getWorld().spawnParticle(Particle.GLOW, hitLoc, 100, 0.5, 0.5, 0.5, 0.1);
            event.getEntity().getWorld().playSound(hitLoc, Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 1, 1);
            nearbyEntities.forEach(entity -> {
                entity.setVelocity(entity.getLocation().toVector().subtract(hitLoc.toVector()).multiply(0.5));
            });
        }
    }
}

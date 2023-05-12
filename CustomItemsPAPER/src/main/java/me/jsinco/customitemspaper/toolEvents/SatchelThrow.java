package me.jsinco.customitemspaper.toolEvents;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;

import me.jsinco.customitemspaper.CustomItemsPAPER;
import me.jsinco.customitemspaper.items.ItemManager;
import me.jsinco.customitemspaper.util.RegisterGlowColors;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Random;


public class SatchelThrow implements Listener {

    @EventHandler
    public void throwSatchel(PlayerLaunchProjectileEvent event) {
        if (event.getItemStack().isSimilar(ItemManager.Satchel)) {
            Projectile projectile = event.getProjectile();
            projectile.setCustomName("Satchel");
            projectile.setCustomNameVisible(false);
            Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
            Random rand = new Random();
            int randnum = rand.nextInt(6);
            try {
                board.getTeam(RegisterGlowColors.colors[randnum]).addEntry(projectile.getUniqueId().toString());
            } catch (Exception e) {
                RegisterGlowColors.registerGlowColors();
                board.getTeam(RegisterGlowColors.colors[randnum]).addEntry(projectile.getUniqueId().toString());
            }
            projectile.setGlowing(true);

            event.getPlayer().damage(1);
            event.getPlayer().getInventory().addItem(ItemManager.Satchel);

            if (!event.getPlayer().getLocation().subtract(0,0.1,0).getBlock().getType().isAir()) return;
            Bukkit.getScheduler().scheduleSyncDelayedTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
                if (!projectile.isDead()){
                    Collection<Entity> nearbies = projectile.getNearbyEntities(3, 6.5, 3);
                    nearbies.forEach(entity -> {
                        entity.setVelocity(new Vector
                                (entity.getFacing().getDirection().getX() * 2, 1, entity.getFacing().getDirection().getZ() * 2));
                    });
                    projectile.getWorld().spawnParticle(Particle.GLOW, projectile.getLocation(), 10);
                    projectile.remove();
                }
            }, 5L);

        }
    }
    @EventHandler
    public void SatchelOut(ProjectileHitEvent event){
        if (event.getEntity().getCustomName() == null || event.getHitBlock() == null) return;
        if (event.getEntity().getCustomName().equals("Satchel")){
            Collection<Entity> nearbies = event.getEntity().getNearbyEntities(2, 2, 2);
            nearbies.forEach(entity -> {
                entity.setVelocity(new Vector
                        (entity.getFacing().getDirection().getX() * 2, 1, entity.getFacing().getDirection().getZ() * 2));
            });
            event.getEntity().getWorld().spawnParticle(Particle.GLOW, event.getEntity().getLocation(), 10);
        }
    }

}
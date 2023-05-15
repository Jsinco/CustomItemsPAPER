package me.jsinco.customitemspaper.toolEvents;

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent;

import me.jsinco.customitemspaper.CustomItemsPAPER;
import me.jsinco.customitemspaper.items.ItemManager;
import me.jsinco.customitemspaper.util.RegisterGlowColors;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
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

            Player p = event.getPlayer();
            if (!p.getLocation().subtract(0,0.1,0).getBlock().getType().isAir()) return;
            if (event.getPlayer().isFlying()) return;
            Bukkit.getScheduler().scheduleSyncDelayedTask(CustomItemsPAPER.getPlugin(CustomItemsPAPER.class), () -> {
                if (!projectile.isDead()){
                    Collection<Entity> nearbies = projectile.getNearbyEntities(3, 6.5, 3);
                    nearbies.forEach(entity -> {
                        entity.setVelocity(new Vector
                                (entity.getFacing().getDirection().getX() * 2, 1, entity.getFacing().getDirection().getZ() * 2));
                        entity.getWorld().spawnParticle(Particle.GLOW, entity.getLocation(), 100, 0.5, 0.5, 0.5, 0.1);
                    });
                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ALLAY_AMBIENT_WITH_ITEM, 1, 1);
                    projectile.getWorld().spawnParticle(Particle.GLOW, projectile.getLocation(), 10);
                    projectile.remove();
                    if (!p.getGameMode().equals(GameMode.CREATIVE)) {p.getInventory().addItem(ItemManager.Satchel);}
                }
            }, 5L);

        }
    }
    @EventHandler
    public void SatchelOut(ProjectileHitEvent event){
        if (event.getEntity().getCustomName() == null || !event.getEntity().getCustomName().equals("Satchel")) return;
        Player p = (Player) event.getEntity().getShooter();
        assert p != null;

        if (event.getHitEntity() != null){
            event.getHitEntity().getWorld().createExplosion(event.getEntity().getLocation(), 1);
            if (!p.getGameMode().equals(GameMode.CREATIVE)) {p.getInventory().addItem(ItemManager.Satchel);}
            return;
        }

        Collection<Entity> nearbies = event.getEntity().getNearbyEntities(3, 3, 3);
        nearbies.forEach(entity -> {
            entity.setVelocity(new Vector
                    (entity.getFacing().getDirection().getX() * 2, 1, entity.getFacing().getDirection().getZ() * 2));
            entity.getWorld().spawnParticle(Particle.GLOW, entity.getLocation(), 100, 0.5, 0.5, 0.5, 0.1);
        });
        event.getEntity().getWorld().spawnParticle(Particle.GLOW, event.getEntity().getLocation(), 10);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ALLAY_AMBIENT_WITH_ITEM, 1, 1);
        if (!p.getGameMode().equals(GameMode.CREATIVE)) {p.getInventory().addItem(ItemManager.Satchel);}

    }

    @EventHandler
    public void playerItemDrop(PlayerDropItemEvent event){
        if (!event.getItemDrop().getItemStack().isSimilar(ItemManager.Satchel)) return;
        Item satchel = event.getItemDrop();
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        Random rand = new Random();
        int randnum = rand.nextInt(6);
        try {
            board.getTeam(RegisterGlowColors.colors[randnum]).addEntry(satchel.getUniqueId().toString());
        } catch (Exception e) {
            RegisterGlowColors.registerGlowColors();
            board.getTeam(RegisterGlowColors.colors[randnum]).addEntry(satchel.getUniqueId().toString());
        }
        satchel.setGlowing(true);

    }
}

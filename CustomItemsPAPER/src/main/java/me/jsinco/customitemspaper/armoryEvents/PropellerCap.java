package me.jsinco.customitemspaper.armoryEvents;

import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PropellerCap implements Listener {
    @EventHandler
    public void PlayerCrouch(PlayerToggleSneakEvent event){
        if (event.getPlayer().getInventory().getHelmet() == null || !event.getPlayer().getInventory().getHelmet().equals(ItemManager.PropellerCap)) return;
        Player player = event.getPlayer();
        double initialY = player.getLocation().getY();
        player.setVelocity(player.getLocation().getDirection().multiply(0.5).setY(1));
        CraftPlayer craftPlayer = (CraftPlayer) player;
        for (int i = 0; i<100;i++){
            craftPlayer.setRotation(i,i);
        }


        //player.spawnParticle(Particle.CLOUD, player.getLocation(), 100, 0.5, 0.5, 0.5, 0.1);





    }
}

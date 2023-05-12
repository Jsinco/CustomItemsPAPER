package me.jsinco.customitemspaper;

import me.jsinco.customitemspaper.armoryEvents.GlowElyG;
import me.jsinco.customitemspaper.commands.TabCompleter;
import me.jsinco.customitemspaper.commands.cEly;
import me.jsinco.customitemspaper.commands.giveItem;
import me.jsinco.customitemspaper.items.ItemManager;
import me.jsinco.customitemspaper.items.glowElytras;
import me.jsinco.customitemspaper.toolEvents.*;
import me.jsinco.customitemspaper.util.RegisterGlowColors;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItemsPAPER extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemManager.callItem();
        glowElytras.callGlowElytras();
        RegisterGlowColors.registerGlowColors();
        GlowElyG.addGlow();
        getServer().getPluginManager().registerEvents(new BoombowEvents(), this);
        getServer().getPluginManager().registerEvents(new LeerEvents(), this);
        getServer().getPluginManager().registerEvents(new HiPoweredExplosives(), this);
        getServer().getPluginManager().registerEvents(new PhantomStarEvent(), this);
        getServer().getPluginManager().registerEvents(new SatchelThrow(), this);
        //getServer().getPluginManager().registerEvents(new superPickaxe(), this);
        //getServer().getPluginManager().registerEvents(new SatchelThrow(), this);
        getServer().getPluginManager().registerEvents(new GlowElyG(), this);
        getCommand("giveitem").setExecutor(new giveItem());
        getCommand("giveitem").setTabCompleter(new TabCompleter());
        getCommand("cely").setExecutor(new cEly());
        getCommand("cely").setTabCompleter(new TabCompleter());
    }
}
package me.jsinco.customitemspaper;

import me.jsinco.customitemspaper.commands.cEly;
import me.jsinco.customitemspaper.commands.giveItem;
import me.jsinco.customitemspaper.commands.tabCompleter;
import me.jsinco.customitemspaper.events.*;
import me.jsinco.customitemspaper.items.ItemManager;
import me.jsinco.customitemspaper.items.glowElytras;
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
        //getServer().getPluginManager().registerEvents(new superPickaxe(), this);
        getServer().getPluginManager().registerEvents(new SatchelThrow(), this);
        getServer().getPluginManager().registerEvents(new GlowElyG(), this);
        getCommand("giveitem").setExecutor(new giveItem());
        getCommand("giveitem").setTabCompleter(new tabCompleter());
        getCommand("cely").setExecutor(new cEly());
        getCommand("cely").setTabCompleter(new tabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

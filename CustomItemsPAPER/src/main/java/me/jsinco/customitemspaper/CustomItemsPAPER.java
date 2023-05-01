package me.jsinco.customitemspaper;

import me.jsinco.customitemspaper.commands.giveItem;
import me.jsinco.customitemspaper.commands.tabCompleter;
import me.jsinco.customitemspaper.events.*;
import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItemsPAPER extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemManager.callItem();
        getServer().getPluginManager().registerEvents(new BoombowEvents(), this);
        getServer().getPluginManager().registerEvents(new LeerEvents(), this);
        getServer().getPluginManager().registerEvents(new HiPoweredExplosives(), this);
        getServer().getPluginManager().registerEvents(new PhantomStarEvent(), this);
        getServer().getPluginManager().registerEvents(new superPickaxe(), this);
        getServer().getPluginManager().registerEvents(new GlowElyG(), this);
        getServer().getPluginManager().registerEvents(new GlowElytrasRED(), this);
        getCommand("giveitem").setExecutor(new giveItem());
        getCommand("giveitem").setTabCompleter(new tabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

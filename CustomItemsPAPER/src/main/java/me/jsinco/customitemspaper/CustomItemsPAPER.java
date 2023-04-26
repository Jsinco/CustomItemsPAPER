package me.jsinco.customitemspaper;

import me.jsinco.customitemspaper.commands.giveItem;
import me.jsinco.customitemspaper.commands.giveleer;
import me.jsinco.customitemspaper.events.BoombowEvents;
import me.jsinco.customitemspaper.events.LeerEvents;
import me.jsinco.customitemspaper.items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItemsPAPER extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemManager.callItem();
        getServer().getPluginManager().registerEvents(new BoombowEvents(), this);
        getServer().getPluginManager().registerEvents(new LeerEvents(), this);
        getCommand("boombow").setExecutor(new giveItem());
        getCommand("leer").setExecutor(new giveleer());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

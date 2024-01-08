package es.crowty.addon;

import es.crowty.addon.commands.CommandManager;
import es.crowty.addon.config.Configuration;
import es.crowty.addon.listener.ListenerManager;
import es.crowty.addon.util.Messager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DisableSign extends JavaPlugin implements Listener, CommandExecutor, TabCompleter {
    public static DisableSign pl;
    private Configuration config;
    private ListenerManager listenerManager;
    private CommandManager commandManager;

    public void onEnable() {
        pl = this;
        config = new Configuration("config.yml");
        listenerManager = new ListenerManager();
        commandManager = new CommandManager();
        Messager.log("§6■ §7□ □ §fCROWTY §cANTI-SIGN-EDITOR§r §f» §7Initializing plugin configuration...");
        Messager.log("§6■ §e■ §7□ §cANTI-SIGN-EDITOR§r §f» §7Registering commands...");
        Messager.log("§a■ ■ ■ §cANTI-SIGN-EDITOR§r §f» §aStarted successfully!");
    }

    public void onDisable() {
        listenerManager = null;
        commandManager = null;
        Messager.log("§c■ ■ ■ §cANTI-SIGN-EDITOR§r §f» §cPlugin shut down correctly!");
        pl = null;
    }

    public Configuration getConfiguration() {
        return config;
    }

    public ListenerManager getListenerManager() {
        return listenerManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}

package es.crowty.addon;

import es.crowty.addon.config.Configuration;
import es.crowty.addon.listener.ListenerManager;
import es.crowty.addon.util.Messager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class DisableSign extends JavaPlugin implements Listener, CommandExecutor, TabCompleter {
    public static DisableSign pl;
    private Configuration config;
    private ListenerManager listenerManager;

    public void onEnable() {
        pl = this;
        config = new Configuration("config.yml");
        listenerManager = new ListenerManager();
        Messager.log("§6■ §7□ □ §fCROWTY §cANTI-SIGN-EDITOR§r §f» §7Initializing plugin configuration...");
        getCommand("cwdisablesign").setExecutor(this);
        getCommand("cwdisablesign").setTabCompleter(this);
        Messager.log("§6■ §e■ §7□ §cANTI-SIGN-EDITOR§r §f» §7Registering commands...");
        Messager.log("§a■ ■ ■ §cANTI-SIGN-EDITOR§r §f» §aStarted successfully!");
    }

    public void onDisable() {
        listenerManager = null;
        Messager.log("§c■ ■ ■ §cANTI-SIGN-EDITOR§r §f» §cPlugin shut down correctly!");
        pl = null;
    }

    public Configuration getConfiguration() {
        return config;
    }

    public ListenerManager getListenerManager() {
        return listenerManager;
    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String prefix = this.config.getPrefix();
        if (command.getName().equalsIgnoreCase("cweditsign") &&
                args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            reloadConfig();
            Messager.notifyTo((Player)sender, "§aConfiguration reloaded successfully!");
            return true;
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1)
            completions.add("reload");
        return completions;
    }
}

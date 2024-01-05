package es.crowty.addon.listener;

import es.crowty.addon.DisableSign;
import es.crowty.addon.listener.types.SignInteract;
import org.bukkit.Bukkit;

public class ListenerManager {
    public ListenerManager() {
        Bukkit.getPluginManager().registerEvents(new SignInteract(), DisableSign.pl);
    }
}

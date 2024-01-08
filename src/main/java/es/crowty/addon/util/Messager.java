package es.crowty.addon.util;

import es.crowty.addon.DisableSign;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messager {

    public static void log(String s) {
        Bukkit.getConsoleSender().sendMessage("§6[crowty-sign-edit] §e" + s);
    }

    public static void notifyTo(Player p, String s) {
        p.sendMessage(Color.translate(DisableSign.pl.getConfiguration().getPrefix()) + s);
    }

    public static void warn(final String s) {
        Bukkit.getConsoleSender().sendMessage("§4[crowty-sign-edit] §c" + s);
    }

    public static void notifyNoPermission(CommandSender sender) {
        sender.sendMessage(Color.translate(DisableSign.pl.getConfiguration().getNoPermissionMessage()));
    }

}
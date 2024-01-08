package es.crowty.addon.commands.common;

import org.bukkit.command.CommandSender;

public interface BaseCommand {
    void onCommand(CommandSender paramCommandSender, String[] paramArrayOfString);

    void help(CommandSender paramCommandSender);

    String getPermission();

    boolean console();
}

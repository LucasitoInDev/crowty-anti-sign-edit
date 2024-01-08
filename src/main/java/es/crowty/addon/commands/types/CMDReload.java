package es.crowty.addon.commands.types;

import es.crowty.addon.DisableSign;
import es.crowty.addon.commands.common.BaseCommand;
import es.crowty.addon.util.Messager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDReload implements BaseCommand {

    @Override
    public void onCommand(CommandSender p, String[] args) {
        if (p instanceof Player) {
            if (p.hasPermission(getPermission())) {
                if (args.length == 0) {
                    Messager.notifyTo((Player) p, "§r §cSyntax error: §7Use §6/cweditsign reload");
                } else {
                    if (args[0].equalsIgnoreCase("reload")) {
                        DisableSign.pl.getConfiguration().reloadConfig();
                        Messager.notifyTo((Player) p, "§aConfig reloaded succesfully!");
                    }
                }
            } else {
                this.help(p);
            }
        }
    }

    @Override
    public void help(CommandSender paramCommandSender) {
        DisableSign.pl.getConfiguration().getNoPermissionMessage();
    }

    @Override
    public String getPermission() {
        return DisableSign.pl.getConfiguration().getPermission();
    }

    @Override
    public boolean console() {
        return true;
    }
}
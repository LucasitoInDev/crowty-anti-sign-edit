package es.crowty.addon.commands;

import es.crowty.addon.DisableSign;
import es.crowty.addon.commands.common.BaseCommand;
import es.crowty.addon.commands.types.CMDReload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;

public class CommandManager implements CommandExecutor {
    private final HashMap<String, BaseCommand> commands = new HashMap<>();

    public CommandManager() {
        loadCommands();
        registerCommands();
    }

    private void loadCommands() {
        commands.put("cweditsign", new CMDReload());
    }

    private void registerCommands() {
        for (String s : commands.keySet()) {
            Objects.requireNonNull(DisableSign.pl.getCommand(s)).setExecutor(this);
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (commands.containsKey(cmd.getName())) {
            String name = cmd.getName();
            ((BaseCommand)commands.get(name)).onCommand(sender, args);
        }
        return true;
    }
}
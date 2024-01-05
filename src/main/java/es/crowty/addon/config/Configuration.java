package es.crowty.addon.config;

import es.crowty.addon.util.Messager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class Configuration {
    private final File file;
    private final FileConfiguration config;

    public Configuration(String file) {
        File folder = new File("plugins/crowty-anti-sign-edit");
        this.file = new File("plugins/crowty-anti-sign-edit/", file);

        if (!this.file.exists()) {
            Messager.log("§7Configuration file §c§lNOT FOUND§7, §7creating §bnew one§7...");
            try {
                if (!folder.exists())
                    folder.mkdir();
                this.file.createNewFile();
            } catch (IOException ex) {
                Messager.log("§cERROR: §7The configuration §chas not been loaded§r§7: §4" + ex);
            }
            this.config = YamlConfiguration.loadConfiguration(this.file);
            Messager.log("§aConfiguration and logs loaded correctly§r§2!");
        } else {
            this.config = YamlConfiguration.loadConfiguration(this.file);
        }
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public File getFile() {
        return this.file;
    }

    public List<String> getEnabledWorlds() {
        return getConfig().getStringList("config.enabled-worlds.worlds");
    }

    public String getPermission() {
        return getConfig().getString("config.permission");
    }

    public boolean areEnabledWorldsEnabled() {
        return getConfig().getBoolean("config.enabled-worlds.enabled");
    }

    public boolean isSoundEnabled() {
        return getConfig().getBoolean("config.sound.enabled");
    }

    public String getSoundType() {
        return getConfig().getString("config.sound.sound-type");
    }

    public boolean areEffectsEnabled() {
        return getConfig().getBoolean("config.effects.enabled");
    }

    public String getEffectType() {
        return getConfig().getString("config.effects.effect-type");
    }

    public String getPrefix() {
        return getConfig().getString("config.prefix");
    }

    public String getNoPermissionMessage() {
        return getConfig().getString("config.nopermission");
    }

    public void saveConfig() {
        try {
            getConfig().save(getFile());
        } catch (IOException ex) {
            Messager.warn("§cError in the configuration, check that it is well structured§r§7: §4" + ex);
        }
    }
}

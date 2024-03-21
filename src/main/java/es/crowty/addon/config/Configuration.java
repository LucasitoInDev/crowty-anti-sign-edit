package es.crowty.addon.config;

import es.crowty.addon.util.Color;
import es.crowty.addon.util.Messager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public final class Configuration {
    private final File file;
    private FileConfiguration config;

    public Configuration(String fileName) {
        File folder = new File("plugins/crowty-anti-sign-edit");
        this.file = new File(folder, fileName);

        if (!file.exists()) {
            Messager.log("§7Configuration file §c§lNOT FOUND§7, §7creating §bnew one§7...");

            try {
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                // Cargar desde los recursos
                InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(fileName);
                Files.copy(Objects.requireNonNull(resourceStream), file.toPath());

                Messager.log("§aConfiguration and logs loaded correctly§r§2!");
            } catch (IOException ex) {
                Messager.log("§cERROR: §7The configuration §chas not been loaded§r§7: §4" + ex);
            }
        }

        this.config = YamlConfiguration.loadConfiguration(file);
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

    public String getSoundType() {
        return getConfig().getString("config.sound.sound-type");
    }

    public String getEffectType() {
        return getConfig().getString("config.effects.effect-type");
    }

    public String getPrefix() {
        return getConfig().getString(Color.translate("config.prefix"));
    }

    public String getNoPermissionMessage() {
        return getConfig().getString(Color.translate("config.nopermission"));
    }

    public boolean isNoPermissionMessage() {
        return getConfig().getBoolean(Color.translate("config.notify-nopermission"));
    }

    public void reloadConfig() {
        this.config = YamlConfiguration.loadConfiguration(file);

        // Realiza otras tareas de recarga si es necesario

        Messager.log("§aConfiguration reloaded successfully!");
    }


    public void saveConfig() {
        try {
            getConfig().save(getFile());
        } catch (IOException ex) {
            Messager.warn("§cError in the configuration, check that it is well structured§r§7: §4" + ex);
        }
    }
}

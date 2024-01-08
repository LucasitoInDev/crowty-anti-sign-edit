package es.crowty.addon.listener.types;

import es.crowty.addon.DisableSign;
import es.crowty.addon.util.Messager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class SignInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if (e.getAction() != Action.RIGHT_CLICK_BLOCK || e.getPlayer().isSneaking()) {
            return;
        }

        Block clickedBlock = e.getClickedBlock();
        if (clickedBlock == null || !isSignBlock(clickedBlock.getType())) {
            return;
        }

        FileConfiguration config = DisableSign.pl.getConfiguration().getConfig();
        String permission = DisableSign.pl.getConfiguration().getPermission();
        List<String> enabledWorlds = DisableSign.pl.getConfiguration().getEnabledWorlds();

        if (!e.getPlayer().hasPermission(permission) || !enabledWorlds.contains(e.getPlayer().getWorld().getName())) {

            e.setCancelled(true);
            Messager.notifyNoPermission(e.getPlayer());

            if (DisableSign.pl.getConfiguration().getConfig().getBoolean("config.effects.enabled")) {
                String effectType = DisableSign.pl.getConfiguration().getEffectType();
                int effectDuration = config.getInt("config.effects.effect-duration");
                applyEffect(e.getPlayer(), effectType, effectDuration);
            }

            if (config.getBoolean("config.sound.enabled")) {
                String soundType = DisableSign.pl.getConfiguration().getSoundType();
                playSound(e.getPlayer(), soundType);
            }

        }
    }

    private void applyEffect(Player player, String effectType, int effectDuration) {
        try {
            PotionEffectType potionEffectType = PotionEffectType.getByName(effectType);

            if (potionEffectType != null) {
                PotionEffect effect = new PotionEffect(potionEffectType, effectDuration, 1);
                player.addPotionEffect(effect);
            } else {
                Messager.warn("§cInvalid effect type in settings: §4" + effectType);
            }
        } catch (IllegalArgumentException e) {
            Messager.warn("§cInvalid effect type in settings: §4" + effectType);
        }
    }


    private void playSound(Player player, String soundType) {
        try {
            Sound sound = Sound.valueOf(soundType);
            player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
        } catch (IllegalArgumentException e) {
            Messager.warn("§cInvalid sound type in settings: §4" + soundType);
        }
    }

    private boolean isSignBlock(Material material) {
        return material.name().endsWith("_SIGN");
    }
}

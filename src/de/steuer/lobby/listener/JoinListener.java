package de.steuer.lobby.listener;

import de.steuer.lobby.inventories.JoinInv;
import de.steuer.lobby.main.Main;
import de.steuer.lobby.utils.ScoreboardMethod;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    ScoreboardMethod.setScoreboard(all);
                }
            }
        }.runTaskLater(Main.getPlugin(), 1);

        if(e.getPlayer().hasPermission("lobby.vanish.on")) {
            Main.vanish.add(e.getPlayer());
            e.getPlayer().sendMessage(Main.prefix + "§7Da du die Permission §alobby.vanish.on §7besitzt, wurde dein §aVanishmodus §7automatisch §aaktiviert§7.");
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 2));
        }

        Player p = e.getPlayer();
        if(Main.build.contains(p)) {
            Main.build.remove(p);
        }
        if(Main.fly.contains(p)) {
            Main.fly.remove(p);
        }

        String msg = Main.getPlugin().getConfig().getString("Lobby.JoinMessage");
        msg = msg.replaceAll("&", "§");
        msg = msg.replace("%player%", p.getName());
        e.setJoinMessage(msg);

        p.setGameMode(GameMode.SURVIVAL);
        p.getInventory().clear();
        JoinInv.GetJoinItems(p);

    }
}

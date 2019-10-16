package de.steuer.lobby.commands;

import de.steuer.lobby.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class setupCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("lobby.setup")) {
                if(args.length == 1) {
                    FileConfiguration cfg = Main.getPlugin().getConfig();
                    if(args[0].equalsIgnoreCase("setuhc")) {
                        cfg.set("Location.uhc.world", p.getWorld().getName());
                        cfg.set("Location.uhc.x", p.getLocation().getX());
                        cfg.set("Location.uhc.y", p.getLocation().getY());
                        cfg.set("Location.uhc.z", p.getLocation().getZ());
                        cfg.set("Location.uhc.yaw", p.getLocation().getYaw());
                        cfg.set("Location.uhc.pitch", p.getLocation().getPitch());
                        Main.getPlugin().saveConfig();
                        p.sendMessage(Main.prefix + "§7Du hast den §e§lUHC §r§7Spawn erfolgreich gesetzt.");
                    } else if(args[0].equalsIgnoreCase("set1v1")) {
                        cfg.set("Location.1v1.world", p.getWorld().getName());
                        cfg.set("Location.1v1.x", p.getLocation().getX());
                        cfg.set("Location.1v1.y", p.getLocation().getY());
                        cfg.set("Location.1v1.z", p.getLocation().getZ());
                        cfg.set("Location.1v1.yaw", p.getLocation().getYaw());
                        cfg.set("Location.1v1.pitch", p.getLocation().getPitch());
                        Main.getPlugin().saveConfig();
                        p.sendMessage(Main.prefix + "§7Du hast den §c§l1v1 §r§7Spawn erfolgreich gesetzt.");
                    } else if(args[0].equalsIgnoreCase("setspawn")) {
                        cfg.set("Location.spawn.world", p.getWorld().getName());
                        cfg.set("Location.spawn.x", p.getLocation().getX());
                        cfg.set("Location.spawn.y", p.getLocation().getY());
                        cfg.set("Location.spawn.z", p.getLocation().getZ());
                        cfg.set("Location.spawn.yaw", p.getLocation().getYaw());
                        cfg.set("Location.spawn.pitch", p.getLocation().getPitch());
                        Main.getPlugin().saveConfig();
                        p.sendMessage(Main.prefix + "§7Du hast den §a§lSpawn §r§7Spawn erfolgreich gesetzt.");
                    } else if(args[0].equalsIgnoreCase("setcommunity")) {
                        cfg.set("Location.commu.world", p.getWorld().getName());
                        cfg.set("Location.commu.x", p.getLocation().getX());
                        cfg.set("Location.commu.y", p.getLocation().getY());
                        cfg.set("Location.commu.z", p.getLocation().getZ());
                        cfg.set("Location.commu.yaw", p.getLocation().getYaw());
                        cfg.set("Location.commu.pitch", p.getLocation().getPitch());
                        Main.getPlugin().saveConfig();
                        p.sendMessage(Main.prefix + "§7Du hast den §a§lCommunity §r§7Spawn erfolgreich gesetzt.");
                    } else if(args[0].equalsIgnoreCase("setcb")) {
                        cfg.set("Location.cb.world", p.getWorld().getName());
                        cfg.set("Location.cb.x", p.getLocation().getX());
                        cfg.set("Location.cb.y", p.getLocation().getY());
                        cfg.set("Location.cb.z", p.getLocation().getZ());
                        cfg.set("Location.cb.yaw", p.getLocation().getYaw());
                        cfg.set("Location.cb.pitch",
                                p.getLocation().getPitch());
                        Main.getPlugin().saveConfig();
                        p.sendMessage(Main.prefix + "§7Du hast den §b§lCitybuild §r§7Spawn erfolgreich gesetzt.");
                    } else if(args[0].equalsIgnoreCase("setknock")) {
                        cfg.set("Location.knock.world", p.getWorld().getName());
                        cfg.set("Location.knock.x", p.getLocation().getX());
                        cfg.set("Location.knock.y", p.getLocation().getY());
                        cfg.set("Location.knock.z", p.getLocation().getZ());
                        cfg.set("Location.knock.yaw", p.getLocation().getYaw());
                        cfg.set("Location.knock.pitch", p.getLocation().getPitch());
                        Main.getPlugin().saveConfig();
                        p.sendMessage(Main.prefix + "§7Du hast den §6§lKnockIT §r§7Spawn erfolgreich gesetzt.");
                    } else
                        p.sendMessage(Main.prefix + "§7Benutze §8-> §a/lobby set<uhc|spawn|1v1|community|cb|knock>");
                } else
                    p.sendMessage(Main.prefix + "§7Benutze §8-> §a/lobby set<uhc|spawn|1v1|community|cb|knock>");
            } else
                p.sendMessage(Main.noperms);
        } else
            sender.sendMessage(Main.prefix + "§7Du musst ein Spieler sein.");



        return false;
    }
}

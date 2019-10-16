package de.steuer.lobby.utils;

import de.steuer.lobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardMethod {

    private Main plugin;

    public ScoreboardMethod(Main plugin) {
        this.plugin = plugin;
    }

    public static void setScoreboard(Player p) {
        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.registerNewObjective("111", "222");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§5DEINSERVER.DE");

        obj.getScore("§4 ").setScore(12);
        obj.getScore("§7Dein Rang:").setScore(11);
        if(p.hasPermission("prefix.owner"))
            obj.getScore("§7 > §4Owner").setScore(10);
        else if(p.hasPermission("prefix.dev"))
            obj.getScore("§7 > §bDeveloper").setScore(10);
        else
            obj.getScore("§7 > Spieler").setScore(10);
        obj.getScore("§7 ").setScore(9);
        obj.getScore("§7Online:").setScore(8);
        obj.getScore("§7 > §e" + Bukkit.getOnlinePlayers().size() + "§7/§e" + Bukkit.getMaxPlayers()).setScore(7);
        obj.getScore("§1 ").setScore(6);
        obj.getScore("§7Coins:").setScore(5);
        obj.getScore("§7 > §bIn Arbeit").setScore(4);
        obj.getScore("§f ").setScore(3);
        obj.getScore("§7Teamspeak").setScore(2);
        obj.getScore("§bDEINETSIP.DE").setScore(1);
        obj.getScore("§8 ").setScore(0);

        p.setScoreboard(sb);
    }
}

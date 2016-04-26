package scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class jugador {

	@SuppressWarnings("deprecation")
	public jugador(Player jugador){
        jugador.getUniqueId();

        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard sb = sbm.getNewScoreboard();
       
        Objective obj = sb.registerNewObjective("KitPvP", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.GREEN + "Prueba");
       
        Score Minecubos = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Prueba"));
        Score Bajas = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Prueba2"));
        Score Muertes = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Prueba3"));
       
        Minecubos.setScore(1);
        Bajas.setScore(2);
        Muertes.setScore(3);
       
        jugador.setScoreboard(sb);
    }
	
}

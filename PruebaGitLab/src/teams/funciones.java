package teams;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class funciones {

	public static void agregarTeam(Player p, teams.Team teamName, String Prefix, ChatColor nickColor) {
		
		Team t = p.getScoreboard().registerNewTeam(p.getName());
		t.setPrefix(Prefix+nickColor);
		t.addPlayer(p);
		
	}

	
	
}

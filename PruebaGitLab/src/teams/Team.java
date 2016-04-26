package teams;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class Team {
	
	public static ArrayList<Team> teams = new ArrayList<Team>();
	public static HashMap<String, Team> playerTeams = new HashMap<String, Team>();
	public String teamColor;
	
	
	public Team(String teamcolor){
		teamColor = teamcolor;
		teams.add(this);
	}
	
	public static void addPlayer(Team team, Player p){
		playerTeams.put(p.getName(), team);
	}
	
	public static void removePlayer(Player p){
		if(hasTeam(p) == true){
				playerTeams.remove(p.getName());
		}
	}
	
	public static boolean hasTeam(Player p){
		return playerTeams.containsKey(p.getName());
	}
	
	public static Team getTeam(Player p){
		if(hasTeam(p) == true){
			return playerTeams.get(p);
		} else if(hasTeam(p) == false){
			return null;
		}
		return null;
	}

	//This method returns a string. It will either return "Red" "Blue" or whatever you pass into the constructor.
	public String getTeamColor(){
		return teamColor;
	}

}











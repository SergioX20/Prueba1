package mainPacket;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import scoreboard.jugador;
import teams.Team;


public class Configuracion implements Listener{
	
	
	/* MENSAJES */
		
		// Join
		public static boolean joinMessage = true;
		public static String customJoinMessage = "El jugador %playername% ha entrado!";
		public static boolean joinTitle = true;
		public static String customTitleMessage = "El jugador %playername% ha entrado!";
	
		// Leave
		public static boolean leaveMessage = false;
		public static String customLeaveMessage = "El jugador %playername% se ha desconectado";
		
		// Death Messages
		public static boolean deathMessage = false;
		public static String customDeathMessage  = "El jugador %playername% ha sido asesinado por %killername%";
	
		
	/* AJUSTES */
	
		// Number of Players
		public static int maxPlayers = mainClass.getInstance().getConfig().getInt("maxPlayers");
		public static boolean VIPaccess = true; /* Los vips pueden entrar si está lleno */
		public static boolean staffAccess = true; /* El staff puede entrar siempre */
		
	/* SCOREBOARD */
		public static boolean scoreboard = false;
		
		
		@SuppressWarnings("unused")
		@EventHandler
		public void setScoreboard(PlayerJoinEvent e) {
			if(scoreboard) {
				jugador human = new jugador(e.getPlayer());
			}
		}
		
	/* TEAMS */
		public static boolean teamsOn = true;
		
		// TEAMS LIST
		static Team redTeam = new Team("Red");
		static Team blueTeam = new Team("Blue");
		
		// INFO EDIT TEAMS
		// teams.funciones.agregarTeam(e.getPlayer(), Configuracion.blueTeam, "[Prefijo] ", ChatColor.BLUE);
		
	
		
	/* HOLOGRAMAS */
		

		@EventHandler
		public void createArmorStand(PlayerChatEvent e) {
			hologramas.funciones.createHologram(e.getPlayer(), "abc");
		}
		
		
		
		
		
		
}			

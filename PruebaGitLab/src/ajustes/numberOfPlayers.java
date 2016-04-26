package ajustes;

import mainPacket.Configuracion;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class numberOfPlayers {

	@EventHandler
    public void placeBlock(PlayerLoginEvent event) {
		
		if(Bukkit.getOnlinePlayers().size()>=Configuracion.maxPlayers) {
			Player p = event.getPlayer();
			
			if (!p.hasPermission("Core.viph") && !p.hasPermission("Core.vipo") && !p.hasPermission("Core.vipd")
					&& !p.hasPermission("Core.admin") && !p.hasPermission("Core.mod") && !p.hasPermission("Core.gmod") && !p.hasPermission("trialmod.mod")) {
				event.disallow(Result.KICK_OTHER, "§6La sala está llena, si eres VIP puedes entrar siempre!");
			}
			
			if(p.hasPermission("Core.admin") && p.hasPermission("Core.mod") && p.hasPermission("Core.gmod") && p.hasPermission("trialmod.mod")) {
				
				if(!Configuracion.staffAccess) {
					event.disallow(Result.KICK_OTHER, "§6La sala está llena, no puedes entrar!");
				}
			} else if (p.hasPermission("Core.viph") || p.hasPermission("Core.vipo") || p.hasPermission("Core.vipd")) {
				if(!Configuracion.VIPaccess) {
					event.disallow(Result.KICK_OTHER, "§6La sala está llena!");
				}
			}
		}
	}
}

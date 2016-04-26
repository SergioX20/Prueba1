package mensajes;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class editorDeMensajes implements Listener{

	@EventHandler
	public void joinMessage(PlayerJoinEvent e) {

		if(mainPacket.Configuracion.joinMessage) {
			
			if(mainPacket.Configuracion.customJoinMessage!=null) {
				e.setJoinMessage(mainPacket.Configuracion.customJoinMessage.replaceAll("%playername%", e.getPlayer().getName()));
			}
			
		} else {
			e.setJoinMessage(null);
		}
	}
	
	@EventHandler
	public void joinTitle(PlayerJoinEvent e) {

		if(mainPacket.Configuracion.joinTitle) {

			if(mainPacket.Configuracion.customJoinMessage!=null) {
            	titles.funciones.enviarTitulo(mainPacket.Configuracion.customJoinMessage, e.getPlayer());
			}
			
		} else {
			e.setJoinMessage(null);
		}
	}
	
	
	
	
	
	@EventHandler
	public void deathMessage(PlayerDeathEvent e) {
				
		if(mainPacket.Configuracion.deathMessage) {
			Player killer = null;
			
			if(e.getEntity() instanceof Player) {
				killer = e.getEntity().getKiller();
			} else if(e.getEntity() instanceof Arrow) {
				killer = (Player) ((Arrow) e.getEntity()).getShooter();
			}
			
			if(killer!=null) {
				if(mainPacket.Configuracion.customDeathMessage!=null) {
					e.setDeathMessage(mainPacket.Configuracion.customDeathMessage.replaceAll("%playername%", e.getEntity().getName()).replaceAll("%killername%", killer.getName()));
				}
			}
			
		} else {
			e.setDeathMessage(null);
		}
		
	}
	
	@EventHandler
	public void leaveMessage(PlayerQuitEvent e) {

		if(mainPacket.Configuracion.leaveMessage) {
			
			if(mainPacket.Configuracion.customLeaveMessage!=null) {
				e.setQuitMessage(mainPacket.Configuracion.customDeathMessage.replaceAll("%playername%", e.getPlayer().getName()));
			}
			
		} else {
			e.setQuitMessage(null);
		}
		
	}
	
}

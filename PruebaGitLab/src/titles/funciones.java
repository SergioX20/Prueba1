package titles;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class funciones {

	
	public static void enviarTitulo(String msg, Player p) {
		
		msg = msg.replaceAll("%playername%", p.getName());
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + msg + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(5, 20, 5);		     
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
		
	}
	
}

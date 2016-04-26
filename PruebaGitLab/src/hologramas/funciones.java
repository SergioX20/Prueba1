package hologramas;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class funciones {

	public static void createHologram(Player p, String myString) {
		
		Location location = p.getLocation();
        ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND); //Spawn the ArmorStand

        String textFinal = ChatColor.translateAlternateColorCodes('&',myString);

        as.setGravity(false); //Make sure it doesn't fall
        as.setCanPickupItems(false); //I'm not sure what happens if you leave this as it is, but you might as well disable it
        as.setCustomName(textFinal); //Set this to the text you want
        as.setCustomNameVisible(true); //This makes the text appear no matter if your looking at the entity or not
        as.setVisible(false); //Makes the ArmorStand invisible
        
	}
	
	
	@EventHandler
	public void manipulate(PlayerArmorStandManipulateEvent e)
	{
        if(!e.getRightClicked().isVisible())
        {
            e.setCancelled(true);
        }
	}
	
}

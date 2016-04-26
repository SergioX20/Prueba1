package mainPacket;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;



public class mainClass extends JavaPlugin implements Listener{
	
	private static Plugin plugin;

	@Override
	public void onEnable() {
		
		/* NO TOCAR */
		for (Team team : Bukkit.getScoreboardManager().getMainScoreboard().getTeams()){
			team.unregister();
		}
		
		/* NO TOCAR */
		plugin = this;
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Configuracion(), this);
		getServer().getPluginManager().registerEvents(new mensajes.editorDeMensajes(), this);
		
		/* CARGAR HOLOGRAMAS */
	}
	
	@Override
	public void onDisable() {
		
	}

	public static Plugin getInstance() {
		return plugin;
	}
	
	@EventHandler
	public void color(PlayerJoinEvent e) {
		teams.funciones.agregarTeam(e.getPlayer(), Configuracion.blueTeam, "Prefijo: ", ChatColor.BLUE);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(cmd.getName().equals("hologram")){

            if(sender instanceof Player){

                if(args.length != 0) {

                    Location location = ((Player) sender).getLocation();
                    ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND); //Spawn the ArmorStand


                    String myString = ""; //we're going to store the arguments here

                    String arg;
                    for(int i = 0; i < args.length; i++){ //loop threw all the arguments
                        if(i != args.length - 1) {
                            arg = args[i] + " "; //get the argument, and add a space so that the words get spaced out
                        }else{
                            arg = args[i]; //So there will be no space after last argument
                        }

                        myString = myString + arg; //add the argument to myString

                    }
                    String textFinal = ChatColor.translateAlternateColorCodes('&',myString);

                    as.setGravity(false); //Make sure it doesn't fall
                    as.setCanPickupItems(false); //I'm not sure what happens if you leave this as it is, but you might as well disable it
                    as.setCustomName(textFinal); //Set this to the text you want
                    as.setCustomNameVisible(true); //This makes the text appear no matter if your looking at the entity or not
                    as.setVisible(false); //Makes the ArmorStand invisible

                }else{

                    sender.sendMessage("No extra parameter set!");

                }

            }else{

                System.out.println("Only players can do this.");


            }

        }

        return false;
    }

}
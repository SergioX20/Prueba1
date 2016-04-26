package mainPacket;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Listener;


public class MapConfig implements Listener{

	public static Location CoordenadasLobby;
	
	public static int jugadoresMaximos, jugadoresMinimos, duracionSegundosPartida, distanciaProteccionSpawn, partidasAntesDelReinicio, mysqlPort,
	minecubosPremioPrimero, minecubosPremioSegundo, minecubosPremioTercero, minecubosPremiokill;
	public static String mysqlDatabase, mysqlHost, mysqlUsername, mysqlPassword;
	public static List<Location> locs = new ArrayList<>();
	public static List<Location> locs2 = new ArrayList<>();
	public static List<Location> locs3 = new ArrayList<>();
	public static List<Location> locs4 = new ArrayList<>();
    public static List<Location> respawn1Restantes = new ArrayList<>();
    public static List<Location> respawn2Restantes = new ArrayList<>();
    public static List<Location> respawn3Restantes = new ArrayList<>();
    public static List<Location> respawn4Restantes = new ArrayList<>();
	
	/**Metodo para cargar la configuración del fichero, si no existe se creará
	 * la carpeta y se copiará la plantilla**/
	public static void loadConfig(){
		mainClass.getInstance().getConfig().options().copyDefaults(true);
		mainClass.getInstance().saveConfig();
		
	    /* Mi edici§n empieza AQU§ (Todo el resto es de DarkMein) */
		// Le decimos a bukkit que el mundo es el Principal
		World mundo = Bukkit.getWorlds().get(0);
		
		// Variables Extraídas De La Configuración
		CoordenadasLobby = getLocation("CoordenadasLobby", mundo);
		jugadoresMinimos = mainClass.getInstance().getConfig().getInt("jugadoresMinimos");
		jugadoresMaximos = mainClass.getInstance().getConfig().getInt("jugadoresMaximos");
		distanciaProteccionSpawn = mainClass.getInstance().getConfig().getInt("distanciaProteccionSpawn");
		duracionSegundosPartida = mainClass.getInstance().getConfig().getInt("duracionSegundosPartida");
		partidasAntesDelReinicio = mainClass.getInstance().getConfig().getInt("partidasAntesDelReinicio");
		
		// Premios
		minecubosPremioPrimero = mainClass.getInstance().getConfig().getInt("minecubosPremioPrimero");
		minecubosPremioSegundo = mainClass.getInstance().getConfig().getInt("minecubosPremioSegundo");
		minecubosPremioTercero = mainClass.getInstance().getConfig().getInt("minecubosPremioTercero");
		minecubosPremiokill = mainClass.getInstance().getConfig().getInt("minecubosPremioKill");
		
		// Mysql
		mysqlPort = mainClass.getInstance().getConfig().getInt("Mysql.Puerto");
		mysqlDatabase = mainClass.getInstance().getConfig().getString("Mysql.Database");
		mysqlHost = mainClass.getInstance().getConfig().getString("Mysql.Host");
		mysqlUsername = mainClass.getInstance().getConfig().getString("Mysql.Username");
		mysqlPassword = mainClass.getInstance().getConfig().getString("Mysql.Password");
		
		// Cargamos las coords de los 4 mapas
		locs.clear();
		for (String str : mainClass.getInstance().getConfig().getStringList("Coords")){
			locs.add(getLocationFromString(str, mundo));
			respawn1Restantes.add(getLocationFromString(str, mundo));
		}
		
		locs2.clear();
		for (String str : mainClass.getInstance().getConfig().getStringList("Coords2")){
			locs2.add(getLocationFromString(str, mundo));
			respawn2Restantes.add(getLocationFromString(str, mundo));
		}
		
		locs3.clear();
		for (String str : mainClass.getInstance().getConfig().getStringList("Coords3")){
			locs3.add(getLocationFromString(str, mundo));
			respawn3Restantes.add(getLocationFromString(str, mundo));
		}
		
		locs4.clear();
		for (String str : mainClass.getInstance().getConfig().getStringList("Coords4")){
			locs4.add(getLocationFromString(str, mundo));
			respawn4Restantes.add(getLocationFromString(str, mundo));
		}
	    /* Mi edici§n termina AQU§ (Todo el resto es de DarkMein) */
	}
	
	public static void resetLocs(int i) {
		World mundo = Bukkit.getWorlds().get(0);
        if (i == 1) {
        	respawn1Restantes.clear();
           
            for (String str : mainClass.getInstance().getConfig().getStringList("Coords")){
    			respawn1Restantes.add(getLocationFromString(str, mundo));
    		}
            
        } else if (i == 2) {
        	respawn2Restantes.clear();
           
        	for (String str : mainClass.getInstance().getConfig().getStringList("Coords2")){
    			respawn2Restantes.add(getLocationFromString(str, mundo));
    		}
        	
        } else if (i == 3) {
        	respawn3Restantes.clear();
           
        	for (String str : mainClass.getInstance().getConfig().getStringList("Coords3")){
    			respawn3Restantes.add(getLocationFromString(str, mundo));
    		}
        	
        } else if (i == 4) {
        	respawn4Restantes.clear();
           
        	for (String str : mainClass.getInstance().getConfig().getStringList("Coords4")){
    			respawn4Restantes.add(getLocationFromString(str, mundo));
    			
    		}
        }
    }
	
	
	
	public static void añadirLocation(Location loc, String map){
		
		if(map.equalsIgnoreCase("MapaUno")) {
			locs.add(loc);
		} else if(map.equalsIgnoreCase("MapaDos")) {
			locs2.add(loc);
		}if(map.equalsIgnoreCase("MapaTres")) {
			locs3.add(loc);
		}if(map.equalsIgnoreCase("MapaCuatro")) {
			locs4.add(loc);
		}
		guardarArray(map);
	}
	
	
	public static void guardarArray(String map) {
		
		if(map.equalsIgnoreCase("MapaUno")) {
			List<String> listaaGuardar = new ArrayList<>();
			for (Location loc : locs) {
				listaaGuardar.add(convertLocationToString(loc));
			}
			mainClass.getInstance().getConfig().set("Coords", listaaGuardar);
		} else if(map.equalsIgnoreCase("MapaDos")) {
			List<String> listaaGuardar = new ArrayList<>();
			for (Location loc : locs2) {
				listaaGuardar.add(convertLocationToString(loc));
			}
			mainClass.getInstance().getConfig().set("Coords2", listaaGuardar);
		} else if(map.equalsIgnoreCase("MapaTres")) {
			List<String> listaaGuardar = new ArrayList<>();
			for (Location loc : locs3) {
				listaaGuardar.add(convertLocationToString(loc));
			}
			mainClass.getInstance().getConfig().set("Coords3", listaaGuardar);
		} else if(map.equalsIgnoreCase("MapaCuatro")) {
			List<String> listaaGuardar = new ArrayList<>();
			for (Location loc : locs4) {
				listaaGuardar.add(convertLocationToString(loc));
			}
			mainClass.getInstance().getConfig().set("Coords4", listaaGuardar);
		}
		
		
		
	}
	
	
	/**Procesa una location guardada en formato texto y devuelve una Location*/
	public static Location getLocationFromString(String locString, World world){
		double x, y, z; // 0,0,0,0,0
		float yaw = 0, pitch = 0;
		String coords[] = locString.split(", ");
		
		x = Double.parseDouble(coords[0]);
		y = Double.parseDouble(coords[1]);
		z = Double.parseDouble(coords[2]);
		
		if (coords.length > 3){
			yaw = Float.parseFloat(coords[3]);
			pitch = Float.parseFloat(coords[4]);
		}
		return new Location(world, x, y, z, yaw, pitch);
	}
	
	/**Extrae una unica Location de la config especificandole la ruta*/
	public static Location getLocation(String ruta, World world){
		double x = 0, y = 0, z = 0;
		float yaw = 0, pitch = 0;
		System.out.println(ruta);
		System.out.println(mainClass.getInstance().getConfig().getString(ruta));
		
		String[] coords = mainClass.getInstance().getConfig().getString(ruta).split(", ");
		
		x = Double.parseDouble(coords[0]);
		y = Double.parseDouble(coords[1]);
		z = Double.parseDouble(coords[2]);
		
		if (coords.length > 3){
			yaw = Float.parseFloat(coords[3]);
			pitch = Float.parseFloat(coords[4]);
		}
		return new Location(world, x, y, z, yaw, pitch);
	}
	
	/**Guarda una location en la configuración*/
	public static void saveLocation(Location loc, String ruta){
		mainClass.getInstance().getConfig().set(ruta, convertLocationToString(loc));
		mainClass.getInstance().saveConfig();
	}
	
	/**Convierte una location en un String para ser guardado en la configuración*/
	public static String convertLocationToString(Location loc){
		String locString = loc.getX() + ", " + loc.getY() + ", " + loc.getZ() + ", " + loc.getYaw() + ", " + loc.getPitch();
		return locString;
	}
}

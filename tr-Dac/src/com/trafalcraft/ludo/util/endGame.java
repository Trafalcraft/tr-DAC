package com.trafalcraft.ludo.util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.trafalcraft.ludo.mainClasse;

public class endGame {

	static JavaPlugin plugin = mainClasse.plugin;
    public static int task;
    public static int temps = 20;
	public static ArrayList <Player> playerKickList = new ArrayList<Player>();

	public static boolean endGame(){
		temps = 5;
    	playerKickList.addAll(Bukkit.getOnlinePlayers());
		temps = Bukkit.getOnlinePlayers().size()+temps;
        task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            
            private int List;
            private int OnlinePlayers = Bukkit.getOnlinePlayers().size();

			public void run() {
                if(temps == 0){
                	Bukkit.shutdown();
                    Bukkit.getServer().getScheduler().cancelTask(task);
                }
            	if(temps <= OnlinePlayers)
                    {
                       	if(playerKickList.get(List) != null && playerKickList.size()<=OnlinePlayers){
                       		BungeeCoord.sendPlayerToHub(playerKickList.get(List));

                       	}
                   		List = List+1;
                   		Bukkit.getLogger().warning(temps+"");
                       	                          	
                    	
                    	

                    }else{
                    	//plus tard les fusée
                    }
               
	            	temps = temps-1;
            }
            },0, 20);
		return false;
	}
	  
	  
}

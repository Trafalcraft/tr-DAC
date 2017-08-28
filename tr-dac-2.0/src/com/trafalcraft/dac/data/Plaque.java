package com.trafalcraft.dac.data;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import com.trafalcraft.dac.Main;
import com.trafalcraft.dac.file.FileControler;

public class Plaque {

	int temps;
	int taskPlaque;
	String arene;
	
	public Plaque(String arene){
		
		this.arene = arene;
		
		for(int i1 = 0; FileControler.getArena(arene).getInt("pos1.x") + i1 <= FileControler.getArena(arene).getInt("pos2.x") ; i1++){
			for(int i3 = 0; FileControler.getArena(arene).getInt("pos1.z") + i3 <= FileControler.getArena(arene).getInt("pos2.z") ; i3++){
					
				Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getInt("pos1.x") + i1, FileControler.getArena(arene).getInt("pos2.y") + 1, FileControler.getArena(arene).getInt("pos1.z") + i3);
				loc.getBlock().setType(Material.STONE);
				
			}
		}
		
		this.startLobbyTimer();
	}
	
	public void startLobbyTimer(){
		this.temps = 5;
		this.taskPlaque = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            
			public void run() {
            	
                   		if(temps == 0){
                   			resetPlaque();
                   			Bukkit.getServer().getScheduler().cancelTask(taskPlaque);
                   		}
            	temps = temps-1;
            }
         }, 0, 20);
	}
	
	private void resetPlaque(){
		
		for(int i1 = 0; FileControler.getArena(arene).getInt("pos1.x") + i1 <= FileControler.getArena(arene).getInt("pos2.x") ; i1++){
			for(int i3 = 0; FileControler.getArena(arene).getInt("pos1.z") + i3 <= FileControler.getArena(arene).getInt("pos2.z") ; i3++){
					
				Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getInt("pos1.x") + i1, FileControler.getArena(arene).getInt("pos2.y") + 1, FileControler.getArena(arene).getInt("pos1.z") + i3);
				loc.getBlock().setType(Material.AIR);
				
			}
		}
	}
}

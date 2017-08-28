package com.trafalcraft.dac;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import com.trafalcraft.dac.file.FileControler;

public class TestFull {

	public static boolean test(String arene){
		
		boolean full = true;
		
		for(int i1 = 0; FileControler.getArena(arene).getInt("pos1.x") + i1 <= FileControler.getArena(arene).getInt("pos2.x") ; i1++){
			for(int i2 = 0; FileControler.getArena(arene).getInt("pos1.y") + i2 <= FileControler.getArena(arene).getInt("pos2.y") ; i2++){
				for(int i3 = 0; FileControler.getArena(arene).getInt("pos1.z") + i3 <= FileControler.getArena(arene).getInt("pos2.z") ; i3++){
					
					Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getInt("pos1.x") + i1, FileControler.getArena(arene).getInt("pos1.y") + i2, FileControler.getArena(arene).getInt("pos1.z") + i3);
					
					if(loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.WATER_LILY || loc.getBlock().getType() == Material.STATIONARY_WATER){
						full = false;
					}
					
					if(full == false){
						break;
					}
				}
				
				if(full == false){
					break;
				}
			}
			
			if(full == false){
				break;
			}
		}
		
		return full;
		
	}
}

package com.trafalcraft.dac;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import com.trafalcraft.dac.file.FileControler;

public class Regen {

	public static void classic(String arene){
		
		for(int i1 = 0; FileControler.getArena(arene).getInt("pos1.x") + i1 <= FileControler.getArena(arene).getInt("pos2.x") ; i1++){
			for(int i2 = 0; FileControler.getArena(arene).getInt("pos1.y") + i2 <= FileControler.getArena(arene).getInt("pos2.y") ; i2++){
				for(int i3 = 0; FileControler.getArena(arene).getInt("pos1.z") + i3 <= FileControler.getArena(arene).getInt("pos2.z") ; i3++){
					
					Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getInt("pos1.x") + i1, FileControler.getArena(arene).getInt("pos1.y") + i2, FileControler.getArena(arene).getInt("pos1.z") + i3);
					
					if(loc.getBlock().getType() == Material.WOOL || loc.getBlock().getType() == Material.GLASS){
						loc.getBlock().setType(Material.WATER);
					}
				}
			}
		}
	
	}
}

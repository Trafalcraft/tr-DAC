package com.trafalcraft.dac;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import com.trafalcraft.dac.file.FileControler;

public class Alldac {

	public static void set(String arene){
		int i4 = 0;
		
		
		for(int i3 = 0; FileControler.getArena(arene).getInt("pos1.z") + i3 <=  FileControler.getArena(arene).getInt("pos2.z"); i3++){
			for(int i2 = 0; (FileControler.getArena(arene).getInt("pos1.x") + i2 + i4) <= FileControler.getArena(arene).getInt("pos2.x"); i2 = i2+2){
				for(int i = 0; (FileControler.getArena(arene).getInt("pos1.y") + i) <= FileControler.getArena(arene).getInt("pos2.y") ; i++){
					Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getInt("pos1.x") + i2 + i4, (FileControler.getArena(arene).getInt("pos1.y") + i), FileControler.getArena(arene).getInt("pos1.z") + i3);
					loc.getBlock().setType(Material.GLASS);
				}
			}
			
			if(i4 == 0){
				i4 = 1;
			}else{
				i4 = 0;
			}
		}
	}
}

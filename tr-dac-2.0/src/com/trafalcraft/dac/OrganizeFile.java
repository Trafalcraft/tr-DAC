package com.trafalcraft.dac;

import com.trafalcraft.dac.file.FileControler;

public class OrganizeFile {
	public static void organize(String arene){
		
		if(FileControler.getArena(arene).getDouble("pos1.x") > FileControler.getArena(arene).getDouble("pos2.x")){
			
			Double save = FileControler.getArena(arene).getDouble("pos1.x");
			FileControler.getArena(arene).set("pos1.x",  FileControler.getArena(arene).getDouble("pos2.x"));
			FileControler.getArena(arene).set("pos2.x",  save);
			FileControler.saveArena(arene);
			
		}
		
		if(FileControler.getArena(arene).getDouble("pos1.y") > FileControler.getArena(arene).getDouble("pos2.y")){
			
			Double save = FileControler.getArena(arene).getDouble("pos1.y");
			FileControler.getArena(arene).set("pos1.y",  FileControler.getArena(arene).getDouble("pos2.y"));
			FileControler.getArena(arene).set("pos2.y",  save);
			FileControler.saveArena(arene);
			
		}	
		
		if(FileControler.getArena(arene).getDouble("pos1.z") > FileControler.getArena(arene).getDouble("pos2.z")){
			
			Double save = FileControler.getArena(arene).getDouble("pos1.z");
			FileControler.getArena(arene).set("pos1.z",  FileControler.getArena(arene).getDouble("pos2.z"));
			FileControler.getArena(arene).set("pos2.z",  save);
			FileControler.saveArena(arene);
			
		}
	}
}

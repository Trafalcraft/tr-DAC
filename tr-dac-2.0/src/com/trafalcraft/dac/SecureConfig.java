package com.trafalcraft.dac;

import com.trafalcraft.dac.file.FileControler;

public class SecureConfig {

	public static boolean testConfig(String arene){
		
		if(FileControler.getArena(arene).contains("world") && FileControler.getArena(arene).getString("world") != null){
			if(FileControler.getArena(arene).contains("maxplayer") && FileControler.getArena(arene).getString("maxplayer") != null){
				if(FileControler.getArena(arene).contains("lobby.x") && FileControler.getArena(arene).getString("lobby.x") != null){
					if(FileControler.getArena(arene).contains("maxpoint") && FileControler.getArena(arene).getString("maxpoint") != null){
						if(FileControler.getArena(arene).contains("eventlobby.x") && FileControler.getArena(arene).getString("eventlobby.x") != null){
							if(FileControler.getArena(arene).contains("plongeoir.x") && FileControler.getArena(arene).getString("plongeoir.x") != null){
								if(FileControler.getArena(arene).contains("pos1.x") && FileControler.getArena(arene).getString("pos1.x") != null){
									if(FileControler.getArena(arene).contains("pos2.x") && FileControler.getArena(arene).getString("pos2.x") != null){
										if(FileControler.getArena(arene).contains("mode") && FileControler.getArena(arene).getString("mode") != null){
											return true;
										}else{
											return false;
										}
									}else{
										return false;
									}
								}else{
									return false;
								}
							}else{
								return false;
							}
						}else{
							return false;
						}			
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}

package com.trafalcraft.dac;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.inventivetalent.bossbar.BossBarAPI;

import com.trafalcraft.dac.Controler.ArenaControle;
import com.trafalcraft.dac.Controler.PlayerControle;
import com.trafalcraft.dac.texte.Msg;

public class Quite {
	public static void leave(Player p){
		
		if(PlayerControle.contains(p.getName())){
			
			String arene = PlayerControle.getJoueur(p.getName()).getArene();
			BossBarAPI.removeAllBars(p);
			p.setDisplayName(p.getName());
			p.getInventory().clear();
			
			if(ArenaControle.getArena(arene).getStatus().equalsIgnoreCase("in-game")){
			
				ArenaControle.getArena(arene).removePlayer(Bukkit.getPlayer(p.getName()));
				PlayerControle.removePlayer(p.getName());
				
				if(ArenaControle.getArena(arene).getEnCour().getPlayer() == p){
					ArenaControle.getArena(arene).getEnCour().stopTourTimer();
					ArenaControle.getArena(arene).setEnCour(null);
					
					if(ArenaControle.getArena(arene).getPlayerList().size() >= 2){
						ArenaControle.getArena(arene).WhoWin();
					}
				}
				
				if(ArenaControle.getArena(arene).getPlayerList().size() == 1){
					for(Player pl : ArenaControle.getArena(arene).getPlayerList()){
						
	       				pl.sendMessage(Msg.Prefix.toString() + Msg.leave_win.toString());
	       			}
					
					if(ArenaControle.getArena(arene).getEnCour() != null){
						ArenaControle.getArena(arene).getEnCour().stopTourTimer();
						ArenaControle.getArena(arene).setEnCour(null);
					}
					
					ArenaControle.getArena(arene).WhoWin();
					ArenaControle.getArena(arene).setStatus("end");
					
				}else if(ArenaControle.getArena(arene).getPlayerList().size() == 0){
					if(ArenaControle.getArena(arene).getTaskFinish() == 0){
						ArenaControle.getArena(arene).StopFinishTimer();
						ArenaControle.getArena(arene).finGame();
					}
				}else{
					ArenaControle.getArena(arene).getScoreBoard().clearScoreBoard();
					ArenaControle.getArena(arene).getScoreBoard().addScoreBoard(arene);
				}
			}else{
				ArenaControle.getArena(arene).removePlayer(Bukkit.getPlayer(p.getName()));
				PlayerControle.removePlayer(p.getName());
			}
		}
	}
}

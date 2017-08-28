package com.trafalcraft.dac.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.trafalcraft.dac.Controler.ArenaControle;
import com.trafalcraft.dac.Controler.PlayerControle;
import com.trafalcraft.dac.file.FileControler;

public class ScoreBoard {
	private static ScoreboardManager manager = Bukkit.getScoreboardManager();
	private Scoreboard Board;
	private Objective o;
	
	public ScoreBoard(String aname){
		addScoreBoard(aname);
	}

	
	public void addScoreBoard(String aname) {
		this.Board = manager.getNewScoreboard();
		this.o = Board.registerNewObjective("Nom", "vie");
		this.sendScoreBoard(aname);
	}
	
	
	private void sendScoreBoard(String aname){
		this.o.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		if(FileControler.getArena(aname).getString("mode").equalsIgnoreCase("basic")){
			this.o.setDisplayName("§3§l" + "vies restantes");
		}else{
			this.o.setDisplayName("§3§l" + "points");
		}
		for(Player allp : ArenaControle.getArena(aname).getPlayerList()){
			this.o.getScore(allp.getName()).setScore(0);
		}
		
		for(Player allp : ArenaControle.getArena(aname).getPlayerList()){
			allp.setScoreboard(Board);
		}
		
		updateScore(aname);
		
		
	}
	
	
	public void updateScore(String arene){
		if(FileControler.getArena(arene).getString("mode").equalsIgnoreCase("basic")){
			for(Player p : ArenaControle.getArena(arene).getPlayerList()){
				this.o.getScore(p.getName()).setScore(PlayerControle.getJoueur(p.getName()).getNbrVie());
			}
		}else{
			for(Player p : ArenaControle.getArena(arene).getPlayerList()){
				this.o.getScore(p.getName()).setScore(PlayerControle.getJoueur(p.getName()).getNbrPoint());
			}
		}
	}
	
	
	public void clearScoreBoard(){
		this.Board.clearSlot(DisplaySlot.SIDEBAR);
		this.o.unregister();
	}
}

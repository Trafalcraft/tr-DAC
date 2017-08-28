package com.trafalcraft.dac.data;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.inventivetalent.bossbar.BossBarAPI;
import org.inventivetalent.bossbar.BossBarAPI.Color;
import org.inventivetalent.bossbar.BossBarAPI.Property;
import org.inventivetalent.bossbar.BossBarAPI.Style;

import com.trafalcraft.dac.Main;
import com.trafalcraft.dac.Controler.ArenaControle;
import com.trafalcraft.dac.Controler.PlayerControle;
import com.trafalcraft.dac.file.FileControler;
import com.trafalcraft.dac.texte.Msg;

import net.md_5.bungee.api.chat.TextComponent;

public class Tour {
	private String arene;
	private Player player;
	int temps = 60;
	int taskTour;
	Location l;
	
	public Tour(String a, Player p, Location loc2){
		this.arene = a;
		this.player = p;
		this.l =loc2;
		
		for(Player pl : ArenaControle.getArena(arene).getPlayerList()){

			BossBarAPI.removeAllBars(pl);
			BossBarAPI.addBar(pl, new TextComponent("§b" + Msg.tour.toString().replace("#name", p.getName())), Color.BLUE, Style.PROGRESS, 1.0f, 1200, 1, Property.PLAY_MUSIC);
		}
		
		PlayerControle.getJoueur(player.getName()).setNbrSaut(PlayerControle.getJoueur(player.getName()).getNbrSaut() + 1);
		Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getDouble("plongeoir.x"), FileControler.getArena(arene).getDouble("plongeoir.y"), FileControler.getArena(arene).getDouble("plongeoir.z"), (float)FileControler.getArena(arene).getDouble("plongeoir.yaw"), (float)FileControler.getArena(arene).getDouble("plongeoir.pitch"));
		player.teleport(loc);
		p.setGameMode(GameMode.SURVIVAL);
		
		startTourTimer();
	}
	
	public void startTourTimer(){

		taskTour = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            
			public void run() {
            	
                   		if(temps == 30||temps == 20||temps == 10||(temps <= 5&&temps>0)){
               			
                   				player.sendMessage(Msg.Prefix.toString() + Msg.temps_restant.toString().replace("#temps", temps + ""));
                   				player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                   		}else if(temps <= 0){
                   			
                   			if(FileControler.getArena(arene).getString("mode").equalsIgnoreCase("basic")){
                   				PlayerControle.getJoueur(player.getName()).setNbrVie(PlayerControle.getJoueur(player.getName()).getNbrVie() - 1);
                   			}
                   			
                   			//Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getDouble("lobby.x"), FileControler.getArena(arene).getDouble("lobby.y"), FileControler.getArena(arene).getDouble("lobby.z"), (float)FileControler.getArena(arene).getDouble("lobby.yaw"), (float)FileControler.getArena(arene).getDouble("lobby.pitch"));
                   			player.teleport(l);
                   			
                   			for(Player pl : ArenaControle.getArena(arene).getPlayerList()){
                   				pl.sendMessage(Msg.Prefix.toString() + Msg.trop_attendu.toString().replace("#name", player.getName()));                   				
                   			}
                   			
                   			ArenaControle.getArena(arene).setEnCour(null);
                   			ArenaControle.getArena(arene).WhoWin();
                   			stopTourTimer();
               				
                   		}
            	temps = temps-1;
            }
         }, 0, 20);
	}
	
	public void stopTourTimer(){
		Bukkit.getServer().getScheduler().cancelTask(this.taskTour);
	}
	
	public Location getLoc(){
		return l;
	}
	
	public Player getPlayer(){
		return this.player;
	}
}

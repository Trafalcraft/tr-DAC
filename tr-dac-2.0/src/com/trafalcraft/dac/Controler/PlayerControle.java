package com.trafalcraft.dac.Controler;

import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.inventivetalent.bossbar.BossBarAPI;

import com.google.common.collect.Maps;
import com.trafalcraft.dac.data.Joueur;
import com.trafalcraft.dac.file.FileControler;
import com.trafalcraft.dac.texte.Msg;

import net.md_5.bungee.api.chat.TextComponent;

public class PlayerControle extends org.inventivetalent.bossbar.BossBarAPI{
	private final static Map<String, Joueur> inGamePlayers = Maps.newHashMap();
	
	public static void addPlayer(String name, String aname){
		if(!inGamePlayers.containsKey(name)){
			if(ArenaControle.contains(aname)){
				if(ArenaControle.getArena(aname).getStatus().equalsIgnoreCase("lobby")){
						if(ArenaControle.getArena(aname).getPlayerList().size() < FileControler.getArena(aname).getInt("maxplayer") && ArenaControle.getArena(aname).getPlayerList().size() < 16){
						
						
							Joueur player = new Joueur(Bukkit.getPlayer(name), "defaut", aname);
							inGamePlayers.put(name, player);
							ArenaControle.getArena(aname).addPlayer(Bukkit.getPlayer(name));
						
							Location loc = new Location(Bukkit.getWorld(FileControler.getArena(aname).getString("world")),FileControler.getArena(aname).getDouble("lobby.x"),FileControler.getArena(aname).getDouble("lobby.y"),FileControler.getArena(aname).getDouble("lobby.z"),(float)FileControler.getArena(aname).getDouble("lobby.yaw"),(float)FileControler.getArena(aname).getDouble("lobby.pitch"));
							Bukkit.getPlayer(name).teleport(loc);
							Bukkit.getPlayer(name).setHealth(20);
							Bukkit.getPlayer(name).setFoodLevel(20);
							Bukkit.getPlayer(name).setSaturation(20);
							Bukkit.getPlayer(name).getInventory().clear();
							Bukkit.getPlayer(name).setGameMode(GameMode.SURVIVAL);
							
							ItemStack i = new ItemStack(Material.CHEST);
							ItemMeta meta = i.getItemMeta();
							meta.setDisplayName("§b" +  "couleur");
							i.setItemMeta(meta);
							
							Bukkit.getPlayer(name).getInventory().setItem(0, i);
							
							if(ArenaControle.getArena(aname).getPlayerList().size() == 1){
								
								BossBarAPI.removeAllBars(Bukkit.getPlayer(name));
								BossBarAPI.addBar(Bukkit.getPlayer(name), new TextComponent("§b" + "dé à coudre"), Color.BLUE, Style.PROGRESS, 1.0f);
							
							}else{
								
								BossBarAPI.removeAllBars(Bukkit.getPlayer(name));
								BossBarAPI.addBar(Bukkit.getPlayer(name), new TextComponent("§b" + "dé à coudre"), Color.BLUE, Style.PROGRESS, (float)1, 20*ArenaControle.getArena(aname).getTemps(), 1, Property.PLAY_MUSIC);
								
							}
							
							for(Player p : ArenaControle.getArena(aname).getPlayerList()){
								p.sendMessage(Msg.Prefix.toString() + Msg.join.toString().replace("#name", name) + " (" + ArenaControle.getArena(aname).getPlayerList().size() + "/" + FileControler.getArena(aname).getInt("maxplayer") + ")");
							}
						
						}else{
							Bukkit.getPlayer(name).sendMessage(Msg.Prefix.toString() + Msg.party_full.toString());
						}
				}else{
					Bukkit.getPlayer(name).sendMessage(Msg.Prefix.toString() + Msg.party_deja_en_cour.toString());
				}
			}else{
				Bukkit.getPlayer(name).sendMessage(Msg.Prefix.toString() + Msg.Arene_Inexistante.toString());
			}
		}else{
			Bukkit.getPlayer(name).sendMessage(Msg.Prefix.toString() + Msg.deja_dans_une_arene.toString());
		}
	}
	
	public static void removePlayer(String name){
			inGamePlayers.remove(name);
	}
	
	public static Joueur getJoueur(String s){
		return inGamePlayers.get(s);
	}
	
	public static boolean contains(String s){
		if(inGamePlayers.containsKey(s)){
			return true;
		}else{
			return false;
		}
	}
	
	public static Set<String> getList(){
		return inGamePlayers.keySet();
	}
}

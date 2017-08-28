package com.trafalcraft.dac.pannel;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.trafalcraft.dac.Alldac;
import com.trafalcraft.dac.Controler.ArenaControle;
import com.trafalcraft.dac.block.InventoryClick;
import com.trafalcraft.dac.data.Plaque;
import com.trafalcraft.dac.file.FileControler;
import com.trafalcraft.dac.texte.Msg;

public class InventoryClickListener implements Listener {
	
	@EventHandler
	public void onPlayerClickInventoryEvent(InventoryClickEvent e){
		if(e.getCurrentItem() != null && e.getCurrentItem().getType()  != Material.AIR){
			if(e.getInventory().getName().contains(";")){
				
				if(e.getInventory().getName().split(";")[2].equalsIgnoreCase("dac")){
					if(e.getCurrentItem().getType() != Material.AIR){
						if(e.getInventory().getName().split(";")[1].equalsIgnoreCase("block")){
							if(e.getCurrentItem().getType() != Material.AIR){
								
								InventoryClick.clicInventory((Player) e.getWhoClicked(), e.getCurrentItem().getDurability());
							}
						}else if(e.getInventory().getName().split(";")[1].equalsIgnoreCase("arenalist")){
							if(e.getCurrentItem().getType() != Material.AIR){
								
								e.getWhoClicked().closeInventory();
								CreateOptionInventory.loadInventoryOption((Player)e.getWhoClicked(), e.getCurrentItem().getItemMeta().getDisplayName());
								
							}
						}else if(e.getInventory().getName().contains(";")){
							if(e.getInventory().getName().split(";")[1].equalsIgnoreCase("optionlist")){
								
								if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("teleportation")){
									
									e.getWhoClicked().closeInventory();
									CreateTeleportationInventory.loadInventoryteleportation((Player) e.getWhoClicked(), e.getInventory().getName().split(";")[0]);
								
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("information")){
									
									e.getWhoClicked().closeInventory();
									CreateInfoInventory.loadInventoryInfo((Player) e.getWhoClicked(), e.getInventory().getName().split(";")[0]);
									
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("action")){
									
									if(ArenaControle.contains(e.getInventory().getName().split(";")[0])){
										if(ArenaControle.getArena(e.getInventory().getName().split(";")[0]).getStatus().equalsIgnoreCase("in-game")){
											
											e.getWhoClicked().closeInventory();
										CreateInventoryAction.loadInventoryInfo((Player) e.getWhoClicked(), e.getInventory().getName().split(";")[0]);
											
										}else{
											e.getWhoClicked().sendMessage(Msg.Prefix.toString() + Msg.pannel_action.toString());
											e.getWhoClicked().closeInventory();
										}
									}else{
										e.getWhoClicked().sendMessage(Msg.Prefix.toString() + Msg.pannel_action.toString());
										e.getWhoClicked().closeInventory();
									}
									
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("back")){
									
									e.getWhoClicked().closeInventory();
									CreateAreneList.loadInventoryArena((Player) e.getWhoClicked());
								}
							
							}else if(e.getInventory().getName().split(";")[1].equalsIgnoreCase("tpInventory")){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("pos1")){
								
									Location loc = new Location(Bukkit.getWorld(FileControler.getArena(e.getInventory().getName().split(";")[0]).getString("world")), FileControler.getArena(e.getInventory().getName().split(";")[0]).getInt("pos1.x"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getInt("pos1.y"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getInt("pos1.z"));
									e.getWhoClicked().teleport(loc);
									
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("pos2")){
									
									Location loc = new Location(Bukkit.getWorld(FileControler.getArena(e.getInventory().getName().split(";")[0]).getString("world")), FileControler.getArena(e.getInventory().getName().split(";")[0]).getInt("pos2.x"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getInt("pos2.y"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getInt("pos2.z"));
									e.getWhoClicked().teleport(loc);
									
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("plongeoir")){
									
									Location loc = new Location(Bukkit.getWorld(FileControler.getArena(e.getInventory().getName().split(";")[0]).getString("world")), FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("plongeoir.x"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("plongeoir.y"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("plongeoir.z"), (float)FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("plongeoir.yaw"), (float)FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("plongeoir.pitch"));
									e.getWhoClicked().teleport(loc);
									
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("lobby")){
									
									Location loc = new Location(Bukkit.getWorld(FileControler.getArena(e.getInventory().getName().split(";")[0]).getString("world")), FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("lobby.x"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("lobby.y"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("lobby.z"), (float)FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("lobby.yaw"), (float)FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("lobby.pitch"));
									e.getWhoClicked().teleport(loc);
									
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("lobby event")){
									
									Location loc = new Location(Bukkit.getWorld(FileControler.getArena(e.getInventory().getName().split(";")[0]).getString("world")), FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("eventlobby.x"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("eventlobby.y"), FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("eventlobby.z"), (float)FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("eventlobby.yaw"), (float)FileControler.getArena(e.getInventory().getName().split(";")[0]).getDouble("eventlobby.pitch"));
									e.getWhoClicked().teleport(loc);
									
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("back")){
									
									e.getWhoClicked().closeInventory();
									CreateOptionInventory.loadInventoryOption((Player)e.getWhoClicked(), e.getInventory().getName().split(";")[0]);
									
								}
								
							}else if(e.getInventory().getName().split(";")[1].equalsIgnoreCase("infoInventory")){
								
								if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("back")){
									
									e.getWhoClicked().closeInventory();
									CreateOptionInventory.loadInventoryOption((Player)e.getWhoClicked(), e.getInventory().getName().split(";")[0]);
									
								}else{
									e.setCancelled(true);
								}
								
							}else if(e.getInventory().getName().split(";")[1].equalsIgnoreCase("actionInventory")){
								
								if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("back")){
									
									e.getWhoClicked().closeInventory();
									CreateOptionInventory.loadInventoryOption((Player)e.getWhoClicked(), e.getInventory().getName().split(";")[0]);
									
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("tour suivant")){
									if(ArenaControle.getArena(e.getInventory().getName().split(";")[0]).getStatus().equalsIgnoreCase("in-game")){
										
										String arene = e.getInventory().getName().split(";")[0];
										
										Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getDouble("lobby.x"), FileControler.getArena(arene).getDouble("lobby.y"), FileControler.getArena(arene).getDouble("lobby.z"), (float)FileControler.getArena(arene).getDouble("lobby.yaw"), (float)FileControler.getArena(arene).getDouble("lobby.pitch"));
			                   			ArenaControle.getArena(arene).getEnCour().getPlayer().teleport(loc);
			                   			
			                   			for(Player pl : ArenaControle.getArena(arene).getPlayerList()){
			                   				pl.sendMessage("§3§lDAC> §b" + e.getWhoClicked().getName() + " a fait passer le tour de " + ArenaControle.getArena(arene).getEnCour().getPlayer().getName());                   				
			                   			}
										
										ArenaControle.getArena(e.getInventory().getName().split(";")[0]).getEnCour().stopTourTimer();
										ArenaControle.getArena(e.getInventory().getName().split(";")[0]).setEnCour(null);
										ArenaControle.getArena(e.getInventory().getName().split(";")[0]).WhoWin();
										
										e.getWhoClicked().closeInventory();
										
									}else{
										e.getWhoClicked().sendMessage(Msg.Prefix.toString() + Msg.pannel_action.toString());
									}
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("stone plaque")){
									Plaque plaque = new Plaque(e.getInventory().getName().split(";")[0]);
									e.getWhoClicked().closeInventory();
								}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("all dac")){
									
									Alldac.set(e.getInventory().getName().split(";")[0]);
									e.getWhoClicked().closeInventory();
								}
							}
						}
					}else{
						e.setCancelled(true);
					}
				}else{
					e.setCancelled(true);
				}
			}
		}
	}
}

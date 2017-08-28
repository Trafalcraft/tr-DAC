package com.trafalcraft.dac;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import com.trafalcraft.dac.Controler.ArenaControle;
import com.trafalcraft.dac.Controler.PlayerControle;
import com.trafalcraft.dac.block.CreateInventory;
import com.trafalcraft.dac.block.SetBlock;
import com.trafalcraft.dac.data.Conteur;
import com.trafalcraft.dac.file.FileControler;
import com.trafalcraft.dac.texte.Msg;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerSendMessageEvent(AsyncPlayerChatEvent e){
		if(PlayerControle.contains(e.getPlayer().getName())){
			String Message = e.getMessage();
			e.setCancelled(true);
	
			Message = (Msg.Prefix.toString() + "§6" + e.getPlayer().getDisplayName() + ">> " + Message);
			Bukkit.getServer().broadcastMessage(Message);
		}
	}
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e){
		if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR|| e.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			if(e.getPlayer().getItemInHand().getType() == Material.CHEST){
				
				if(PlayerControle.contains(e.getPlayer().getName())){
					
					if(ArenaControle.getArena(PlayerControle.getJoueur(e.getPlayer().getName()).getArene()).getStatus().equalsIgnoreCase("lobby")){
						
						e.getPlayer().openInventory(CreateInventory.craftInventory(e.getPlayer()));
					}
				}
			}
		}
	}

	@EventHandler
	public void onEntityDamageEvent(EntityDamageEvent e){
		if(PlayerControle.contains(((Player)e.getEntity()).getName())){
			if(e.getCause() == DamageCause.FALL){
				if(e.getEntity().getType() == EntityType.PLAYER){
					
						
						String arene = PlayerControle.getJoueur(((Player)e.getEntity()).getName()).getArene();
						
						if(ArenaControle.getArena(arene).getEnCour() != null){
							if(((Player)e.getEntity()).getName().equalsIgnoreCase(ArenaControle.getArena(arene).getEnCour().getPlayer().getName())){
								
								e.setCancelled(true);
								
								if(FileControler.getArena(arene).getString("mode").equalsIgnoreCase("basic")){
								
									PlayerControle.getJoueur(((Player)e.getEntity()).getName()).setNbrVie(PlayerControle.getJoueur(((Player)e.getEntity()).getName()).getNbrVie() - 1);
									PlayerControle.getJoueur(((Player)e.getEntity()).getName()).setNbrMort(PlayerControle.getJoueur(((Player)e.getEntity()).getName()).getNbrMort() + 1);
								}
								
								//Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getDouble("lobby.x"), FileControler.getArena(arene).getDouble("lobby.y"), FileControler.getArena(arene).getDouble("lobby.z"), (float)FileControler.getArena(arene).getDouble("lobby.yaw"), (float)FileControler.getArena(arene).getDouble("lobby.pitch"));
	                   			((Player)e.getEntity()).teleport(ArenaControle.getArena(arene).getEnCour().getLoc());
	                   			
	                   			for(Player pl : ArenaControle.getArena(arene).getPlayerList()){
	                   				pl.sendMessage(Msg.Prefix.toString() + Msg.saut_rater.toString().replace("#name", ((Player)e.getEntity()).getName()));
	                   				pl.playSound(pl.getLocation(), Sound.ENTITY_HORSE_DEATH, 100.0F, 100.0F);
	                   			}
	                   			
	                   			ArenaControle.getArena(arene).getEnCour().stopTourTimer();
	                   			ArenaControle.getArena(arene).setEnCour(null);
	                   			ArenaControle.getArena(arene).WhoWin();
	                   			
							}else{
								e.setCancelled(true);
							}
					}else{
						e.setCancelled(true);
					}
				}else{
					e.setCancelled(true);
				}
			}else{
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent e){
		
		if(PlayerControle.contains(e.getPlayer().getName())){
			
			String arene = PlayerControle.getJoueur(e.getPlayer().getName()).getArene();
			
			if(ArenaControle.getArena(arene).getEnCour() != null){
				
				if(e.getPlayer().getName().equalsIgnoreCase(ArenaControle.getArena(arene).getEnCour().getPlayer().getName())){
					
					if(e.getPlayer().getLocation().getBlockX() >= FileControler.getArena(arene).getInt("pos1.x") && e.getPlayer().getLocation().getBlockX() <= FileControler.getArena(arene).getInt("pos2.x")){
						
						if(e.getPlayer().getLocation().getBlockY() >= FileControler.getArena(arene).getInt("pos1.Y") && e.getPlayer().getLocation().getY() <= (FileControler.getArena(arene).getInt("pos2.y") + 0.5)){
							
							if(e.getPlayer().getLocation().getBlockZ() >= FileControler.getArena(arene).getInt("pos1.z") && e.getPlayer().getLocation().getBlockZ() <= FileControler.getArena(arene).getInt("pos2.z")){
								
								if(e.getPlayer().getLocation().getBlock().getRelative(BlockFace.NORTH).getType() != Material.WATER && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.NORTH).getType() != Material.STATIONARY_WATER && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.NORTH).getType() != Material.WATER_LILY && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.SOUTH).getType() != Material.WATER && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.SOUTH).getType() != Material.STATIONARY_WATER && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.SOUTH).getType() != Material.WATER_LILY && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.EAST).getType() != Material.WATER && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.EAST).getType() != Material.STATIONARY_WATER && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.EAST).getType() != Material.WATER_LILY && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.WEST).getType() != Material.WATER && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.WEST).getType() != Material.STATIONARY_WATER && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.WEST).getType() != Material.WATER_LILY){
									
									Location locf = e.getPlayer().getLocation();
									locf.setY(locf.getY() + 1);
									
									Firework f = (Firework) e.getPlayer().getWorld().spawn(locf, Firework.class);
                   					FireworkMeta fm = f.getFireworkMeta();
                    		
                   					fm.addEffects(FireworkEffect.builder()
                   							.flicker(true)
                   							.trail(true)
                   							.with(Type.BALL_LARGE)
                   							.withColor(Color.AQUA)
                   							.withColor(Color.RED)
                   							.withColor(Color.AQUA)
                   							.withColor(Color.RED)
                   							.build()
                   							);
                    		
                   					fm.setPower(0);
                   					f.setFireworkMeta(fm);
                   					
                   					if(FileControler.getArena(arene).getString("mode").equalsIgnoreCase("conquete")){
                   						
                   						for(int i = 0; (FileControler.getArena(arene).getInt("pos1.y") + i) <= FileControler.getArena(arene).getInt("pos2.y") ; i++){
											
                   							if(FileControler.getArena(arene).getInt("pos1.y") + i == FileControler.getArena(arene).getInt("pos2.y")){
                   								Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), e.getPlayer().getLocation().getBlockX(), (FileControler.getArena(arene).getInt("pos1.y") + i), e.getPlayer().getLocation().getBlockZ());
    											loc.getBlock().setType(Material.GLASS);
                   							}else{
	                   							Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), e.getPlayer().getLocation().getBlockX(), (FileControler.getArena(arene).getInt("pos1.y") + i), e.getPlayer().getLocation().getBlockZ());
												SetBlock.setBlock(loc, PlayerControle.getJoueur(e.getPlayer().getName()).getBlock());
                   							}
                   						}
										int score = new Conteur().conter(e.getPlayer().getLocation());
										PlayerControle.getJoueur(e.getPlayer().getName()).setNbrpoint(PlayerControle.getJoueur(e.getPlayer().getName()).getNbrPoint() + score*2);
										PlayerControle.getJoueur(e.getPlayer().getName()).setNbrDac(PlayerControle.getJoueur(e.getPlayer().getName()).getNbrDac() + 1);
                   						
                   						for(Player pl : ArenaControle.getArena(arene).getPlayerList()){
    		                   				pl.sendMessage(Msg.Prefix.toString() + Msg.reussi_dac.toString().replace("#name", e.getPlayer().getName()) +" (§6+" + score*2 + "§b)!!!"); 
    		                   				pl.playSound(pl.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 100.0F, 100.0F);
    		                   			}
                   					}else{
                   						PlayerControle.getJoueur(e.getPlayer().getName()).setNbrVie(PlayerControle.getJoueur(e.getPlayer().getName()).getNbrVie() + 1);
                   						PlayerControle.getJoueur(e.getPlayer().getName()).setNbrDac(PlayerControle.getJoueur(e.getPlayer().getName()).getNbrDac() + 1);
    									
										for(int i = 0; (FileControler.getArena(arene).getInt("pos1.y") + i) <= FileControler.getArena(arene).getInt("pos2.y") ; i++){
											Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), e.getPlayer().getLocation().getBlockX(), (FileControler.getArena(arene).getInt("pos1.y") + i), e.getPlayer().getLocation().getBlockZ());
											loc.getBlock().setType(Material.GLASS);
										}
                   						
                   						for(Player pl : ArenaControle.getArena(arene).getPlayerList()){
    		                   				pl.sendMessage(Msg.Prefix.toString() + Msg.reussi_dac.toString().replace("#name", e.getPlayer().getName())); 
    		                   				pl.playSound(pl.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 100.0F, 100.0F);
    		                   			}
                   					}
                   					
									//Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getDouble("lobby.x"), FileControler.getArena(arene).getDouble("lobby.y"), FileControler.getArena(arene).getDouble("lobby.z"), (float)FileControler.getArena(arene).getDouble("lobby.yaw"), (float)FileControler.getArena(arene).getDouble("lobby.pitch"));
		                   			e.getPlayer().teleport(ArenaControle.getArena(arene).getEnCour().getLoc());
		                   			
		                   			ArenaControle.getArena(arene).getEnCour().stopTourTimer();
		                   			ArenaControle.getArena(arene).setEnCour(null);
		                   			ArenaControle.getArena(arene).WhoWin();
		                   			
								}else{
									
									for(int i = 0; (FileControler.getArena(arene).getInt("pos1.y") + i) <= FileControler.getArena(arene).getInt("pos2.y") ; i++){
										Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), e.getPlayer().getLocation().getBlockX(), (FileControler.getArena(arene).getInt("pos1.y") + i), e.getPlayer().getLocation().getBlockZ());
										SetBlock.setBlock(loc, PlayerControle.getJoueur(e.getPlayer().getName()).getBlock());
									}
									
									if(FileControler.getArena(arene).getString("mode").equalsIgnoreCase("conquete")){
                   						int score = new Conteur().conter(e.getPlayer().getLocation());
                   						
                   						PlayerControle.getJoueur(e.getPlayer().getName()).setNbrpoint(PlayerControle.getJoueur(e.getPlayer().getName()).getNbrPoint() + score);
                   						
                   						for(Player pl : ArenaControle.getArena(arene).getPlayerList()){
    		                   				pl.sendMessage(Msg.Prefix.toString() + Msg.reussi_saut.toString().replace("#name", e.getPlayer().getName()) + " (§6+" + score + "§b)");  
    		                   				pl.playSound(pl.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0F, 100.0F);
    		                   			}
                   					}else{
                   						for(Player pl : ArenaControle.getArena(arene).getPlayerList()){
    		                   				pl.sendMessage(Msg.Prefix.toString() + Msg.reussi_saut.toString().replace("#name", e.getPlayer().getName()));  
    		                   				pl.playSound(pl.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0F, 100.0F);
    		                   			}
                   					}
									
									//Location loc = new Location(Bukkit.getWorld(FileControler.getArena(arene).getString("world")), FileControler.getArena(arene).getDouble("lobby.x"), FileControler.getArena(arene).getDouble("lobby.y"), FileControler.getArena(arene).getDouble("lobby.z"), (float)FileControler.getArena(arene).getDouble("lobby.yaw"), (float)FileControler.getArena(arene).getDouble("lobby.pitch"));
		                   			e.getPlayer().teleport(ArenaControle.getArena(arene).getEnCour().getLoc());
		                   				
		                   			ArenaControle.getArena(arene).getEnCour().stopTourTimer();
		                   			ArenaControle.getArena(arene).setEnCour(null);
		                   			ArenaControle.getArena(arene).WhoWin();
		                   			
								}
	            			}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void OnBreackBlockEvent(BlockBreakEvent e){
		if(PlayerControle.contains(e.getPlayer().getName())){
			e.setCancelled(true);
		}
	}
	
	
	@EventHandler
	public void onMob(EntitySpawnEvent e){
		e.setCancelled(true);
	}
	
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		
		if(PlayerControle.contains(e.getPlayer().getName())){
				
			e.setCancelled(true);
				
		}
	}
	
	
	@EventHandler
	public void OnblockPlaceEvent(BlockPlaceEvent e){
		if(PlayerControle.contains(e.getPlayer().getName())){
			e.setCancelled(true);
		}
	}
	
	
	@EventHandler
	public void onPlayerpickEvent(PlayerPickupItemEvent e){
		if(PlayerControle.contains(e.getPlayer().getName())){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerFoodEvent(FoodLevelChangeEvent e){
		if(e.getEntity().getType() == EntityType.PLAYER){
			if(PlayerControle.contains(((Player)e.getEntity()).getName())){
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerLeaveEvent(PlayerQuitEvent e){
		Quite.leave(e.getPlayer());
	}
}

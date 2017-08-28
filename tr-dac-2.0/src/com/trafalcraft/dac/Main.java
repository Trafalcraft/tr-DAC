package com.trafalcraft.dac;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.bossbar.BossBarAPI;
import org.inventivetalent.bossbar.BossBarAPI.Color;
import org.inventivetalent.bossbar.BossBarAPI.Property;
import org.inventivetalent.bossbar.BossBarAPI.Style;

import com.trafalcraft.client.api.SocketApi;
import com.trafalcraft.dac.Controler.ArenaControle;
import com.trafalcraft.dac.Controler.PlayerControle;
import com.trafalcraft.dac.block.CreateList;
import com.trafalcraft.dac.file.FileControler;
import com.trafalcraft.dac.pannel.CreateAreneList;
import com.trafalcraft.dac.pannel.InventoryClickListener;
import com.trafalcraft.dac.texte.CreateSection;
import com.trafalcraft.dac.texte.Msg;
import com.trafalcraft.dac.texte.Replace;
import com.trafalcraft.dac.util.BungeeCord;
import com.trafalcraft.dac.util.SocketPerso;

import net.md_5.bungee.api.chat.TextComponent;

public class Main extends JavaPlugin implements Listener{
	private static JavaPlugin plugin;
	
	public void onEnable(){
		plugin = this;
		getPlugin().getConfig().options().copyDefaults(true);
		
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(),this);
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryClickListener(),this);
		SocketApi.registerPlugin("dac", new SocketPerso());
		
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeCord());
		
		File d = new File(getPlugin().getDataFolder().getPath()+"//arene");
		
		if(!(d.exists())){
			d.mkdir();
			d.mkdirs();
		}
		
		File t = new File(getPlugin().getDataFolder().getPath() , "texte.yml");
		
		if(!(t.exists())){
			try {
				t.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			CreateSection.create();
		}else{
			Replace.replaceTexte();
		}
		
		FileControler.loadAllFile();
		
		for(String s : FileControler.getAllName()){
			if(FileControler.getArena(s).getString("status").equalsIgnoreCase("on")){
				if(SecureConfig.testConfig(s) == true){
					
					ArenaControle.addArene(s);
					Bukkit.getLogger().info("arene " + s + " creer");
					CreateList.addBlocks(s);
					OrganizeFile.organize(s);
					
				}else{
					Bukkit.getLogger().warning("l'arene " + s + " est mal configuree");
				}
			}
		}
	}

	public void onDisable(){
		for(String name : PlayerControle.getList()){
			BossBarAPI.removeAllBars(Bukkit.getPlayer(name));
		}
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		
		if(command.getName().equalsIgnoreCase("dac")){
			if(args.length != 0){
				if(args[0].equalsIgnoreCase("create")){
					if(p.isOp()){
						if(!(PlayerControle.contains(p.getName()))){
							if(args.length == 2){
								if(!(FileControler.contains(args[1]))){
									FileControler.addFile(getPlugin().getDataFolder(), args[1]);
									FileControler.getArena(args[1]).set("name", args[1]);
									FileControler.getArena(args[1]).set("world", p.getWorld().getName());
									FileControler.getArena(args[1]).set("status", "off");
									FileControler.getArena(args[1]).set("mode", "basic");
									FileControler.saveArena(args[1]);
									p.sendMessage(Msg.Prefix.toString() + Msg.arene_creee.toString());
								}else{
									p.sendMessage(Msg.Prefix.toString() + Msg.arene_existante.toString());
								}
							}else{
								p.sendMessage(Msg.Prefix.toString() + Msg.Commande_Imcomplete.toString());
							}
						}else{
							p.sendMessage(Msg.Prefix.toString() + Msg.No_config_ingame_2.toString());
						}
					}else{
						p.sendMessage(Msg.Prefix.toString() + Msg.No_Permission.toString().toString());
					}
					
				}else if(FileControler.contains(args[0])){
					if(p.isOp()){
						if(!PlayerControle.contains(p.getName())){
							if(args.length == 3){
								if(args[1].equalsIgnoreCase("set")){
									if(args[2].equalsIgnoreCase("lobby")){
												
										FileControler.getArena(args[0]).set("lobby.x", p.getLocation().getX());
										FileControler.getArena(args[0]).set("lobby.y", p.getLocation().getY());
										FileControler.getArena(args[0]).set("lobby.z", p.getLocation().getZ());
										FileControler.getArena(args[0]).set("lobby.yaw", p.getLocation().getYaw());
										FileControler.getArena(args[0]).set("lobby.pitch", p.getLocation().getPitch());
										FileControler.saveArena(args[0]);
												
										p.sendMessage(Msg.Prefix.toString() + Msg.lobby_config.toString());
									}else if(args[2].equalsIgnoreCase("plongeoir")){
									
										FileControler.getArena(args[0]).set("plongeoir.x", p.getLocation().getX());
										FileControler.getArena(args[0]).set("plongeoir.y", p.getLocation().getY());
										FileControler.getArena(args[0]).set("plongeoir.z", p.getLocation().getZ());
										FileControler.getArena(args[0]).set("plongeoir.yaw", p.getLocation().getYaw());
										FileControler.getArena(args[0]).set("plongeoir.pitch", p.getLocation().getPitch());
										FileControler.saveArena(args[0]);
										
										p.sendMessage(Msg.Prefix.toString() + Msg.plongeoir_config.toString());
									
									}else if(args[2].equalsIgnoreCase("eventlobby")){
										
										FileControler.getArena(args[0]).set("eventlobby.x", p.getLocation().getX());
										FileControler.getArena(args[0]).set("eventlobby.y", p.getLocation().getY());
										FileControler.getArena(args[0]).set("eventlobby.z", p.getLocation().getZ());
										FileControler.getArena(args[0]).set("eventlobby.yaw", p.getLocation().getYaw());
										FileControler.getArena(args[0]).set("eventlobby.pitch", p.getLocation().getPitch());
										FileControler.saveArena(args[0]);
										
										p.sendMessage(Msg.Prefix.toString() + Msg.lobby_event_config.toString());
									}else if(args[2].equalsIgnoreCase("pos1")){
										
										FileControler.getArena(args[0]).set("pos1.x", p.getLocation().getBlockX());
										FileControler.getArena(args[0]).set("pos1.y", p.getLocation().getBlockY());
										FileControler.getArena(args[0]).set("pos1.z", p.getLocation().getBlockZ());
										FileControler.saveArena(args[0]);
										
										p.sendMessage(Msg.Prefix.toString() + Msg.pos1_config.toString());
									}else if(args[2].equalsIgnoreCase("pos2")){

										FileControler.getArena(args[0]).set("pos2.x", p.getLocation().getBlockX());
										FileControler.getArena(args[0]).set("pos2.y", p.getLocation().getBlockY());
										FileControler.getArena(args[0]).set("pos2.z", p.getLocation().getBlockZ());
										FileControler.saveArena(args[0]);
										
										p.sendMessage(Msg.Prefix.toString() + Msg.pos2_config.toString());
									}else if(args[2].equalsIgnoreCase("help")){
										
										p.sendMessage("/dac <nom d'une arène> set lobby");
										p.sendMessage("/dac <nom d'une arène> set plongeoir");
										p.sendMessage("/dac <nom d'une arène> set eventlobby");
										p.sendMessage("/dac <nom d'une arène> set pos1");
										p.sendMessage("/dac <nom d'une arène> set pos2");
										p.sendMessage("/dac <nom d'une arène> set maxplayer <nombre>");
										p.sendMessage("/dac <nom d'une arène> set maxpoint <nombre>");
										p.sendMessage("/dac <nom d'une arène> set status <on/off>");
										p.sendMessage("/dac <nom d'une arène> set mode <basic/conquete>");
										
									}else{
										p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString().replace("#arg", args[2]));
									}
								}else{
									p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString().replace("#arg", args[1]));
								}
							}else if(args.length == 4){
								if(args[1].equalsIgnoreCase("set")){
									if(args[2].equalsIgnoreCase("maxplayer")){
										try{
													
											Integer max1 = Integer.valueOf(args[3]);
											FileControler.getArena(args[0]).set("maxplayer", max1);
											FileControler.saveArena(args[0]);
											p.sendMessage(Msg.Prefix.toString() + Msg.config_maxplayer.toString());
												
										}catch(NumberFormatException e){
											p.sendMessage(Msg.Prefix.toString() + Msg.entrer_nombre.toString());
										}
									}else if(args[2].equalsIgnoreCase("maxpoint")){
										try{
											
											Integer max1 = Integer.valueOf(args[3]);
											FileControler.getArena(args[0]).set("maxpoint", max1);
											FileControler.saveArena(args[0]);
											p.sendMessage(Msg.Prefix.toString() + Msg.config_maxpoint.toString());
												
										}catch(NumberFormatException e){
											p.sendMessage(Msg.Prefix.toString() + Msg.entrer_nombre.toString());
										}
									}else if(args[2].equalsIgnoreCase("status")){
										if(args[3].equalsIgnoreCase("on") || args[3].equalsIgnoreCase("off")){
											if(SecureConfig.testConfig(args[0]) == true){
												if(FileControler.getArena(args[0]).getString("status").equalsIgnoreCase("off")){
													FileControler.getArena(args[0]).set("status", args[3]);
													FileControler.saveArena(args[0]);
														
													ArenaControle.addArene(args[0]);
													Bukkit.getLogger().info("arene " + args[0] + " creer");
													CreateList.addBlocks(args[0]);
													OrganizeFile.organize(args[0]);
															
													p.sendMessage(Msg.Prefix.toString() + Msg.config_status.toString());
												}else{
													p.sendMessage(Msg.Prefix.toString() + Msg.status_deja_on.toString());
												}
											}else{
												p.sendMessage(Msg.Prefix.toString() + Msg.status_off_mal_congig.toString());
											}
										}else{
											p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString());
										}
									}else if(args[2].equalsIgnoreCase("mode")){
										if(args[3].equalsIgnoreCase("basic") || args[3].equalsIgnoreCase("conquete")){
											
											FileControler.getArena(args[0]).set("mode", args[3]);
											FileControler.saveArena(args[0]);
											
											p.sendMessage(Msg.Prefix.toString() + Msg.config_mod.toString());
											
										}else{
											p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString().replace("#arg", args[3]));
										}
									}else{
										p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString().replace("#arg", args[2]));
									}
								
								}else{			
									p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString().replace("#arg", args[1]));
								}		
							}else{
								p.sendMessage(Msg.Prefix.toString() + Msg.Commande_Imcomplete.toString());
							}
						}else{
							p.sendMessage(Msg.Prefix.toString() + Msg.No_config_ingame_2.toString());
						}
					}else{
						p.sendMessage(Msg.Prefix.toString() + Msg.No_Permission.toString());
					}
				}else if(args[0].equalsIgnoreCase("join")){
					if(args.length == 2){
						PlayerControle.addPlayer(p.getName(), args[1]);
					}else{
						p.sendMessage(Msg.Prefix.toString() + Msg.Commande_Imcomplete.toString());
					}
				}else if(args[0].equalsIgnoreCase("start")){
					if(p.isOp()){
						if(args.length == 3 || args.length == 5){
							if(args[1].equalsIgnoreCase("event")){
								if(ArenaControle.contains(args[2])){
									if(args.length == 5){
										if(args[3].equalsIgnoreCase("admin")){
											if(args[4].equalsIgnoreCase("on")){
												
												ArenaControle.getArena(args[2]).setEvent(true);
												
												for(Player pl : Bukkit.getServer().getOnlinePlayers()){
													PlayerControle.addPlayer(pl.getName(), args[2]);
												}
												
											}else if(args[4].equalsIgnoreCase("off")){
												
												ArenaControle.getArena(args[2]).setEvent(true);
												
												for(Player pl : Bukkit.getServer().getOnlinePlayers()){
													if(!pl.isOp()){
														PlayerControle.addPlayer(pl.getName(), args[2]);
													}
												}
												
											}else{
												p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString().replace("#arg", args[4]));
											}
										}else{
											p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString().replace("#arg", args[3]));
										}
									}else{
										ArenaControle.getArena(args[2]).setEvent(true);
										
										for(Player pl : Bukkit.getServer().getOnlinePlayers()){
											PlayerControle.addPlayer(pl.getName(), args[2]);
										}
									}
								}else{
									p.sendMessage(Msg.Prefix.toString() + Msg.Arene_Inexistante.toString());
								}
							}else{
								p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString().replace("#arg", args[1]));
							}
						}else{
							p.sendMessage("/oitc start event <nom d'une arène> admin <on/off>");
						}
					}else{
						p.sendMessage(Msg.Prefix.toString() + Msg.No_Permission.toString());
					}
				}else if(args[0].equalsIgnoreCase("leave")){
					BungeeCord.sendPlayerToHub(p);
				}else if(args[0].equalsIgnoreCase("reload")){
					if(p.isOp()){
						if(args.length == 2){
							if(ArenaControle.contains(args[1])){
								if(ArenaControle.getArena(args[1]).getStatus().equalsIgnoreCase("lobby")){
									if(ArenaControle.getArena(args[1]).getPlayerList().size() == 0){
										
										FileControler.saveArena(args[1]);
										ArenaControle.removeMap(args[1]);
										FileControler.removeFile(args[1]);
										FileControler.loadFile(args[1]);
										
										ArenaControle.addArene(args[1]);
										Bukkit.getLogger().info("arene " + args[1] + " creer");
										CreateList.addBlocks(args[1]);
										OrganizeFile.organize(args[1]);
										
										p.sendMessage(Msg.Prefix.toString() + Msg.arene_reload.toString());
										
										
									}else{
										p.sendMessage(Msg.Prefix.toString() + Msg.no_reload_avec_joueur.toString());
									}
								}else{
									p.sendMessage(Msg.Prefix.toString() + Msg.No_Configure_Ingame.toString());
								}
							}else{
								p.sendMessage(Msg.Prefix.toString() + Msg.Arene_Inexistante.toString());
							}
						}else{
							p.sendMessage(Msg.Prefix.toString() + Msg.Commande_Imcomplete.toString());
						}
					}else{
						p.sendMessage(Msg.Prefix.toString() + Msg.No_Permission.toString());
					}
				}else if(args[0].equalsIgnoreCase("pannel")){
					if(p.isOp()){
						if(FileControler.getAllName().size() <= 54){
							if(FileControler.getAllName().size() != 0){
								
								CreateAreneList.loadInventoryArena(p);
								
							}else{
								p.sendMessage(Msg.Prefix.toString() + Msg.aucune_arene_config.toString());
							}
						}else{
							p.sendMessage(Msg.Prefix.toString() + Msg.trop_arene.toString());
						}
					}else{
						p.sendMessage(Msg.Prefix.toString() + Msg.No_Permission.toString());
					}
				}else if(args[0].equalsIgnoreCase("fstart")){
					if(p.isOp()){
						if(PlayerControle.contains(p.getName())){
							
							String arene = PlayerControle.getJoueur(p.getName()).getArene();
							
							if(ArenaControle.getArena(arene).getStatus().equalsIgnoreCase("lobby")){
								if(ArenaControle.getArena(arene).getTaskLobby() != 0){
									
									ArenaControle.getArena(arene).setTemps(5);
									
									for(Player pl : ArenaControle.getArena(arene).getPlayerList()){
										BossBarAPI.removeAllBars(pl);
										BossBarAPI.addBar(pl, new TextComponent("§b" + "dé à coudre"), Color.BLUE, Style.PROGRESS, (float)5/30, 100, 1, Property.PLAY_MUSIC);
									}
								
								}else{
									p.sendMessage(Msg.Prefix.toString() + Msg.compte_a_rebour_pas_commencee.toString());
								}
							}else{
								p.sendMessage(Msg.Prefix.toString() + Msg.No_Configure_Ingame.toString());
							}
						}else{
							p.sendMessage(Msg.Prefix.toString() + Msg.dans_aucune_arene.toString());
						}
					}else{
						p.sendMessage(Msg.Prefix.toString() + Msg.No_Permission.toString());
					}
				}else if(args[0].equalsIgnoreCase("help")){
					
					p.sendMessage("/dac create <name>");
					p.sendMessage("/dac <nom d'une arène> set");
					p.sendMessage("/dac join <nom d'une arène>");
					p.sendMessage("/dac start");
					p.sendMessage("/dac leave");
					p.sendMessage("/dac reload <nom d'une arène>");
					p.sendMessage("/dac pannel");
					p.sendMessage("/dac fstart");
					
				}else{
					p.sendMessage(Msg.Prefix.toString() + Msg.Argument_Incorect.toString().replace("#arg", args[0]));
				}
			}else{
				p.sendMessage(Msg.Prefix.toString() + Msg.Commande_Imcomplete.toString());
			}
		}
		return false;
	}
	
	public static JavaPlugin getPlugin(){
		return plugin;
	}
}

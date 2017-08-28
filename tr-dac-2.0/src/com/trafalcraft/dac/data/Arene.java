package com.trafalcraft.dac.data;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.inventivetalent.bossbar.BossBarAPI;

import com.trafalcraft.dac.Main;
import com.trafalcraft.dac.Quite;
import com.trafalcraft.dac.Regen;
import com.trafalcraft.dac.TestFull;
import com.trafalcraft.dac.Controler.PlayerControle;
import com.trafalcraft.dac.block.ColorName;
import com.trafalcraft.dac.block.CreateList;
import com.trafalcraft.dac.file.FileControler;
import com.trafalcraft.dac.texte.Msg;
import com.trafalcraft.dac.util.BungeeCord;

import net.md_5.bungee.api.chat.TextComponent;


public class Arene extends org.inventivetalent.bossbar.BossBarAPI{
	private String name;
	private ArrayList <Player> playerList = new ArrayList<Player>();
	private String status;
	private int temps;
	private int taskLobby = 0;
	private int taskFinish = 0;
	ArrayList<Player> winner = new ArrayList<Player>();
	ArrayList<String> block = new ArrayList<String>();
	int indexBlock = 0;
	private ScoreBoard score;
	private boolean event;
	private Tour enCour;
	private int indexEnCour = 0;

	public Arene(String nom){
		
		this.name = nom;
		this.status = "lobby";

	}
	
	public int getTemps(){
		return this.temps;
	}
	
	public void setTemps(int i){
		this.temps = i;
	}
	
	public int getTaskLobby(){
		return this.taskLobby;
	}
	
	public int getTaskFinish(){
		return this.taskFinish;
	}
	
	public void addBlock(String s){
		block.add(s);
	}
	
	public ArrayList<String> getBlockList(){
		return block;
	}
	
	public void setEnCour(Tour t){
		this.enCour = t;
	}
	
	public Tour getEnCour(){
		return enCour;
	}
	
	public void setEvent(boolean e){
		this.event = e;
	}
	
	public boolean getEvent(){
		return this.event;
	}
	
	public ScoreBoard getScoreBoard(){
		return this.score;
	}
	
	public void setName(String nom){
		this.name = nom;
	}
	
	public String getName(){
		return name;
	}
	
	public void addPlayer(Player p){
		playerList.add(p);
		
		if(indexBlock == block.size() -1){
			indexBlock = 0;
		}else{
			indexBlock = indexBlock + 1;
		}
		
		if(getPlayerList().size() == 2){
			startLobbyTimer();
			
			for(Player pl : getPlayerList()){
				BossBarAPI.removeAllBars(pl);
				BossBarAPI.addBar(pl, new TextComponent("§b" + "dé à coudre"), Color.BLUE, Style.PROGRESS, 1.0f, 620, 1, Property.PLAY_MUSIC);
			}
		}
	}
	
	public void removePlayer(Player p){
		playerList.remove(p);
		
		if(indexBlock == 0){
			indexBlock =  block.size() -1;
		}else{
			indexBlock = indexBlock - 1;
		}
		
		for(Player pl : getPlayerList()){
			pl.sendMessage(Msg.Prefix.toString() + Msg.leave.toString().replace("#name", p.getName()));
		}
		
		if(getPlayerList().size() == 1){
			if(getTaskLobby() != 0){
				stopLobbyTimer();
				
				for(Player pl : getPlayerList()){
					pl.sendMessage(Msg.Prefix.toString() + Msg.stop_Lobby_Timer.toString());
					
					BossBarAPI.removeAllBars(pl);
					BossBarAPI.addBar(pl, new TextComponent("§b" + "dé à coudre"), Color.BLUE, Style.PROGRESS, 1.0f);
					
				}
			}
		}
	}
	
	public int PlayerIndexOf(Player p){
		return playerList.indexOf(p);
	}
	
	public void setStatus(String s){
		this.status = s;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public ArrayList<Player> getPlayerList(){
		return this.playerList;
	}
	
	public void startLobbyTimer(){
		this.temps = 31;
		this.taskLobby = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            
			public void run() {
            	
						for(Player p : getPlayerList()){
							p.setLevel(temps);
						}
                   		if(temps == 30||temps == 20||temps == 10||(temps <= 5&&temps>0)){
                   			for(Player pl : getPlayerList()){
                   				pl.sendMessage(Msg.Prefix.toString() + Msg.start_lobby_timer.toString().replace("#temps", "" + temps));
                   				pl.playSound(pl.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                   				pl.sendTitle("§b" + temps + "", "§b" + Msg.seconde.toString());
                   			}
                   		}else if(temps <= 0){
                   			
                   			for(Player pl : getPlayerList()){
                   				
                   				pl.sendMessage(Msg.Prefix.toString() + Msg.start_game.toString());
                   				pl.playSound(pl.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 1.0F);
                   				
                   				pl.closeInventory();
                   				pl.getInventory().clear();
                   				pl.setHealth(20);
               					pl.setSaturation(0);
               					pl.setFoodLevel(20);
               					PlayerControle.getJoueur(pl.getName()).setInGame(true);
               					
               					if(PlayerControle.getJoueur(pl.getName()).getBlock() == null){
               						PlayerControle.getJoueur(pl.getName()).setBlock(block.get(0));
               						block.remove(0);
               					}
               					
               					ColorName.viewColor(pl);
                   			}
                   			
                   			stopLobbyTimer();
               				status = "in-game";
               				Regen.classic(getName());
               				score = new ScoreBoard(getName());
               				taskLobby = 0;
               				WhoWin();
               				
               				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {

            	                @Override
            	                public void run() {
            	                   for(Player p : playerList){
            	                	   p.sendTitle("", "");
            	                   }
            	                }
            	            },20);
               				
                   		}
            	temps = temps-1;
            }
         }, 0, 20);
	}
	
	public void stopLobbyTimer(){
		Bukkit.getServer().getScheduler().cancelTask(this.taskLobby);
	}
	
	public void WhoWin(){
		
		getScoreBoard().updateScore(getName());
		
		if(FileControler.getArena(getName()).getString("mode").equalsIgnoreCase("basic")){
		
			ArrayList<Player> joueurInGame = new ArrayList<Player>();
			
			for(Player p : getPlayerList()){
				
				if(PlayerControle.getJoueur(p.getName()).getInGame() == true){
					
					joueurInGame.add(p);
				}
			}
			
			if(indexEnCour + 1 > joueurInGame.size()){
				indexEnCour = indexEnCour - 1;
			}
			
			if(TestFull.test(getName()) == true){
				for(Player p : getPlayerList()){
					if(this.winner.size() == 0){
						this.winner.add(p);
					}else{
						if(PlayerControle.getJoueur(p.getName()).getNbrVie() > PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrVie()){
							this.winner.clear();
							this.winner.add(p);
						}else if(PlayerControle.getJoueur(p.getName()).getNbrVie() == PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrVie()){
							if(PlayerControle.getJoueur(p.getName()).getNbrDac() > PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrDac()){
								this.winner.clear();
								this.winner.add(p);
							}else if(PlayerControle.getJoueur(p.getName()).getNbrDac() == PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrDac()){
								if(PlayerControle.getJoueur(p.getName()).getNbrMort() > PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrMort()){
									this.winner.clear();
									this.winner.add(p);
								}else if(PlayerControle.getJoueur(p.getName()).getNbrMort() == PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrMort()){
									this.winner.add(p);
								}
							}
						}
					}
				}
				
				if(this.winner.size() == 1){
					Player winner;
					
					winner = this.winner.get(0);
					
					for(Player p : getPlayerList()){
						p.sendTitle("§b" + winner.getName() + "" , "§b" + Msg.win_title.toString());
						p.sendMessage(Msg.Prefix.toString() + Msg.win.toString().replace("#name", winner.getName()));
						PlayerControle.getJoueur(p.getName()).setInGame(false);
	
	       				BossBarAPI.removeAllBars(p);
						BossBarAPI.addBar(p, new TextComponent("§b" +  Msg.win.toString().replace("#name", winner.getName())), Color.BLUE, Style.PROGRESS, 1.0f, Property.PLAY_MUSIC);
	       				
					}
				}else{
					for(Player p : getPlayerList()){
						p.sendTitle("§b" + Msg.egalite.toString() , "");
						
						p.sendMessage(Msg.Prefix.toString() + Msg.plusieurs_gagnants.toString());
						
						for(Player pl : this.winner){
							p.sendMessage(Msg.Prefix.toString() + "-" + pl.getName());
						}
						
						PlayerControle.getJoueur(p.getName()).setInGame(false);
	
	       				BossBarAPI.removeAllBars(p);
						BossBarAPI.addBar(p, new TextComponent("§b" + Msg.egalite.toString()), Color.BLUE, Style.PROGRESS, 1.0f, Property.PLAY_MUSIC);
	       				
					}
				}
				
				this.status = "end";
				startFinishTimer();
				
			}else{ 
				
				if(joueurInGame.size() > 2){
					
					Tour suivant = new Tour(getName(), joueurInGame.get(indexEnCour), joueurInGame.get(indexEnCour).getLocation());
					this.enCour = suivant;
					
					if(indexEnCour + 1 == joueurInGame.size()){
						this.indexEnCour = 0 ;
					}else{
						this.indexEnCour = this.indexEnCour + 1;
					}
					
					for(Player p : joueurInGame){
						if(PlayerControle.getJoueur(p.getName()).getNbrVie() == 0){
							PlayerControle.getJoueur(p.getName()).setInGame(false);
						}
					}
					
				}else if(joueurInGame.size() == 2){
					
					if(PlayerControle.getJoueur(joueurInGame.get(0).getName()).getNbrVie() >= 1 && PlayerControle.getJoueur(joueurInGame.get(1).getName()).getNbrVie() >= 1){
						
						Tour suivant = new Tour(getName(), joueurInGame.get(indexEnCour), joueurInGame.get(indexEnCour).getLocation());
						this.enCour = suivant;
						
						if(indexEnCour + 1 == joueurInGame.size()){
							this.indexEnCour = 0 ;
						}else{
							this.indexEnCour = this.indexEnCour + 1;
						}
					}else if(PlayerControle.getJoueur(joueurInGame.get(0).getName()).getNbrVie() == 0 && PlayerControle.getJoueur(joueurInGame.get(1).getName()).getNbrVie() == 0){
						
						PlayerControle.getJoueur(joueurInGame.get(0).getName()).setNbrVie(1);
						PlayerControle.getJoueur(joueurInGame.get(1).getName()).setNbrVie(1);
						
						getScoreBoard().updateScore(getName());
						
						for(Player p : getPlayerList()){
							p.sendMessage(Msg.Prefix.toString() + Msg.pas_confirmer.toString());
						}
						
						Tour suivant = new Tour(getName(), joueurInGame.get(indexEnCour), joueurInGame.get(indexEnCour).getLocation());
						this.enCour = suivant;
						
						if(indexEnCour + 1 == joueurInGame.size()){
							this.indexEnCour = 0 ;
						}else{
							this.indexEnCour = this.indexEnCour + 1;
						}
						
					}else if(PlayerControle.getJoueur(joueurInGame.get(0).getName()).getNbrVie() == 0 || PlayerControle.getJoueur(joueurInGame.get(1).getName()).getNbrVie() == 0){
						
						if(PlayerControle.getJoueur(joueurInGame.get(0).getName()).getNbrVie() == 1 || PlayerControle.getJoueur(joueurInGame.get(1).getName()).getNbrVie() == 1){
							
							if(PlayerControle.getJoueur(joueurInGame.get(0).getName()).getNbrSaut() != PlayerControle.getJoueur(joueurInGame.get(1).getName()).getNbrSaut()){
								
								for(Player p : getPlayerList()){
									p.sendMessage(Msg.Prefix.toString() + Msg.doit_confirmer.toString().replace("#name", joueurInGame.get(indexEnCour).getName()));
								}
								
								Tour suivant = new Tour(getName(), joueurInGame.get(indexEnCour), joueurInGame.get(indexEnCour).getLocation());
								this.enCour = suivant;
								
								if(indexEnCour + 1 == joueurInGame.size()){
									this.indexEnCour = 0 ;
								}else{
									this.indexEnCour = this.indexEnCour + 1;
								}
								
							}else{
								
								Player winner;
								if(PlayerControle.getJoueur(joueurInGame.get(0).getName()).getNbrVie() == 0){
									winner = joueurInGame.get(1);
								}else{
									winner = joueurInGame.get(0);
								}
								
								for(Player p : getPlayerList()){
									p.sendTitle("§b" + winner.getName() + "" , "§b" + Msg.win_title.toString());
									p.sendMessage(Msg.Prefix.toString() + Msg.win.toString().replace("#name", winner.getName()));
									PlayerControle.getJoueur(p.getName()).setInGame(false);
									
									BossBarAPI.removeAllBars(p);
									BossBarAPI.addBar(p, new TextComponent("§b" + Msg.win.toString().replace("#name", winner.getName())), Color.BLUE, Style.PROGRESS, 1.0f, Property.PLAY_MUSIC);
				       				
								}
								
								this.status = "end";
								this.winner.add(winner);
								startFinishTimer();
								
							}
						}else{
							
							Player winner;
							if(PlayerControle.getJoueur(joueurInGame.get(0).getName()).getNbrVie() == 0){
								winner = joueurInGame.get(1);
							}else{
								winner = joueurInGame.get(0);
							}
							
							for(Player p : getPlayerList()){
								p.sendTitle("§b" + winner.getName() + "" , "§b" + Msg.win_title.toString());
								p.sendMessage(Msg.Prefix.toString() + Msg.win.toString().replace("#name", winner.getName()));
								PlayerControle.getJoueur(p.getName()).setInGame(false);
								
								BossBarAPI.removeAllBars(p);
								BossBarAPI.addBar(p, new TextComponent("§b" + Msg.win.toString().replace("#name", winner.getName())), Color.BLUE, Style.PROGRESS, 1.0f, Property.PLAY_MUSIC);
			       				
							}
							
							this.status = "end";
							this.winner.add(winner);
							startFinishTimer();
							
						}
					}
				}else{
					Player winner;
					
					winner = joueurInGame.get(0);
					
					for(Player p : getPlayerList()){
						p.sendTitle("§b" + winner.getName() + "" , "§b" + Msg.win_title.toString());
						p.sendMessage(Msg.Prefix.toString() + Msg.win.toString().replace("#name", winner.getName()));
						PlayerControle.getJoueur(p.getName()).setInGame(false);
						
						BossBarAPI.removeAllBars(p);
						BossBarAPI.addBar(p, new TextComponent("§b" + Msg.win.toString().replace("#name", winner.getName())), Color.BLUE, Style.PROGRESS, 1.0f, Property.PLAY_MUSIC);
	       				
					}
					
					this.status = "end";
					this.winner.add(winner);
					startFinishTimer();
					
				}
			}
		}else if(FileControler.getArena(getName()).getString("mode").equalsIgnoreCase("conquete")){
			
			if(getPlayerList().size() == 1){
				
				Player winner;
				
				winner = getPlayerList().get(0);
				
				for(Player p : getPlayerList()){
					p.sendTitle("§b" + winner.getName() + "" , "§b" + Msg.win_title.toString());
					p.sendMessage(Msg.Prefix.toString() + Msg.win.toString().replace("#name", winner.getName()));
					PlayerControle.getJoueur(p.getName()).setInGame(false);

       				BossBarAPI.removeAllBars(p);
					BossBarAPI.addBar(p, new TextComponent("§b" + Msg.win.toString().replace("#name", winner.getName())), Color.BLUE, Style.PROGRESS, 1.0f, Property.PLAY_MUSIC);
       				
				}
				
				this.status = "end";
				this.winner.add(winner);
				startFinishTimer();
				
			}else{
				ArrayList<Player> joueurInGame = new ArrayList<Player>();
				
				for(Player p : getPlayerList()){
					
					if(PlayerControle.getJoueur(p.getName()).getNbrPoint() >= FileControler.getArena(getName()).getInt("maxpoint")){
						
						joueurInGame.add(p);
					}
				}
				
				if(TestFull.test(getName()) == true){
					
					for(Player p : getPlayerList()){
						if(this.winner.size() == 0){
							this.winner.add(p);
						}else{
							if(PlayerControle.getJoueur(p.getName()).getNbrPoint() > PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrPoint()){
								this.winner.clear();
								this.winner.add(p);
							}else if(PlayerControle.getJoueur(p.getName()).getNbrPoint() == PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrPoint()){
								if(PlayerControle.getJoueur(p.getName()).getNbrDac() > PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrDac()){
									this.winner.clear();
									this.winner.add(p);
								}else if(PlayerControle.getJoueur(p.getName()).getNbrDac() == PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrDac()){
									if(PlayerControle.getJoueur(p.getName()).getNbrMort() > PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrMort()){
										this.winner.clear();
										this.winner.add(p);
									}else if(PlayerControle.getJoueur(p.getName()).getNbrMort() == PlayerControle.getJoueur(this.winner.get(0).getName()).getNbrMort()){
										this.winner.add(p);
									}
								}
							}
						}
					}
					
					if(this.winner.size() == 1){
						Player winner;
						
						winner = this.winner.get(0);
						
						for(Player p : getPlayerList()){
							p.sendTitle("§b" + winner.getName() + "" , "§b" + Msg.win_title.toString());
							p.sendMessage(Msg.Prefix.toString() + Msg.win.toString().replace("#name", winner.getName()));
							PlayerControle.getJoueur(p.getName()).setInGame(false);
		
		       				BossBarAPI.removeAllBars(p);
							BossBarAPI.addBar(p, new TextComponent("§b" + Msg.win.toString().replace("#name", winner.getName())), Color.BLUE, Style.PROGRESS, 1.0f, Property.PLAY_MUSIC);
		       				
						}
					}else{
						for(Player p : getPlayerList()){
							p.sendTitle("§b" + Msg.egalite.toString() , "");
							
							p.sendMessage(Msg.Prefix.toString() + Msg.plusieurs_gagnants.toString());
							
							for(Player pl : this.winner){
								p.sendMessage(Msg.Prefix.toString() + "-" + pl.getName());
							}
							
							PlayerControle.getJoueur(p.getName()).setInGame(false);
		
		       				BossBarAPI.removeAllBars(p);
							BossBarAPI.addBar(p, new TextComponent("§b" + Msg.egalite.toString()), Color.BLUE, Style.PROGRESS, 1.0f, Property.PLAY_MUSIC);
		       				
						}
					}
					
					this.status = "end";
					startFinishTimer();
					
				}else{
				
					if(joueurInGame.size() == 0){
						
						Tour suivant = new Tour(getName(), getPlayerList().get(indexEnCour), getPlayerList().get(indexEnCour).getLocation());
						this.enCour = suivant;
						
						if(indexEnCour + 1 == getPlayerList().size()){
							this.indexEnCour = 0 ;
						}else{
							this.indexEnCour = this.indexEnCour + 1;
						}
						
					}else{
						Player winner;
						
						winner = joueurInGame.get(0);
						
						for(Player p : getPlayerList()){
							p.sendTitle("§b" + winner.getName() + "" , "§b" + Msg.win_title.toString());
							p.sendMessage(Msg.Prefix.toString() + Msg.win.toString().replace("#name", winner.getName()));
							PlayerControle.getJoueur(p.getName()).setInGame(false);
		
		       				BossBarAPI.removeAllBars(p);
							BossBarAPI.addBar(p, new TextComponent("§b" + Msg.win.toString().replace("#name", winner.getName())), Color.BLUE, Style.PROGRESS, 1.0f, Property.PLAY_MUSIC);
		       				
						}
						
						this.status = "end";
						this.winner.add(winner);
						startFinishTimer();
					}
				}
			}
		}
	}
	
	public void startFinishTimer(){
		this.temps = 5;
		this.taskFinish = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            
			public void run() {
            	
                   		if(temps != 0){
                   				for(Player listwinner : winner){
                   	
                   					Firework f = (Firework) listwinner.getWorld().spawn(listwinner.getLocation(), Firework.class);
                   					FireworkMeta fm = f.getFireworkMeta();
                    		
                   					fm.addEffects(FireworkEffect.builder()
                   							.flicker(true)
                   							.trail(true)
                   							.with(Type.BALL_LARGE)
                   							.withColor(org.bukkit.Color.AQUA)
                   							.withColor(org.bukkit.Color.RED)
                   							.withColor(org.bukkit.Color.AQUA)
                   							.withColor(org.bukkit.Color.RED)
                   							.build()
                   							);
                    		
                   					fm.setPower(2);
                   					f.setFireworkMeta(fm);
                   				}
                   		}else{
                   			if(event == true){
	                   			for(Player p : getPlayerList()){
	                   				p.teleport(new Location(Bukkit.getWorld(FileControler.getArena(getName()).getString("world")), FileControler.getArena(getName()).getDouble("eventlobby.x"), FileControler.getArena(getName()).getDouble("eventlobby.y"), FileControler.getArena(getName()).getDouble("eventlobby.z"), (float)FileControler.getArena(getName()).getDouble("eventlobby.yaw"), (float)FileControler.getArena(getName()).getDouble("eventlobby.pitch")));
	                   			}	
                   			}
                   			StopFinishTimer();
                   			finGame();
                   		}
            	temps = temps-1;
            }
         }, 0, 20);
	}
	
	public void StopFinishTimer(){
		Bukkit.getServer().getScheduler().cancelTask(taskFinish);
	}
	
	public void finGame(){
		
		if(event == false){
			for(Player p : getPlayerList()){
				BungeeCord.sendPlayerToHub(p);
			}
		}else{
			
			for(int i = 0; i < getPlayerList().size(); i = i){
				Quite.leave(getPlayerList().get(0));
			}
		}
		
		this.status = "lobby";
		this.winner.clear();
		this.temps = 0;
		this.enCour = null;
		this.indexEnCour = 0;
		this.taskLobby = 0;
		this.taskFinish = 0;
		this.block.clear();
		CreateList.addBlocks(getName());
		getScoreBoard().clearScoreBoard();
	}
}

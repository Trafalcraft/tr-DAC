package com.trafalcraft.ludo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import org.bukkit.plugin.java.JavaPlugin;

public class mainClasse extends JavaPlugin implements Listener {
	public static int nbrJoueur = 0;
	int g = 0;
	public static int a5;
	public static int a6;
	public static int a7;
	public static int cf1;
	public static int cf2;
	public static int cf3;
	public static int cf4;
	public static int cf5;
	public static int cf6;
	public static int cf7;
	public static int cf8;
	public static mainClasse plugin;

	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(false);
		plugin = this;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if (command.getName().equalsIgnoreCase("fstart")) {
			if (p.isOp() == true) {
				if (nbrJoueur >= 2) {
					int CAB = 31;
					timer1.startCountdown(CAB);
					return true;
				} else {
					p.sendMessage("§3§ldé à coudre> §bil n'y a pas assez de joueur");
				}
			} else {
				p.sendMessage("§3§ldé à coudre> §btu n'a pas l'autorisation d'effectuer cette commande");
			}
		}

		if (command.getName().equalsIgnoreCase("join")) {
			String a4 = p.getPlayer().getName();
			if (nbrJoueur < 8 && a4 != player1.getNom() && a4 != player2.getNom() && a4 != player3.getNom()
					&& a4 != player4.getNom() && a4 != player5.getNom() && a4 != player6.getNom()
					&& a4 != player7.getNom() && a4 != player8.getNom()) {

				if (player1.getVie() == 0) {
					player1.setNom(p.getPlayer().getName());
					player1.setVie(1);
					player1.setJoueur(p);
					nbrJoueur++;
					startauto();
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + p.getPlayer().getName()
							+ " a rejoint la partie (" + nbrJoueur + "/8)");
				} else if (player2.getVie() == 0) {
					player2.setNom(p.getPlayer().getName());
					player2.setVie(1);
					player2.setJoueur(p);
					nbrJoueur++;
					startauto();
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + p.getPlayer().getName()
							+ " a rejoint la partie (" + nbrJoueur + "/8)");
				} else if (player3.getVie() == 0) {
					player3.setNom(p.getPlayer().getName());
					player3.setVie(1);
					player3.setJoueur(p);
					nbrJoueur++;
					startauto();
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + p.getPlayer().getName()
							+ " a rejoint la partie (" + nbrJoueur + "/8)");
				} else if (player4.getVie() == 0) {
					player4.setNom(p.getPlayer().getName());
					player4.setVie(1);
					player4.setJoueur(p);
					nbrJoueur++;
					startauto();
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + p.getPlayer().getName()
							+ " a rejoint la partie (" + nbrJoueur + "/8)");
				} else if (player5.getVie() == 0) {
					player5.setNom(p.getPlayer().getName());
					player5.setVie(1);
					player5.setJoueur(p);
					nbrJoueur++;
					startauto();
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + p.getPlayer().getName()
							+ " a rejoint la partie (" + nbrJoueur + "/8)");
				} else if (player6.getVie() == 0) {
					player6.setNom(p.getPlayer().getName());
					player6.setVie(1);
					player6.setJoueur(p);
					nbrJoueur++;
					startauto();
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + p.getPlayer().getName()
							+ " a rejoint la partie (" + nbrJoueur + "/8)");
				} else if (player7.getVie() == 0) {
					player7.setNom(p.getPlayer().getName());
					player7.setVie(1);
					player7.setJoueur(p);
					nbrJoueur++;
					startauto();
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + p.getPlayer().getName()
							+ " a rejoint la partie (" + nbrJoueur + "/8)");
				} else if (player8.getVie() == 0) {
					player8.setNom(p.getPlayer().getName());
					player8.setVie(1);
					player8.setJoueur(p);
					nbrJoueur++;
					startauto();
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + p.getPlayer().getName()
							+ " a rejoint la partie (" + nbrJoueur + "/8)");
				}
			} else {
				p.sendMessage("§3§ldé à coudre> §bimpossible de rejoindre la partie");
			}
			return true;

		}

		if (command.getName().equalsIgnoreCase("leave")) {
			String a3 = p.getPlayer().getName();

			if (a3 == player1.getNom()) {
				player1.setVie(0);
				player1.setNom("inconnue");
				nbrJoueur--;
				stopauto();
				Bukkit.getServer()
						.broadcastMessage("§3§ldé à coudre> §b" + a3 + " a quité la partie (" + nbrJoueur + "/8)");
			} else if (a3 == player2.getNom()) {
				player2.setVie(0);
				player2.setNom("inconnue");
				nbrJoueur--;
				stopauto();
				Bukkit.getServer()
						.broadcastMessage("§3§ldé à coudre> §b" + a3 + " a quité la partie (" + nbrJoueur + "/8)");
			} else if (a3 == player3.getNom()) {
				player3.setVie(0);
				player3.setNom("inconnue");
				nbrJoueur--;
				stopauto();
				Bukkit.getServer()
						.broadcastMessage("§3§ldé à coudre> §b" + a3 + " a quité la partie (" + nbrJoueur + "/8)");
			} else if (a3 == player4.getNom()) {
				player4.setVie(0);
				player4.setNom("inconnue");
				nbrJoueur--;
				stopauto();
				Bukkit.getServer()
						.broadcastMessage("§3§ldé à coudre> §b" + a3 + " a quité la partie (" + nbrJoueur + "/8)");
			} else if (a3 == player5.getNom()) {
				player5.setVie(0);
				player5.setNom("inconnue");
				nbrJoueur--;
				stopauto();
				Bukkit.getServer()
						.broadcastMessage("§3§ldé à coudre> §b" + a3 + " a quité la partie (" + nbrJoueur + "/8)");
			} else if (a3 == player6.getNom()) {
				player6.setVie(0);
				player6.setNom("inconnue");
				nbrJoueur--;
				stopauto();
				Bukkit.getServer()
						.broadcastMessage("§3§ldé à coudre> §b" + a3 + " a quité la partie (" + nbrJoueur + "/8)");
			} else if (a3 == player7.getNom()) {
				player7.setVie(0);
				player7.setNom("inconnue");
				nbrJoueur--;
				stopauto();
				Bukkit.getServer()
						.broadcastMessage("§3§ldé à coudre> §b" + a3 + " a quité la partie (" + nbrJoueur + "/8)");
			} else if (a3 == player8.getNom()) {
				player8.setVie(0);
				player8.setNom("inconnue");
				nbrJoueur--;
				stopauto();
				Bukkit.getServer()
						.broadcastMessage("§3§ldé à coudre> §b" + a3 + " a quité la partie (" + nbrJoueur + "/8)");
			} else {
				Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §bvous n'etes pas dans une partie");

			}
			return true;
		}

		if (command.getName().equalsIgnoreCase("setplongeoir")) {
			if (p.isOp() == true) {
				getConfig().createSection("plongeoir");
				saveConfig();

				int x;
				int y;
				int z;

				getConfig().createSection("plongeoir.x");
				getConfig().createSection("plongeoir.y");
				getConfig().createSection("plongeoir.z");
				saveConfig();

				x = p.getLocation().getBlockX();
				y = p.getLocation().getBlockY();
				z = p.getLocation().getBlockZ();

				getConfig().set("plongeoir.x", x);
				getConfig().set("plongeoir.y", y);
				getConfig().set("plongeoir.z", z);
				saveConfig();

				p.sendMessage("§3§ldé à coudre> §ble plongeoir a bien etait definit");

			} else {
				p.sendMessage("§3§ldé à coudre> §btu n'a pas l'autorisation d'effectuer cette commande");
			}
		}

		if (command.getName().equalsIgnoreCase("setmapspawn")) {
			if (p.isOp() == true) {
				getConfig().createSection("mapSpawn");
				saveConfig();

				int x;
				int y;
				int z;

				getConfig().createSection("mapSpawn.x");
				getConfig().createSection("mapSpawn.y");
				getConfig().createSection("mapSpawn.z");
				saveConfig();

				x = p.getLocation().getBlockX();
				y = p.getLocation().getBlockY();
				z = p.getLocation().getBlockZ();

				getConfig().set("mapSpawn.x", x);
				getConfig().set("mapSpawn.y", y);
				getConfig().set("mapSpawn.z", z);
				saveConfig();

				p.sendMessage("§3§ldé à coudre> §ble spawn de la map  a bien etait definit");
			} else {
				p.sendMessage("§3§ldé à coudre> §btu n'a pas l'autorisation d'effectuer cette commande");
			}
		}
		if (command.getName().equalsIgnoreCase("setpos1")) {
			if (p.isOp() == true) {
				getConfig().createSection("piscinePos1");
				saveConfig();

				getConfig().createSection("piscinePos1.x");
				getConfig().createSection("piscinePos1.y");
				getConfig().createSection("piscinePos1.z");

				getConfig().set("piscinePos1.x", p.getLocation().getBlockX());
				getConfig().set("piscinePos1.y", p.getLocation().getBlockY());
				getConfig().set("piscinePos1.z", p.getLocation().getBlockZ());
				saveConfig();

				p.sendMessage("§3§ldé à coudre> §bpos1 configurer");
			} else {
				p.sendMessage("§3§ldé à coudre> §btu n'a pas l'autorisation d'effectuer cette commande");
			}
		}
		if (command.getName().equalsIgnoreCase("setpos2")) {
			if (p.isOp() == true) {
				getConfig().createSection("piscinePos2");
				saveConfig();

				getConfig().createSection("piscinePos2.x");
				getConfig().createSection("piscinePos2.y");
				getConfig().createSection("piscinePos2.z");

				getConfig().set("piscinePos2.x", p.getLocation().getBlockX());
				getConfig().set("piscinePos2.y", p.getLocation().getBlockY());
				getConfig().set("piscinePos2.z", p.getLocation().getBlockZ());
				saveConfig();

				p.sendMessage("§3§ldé à coudre> §bpos2 configurer");
			} else {
				p.sendMessage("§3§ldé à coudre> §btu n'a pas l'autorisation d'effectuer cette commande");
			}
		}
		return false;
	}

	player player1 = new player("inconnue", 0, null, 0, 1);
	player player2 = new player("inconnue", 0, null, 0, 2);
	player player3 = new player("inconnue", 0, null, 0, 3);
	player player4 = new player("inconnue", 0, null, 0, 4);
	player player5 = new player("inconnue", 0, null, 0, 5);
	player player6 = new player("inconnue", 0, null, 0, 6);
	player player7 = new player("inconnue", 0, null, 0, 7);
	player player8 = new player("inconnue", 0, null, 0, 8);

	public static void main(String[] args) {
	}

	@EventHandler
	public void onBreakBlock(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (p.isOp() == true) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void FallDamages(EntityDamageEvent e) {

		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		e.setCancelled(true);
		p.setHealth(20);

		if (e.getCause() == DamageCause.FALL) {
			if (p.getName() == player1.getNom() && player1.getEnJeu() == 1) {
				a5 = 1;
			}
			if (p.getName() == player2.getNom() && player2.getEnJeu() == 1) {
				a5 = 1;
			}
			if (p.getName() == player3.getNom() && player3.getEnJeu() == 1) {
				a5 = 1;
			}
			if (p.getName() == player4.getNom() && player4.getEnJeu() == 1) {
				a5 = 1;
			}
			if (p.getName() == player5.getNom() && player5.getEnJeu() == 1) {
				a5 = 1;
			}
			if (p.getName() == player6.getNom() && player6.getEnJeu() == 1) {
				a5 = 1;
			}
			if (p.getName() == player7.getNom() && player7.getEnJeu() == 1) {
				a5 = 1;
			}
			if (p.getName() == player8.getNom() && player8.getEnJeu() == 1) {
				a5 = 1;
			}

		}

	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = (Player) e.getPlayer();

		int x = e.getPlayer().getLocation().getBlockX();
		int y = e.getPlayer().getLocation().getBlockY();
		int z = e.getPlayer().getLocation().getBlockZ();

		if (e.getPlayer().getLocation().getBlock().getType() == Material.WATER
				|| e.getPlayer().getLocation().getBlock().getType() == Material.STATIONARY_WATER
				|| e.getPlayer().getLocation().getBlock().getType() == Material.WATER_LILY) {
			if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.NORTH).getType() != Material.WATER
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.NORTH)
							.getType() != Material.STATIONARY_WATER
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.NORTH)
							.getType() != Material.WATER_LILY
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.SOUTH).getType() != Material.WATER
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.SOUTH)
							.getType() != Material.STATIONARY_WATER
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.SOUTH)
							.getType() != Material.WATER_LILY
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.EAST).getType() != Material.WATER
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.EAST)
							.getType() != Material.STATIONARY_WATER
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.EAST)
							.getType() != Material.WATER_LILY
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.WEST).getType() != Material.WATER
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.WEST)
							.getType() != Material.STATIONARY_WATER
					&& e.getPlayer().getLocation().getBlock().getRelative(BlockFace.WEST)
							.getType() != Material.WATER_LILY) {
				if (p.getName() == player1.getNom() && player1.getEnJeu() == 1) {
					a7 = 1;
				}
				if (p.getName() == player2.getNom() && player2.getEnJeu() == 1) {
					a7 = 1;
				}
				if (p.getName() == player3.getNom() && player3.getEnJeu() == 1) {
					a7 = 1;
				}
				if (p.getName() == player4.getNom() && player4.getEnJeu() == 1) {
					a7 = 1;
				}
				if (p.getName() == player5.getNom() && player5.getEnJeu() == 1) {
					a7 = 1;
				}
				if (p.getName() == player6.getNom() && player6.getEnJeu() == 1) {
					a7 = 1;
				}
				if (p.getName() == player7.getNom() && player7.getEnJeu() == 1) {
					a7 = 1;
				}
				if (p.getName() == player8.getNom() && player8.getEnJeu() == 1) {
					a7 = 1;
				}
			} else {
				if (p.getName() == player1.getNom() && player1.getEnJeu() == 1) {
					a6 = 1;
				}
				if (p.getName() == player2.getNom() && player2.getEnJeu() == 1) {
					a6 = 1;
				}
				if (p.getName() == player3.getNom() && player3.getEnJeu() == 1) {
					a6 = 1;
				}
				if (p.getName() == player4.getNom() && player4.getEnJeu() == 1) {
					a6 = 1;
				}
				if (p.getName() == player5.getNom() && player5.getEnJeu() == 1) {
					a6 = 1;
				}
				if (p.getName() == player6.getNom() && player6.getEnJeu() == 1) {
					a6 = 1;
				}
				if (p.getName() == player7.getNom() && player7.getEnJeu() == 1) {
					a6 = 1;
				}
				if (p.getName() == player8.getNom() && player8.getEnJeu() == 1) {
					a6 = 1;
				}
			}

		}
	}

	@EventHandler
	public void onFaim(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		String Message = e.getMessage();
		e.setCancelled(true);
		Player p = e.getPlayer();
		Message = ("§3§ldé à coudre> §b" + p.getDisplayName() + ">> " + Message);
		Bukkit.getServer().broadcastMessage(Message);
	}

	public static void startauto() {
		if (nbrJoueur == 2) {
			int CAB = 31;
			timer1.startCountdown(CAB);
		}
	}

	public static void stopauto() {
		if (nbrJoueur == 1) {
			Bukkit.getScheduler().cancelTask(timer1.task);
			Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §bun joueur a quité, le comte a rebourt est annulé");
		}
	}

}

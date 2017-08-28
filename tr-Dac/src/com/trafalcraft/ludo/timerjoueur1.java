package com.trafalcraft.ludo;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.trafalcraft.ludo.mainClasse;

public class timerjoueur1 {
	static JavaPlugin plugin = mainClasse.plugin;
	static int a15;
	static String a16;

	public static int task2;

	public static void startCountdown2(final int CAB2) {
		task2 = Bukkit.getScheduler().scheduleSyncDelayedTask(mainClasse.plugin, new Runnable() {

			@Override
			public void run() {
				int time2 = CAB2;

				if (time2 != 0) {
					time2--;
					startCountdown2(time2);
				}

				if (mainClasse.a5 == 1) {
					mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() - 1);

					double x = plugin.getConfig().getInt("mapSpawn.x");
					double y = plugin.getConfig().getInt("mapSpawn.y");
					double z = plugin.getConfig().getInt("mapSpawn.z");

					World world = Bukkit.getWorld("world");
					Player a8 = mainClasse.plugin.player1.getJoueur();
					a8.teleport(new Location(world, x, y, z));

					if (mainClasse.cf1 == 1 || mainClasse.cf2 == 1 || mainClasse.cf3 == 1 || mainClasse.cf4 == 1
							|| mainClasse.cf5 == 1 || mainClasse.cf6 == 1 || mainClasse.cf7 == 1
							|| mainClasse.cf8 == 1) {
						if (mainClasse.plugin.player1.getVie() >= 1) {

							Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b"
									+ mainClasse.plugin.player1.getNom() + " n'a pas réussit a confirmer");
							if (mainClasse.cf1 == 1) {
								mainClasse.plugin.player1.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf2 == 1) {
								mainClasse.plugin.player2.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf3 == 1) {
								mainClasse.plugin.player3.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf4 == 1) {
								mainClasse.plugin.player4.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf5 == 1) {
								mainClasse.plugin.player5.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf6 == 1) {
								mainClasse.plugin.player6.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf7 == 1) {
								mainClasse.plugin.player7.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf8 == 1) {
								mainClasse.plugin.player8.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
						}
					}

					if (mainClasse.plugin.player1.getVie() == 0) {
						if (mainClasse.nbrJoueur == 2) {
							if (mainClasse.plugin.player2.getVie() >= 1) {
								a15 = mainClasse.plugin.player2.getNumero();
								a16 = mainClasse.plugin.player2.getNom();
							} else if (mainClasse.plugin.player3.getVie() >= 1) {
								a15 = mainClasse.plugin.player3.getNumero();
								a16 = mainClasse.plugin.player3.getNom();
							} else if (mainClasse.plugin.player4.getVie() >= 1) {
								a15 = mainClasse.plugin.player4.getNumero();
								a16 = mainClasse.plugin.player4.getNom();
							} else if (mainClasse.plugin.player5.getVie() >= 1) {
								a15 = mainClasse.plugin.player5.getNumero();
								a16 = mainClasse.plugin.player5.getNom();
							} else if (mainClasse.plugin.player6.getVie() >= 1) {
								a15 = mainClasse.plugin.player6.getNumero();
								a16 = mainClasse.plugin.player6.getNom();
							} else if (mainClasse.plugin.player7.getVie() >= 1) {
								a15 = mainClasse.plugin.player7.getNumero();
								a16 = mainClasse.plugin.player7.getNom();
							} else if (mainClasse.plugin.player8.getVie() >= 1) {
								a15 = mainClasse.plugin.player8.getNumero();
								a16 = mainClasse.plugin.player8.getNom();
							}

							if (a15 > mainClasse.plugin.player1.getNumero()) {
								Bukkit.getServer()
										.broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
												+ " a raté(e) son saut il lui reste "
												+ mainClasse.plugin.player1.getVie() + " vie");
								Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + a16 + " doit confirmer");
								mainClasse.cf1 = 1;

							} else {
								if (mainClasse.cf1 == 1 || mainClasse.cf2 == 1 || mainClasse.cf3 == 1
										|| mainClasse.cf4 == 1 || mainClasse.cf5 == 1 || mainClasse.cf6 == 1
										|| mainClasse.cf7 == 1 || mainClasse.cf8 == 1) {
									Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b"
											+ mainClasse.plugin.player1.getNom() + " n'a pas réussit a confirmer");
									if (mainClasse.cf1 == 1) {
										mainClasse.plugin.player1.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf2 == 1) {
										mainClasse.plugin.player2.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf3 == 1) {
										mainClasse.plugin.player3.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf4 == 1) {
										mainClasse.plugin.player4.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf5 == 1) {
										mainClasse.plugin.player5.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf6 == 1) {
										mainClasse.plugin.player6.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf7 == 1) {
										mainClasse.plugin.player7.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf8 == 1) {
										mainClasse.plugin.player8.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}

								} else {
									Bukkit.getServer()
											.broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
													+ " a raté(e) son saut il lui reste "
													+ mainClasse.plugin.player1.getVie() + " vie");
									Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b"
											+ mainClasse.plugin.player1.getNom() + " est eliminé(e)");
									mainClasse.nbrJoueur--;
								}
							}

						} else {
							Bukkit.getServer()
									.broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
											+ " a raté(e) son saut il lui reste " + mainClasse.plugin.player1.getVie()
											+ " vie");
							Bukkit.getServer().broadcastMessage(
									"§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom() + " est eliminé(e)");
							mainClasse.nbrJoueur--;
						}
					} else {
						Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
								+ " a raté(e) son saut il lui reste " + mainClasse.plugin.player1.getVie() + " vie");
					}
					mainClasse.a5 = 0;
					mainClasse.a6 = 0;
					mainClasse.a7 = 0;

					mainClasse.plugin.player1.getJoueur().setHealth(20);
					mainClasse.plugin.player1.setEnJeu(0);
					gamestart.joueur2Start();
					Bukkit.getScheduler().cancelTask(task2);
				}

				if (mainClasse.a6 == 1) {
					double x = plugin.getConfig().getInt("mapSpawn.x");
					double y = plugin.getConfig().getInt("mapSpawn.y");
					double z = plugin.getConfig().getInt("mapSpawn.z");

					World world = Bukkit.getWorld("world");
					Player a8 = mainClasse.plugin.player1.getJoueur();

					Location blockLocation = new Location(a8.getWorld(), a8.getLocation().getBlockX(),
							a8.getLocation().getBlockY() + 1, a8.getLocation().getBlockZ());
					Bukkit.getWorld(a8.getWorld().getName()).spawnFallingBlock(a8.getLocation(), Material.WOOL,
							(byte) 15);
					Bukkit.getWorld(a8.getWorld().getName()).spawnFallingBlock(blockLocation, Material.WOOL, (byte) 15);

					a8.teleport(new Location(world, x, y, z));

					Bukkit.getServer()
							.broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
									+ " a réussit son saut, il lui rest toujours " + mainClasse.plugin.player1.getVie()
									+ "vie(s)");

					mainClasse.a5 = 0;
					mainClasse.a6 = 0;
					mainClasse.a7 = 0;

					if (mainClasse.cf1 == 1 || mainClasse.cf2 == 1 || mainClasse.cf3 == 1 || mainClasse.cf4 == 1
							|| mainClasse.cf5 == 1 || mainClasse.cf6 == 1 || mainClasse.cf7 == 1
							|| mainClasse.cf8 == 1) {
						mainClasse.plugin.player2.setVie(0);
						mainClasse.plugin.player3.setVie(0);
						mainClasse.plugin.player4.setVie(0);
						mainClasse.plugin.player5.setVie(0);
						mainClasse.plugin.player6.setVie(0);
						mainClasse.plugin.player7.setVie(0);
						mainClasse.plugin.player8.setVie(0);
						Bukkit.getServer().broadcastMessage(
								"§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom() + " a confirmer");
						mainClasse.nbrJoueur = 1;

					}
					mainClasse.plugin.player1.getJoueur().setHealth(20);
					mainClasse.plugin.player1.setEnJeu(0);
					gamestart.joueur2Start();
					Bukkit.getScheduler().cancelTask(task2);
				}

				if (mainClasse.a7 == 1) {
					double x = plugin.getConfig().getInt("mapSpawn.x");
					double y = plugin.getConfig().getInt("mapSpawn.y");
					double z = plugin.getConfig().getInt("mapSpawn.z");

					World world = Bukkit.getWorld("world");
					Player a8 = mainClasse.plugin.player1.getJoueur();

					Location blockLocation = new Location(a8.getWorld(), a8.getLocation().getBlockX(),
							a8.getLocation().getBlockY() + 1, a8.getLocation().getBlockZ());
					Bukkit.getWorld(a8.getWorld().getName()).spawnFallingBlock(a8.getLocation(), Material.WOOL,
							(byte) 15);
					Bukkit.getWorld(a8.getWorld().getName()).spawnFallingBlock(blockLocation, Material.GLASS,
							(byte) 15);

					a8.teleport(new Location(world, x, y, z));

					mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);

					Bukkit.getServer()
							.broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
									+ " a réussit un dé à coudre, il lui reste donc "
									+ mainClasse.plugin.player1.getVie() + " vie(s)");

					mainClasse.a5 = 0;
					mainClasse.a6 = 0;
					mainClasse.a7 = 0;

					if (mainClasse.cf1 == 1 || mainClasse.cf2 == 1 || mainClasse.cf3 == 1 || mainClasse.cf4 == 1
							|| mainClasse.cf5 == 1 || mainClasse.cf6 == 1 || mainClasse.cf7 == 1
							|| mainClasse.cf8 == 1) {
						mainClasse.plugin.player2.setVie(0);
						mainClasse.plugin.player3.setVie(0);
						mainClasse.plugin.player4.setVie(0);
						mainClasse.plugin.player5.setVie(0);
						mainClasse.plugin.player6.setVie(0);
						mainClasse.plugin.player7.setVie(0);
						mainClasse.plugin.player8.setVie(0);
						Bukkit.getServer().broadcastMessage(
								"§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom() + " a confirmer");
						mainClasse.nbrJoueur = 1;
					}
					mainClasse.plugin.player1.getJoueur().setHealth(20);
					mainClasse.plugin.player1.setEnJeu(0);
					gamestart.joueur2Start();
					Bukkit.getScheduler().cancelTask(task2);
				}

				if (time2 == 10) {
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §bil reste 10 seconds à "
							+ mainClasse.plugin.player1.getNom() + " pour sauter");
				}
				if (time2 == 0) {
					double x = plugin.getConfig().getInt("mapSpawn.x");
					double y = plugin.getConfig().getInt("mapSpawn.y");
					double z = plugin.getConfig().getInt("mapSpawn.z");

					World world = Bukkit.getWorld("world");
					Player a8 = mainClasse.plugin.player1.getJoueur();
					a8.teleport(new Location(world, x, y, z));

					mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() - 1);

					if (mainClasse.cf1 == 1 || mainClasse.cf2 == 1 || mainClasse.cf3 == 1 || mainClasse.cf4 == 1
							|| mainClasse.cf5 == 1 || mainClasse.cf6 == 1 || mainClasse.cf7 == 1
							|| mainClasse.cf8 == 1) {
						if (mainClasse.plugin.player1.getVie() >= 1) {

							Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b"
									+ mainClasse.plugin.player1.getNom() + " n'a pas réussit a confirmer");
							if (mainClasse.cf1 == 1) {
								mainClasse.plugin.player1.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf2 == 1) {
								mainClasse.plugin.player2.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf3 == 1) {
								mainClasse.plugin.player3.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf4 == 1) {
								mainClasse.plugin.player4.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf5 == 1) {
								mainClasse.plugin.player5.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf6 == 1) {
								mainClasse.plugin.player6.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf7 == 1) {
								mainClasse.plugin.player7.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
							if (mainClasse.cf8 == 1) {
								mainClasse.plugin.player8.setVie(1);
								mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
							}
						}
					}

					if (mainClasse.plugin.player1.getVie() == 0) {
						if (mainClasse.nbrJoueur == 2) {
							if (mainClasse.plugin.player2.getVie() >= 1) {
								a15 = mainClasse.plugin.player2.getNumero();
								a16 = mainClasse.plugin.player2.getNom();
							} else if (mainClasse.plugin.player3.getVie() >= 1) {
								a15 = mainClasse.plugin.player3.getNumero();
								a16 = mainClasse.plugin.player3.getNom();
							} else if (mainClasse.plugin.player4.getVie() >= 1) {
								a15 = mainClasse.plugin.player4.getNumero();
								a16 = mainClasse.plugin.player4.getNom();
							} else if (mainClasse.plugin.player5.getVie() >= 1) {
								a15 = mainClasse.plugin.player5.getNumero();
								a16 = mainClasse.plugin.player5.getNom();
							} else if (mainClasse.plugin.player6.getVie() >= 1) {
								a15 = mainClasse.plugin.player6.getNumero();
								a16 = mainClasse.plugin.player6.getNom();
							} else if (mainClasse.plugin.player7.getVie() >= 1) {
								a15 = mainClasse.plugin.player7.getNumero();
								a16 = mainClasse.plugin.player7.getNom();
							} else if (mainClasse.plugin.player8.getVie() >= 1) {
								a15 = mainClasse.plugin.player8.getNumero();
								a16 = mainClasse.plugin.player8.getNom();
							}

							if (a15 > mainClasse.plugin.player1.getNumero()) {
								Bukkit.getServer()
										.broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
												+ " a attendut trop longtemps pour sauter, il lui reste donc "
												+ mainClasse.plugin.player1.getVie() + " vie(s)");
								Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + a16 + " doit confirmer");
								mainClasse.cf1 = 1;

							} else {
								if (mainClasse.cf1 == 1 || mainClasse.cf2 == 1 || mainClasse.cf3 == 1
										|| mainClasse.cf4 == 1 || mainClasse.cf5 == 1 || mainClasse.cf6 == 1
										|| mainClasse.cf7 == 1 || mainClasse.cf8 == 1) {
									Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b"
											+ mainClasse.plugin.player1.getNom() + " n'a pas réussit a confirmer");
									if (mainClasse.cf1 == 1) {
										mainClasse.plugin.player1.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf2 == 1) {
										mainClasse.plugin.player2.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf3 == 1) {
										mainClasse.plugin.player3.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf4 == 1) {
										mainClasse.plugin.player4.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf5 == 1) {
										mainClasse.plugin.player5.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf6 == 1) {
										mainClasse.plugin.player6.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf7 == 1) {
										mainClasse.plugin.player7.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}
									if (mainClasse.cf8 == 1) {
										mainClasse.plugin.player8.setVie(1);
										mainClasse.plugin.player1.setVie(mainClasse.plugin.player1.getVie() + 1);
									}

								} else {
									Bukkit.getServer()
											.broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
													+ " a attendut trop longtemps pour sauter, il lui reste donc "
													+ mainClasse.plugin.player1.getVie() + " vie(s)");
									Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b"
											+ mainClasse.plugin.player1.getNom() + " est eliminé(e)");
									mainClasse.nbrJoueur--;
								}
							}

						} else {
							Bukkit.getServer()
									.broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
											+ " a attendut trop longtemps pour sauter, il lui reste donc "
											+ mainClasse.plugin.player1.getVie() + " vie(s)");
							Bukkit.getServer().broadcastMessage(
									"§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom() + " est eliminé(e)");
							mainClasse.nbrJoueur--;
						}
					} else {
						Bukkit.getServer()
								.broadcastMessage("§3§ldé à coudre> §b" + mainClasse.plugin.player1.getNom()
										+ " a attendut trop longtemps pour sauter, il lui reste donc "
										+ mainClasse.plugin.player1.getVie() + " vie(s)");
					}

					mainClasse.plugin.player1.getJoueur().setHealth(20);
					mainClasse.plugin.player1.setEnJeu(0);
					gamestart.joueur2Start();
					Bukkit.getScheduler().cancelTask(task2);

				}

			}

		}, 20);

	}

}

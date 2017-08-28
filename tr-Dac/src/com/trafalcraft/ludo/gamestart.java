package com.trafalcraft.ludo;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class gamestart {
	static JavaPlugin plugin = mainClasse.plugin;

	public static void joueur1Start() {

		if (mainClasse.nbrJoueur == 1) {
			gamestop.gamestop();
		} else {

			World world = Bukkit.getWorld("world");

			if (mainClasse.plugin.player1.getVie() >= 1) {
				mainClasse.plugin.player1.setEnJeu(1);

				int x = plugin.getConfig().getInt("plongeoir.x");
				int y = plugin.getConfig().getInt("plongeoir.y");
				int z = plugin.getConfig().getInt("plongeoir.z");

				Player a4 = mainClasse.plugin.player1.getJoueur();
				a4.teleport(new Location(world, x, y, z));

				int CAB2 = 60;
				timerjoueur1.startCountdown2(CAB2);

			} else {
				gamestart.joueur2Start();
			}
		}
	}

	public static void joueur2Start() {

		if (mainClasse.nbrJoueur == 1) {
			gamestop.gamestop();
		} else {

			World world = Bukkit.getWorld("world");

			if (mainClasse.plugin.player2.getVie() >= 1) {
				mainClasse.plugin.player2.setEnJeu(1);

				int x = plugin.getConfig().getInt("plongeoir.x");
				int y = plugin.getConfig().getInt("plongeoir.y");
				int z = plugin.getConfig().getInt("plongeoir.z");

				Player a4 = mainClasse.plugin.player2.getJoueur();
				a4.teleport(new Location(world, x, y, z));

				int CAB2 = 60;
				timerjoueur2.startCountdown2(CAB2);

			} else {
				gamestart.joueur3Start();
			}
		}
	}

	public static void joueur3Start() {

		if (mainClasse.nbrJoueur == 1) {
			gamestop.gamestop();
		} else {

			World world = Bukkit.getWorld("world");

			if (mainClasse.plugin.player3.getVie() >= 1) {
				mainClasse.plugin.player3.setEnJeu(1);

				int x = plugin.getConfig().getInt("plongeoir.x");
				int y = plugin.getConfig().getInt("plongeoir.y");
				int z = plugin.getConfig().getInt("plongeoir.z");

				Player a4 = mainClasse.plugin.player3.getJoueur();
				a4.teleport(new Location(world, x, y, z));

				int CAB2 = 60;
				timerjoueur3.startCountdown2(CAB2);

			} else {
				gamestart.joueur4Start();
			}
		}
	}

	public static void joueur4Start() {

		if (mainClasse.nbrJoueur == 1) {
			gamestop.gamestop();
		} else {

			World world = Bukkit.getWorld("world");

			if (mainClasse.plugin.player4.getVie() >= 1) {
				mainClasse.plugin.player4.setEnJeu(1);

				int x = plugin.getConfig().getInt("plongeoir.x");
				int y = plugin.getConfig().getInt("plongeoir.y");
				int z = plugin.getConfig().getInt("plongeoir.z");

				Player a4 = mainClasse.plugin.player4.getJoueur();
				a4.teleport(new Location(world, x, y, z));

				int CAB2 = 60;
				timerjoueur4.startCountdown2(CAB2);

			} else {
				gamestart.joueur5Start();
			}
		}
	}

	public static void joueur5Start() {

		if (mainClasse.nbrJoueur == 1) {
			gamestop.gamestop();
		} else {

			World world = Bukkit.getWorld("world");

			if (mainClasse.plugin.player5.getVie() >= 1) {
				mainClasse.plugin.player5.setEnJeu(1);

				int x = plugin.getConfig().getInt("plongeoir.x");
				int y = plugin.getConfig().getInt("plongeoir.y");
				int z = plugin.getConfig().getInt("plongeoir.z");

				Player a4 = mainClasse.plugin.player5.getJoueur();
				a4.teleport(new Location(world, x, y, z));

				int CAB2 = 60;
				timerjoueur5.startCountdown2(CAB2);

			} else {
				gamestart.joueur6Start();
			}
		}
	}

	public static void joueur6Start() {

		if (mainClasse.nbrJoueur == 1) {
			gamestop.gamestop();
		} else {

			World world = Bukkit.getWorld("world");

			if (mainClasse.plugin.player6.getVie() >= 1) {
				mainClasse.plugin.player6.setEnJeu(1);

				int x = plugin.getConfig().getInt("plongeoir.x");
				int y = plugin.getConfig().getInt("plongeoir.y");
				int z = plugin.getConfig().getInt("plongeoir.z");

				Player a4 = mainClasse.plugin.player6.getJoueur();
				a4.teleport(new Location(world, x, y, z));

				int CAB2 = 60;
				timerjoueur6.startCountdown2(CAB2);

			} else {
				gamestart.joueur7Start();
			}
		}
	}

	public static void joueur7Start() {

		if (mainClasse.nbrJoueur == 1) {
			gamestop.gamestop();
		} else {

			World world = Bukkit.getWorld("world");

			if (mainClasse.plugin.player7.getVie() >= 1) {
				mainClasse.plugin.player7.setEnJeu(1);

				int x = plugin.getConfig().getInt("plongeoir.x");
				int y = plugin.getConfig().getInt("plongeoir.y");
				int z = plugin.getConfig().getInt("plongeoir.z");

				Player a4 = mainClasse.plugin.player7.getJoueur();
				a4.teleport(new Location(world, x, y, z));

				int CAB2 = 60;
				timerjoueur7.startCountdown2(CAB2);

			} else {
				gamestart.joueur8Start();
			}
		}
	}

	public static void joueur8Start() {

		if (mainClasse.nbrJoueur == 1) {
			gamestop.gamestop();
		} else {

			World world = Bukkit.getWorld("world");

			if (mainClasse.plugin.player8.getVie() >= 1) {
				mainClasse.plugin.player8.setEnJeu(1);

				int x = plugin.getConfig().getInt("plongeoir.x");
				int y = plugin.getConfig().getInt("plongeoir.y");
				int z = plugin.getConfig().getInt("plongeoir.z");

				Player a4 = mainClasse.plugin.player8.getJoueur();
				a4.teleport(new Location(world, x, y, z));

				int CAB2 = 0;
				timerjoueur8.startCountdown2(CAB2);

			} else {
				gamestart.joueur1Start();
				mainClasse.cf1 = 0;
				mainClasse.cf2 = 0;
				mainClasse.cf3 = 0;
				mainClasse.cf4 = 0;
				mainClasse.cf5 = 0;
				mainClasse.cf6 = 0;
				mainClasse.cf7 = 0;
				mainClasse.cf8 = 0;
			}
		}
	}
}

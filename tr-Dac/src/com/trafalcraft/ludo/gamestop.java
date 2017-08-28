package com.trafalcraft.ludo;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import com.trafalcraft.ludo.util.endGame;

public class gamestop {
	static JavaPlugin plugin = mainClasse.plugin;
	static String a9;

	public static void gamestop() {
		if (mainClasse.plugin.player1.getVie() >= 1) {
			a9 = mainClasse.plugin.player1.getNom();
		}
		if (mainClasse.plugin.player2.getVie() >= 1) {
			a9 = mainClasse.plugin.player2.getNom();
		}
		if (mainClasse.plugin.player3.getVie() >= 1) {
			a9 = mainClasse.plugin.player3.getNom();
		}
		if (mainClasse.plugin.player4.getVie() >= 1) {
			a9 = mainClasse.plugin.player4.getNom();
		}
		if (mainClasse.plugin.player5.getVie() >= 1) {
			a9 = mainClasse.plugin.player5.getNom();
		}
		if (mainClasse.plugin.player6.getVie() >= 1) {
			a9 = mainClasse.plugin.player6.getNom();
		}
		if (mainClasse.plugin.player7.getVie() >= 1) {
			a9 = mainClasse.plugin.player7.getNom();
		}
		if (mainClasse.plugin.player8.getVie() >= 1) {
			a9 = mainClasse.plugin.player8.getNom();
		}
		Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §b" + a9 + " a gagné(e)!!!!!!");
		endGame.endGame();
	}
}

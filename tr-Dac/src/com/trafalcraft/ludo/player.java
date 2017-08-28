package com.trafalcraft.ludo;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class player {
	String nomJoueur;
	int nbrVie;
	Player player;
	int enJeu;
	int numero;

	public player() {
		System.out.println("joueur creee");
		nomJoueur = "inconnu";
		nbrVie = 0;
		player = null;
		enJeu = 0;
		numero = 0;
	}

	public player(String pNom, int pNbr, Player joueur, int eJ, int num) {
		System.out.println("joueur avec parametre creee");
		nomJoueur = pNom;
		nbrVie = pNbr;
		player = joueur;
		enJeu = eJ;
		numero = num;
	}

	public String getNom() {
		return nomJoueur;
	}

	public int getVie() {
		return nbrVie;
	}

	public Player getJoueur() {
		return player;
	}

	public int getEnJeu() {
		return enJeu;
	}

	public int getNumero() {
		return numero;
	}

	public void setVie(int nbr) {
		nbrVie = nbr;
	}

	public void setNom(String Nom) {
		nomJoueur = Nom;
	}

	public void setJoueur(Player p) {
		player = p;
	}

	public void setEnJeu(int ej) {
		enJeu = ej;
	}

}

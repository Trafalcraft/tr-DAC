package com.trafalcraft.dac.data;

import org.bukkit.entity.Player;

public class Joueur {
	Player player;
	String arene;
	boolean inGame;	
	int nbrVie;
	int nbrSaut;
	String block;
	int nbrPoint;
	int nbrdac = 0;
	int nbrMort = 0;
	
	public Joueur(Player p, String c, String a){
		this.player = p;
		this.arene = a;
		this.inGame = false;
		this.nbrVie = 1;
		this.nbrSaut = 0;
		this.nbrPoint= 0;
	}
	
	public void setNbrMort(int i){
		this.nbrMort = i;
	}
	
	public int getNbrMort(){
		return this.nbrMort;
	}
	
	public void setNbrDac(int i){
		this.nbrdac = i;
	}
	
	public int getNbrDac(){
		return this.nbrdac;
	}
	
	public int getNbrPoint(){
		return this.nbrPoint;
	}
	
	public void setNbrpoint(int i){
		this.nbrPoint = i;
	}
	
	public String getBlock(){
		return block;
	}
	
	public void setBlock(String s){
		this.block = s;
	}
	
	public int getNbrSaut(){
		return this.nbrSaut;
	}
	
	public void setNbrSaut(int s){
		this.nbrSaut = s;
	}
	
	public void setPlayer(Player pl){
		this.player = pl;
	}
	
	public void setArene(String ar){
		this.arene = ar;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public String getArene(){
		return this.arene;
	}
	
	public boolean getInGame(){
		return this.inGame;
	}
	
	public void setInGame(boolean b){
		this.inGame = b;
	}
	
	public void setNbrVie(int i){
		this.nbrVie = i;
	}
	
	public int getNbrVie(){
		return this.nbrVie;
	}
}

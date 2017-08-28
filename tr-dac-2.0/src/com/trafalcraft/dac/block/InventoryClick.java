package com.trafalcraft.dac.block;

import org.bukkit.entity.Player;

import com.trafalcraft.dac.Controler.ArenaControle;
import com.trafalcraft.dac.Controler.PlayerControle;

public class InventoryClick {
public static void clicInventory(Player p, short item){
		
		String arene = PlayerControle.getJoueur(p.getName()).getArene();
		
		if(item == 0){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("laineblanche")){
					PlayerControle.getJoueur(p.getName()).setBlock("laineblanche");
					ArenaControle.getArena(arene).getBlockList().remove("laineblanche");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur blanche");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("laineblanche")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("laineblanche");
					ArenaControle.getArena(arene).getBlockList().remove("laineblanche");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur blanche");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 1){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("laineorange")){
					PlayerControle.getJoueur(p.getName()).setBlock("laineorange");
					ArenaControle.getArena(arene).getBlockList().remove("laineorange");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur orange");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("laineorange")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("laineorange");
					ArenaControle.getArena(arene).getBlockList().remove("laineorange");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur orange");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 2){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainemagenta")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainemagenta");
					ArenaControle.getArena(arene).getBlockList().remove("lainemagenta");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur magenta");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainemagenta")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainemagenta");
					ArenaControle.getArena(arene).getBlockList().remove("lainemagenta");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur magenta");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 3){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("laineblueclair")){
					PlayerControle.getJoueur(p.getName()).setBlock("laineblueclair");
					ArenaControle.getArena(arene).getBlockList().remove("laineblueclair");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur bleu clair");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("laineblueclair")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("laineblueclair");
					ArenaControle.getArena(arene).getBlockList().remove("laineblueclair");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur bleu clair");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 4){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainejaune")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainejaune");
					ArenaControle.getArena(arene).getBlockList().remove("lainejaune");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur jaune");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainejaune")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainejaune");
					ArenaControle.getArena(arene).getBlockList().remove("lainejaune");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur jaune");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 5){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainevert")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainevert");
					ArenaControle.getArena(arene).getBlockList().remove("lainevert");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur verte");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainevert")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainevert");
					ArenaControle.getArena(arene).getBlockList().remove("lainevert");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur verte");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 6){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainerose")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainerose");
					ArenaControle.getArena(arene).getBlockList().remove("lainerose");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur rose");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainerose")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainerose");
					ArenaControle.getArena(arene).getBlockList().remove("lainerose");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur rose");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 7){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainegris")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainegris");
					ArenaControle.getArena(arene).getBlockList().remove("lainegris");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur grise");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainegris")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainegris");
					ArenaControle.getArena(arene).getBlockList().remove("lainegris");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur grise");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 8){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainegrisclair")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainegrisclair");
					ArenaControle.getArena(arene).getBlockList().remove("lainegrisclair");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur gris clair");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
				
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainegrisclair")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainegrisclair");
					ArenaControle.getArena(arene).getBlockList().remove("lainegrisclair");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur gris clair");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 9){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("laineblueciel")){
					PlayerControle.getJoueur(p.getName()).setBlock("laineblueciel");
					ArenaControle.getArena(arene).getBlockList().remove("laineblueciel");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur cian");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("laineblueciel")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("laineblueciel");
					ArenaControle.getArena(arene).getBlockList().remove("laineblueciel");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur cian");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 10){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("laineviolet")){
					PlayerControle.getJoueur(p.getName()).setBlock("laineviolet");
					ArenaControle.getArena(arene).getBlockList().remove("laineviolet");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur violette");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("laineviolet")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("laineviolet");
					ArenaControle.getArena(arene).getBlockList().remove("laineviolet");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur violette");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 11){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("laineblue")){
					PlayerControle.getJoueur(p.getName()).setBlock("laineblue");
					ArenaControle.getArena(arene).getBlockList().remove("laineblue");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur bleue");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("laineblue")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("laineblue");
					ArenaControle.getArena(arene).getBlockList().remove("laineblue");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur bleue");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 12){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainemarron")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainemarron");
					ArenaControle.getArena(arene).getBlockList().remove("lainemarron");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur marron");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainemarron")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainemarron");
					ArenaControle.getArena(arene).getBlockList().remove("lainemarron");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur marron");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 13){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainevertfoncé")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainevertfoncé");
					ArenaControle.getArena(arene).getBlockList().remove("lainevertfoncé");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur vert foncé");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainevertfoncé")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainevertfoncé");
					ArenaControle.getArena(arene).getBlockList().remove("lainevertfoncé");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur vert foncé");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 14){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainerouge")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainerouge");
					ArenaControle.getArena(arene).getBlockList().remove("lainerouge");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur rouge");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
				
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainerouge")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainerouge");
					ArenaControle.getArena(arene).getBlockList().remove("lainerouge");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur rouge");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		}else if(item == 15){
			if(PlayerControle.getJoueur(p.getName()).getBlock() == null){
				if(ArenaControle.getArena(arene).getBlockList().contains("lainenoir")){
					PlayerControle.getJoueur(p.getName()).setBlock("lainenoir");
					ArenaControle.getArena(arene).getBlockList().remove("lainenoir");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur noir");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
				
			}else{
				if(ArenaControle.getArena(arene).getBlockList().contains("lainenoir")){
					ArenaControle.getArena(arene).getBlockList().add(PlayerControle.getJoueur(p.getName()).getBlock());
					PlayerControle.getJoueur(p.getName()).setBlock("lainenoir");
					ArenaControle.getArena(arene).getBlockList().remove("lainenoir");
					
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "vous avez choisi la couleur noir");
				}else{
					p.closeInventory();
					p.sendMessage("§3§lDAC> §b" + "cette couleur est deja prise");
				}
			}
		} 
	}
}

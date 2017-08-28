package com.trafalcraft.dac.block;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.trafalcraft.dac.Controler.PlayerControle;

public class ColorName {
	public static void viewColor(Player p){
		
		if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("laineblanche")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 0);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainerouge")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 14);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainejaune")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 4);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("laineblue")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 11);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainemagenta")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 2);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("laineorange")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 1);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("laineblueclair")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 3);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainevert")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 5);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainegris")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 7);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("laineblueciel")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 9);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("laineviolet")){
			
			p.setDisplayName("violet" + p.getName());
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 10);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainerose")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 6);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainemarron")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 12);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainevertfoncé")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 13);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainegrisclair")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 8);
			p.getInventory().setItem(8, i);
			
		}else if(PlayerControle.getJoueur(p.getName()).getBlock().equalsIgnoreCase("lainenoir")){
			
			ItemStack i = new ItemStack(Material.WOOL);
			i.setDurability((short) 15);
			p.getInventory().setItem(8, i);
			
		}
	}
}

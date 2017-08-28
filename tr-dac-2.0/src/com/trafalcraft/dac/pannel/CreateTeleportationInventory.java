package com.trafalcraft.dac.pannel;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.trafalcraft.dac.file.FileControler;

public class CreateTeleportationInventory {
	
	public static void loadInventoryteleportation(Player p, String arene){
		
		Inventory inv = Bukkit.createInventory(p, 36, arene + ";tpInventory;dac");
		
		if(FileControler.getArena(arene).contains("pos1.x")){
			
			ItemStack item = new ItemStack(Material.ENDER_PEARL);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("pos1");
			
			List<String> lore = new ArrayList<String>();
			lore.add(FileControler.getArena(arene).getInt("pos1.x") + "");
			lore.add(FileControler.getArena(arene).getInt("pos1.y") + "");
			lore.add(FileControler.getArena(arene).getInt("pos1.z") + "");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(9, item);
			
		}else{
			
			ItemStack item = new ItemStack(Material.BARRIER);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("pos1");
			
			List<String> lore = new ArrayList<String>();
			lore.add("information non configurée");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(9, item);
		}
		
		if(FileControler.getArena(arene).contains("pos2.x")){
			
			ItemStack item = new ItemStack(Material.ENDER_PEARL);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("pos2");
			
			List<String> lore = new ArrayList<String>();
			lore.add(FileControler.getArena(arene).getInt("pos2.x") + "");
			lore.add(FileControler.getArena(arene).getInt("pos2.y") + "");
			lore.add(FileControler.getArena(arene).getInt("pos2.z") + "");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(11, item);
			
		}else{
			
			ItemStack item = new ItemStack(Material.BARRIER);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("pos2");
			
			List<String> lore = new ArrayList<String>();
			lore.add("information non configurée");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(11, item);
		}
		
		if(FileControler.getArena(arene).contains("plongeoir.x")){
			
			ItemStack item = new ItemStack(Material.ENDER_PEARL);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("plongeoir");
			
			List<String> lore = new ArrayList<String>();
			lore.add(FileControler.getArena(arene).getInt("plongeoir.x") + "");
			lore.add(FileControler.getArena(arene).getInt("plongeoir.y") + "");
			lore.add(FileControler.getArena(arene).getInt("plongeoir.z") + "");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(13, item);
			
		}else{
			
			ItemStack item = new ItemStack(Material.BARRIER);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("plongeoir");
			
			List<String> lore = new ArrayList<String>();
			lore.add("information non configurée");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(13, item);
		}
		
		if(FileControler.getArena(arene).contains("lobby.x")){
			
			ItemStack item = new ItemStack(Material.ENDER_PEARL);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("lobby");
			
			List<String> lore = new ArrayList<String>();
			lore.add(FileControler.getArena(arene).getInt("lobby.x") + "");
			lore.add(FileControler.getArena(arene).getInt("lobby.y") + "");
			lore.add(FileControler.getArena(arene).getInt("lobby.z") + "");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(15, item);
			
		}else{
			
			ItemStack item = new ItemStack(Material.BARRIER);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("lobby");
			
			List<String> lore = new ArrayList<String>();
			lore.add("information non configurée");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(15, item);
		}
		
		if(FileControler.getArena(arene).contains("eventlobby.x")){
			
			ItemStack item = new ItemStack(Material.ENDER_PEARL);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("lobby event");
			
			List<String> lore = new ArrayList<String>();
			lore.add(FileControler.getArena(arene).getInt("eventlobby.x") + "");
			lore.add(FileControler.getArena(arene).getInt("eventlobby.y") + "");
			lore.add(FileControler.getArena(arene).getInt("eventlobby.z") + "");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(17, item);
			
		}else{
			
			ItemStack item = new ItemStack(Material.BARRIER);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("lobby event");
			
			List<String> lore = new ArrayList<String>();
			lore.add("information non configurée");
			i.setLore(lore);
			
			item.setItemMeta(i);
			
			inv.setItem(17, item);
		}
		
		ItemStack item = new ItemStack(Material.ARROW);		
		ItemMeta i = item.getItemMeta();
		i.setDisplayName("back");
		
		item.setItemMeta(i);
		
		inv.setItem(31, item);
		
		p.openInventory(inv);
		
	}
}

package com.trafalcraft.dac.pannel;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CreateInventoryAction {
	public static void loadInventoryInfo(Player p, String arene){
		
		Inventory inv = Bukkit.createInventory(p, 36, arene + ";actionInventory;dac");
		
			ItemStack item = new ItemStack(Material.STONE);		
			ItemMeta i = item.getItemMeta();
			i.setDisplayName("stone plaque");
			
			item.setItemMeta(i);
			
			inv.setItem(11, item);
			

			ItemStack item4 = new ItemStack(Material.GLASS);		
			ItemMeta i4 = item.getItemMeta();
			i4.setDisplayName("all dac");
			
			item4.setItemMeta(i4);
			
			inv.setItem(13, item4);
			
			
			
			ItemStack item2 = new ItemStack(Material.SKULL_ITEM);	
			item2.setDurability((short) 3);
			
			SkullMeta i2 = (SkullMeta) item2.getItemMeta();
			i2.setDisplayName("tour suivant");
			i2.setOwner("MHF_ArrowRight");
			
			item2.setItemMeta(i2);
			
			inv.setItem(15, item2);
			
			
			
			ItemStack item3 = new ItemStack(Material.ARROW);		
			ItemMeta i3 = item3.getItemMeta();
			i3.setDisplayName("back");
			
			item3.setItemMeta(i3);
			
			inv.setItem(31, item3);
			
			p.openInventory(inv);
	}	
}

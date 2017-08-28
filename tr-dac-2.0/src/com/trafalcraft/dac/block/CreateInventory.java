package com.trafalcraft.dac.block;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CreateInventory {
	public static Inventory craftInventory(Player p){
		
		Inventory inv = Bukkit.createInventory(p, 18, "null;block;dac");
		ItemStack i = new ItemStack(Material.WOOL);

		for(int in = 0; in < 16; in++){
			i.setDurability((short) in);
			inv.addItem(i);
		}
		
		return inv;
	
}
}

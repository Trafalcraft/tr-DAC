package com.trafalcraft.ludo;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class regen {

	static JavaPlugin plugin = mainClasse.plugin;

	public static void regen() {

		if (plugin.getConfig().getInt("piscinePos1.x") > plugin.getConfig().getInt("piscinePos2.x")) {

			int t1 = plugin.getConfig().getInt("piscinePos2.x");
			plugin.getConfig().set("piscinePos2.x", plugin.getConfig().getInt("piscinePos1.x"));
			plugin.getConfig().set("piscinePos1.x", t1);
		}
		if (plugin.getConfig().getInt("piscinePos1.y") > plugin.getConfig().getInt("piscinePos2.y")) {

			int t2 = plugin.getConfig().getInt("piscinePos2.y");
			plugin.getConfig().set("piscinePos2.y", plugin.getConfig().getInt("piscinePos1.y"));
			plugin.getConfig().set("piscinePos1.y", t2);
		}
		if (plugin.getConfig().getInt("piscinePos1.z") > plugin.getConfig().getInt("piscinePos2.z")) {

			int t3 = plugin.getConfig().getInt("piscinePos2.z");
			plugin.getConfig().set("piscinePos2.z", plugin.getConfig().getInt("piscinePos1.z"));
			plugin.getConfig().set("piscinePos1.z", t3);
		}

		int x1 = plugin.getConfig().getInt("piscinePos1.x");
		int y1 = plugin.getConfig().getInt("piscinePos1.y");
		int z1 = plugin.getConfig().getInt("piscinePos1.z");

		int x2 = plugin.getConfig().getInt("piscinePos2.x");
		int y2 = plugin.getConfig().getInt("piscinePos2.y");
		int z2 = plugin.getConfig().getInt("piscinePos2.z");

		for (int i3 = 0; z1 + i3 != z2 + 1; i3++) {
			for (int i2 = 0; y1 + i2 != y2 + 1; i2++) {
				for (int i1 = 0; x1 + i1 != x2 + 1; i1++) {
					World world = Bukkit.getWorld("world");
					Location pos1 = new Location(world, x1 + i1, y1 + i2, z1 + i3);
					pos1.getBlock().setType(Material.WATER);
				}
			}
		}
	}
}

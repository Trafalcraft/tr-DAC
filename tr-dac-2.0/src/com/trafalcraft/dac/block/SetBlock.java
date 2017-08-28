package com.trafalcraft.dac.block;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;

public class SetBlock {
	public static void setBlock(Location loc, String s){
		if(s.equalsIgnoreCase("laineblanche")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.WHITE.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainerouge")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.RED.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainejaune")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.YELLOW.getWoolData(), true);
		}else if(s.equalsIgnoreCase("laineblue")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.BLUE.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainemagenta")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.MAGENTA.getWoolData(), true);
		}else if(s.equalsIgnoreCase("laineorange")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.ORANGE.getWoolData(), true);
		}else if(s.equalsIgnoreCase("laineblueclair")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.LIGHT_BLUE.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainevert")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.LIME.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainegris")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.GRAY.getWoolData(), true);
		}else if(s.equalsIgnoreCase("laineblueciel")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.CYAN.getWoolData(), true);
		}else if(s.equalsIgnoreCase("laineviolet")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.PURPLE.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainerose")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.PINK.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainemarron")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.BROWN.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainevertfoncé")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.GREEN.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainegrisclair")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.SILVER.getWoolData(), true);
		}else if(s.equalsIgnoreCase("lainenoir")){
			loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), DyeColor.BLACK.getWoolData(), true);
		}
	}
}

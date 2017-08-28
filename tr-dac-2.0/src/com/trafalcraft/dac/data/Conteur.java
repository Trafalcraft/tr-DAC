package com.trafalcraft.dac.data;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class Conteur {
	ArrayList<Block> attente = new ArrayList<Block>();
	int nbrBlock = 0;
	ArrayList<Location> location = new ArrayList<Location>();
	
	
	public Conteur(){
	}
	
	public int conter(Location loc){
		
		loc.setY(loc.getY() - 1);
		
		attente.add(loc.getBlock());
		location.add(loc.getBlock().getLocation());
		nbrBlock++;
		
		while(attente.size() > 0){
			this.conterBlock(attente.get(0));
		}
		
		return this.nbrBlock;
	}
	
	private void conterBlock(Block b){
		
		if(b.getRelative(BlockFace.NORTH).getType() == b.getType()){
			if(b.getType() == Material.WOOL){
				if(b.getData() == b.getRelative(BlockFace.NORTH).getData()){
					
					if(! location.contains(b.getRelative(BlockFace.NORTH).getLocation())){
						attente.add(b.getRelative(BlockFace.NORTH));
						location.add(b.getRelative(BlockFace.NORTH).getLocation());
						this.nbrBlock = this.nbrBlock + 1;
					}	
					
				
				}
			}else{
				if(! location.contains(b.getRelative(BlockFace.NORTH).getLocation())){
					attente.add(b.getRelative(BlockFace.NORTH));
					location.add(b.getRelative(BlockFace.NORTH).getLocation());
					this.nbrBlock = this.nbrBlock + 1;
				}
			}
		}
		
		if(b.getRelative(BlockFace.SOUTH).getType() == b.getType()){
			if(b.getType() == Material.WOOL){
				if(b.getData() == b.getRelative(BlockFace.SOUTH).getData()){
					
					if(! location.contains(b.getRelative(BlockFace.SOUTH).getLocation())){
						attente.add(b.getRelative(BlockFace.SOUTH));
						location.add(b.getRelative(BlockFace.SOUTH).getLocation());
						this.nbrBlock = this.nbrBlock + 1;
					}	
					
				
				}
			}else{
				if(! location.contains(b.getRelative(BlockFace.SOUTH).getLocation())){
					attente.add(b.getRelative(BlockFace.SOUTH));
					location.add(b.getRelative(BlockFace.SOUTH).getLocation());
					this.nbrBlock = this.nbrBlock + 1;
				}
			}
		}
		
		if(b.getRelative(BlockFace.EAST).getType() == b.getType()){
			if(b.getType() == Material.WOOL){
				if(b.getData() == b.getRelative(BlockFace.EAST).getData()){
					
					if(! location.contains(b.getRelative(BlockFace.EAST).getLocation())){
						attente.add(b.getRelative(BlockFace.EAST));
						location.add(b.getRelative(BlockFace.EAST).getLocation());
						this.nbrBlock = this.nbrBlock + 1;
					}	
					
				
				}
			}else{
				if(! location.contains(b.getRelative(BlockFace.EAST).getLocation())){
					attente.add(b.getRelative(BlockFace.EAST));
					location.add(b.getRelative(BlockFace.EAST).getLocation());
					this.nbrBlock = this.nbrBlock + 1;
				}
			}
		}
		
		if(b.getRelative(BlockFace.WEST).getType() == b.getType()){
			if(b.getType() == Material.WOOL){
				if(b.getData() == b.getRelative(BlockFace.WEST).getData()){
					
					if(! location.contains(b.getRelative(BlockFace.WEST).getLocation())){
						attente.add(b.getRelative(BlockFace.WEST));
						location.add(b.getRelative(BlockFace.WEST).getLocation());
						this.nbrBlock = this.nbrBlock + 1;
					}	
					
				
				}
			}else{
				if(! location.contains(b.getRelative(BlockFace.WEST).getLocation())){
					attente.add(b.getRelative(BlockFace.WEST));
					location.add(b.getRelative(BlockFace.WEST).getLocation());
					this.nbrBlock = this.nbrBlock + 1;
				}
			}
		}
		
		attente.remove(0);
		
	}
}

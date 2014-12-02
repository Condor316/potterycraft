package uk.co.ofsol.pottery.blocks;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MultiBlockStructure extends Block{

	//declare variables
	public static int x, y ,z;
	public static Map<Character, Block> materials;
	public static String[][] pattern;
	
	//basic constructor: sets the dimensions of the multi-block, but requires that the pattern, and materials be initialised manually.
	public MultiBlockStructure(Material mat, int sizeX, int sizeY, int sizeZ) {
		super(mat);
		this.x = sizeX;
		this.y = sizeY;
		this.z = sizeZ;		
	}
	
	//pattern should be made up of integers (y = air block, z = anything)
	public MultiBlockStructure(Material mat, int sizeX, int sizeY, int sizeZ, String[][] pat, char materialOrder[], Block[] mats) {
		super(mat);
		this.x = sizeX;
		this.y = sizeY;
		this.z = sizeZ;
		this.setPattern(pat);
		try 
		{
			this.fillMats(materialOrder, mats);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
	
	//set up the pattern for this multi-block structure
	public void setPattern(String[][] pat)
	{
		this.pattern = pat;
	}
	
	//fill the materials list for the pattern.
	public void fillMats(char order[], Block[] mats) throws Exception
	{
		if (order.length == mats.length)
		{
			for (int i = 0; i < order.length; i++)
			{
				this.materials.put(order[i] , mats[i]);
			}
		}
		else
		{
			throw(new Exception("We do not seem to have the correct number of Blocks or characters for the pattern... please ensure that each material is accompanied with a character to match against the pattern"));
		}
	}
	
	
}

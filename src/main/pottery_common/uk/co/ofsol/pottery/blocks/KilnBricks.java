package uk.co.ofsol.pottery.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class KilnBricks extends Block {

	public KilnBricks(Material mat) {
		super(mat);
		this.setHardness(2f);
		this.setStepSound(Block.soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
	}

}

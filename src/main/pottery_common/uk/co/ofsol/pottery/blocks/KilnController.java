package uk.co.ofsol.pottery.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class KilnController extends Block {

	public KilnController(Material mat) {
		super(mat);
		this.setHardness(2f);
		this.setStepSound(Block.soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
	}

}

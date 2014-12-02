package uk.co.ofsol.pottery.items;

import uk.co.ofsol.pottery.Pottery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Mallett extends Item{
	public Mallett()
	{
		this.setMaxDamage(10);
		this.setMaxStackSize(1);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, final int x, final int y, final int z, int w, float par8, float par9, float par10)
	{
		if (player.isSneaking())
		{
			player.openGui(Pottery.instance, 0, world, 0, 0, 0);
			return false;
		}
		else { return true;}
	}
}

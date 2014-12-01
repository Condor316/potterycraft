package uk.co.ofsol.pottery.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Mallett extends Item{
	public Mallett()
	{
		this.setMaxDamage(10);
		this.setMaxStackSize(1);
	}
	
	 @Override
	    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
	    {
	        return false;
	    }
	 
	 @Override
	    public ItemStack getContainerItem(ItemStack itemStack)
	    {
	        ItemStack copiedStack = itemStack.copy();

	        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
	        copiedStack.stackSize = 1;

	        return copiedStack;
	    }

}

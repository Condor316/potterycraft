package uk.co.ofsol.pottery.gui.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class potteryTab extends CreativeTabs{

	public potteryTab(String lable) {
		super(lable);
	}
	
	@Override
	public Item getTabIconItem() {
		return this.icon;
	}
	// Member Variables
	
	public void setTabIconItem(Item icon)
	{
		this.icon = icon;
	}
	public static Item icon;
}

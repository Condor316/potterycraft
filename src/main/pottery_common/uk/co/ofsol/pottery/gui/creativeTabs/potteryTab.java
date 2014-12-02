package uk.co.ofsol.pottery.gui.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class potteryTab extends CreativeTabs{

	public potteryTab(String label) {
		super(label);
	}
	
	@Override
	public Item getTabIconItem() {
		return this.icon;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel()
    {
        return "PotteryCraft";
    }
	
	public void setTabIconItem(Item icon)
	{
		this.icon = icon;
	}
	
	// Member Variables
	public static Item icon;
}

package uk.co.ofsol.pottery;

/*
 * pottery_common
 * 
 * Pottery
 * 
 * @author Condor316
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenceses/lgpl.html)
 * 
 */

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import uk.co.ofsol.pottery.blocks.KilnBricks;
import uk.co.ofsol.pottery.core.proxy.CommonProxy;
import uk.co.ofsol.pottery.gui.creativeTabs.potteryTab;
import uk.co.ofsol.pottery.items.FireCement;
import uk.co.ofsol.pottery.items.KilnBrick;
import uk.co.ofsol.pottery.items.Mallett;
import uk.co.ofsol.pottery.items.Mud;
import uk.co.ofsol.pottery.items.NetherrackDust;
import uk.co.ofsol.pottery.items.SoulDust;
import uk.co.ofsol.pottery.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
		modid = Reference.MOD_ID, 
		name = Reference.MOD_NAME,
		version = Reference.VERSION_NUMBER)

public class Pottery
{   
	
	@Instance (Reference.MOD_ID)
	public static Pottery instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static potteryTab potteryTab = new potteryTab("Pottery");
	
	public static Block kilnBricks = new KilnBricks(Material.rock).setBlockName("kilnbricks").setBlockTextureName("potterycraft:kilnbricks").setCreativeTab(potteryTab);
	public static Item kilnBrick = new KilnBrick().setUnlocalizedName("kilnbrick").setTextureName("potterycraft:kilnbrick").setCreativeTab(potteryTab);
	public static Item mallett = new Mallett().setUnlocalizedName("mallett").setTextureName("potterycraft:mallett").setCreativeTab(potteryTab);
	public static Item soulDust = new SoulDust().setUnlocalizedName("souldust").setTextureName("potterycraft:souldust").setCreativeTab(potteryTab);
	public static Item netherrackDust = new NetherrackDust().setUnlocalizedName("netherrackdust").setTextureName("potterycraft:netherrackdust").setCreativeTab(potteryTab);
	public static Item mud = new Mud().setUnlocalizedName("mud").setTextureName("potterycraft:mud").setCreativeTab(potteryTab);
	public static Item firecement = new FireCement().setUnlocalizedName("firecement").setTextureName("potterycraft:firecement").setCreativeTab(potteryTab);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Register Blocks
		GameRegistry.registerBlock(kilnBricks, "Kiln Bricks");
		
		//Register Items
		GameRegistry.registerItem(kilnBrick, "Kiln Brick");
		GameRegistry.registerItem(mud, "Mud");
		GameRegistry.registerItem(netherrackDust, "Netherrack Dust");
		GameRegistry.registerItem(soulDust, "Soul Dust");
		GameRegistry.registerItem(firecement, "Fire Cement");
		GameRegistry.registerItem(mallett, "Mallett");
		//Register Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(mud, 1), Blocks.dirt, Items.water_bucket);
		GameRegistry.addShapelessRecipe(new ItemStack(netherrackDust, 4), Blocks.netherrack, new ItemStack(mallett));
		GameRegistry.addShapelessRecipe(new ItemStack(soulDust, 4), Blocks.soul_sand, new ItemStack(mallett));
		GameRegistry.addShapelessRecipe(new ItemStack(firecement, 1), mud, netherrackDust, soulDust);
		GameRegistry.addSmelting(firecement, new ItemStack(kilnBrick), 2.0F);
		GameRegistry.addRecipe(new ItemStack(kilnBricks, 1), "xx", "xx",'x', kilnBrick);
		GameRegistry.addRecipe(new ItemStack(mallett, 1, 10), " x ", " yx", "y  ", 'x', Blocks.planks, 'y', Items.stick);
		
		//add Icon to the Creative Tab
		potteryTab.setTabIconItem(mallett);
		
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		/*TODO add code!*/
        
    }
    @EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		/*TODO add code!*/
	}
    
   
    public void takenFromCrafting(EntityPlayer player, ItemStack item, IInventory matrix)
    {
             for(int i=0; i<matrix.getSizeInventory(); i++)
    {               
             if(matrix.getStackInSlot(i) != null)
             {
             ItemStack itemnew = matrix.getStackInSlot(i);
             if(itemnew != null && itemnew.getItem() == mallett)
             {
             ItemStack k = new ItemStack(mallett, 2);
             k.damageItem(itemnew.getItemDamage() + 1, player);
             matrix.setInventorySlotContents(i, k);
             }
             }      
    }
    }
}
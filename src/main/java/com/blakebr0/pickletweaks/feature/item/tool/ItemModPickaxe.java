package com.blakebr0.pickletweaks.feature.item.tool;

import com.blakebr0.cucumber.iface.IRepairMaterial;
import com.blakebr0.pickletweaks.PickleTweaks;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemModPickaxe extends ItemPickaxe implements IRepairMaterial {

	private ItemStack repairMaterial;
	
	public ItemModPickaxe(String name, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("pt." + name);
		this.setCreativeTab(PickleTweaks.tab);
	}
	
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return OreDictionary.itemMatches(getRepairMaterial(), repair, false);
    }
	
	@Override
	public ItemStack getRepairMaterial() {
		return this.repairMaterial;
	}

	@Override
	public void setRepairMaterial(ItemStack stack) {
		this.repairMaterial = stack;
	}
}
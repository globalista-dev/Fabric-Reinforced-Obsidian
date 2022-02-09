package com.globalista.romod;

import com.globalista.romod.block.ModBlocks;
import com.globalista.romod.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoMod implements ModInitializer {

	public static final String MOD_ID = "romod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ItemGroup ROGROUP = FabricItemGroupBuilder.build(new Identifier(RoMod.MOD_ID, "rogroup"),
			() -> new ItemStack(ModBlocks.REINFORCED_OBSIDIAN));

	@Override
	public void onInitialize() {


		if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
			BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_IRON_BARS, RenderLayer.getCutout());
			BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REINFORCED_TINTED_GLASS, RenderLayer.getTranslucent());
			BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REINFORCED_GLASS, RenderLayer.getTranslucent());
		}

		ModBlocks.callBlocks();
		ModItems.callItems();

		LOGGER.info("Fabric Reinforced Obsidian!");
	}
}

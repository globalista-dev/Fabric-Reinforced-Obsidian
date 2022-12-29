package com.globalista.romod;

import com.globalista.romod.block.ROBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.globalista.romod.block.ROBlocks.*;

public class ROMod implements ModInitializer {

    public static final String MOD_ID = "romod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ItemGroup ROGROUP = FabricItemGroup.builder(new Identifier(ROMod.MOD_ID, "rogroup")).icon(()
            -> new ItemStack(ROBlocks.REINFORCED_OBSIDIAN)).build();

    @Override
    public void onInitialize() {


        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            BlockRenderLayerMap.INSTANCE.putBlock(REINFORCED_IRON_BARS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(REINFORCED_TINTED_GLASS, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putBlock(REINFORCED_GLASS, RenderLayer.getTranslucent());
        }

        ROBlocks.callBlocks();

        LOGGER.info("Fabric Reinforced Obsidian!");
    }
}

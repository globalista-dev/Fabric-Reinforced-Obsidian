package com.globalista.romod.block;

import com.globalista.romod.RoMod;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PaneBlock;
import net.minecraft.client.render.RenderLayer;

public class ModPaneBlocks extends PaneBlock implements BlockRegister {

    protected ModPaneBlocks(Settings settings) {
        super(settings);
    }

    public static void callPaneBlocks() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModPaneBlocks.DARK_IRON_BARS, RenderLayer.getCutout());
        System.out.println("Registering RoMod blocks");
    }

    public static final Block DARK_IRON_BARS = BlockRegister.registerBlock("dark_iron_bars",
            new ModPaneBlocks(FabricBlockSettings.of(Material.METAL).strength(7.0f, 92.8f).requiresTool().nonOpaque()), RoMod.ROGROUP);


}

package com.globalista.romod.block;

import com.globalista.romod.ROMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;

import static com.globalista.romod.util.RORegister.registerBlock;

public class ROBlocks {

    public static final Block REINFORCED_OBSIDIAN = registerBlock("reinforced_obsidian",
            new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE).strength(50.0f, 3600000.0f).requiresTool()), ROMod.ROGROUP);

    public static final Block REINFORCED_OBSIDIAN_SLAB = registerBlock("reinforced_obsidian_slab",
           new SlabBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE).strength(50.0f, 3600000.0f).requiresTool()), ROMod.ROGROUP);

    public static final Block REINFORCED_OBSIDIAN_WALL = registerBlock("reinforced_obsidian_wall",
            new WallBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE).strength(50.0f, 3600000.0f).requiresTool()), ROMod.ROGROUP);

    public static final Block REINFORCED_OBSIDIAN_STAIRS = registerBlock("reinforced_obsidian_stairs",
            new ROStairsBlock(REINFORCED_OBSIDIAN.getDefaultState(), FabricBlockSettings.create().sounds(BlockSoundGroup.STONE).strength(50.0f, 3600000.0f).requiresTool()), ROMod.ROGROUP);
    public static final Block REINFORCED_IRON_BARS = registerBlock("reinforced_iron_bars",
            new ROPaneBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).strength(7.0f, 92.8f).requiresTool().nonOpaque().sounds(BlockSoundGroup.METAL)), ROMod.ROGROUP);

    public static final Block REINFORCED_GLASS = registerBlock("reinforced_glass",
            new GlassBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.GLASS).strength(0.3f, 3600000.0f).nonOpaque().sounds(BlockSoundGroup.GLASS)), ROMod.ROGROUP);

    public static final Block REINFORCED_TINTED_GLASS = registerBlock("reinforced_tinted_glass",
            new TintedGlassBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.GLASS).strength(0.3f, 3600000.0f).nonOpaque().sounds(BlockSoundGroup.GLASS)), ROMod.ROGROUP);

    public static void callBlocks() {
        System.out.println("Registering RoMod blocks");
    }

}

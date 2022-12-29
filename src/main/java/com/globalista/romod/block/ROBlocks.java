package com.globalista.romod.block;

import com.globalista.romod.ROMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

import static com.globalista.romod.util.RORegister.registerBlock;

public class ROBlocks {

    public static final Block REINFORCED_OBSIDIAN = registerBlock("reinforced_obsidian",
            new Block(FabricBlockSettings.of(Material.STONE).strength(50.0f, 3600000.0f).requiresTool()), ROMod.ROGROUP);

    public static final Block REINFORCED_OBSIDIAN_SLAB = registerBlock("reinforced_obsidian_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(50.0f, 3600000.0f).requiresTool()), ROMod.ROGROUP);

    public static final Block REINFORCED_OBSIDIAN_WALL = registerBlock("reinforced_obsidian_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(50.0f, 3600000.0f).requiresTool()), ROMod.ROGROUP);

    public static final Block REINFORCED_OBSIDIAN_STAIRS = registerBlock("reinforced_obsidian_stairs",
            new ROStairsBlock(REINFORCED_OBSIDIAN.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(50.0f, 3600000.0f).requiresTool()), ROMod.ROGROUP);
    public static final Block REINFORCED_IRON_BARS = registerBlock("reinforced_iron_bars",
            new ROPaneBlock(FabricBlockSettings.of(Material.METAL).strength(7.0f, 92.8f).requiresTool().nonOpaque().sounds(BlockSoundGroup.METAL)), ROMod.ROGROUP);

    public static final Block REINFORCED_GLASS = registerBlock("reinforced_glass",
            new GlassBlock(FabricBlockSettings.of(Material.GLASS).strength(0.3f, 3600000.0f).nonOpaque().sounds(BlockSoundGroup.GLASS)), ROMod.ROGROUP);

    public static final Block REINFORCED_TINTED_GLASS = registerBlock("reinforced_tinted_glass",
            new TintedGlassBlock(FabricBlockSettings.of(Material.GLASS).strength(0.3f, 3600000.0f).nonOpaque().sounds(BlockSoundGroup.GLASS)), ROMod.ROGROUP);

    public static void callBlocks() {
        System.out.println("Registering RoMod blocks");
    }

}

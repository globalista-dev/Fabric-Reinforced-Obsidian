package com.globalista.romod;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReinforcedObsidian implements ModInitializer {

    public static final String MOD_ID = "romod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final RegistryKey<ItemGroup> ROGROUP = RegistryKey.of(
            RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "rogroup"));

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ReinforcedObsidian.ROGROUP).register(content -> content.add(block));
        return item;
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }

    public static final Block REINFORCED_OBSIDIAN = registerBlock("reinforced_obsidian",
            new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE).strength(50.0f, 3600000.0f).requiresTool()));

    public static final Block REINFORCED_OBSIDIAN_SLAB = registerBlock("reinforced_obsidian_slab",
            new SlabBlock(FabricBlockSettings.copyOf(REINFORCED_OBSIDIAN)));

    public static final Block REINFORCED_OBSIDIAN_WALL = registerBlock("reinforced_obsidian_wall",
            new WallBlock(FabricBlockSettings.copyOf(REINFORCED_OBSIDIAN)));

    public static final Block REINFORCED_OBSIDIAN_STAIRS = registerBlock("reinforced_obsidian_stairs",
            new StairsBlock(REINFORCED_OBSIDIAN.getDefaultState(), FabricBlockSettings.copyOf(REINFORCED_OBSIDIAN)));
    public static final Block REINFORCED_IRON_BARS = registerBlock("reinforced_iron_bars",
            new PaneBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).strength(7.0f, 92.8f).requiresTool().nonOpaque().sounds(BlockSoundGroup.METAL)));

    public static final Block REINFORCED_GLASS = registerBlock("reinforced_glass",
            new StainedGlassBlock(DyeColor.LIGHT_GRAY, FabricBlockSettings.create().sounds(BlockSoundGroup.GLASS).strength(0.3f, 3600000.0f).nonOpaque()
                    .sounds(BlockSoundGroup.GLASS).allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));

    public static final Block REINFORCED_TINTED_GLASS = registerBlock("reinforced_tinted_glass",
            new TintedGlassBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.GLASS).strength(0.3f, 3600000.0f).nonOpaque()
                    .sounds(BlockSoundGroup.GLASS).allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));

    @Override
    public void onInitialize() {

        Registry.register(Registries.ITEM_GROUP, ROGROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(REINFORCED_OBSIDIAN))
                .displayName(Text.translatable("itemGroup.romod.rogroup"))
                .build());


        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            BlockRenderLayerMap.INSTANCE.putBlock(REINFORCED_IRON_BARS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(REINFORCED_TINTED_GLASS, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putBlock(REINFORCED_GLASS, RenderLayer.getTranslucent());
        }

        LOGGER.info("Fabric Reinforced Obsidian has been loaded!");
    }
}

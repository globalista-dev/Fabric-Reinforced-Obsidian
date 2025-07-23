package com.globalista.romod;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.client.render.BlockRenderLayer;
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

import java.util.function.Function;

public class ReinforcedObsidian implements ModInitializer {

    public static final String MOD_ID = "romod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final RegistryKey<ItemGroup> ROGROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "rogroup"));
    public static final ItemGroup ROGROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Registries.ITEM.get(Identifier.of(MOD_ID, "reinforced_obsidian"))))
            .displayName(Text.translatable("itemGroup.romod.rogroup"))
            .build();

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {

        var blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name));
        var itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));

        Block block = blockFactory.apply(settings.registryKey(blockKey));

        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, blockItem);

        ItemGroupEvents.modifyEntriesEvent(ROGROUP_KEY).register(content -> content.add(blockItem));

        return Registry.register(Registries.BLOCK, blockKey, block);
    }


    public static final Block REINFORCED_OBSIDIAN = register("reinforced_obsidian", Block::new, Block.Settings.create().sounds(BlockSoundGroup.STONE).strength(50.0f, 3600000.0f).requiresTool());

    public static final Block REINFORCED_IRON_BARS = register("reinforced_iron_bars",
            PaneBlock::new, Block.Settings.create().sounds(BlockSoundGroup.METAL).strength(7.0f, 92.8f).requiresTool().nonOpaque().sounds(BlockSoundGroup.METAL));

    public static final Block REINFORCED_OBSIDIAN_SLAB = register("reinforced_obsidian_slab",
            SlabBlock::new, Block.Settings.copy(REINFORCED_OBSIDIAN));

    public static final Block REINFORCED_OBSIDIAN_WALL = register("reinforced_obsidian_wall",
            WallBlock::new, Block.Settings.copy(REINFORCED_OBSIDIAN));

    public static final Block REINFORCED_OBSIDIAN_STAIRS = register("reinforced_obsidian_stairs", (settings) ->
            new StairsBlock(REINFORCED_OBSIDIAN.getDefaultState(), settings), Block.Settings.copy(REINFORCED_OBSIDIAN));

    public static final Block REINFORCED_GLASS = register("reinforced_glass", (settings) ->
            new StainedGlassBlock(DyeColor.GRAY, settings), Block.Settings.create().sounds(BlockSoundGroup.GLASS).strength(0.3f, 3600000.0f).nonOpaque()
            .sounds(BlockSoundGroup.GLASS).allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never));

    public static final Block REINFORCED_TINTED_GLASS = register("reinforced_tinted_glass",
            TintedGlassBlock::new, Block.Settings.create().sounds(BlockSoundGroup.GLASS).strength(0.3f, 3600000.0f).nonOpaque()
                    .sounds(BlockSoundGroup.GLASS).allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never));

    @Override
    public void onInitialize() {

        Registry.register(Registries.ITEM_GROUP, ROGROUP_KEY, ROGROUP);

        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            BlockRenderLayerMap.putBlock(REINFORCED_IRON_BARS, BlockRenderLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(REINFORCED_TINTED_GLASS, BlockRenderLayer.TRANSLUCENT);
            BlockRenderLayerMap.putBlock(REINFORCED_GLASS, BlockRenderLayer.TRANSLUCENT);
        }

        LOGGER.info("[Reinforced Obsidian] Mod loaded");
    }
}

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
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.globalista.romod.block.ROBlocks.*;

public class ROMod implements ModInitializer {

    public static final String MOD_ID = "romod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final RegistryKey<ItemGroup> ROGROUP = RegistryKey.of(
            RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "rogroup"));

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

        ROBlocks.callBlocks();

        LOGGER.info("Fabric Reinforced Obsidian!");
    }
}

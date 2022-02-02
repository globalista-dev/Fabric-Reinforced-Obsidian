package com.globalista.romod.block;

import com.globalista.romod.RoMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class ModBlocks implements BlockRegister {

    public static void callBlocks() {
        System.out.println("Registering RoMod blocks");
    }

    public static final Block REINFORCED_OBSIDIAN = BlockRegister.registerBlock("reinforced_obsidian",
            new Block(FabricBlockSettings.of(Material.STONE).strength(50.0f, 3600000.0f).requiresTool()), RoMod.ROGROUP);

    public static final Block DARK_IRON_BLOCK = BlockRegister.registerBlock("dark_iron_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(10.5f, 139.3f).requiresTool()), RoMod.ROGROUP);

}

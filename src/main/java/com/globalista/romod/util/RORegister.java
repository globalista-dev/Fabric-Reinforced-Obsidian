package com.globalista.romod.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.globalista.romod.ROMod.MOD_ID;

public class RORegister {

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries ->
                entries.add(block));
        return item;
    }

    public static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }

    public static Item registerItem(String name, Item item, ItemGroup tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
            content.add(item);});
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }

}

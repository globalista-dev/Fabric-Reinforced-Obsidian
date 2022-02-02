package com.globalista.romod.item;

import com.globalista.romod.RoMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class ModItems implements ItemRegister {

    public static void callItems() {
        System.out.println("Registering RoMod items");
    }

    public static final Item DARK_IRON_INGOT = ItemRegister.registerItem("dark_iron_ingot",
            new Item(new FabricItemSettings().group(RoMod.ROGROUP)));
}

package com.globalista.romod.item;

import com.globalista.romod.RoMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface ItemRegister {

        static Item registerItem(String name, Item item) {
            return Registry.register(Registry.ITEM, new Identifier(RoMod.MOD_ID, name), item);
        }
}

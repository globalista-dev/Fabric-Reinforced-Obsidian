package com.globalista.romod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoMod implements ModInitializer {

	public static final String MOD_ID = "romod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		
		LOGGER.info("Fabric Reinforced Obsidian!");
	}
}

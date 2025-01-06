package net.justus.testmod;

import net.fabricmc.api.ModInitializer;

import net.justus.testmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//test
public class testmod implements ModInitializer {
	public static final String MOD_ID = "testmod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
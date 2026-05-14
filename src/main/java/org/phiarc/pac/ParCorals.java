package org.phiarc.pac;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParCorals implements ModInitializer {
	public static final String MOD_ID = "par-corals";
    @SuppressWarnings("unused")
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ParCoralsItem.initialize();
	}
}
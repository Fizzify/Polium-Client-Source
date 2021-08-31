package me.fizzify.polium.module.mods;

import me.fizzify.polium.module.AbstractModule;

public class FullBrightModule extends AbstractModule {

	public FullBrightModule() {
		super("FullBright", "Makes your gamma up so you can see better!", Type.MISC);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		mc.gameSettings.gammaSetting = 100f;
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		mc.gameSettings.gammaSetting = 1f;
	}
	
}

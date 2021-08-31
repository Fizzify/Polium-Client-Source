package me.fizzify.polium.module.mods;

import me.fizzify.polium.event.EventTarget;
import me.fizzify.polium.event.events.EventUpdate;
import me.fizzify.polium.module.AbstractModule;
import net.minecraft.potion.Potion;

public class ToggleSprintModule extends AbstractModule {

	public ToggleSprintModule() {
		super("Toggle Sprint", "Makes you constantly sprint without you holding the keybind!", Type.WORLD);
	}
	
	@Override
	public void render(int scaledWidth) {
		fr.drawStringWithShadow("Sprinting", getX(), getY(), -1);
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawStringWithShadow("Sprinting", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (this.isEnabled() 
				&& !mc.thePlayer.isBlocking()
				&& !mc.thePlayer.isSneaking()
				&& (mc.thePlayer.motionX != 0 && mc.thePlayer.motionZ != 0)
				&& !mc.thePlayer.isCollidedHorizontally
				&& !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
				&& !mc.thePlayer.isPotionActive(Potion.confusion)
				&& !mc.gameSettings.keyBindBack.isKeyDown()) {
			mc.thePlayer.setSprinting(true);
		}
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		mc.thePlayer.setSprinting(false);
	}
	
	@Override
	public int getW() {
		return fr.getStringWidth("Sprinting");
	}
	
	@Override
	public int getH() {
		return fr.FONT_HEIGHT + 2;
	}

}

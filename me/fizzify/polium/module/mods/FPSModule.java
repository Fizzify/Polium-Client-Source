package me.fizzify.polium.module.mods;

import me.fizzify.polium.module.AbstractModule;
import net.minecraft.client.Minecraft;

public class FPSModule extends AbstractModule {

    private int centerX;
    public int startX;
    public int startY;

    public FPSModule() {
        super("FPS", "Shows your frames per seconds!", Type.VISUAL);
    }

    @Override
    public void render(int scaledWidth) {
        fr.drawStringWithShadow("FPS: " + mc.getDebugFPS(), getX(), getY(), -1);
    }
    
    @Override
    public void renderDummy(int mouseX, int mouseY) {
    	fr.drawStringWithShadow("FPS: " + mc.getDebugFPS(), getX(), getY(), -1);
    	super.renderDummy(mouseX, mouseY);
    }

    @Override
    public int getW() {
        return fr.getStringWidth("FPS: 999");
    }

    @Override
    public int getH() {
        return fr.FONT_HEIGHT;
    }
}

package me.fizzify.polium.module;

import java.io.IOException;

import me.fizzify.polium.Polium;
import me.fizzify.polium.ui.UIScreen;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class HudConfigScreen extends UIScreen {

	@Override
	public void renderUI(int mouseX, int mouseY) {
		this.drawDefaultBackground();
		
		for (AbstractModule m : ModuleManager.modules) {
			m.renderDummy(mouseX, mouseY);
		}
	}

	@Override
	public void mousePressed(float mouseX, float mouseY, int button) {
	}

	@Override
	public void mouseReleased(float mouseX, float mouseY) {
	}
	
	@Override
	public void onResize(Minecraft mcIn, int w, int h) {
		super.onResize(mcIn, w, h);
	}

    
}


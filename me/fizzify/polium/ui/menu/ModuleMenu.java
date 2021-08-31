package me.fizzify.polium.ui.menu;

import java.awt.Color;
import java.util.ArrayList;

import me.fizzify.polium.Polium;
import me.fizzify.polium.module.AbstractModule;
import me.fizzify.polium.ui.UIScreen;
import me.fizzify.polium.ui.buttons.ModuleButton;
import me.fizzify.polium.util.RenderUtil;
import net.minecraft.client.gui.ScaledResolution;

public class ModuleMenu extends UIScreen {
	
	public int count = 0;
	
	ArrayList<ModuleButton> modButtons = new ArrayList<>();
	
	@Override
	public void initGui() {
		super.initGui();
		this.modButtons.add(new ModuleButton(210, 10, 50, 100, Polium.INSTANCE.moduleManager.fpsModule));
	}
	
	@Override
	public void renderUI(int mouseX, int mouseY) {
		ScaledResolution sr = new ScaledResolution(mc);
		RenderUtil.drawRect(this.width / 2 + 260, this.height / 1 - 60, this.width / 2 - 260, this.height / 7, new Color(0, 0, 0, 170).getRGB());
		RenderUtil.drawRectOutline(this.width / 2 + 260, this.height / 1 - 60, this.width / 2 - 260, this.height / 7, new Color(255, 255, 255, 30).getRGB());
		
		for (ModuleButton m : modButtons) {
			m.renderElement();
		}
	}

	@Override
	public void mousePressed(float mouseX, float mouseY, int button) {
		for (ModuleButton m : modButtons) {
			m.mouseClicked(mouseX, mouseY, button);
		}
	}

	@Override
	public void mouseReleased(float mouseX, float mouseY) {
	}

}

package me.fizzify.polium.ui.buttons;

import java.awt.Color;

import me.fizzify.polium.module.AbstractModule;
import me.fizzify.polium.ui.UIElement;
import me.fizzify.polium.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class ModuleButton {

	public int x, y, w, h;
	private AbstractModule m;
	
	public ModuleButton(int x, int y, int w, int h, AbstractModule m) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.m = m;
	}

	public void renderElement() {
		RenderUtil.drawRect(this.x, this.y, this.x + this.w, this.y + this.h, new Color(0, 0, 0, 100).getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawString(m.name, x + 2, y + 2, -1);
	}

	public void mouseClicked(float mouseX, float mouseY, int button) {
		if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
			m.toggle();
		}
	}

}

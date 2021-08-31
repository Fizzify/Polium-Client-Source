package me.fizzify.polium.module;

import java.awt.Color;

import me.fizzify.polium.Polium;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public abstract class AbstractModule {
	
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;

	public int x, y;
    
    public String name, description;
    public Type type;
    public DragComponent d;
    
    protected boolean enabled;
    
    
    public AbstractModule(String name, String description, Type type) {
    	this.name = name;
    	this.description = description;
    	this.type = type;
    	
    	d = new DragComponent(this.x, this.y, this.getW(), this.getH(), new Color(0, 0, 0, 0).getRGB());
    	enabled = true;
    	Polium.INSTANCE.moduleManager.modules.add(this);
    }

    public void render(int scaledWidth) {
    }
    
    public void renderDummy(int mouseX, int mouseY) {
    	d.draw(mouseX, mouseY);
    }
    
    public int getW() {
    	return 50;
    }
    
    public int getH() {
    	return 50;
    }
    
    public int getX() {
		return d.getXPosition();
	}
    
    public int getY() {
    	return d.getYPosition();
    }
    
    public void onEnable() {
    	Polium.INSTANCE.eventManager.register(this);
    }
    
    public void onDisable() {
    	Polium.INSTANCE.eventManager.unregister(this);
    }
    
    public boolean isEnabled() {
    	return enabled;
    }
    
    public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if (enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}
    
    public void toggle() {
    	setEnabled(!this.enabled);
    }

	public enum Type {
    	VISUAL,
    	WORLD,
    	ANIMATIONS,
    	SERVER,
    	MISC;
    }

}

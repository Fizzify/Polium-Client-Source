package me.fizzify.polium;

import org.lwjgl.input.Keyboard;

import lombok.Getter;
import me.fizzify.polium.event.EventManager;
import me.fizzify.polium.event.EventTarget;
import me.fizzify.polium.event.events.EventTick;
import me.fizzify.polium.module.HudConfigScreen;
import me.fizzify.polium.module.ModuleManager;
import me.fizzify.polium.module.mods.ToggleSprintModule;
import me.fizzify.polium.ui.menu.ModuleMenu;
import net.minecraft.client.Minecraft;

public class Polium {
	
	Minecraft mc = Minecraft.getMinecraft();

	public static Polium INSTANCE = new Polium();
	
	public static ModuleManager moduleManager;
	public static EventManager eventManager;
	
	public void onStartup() {
		moduleManager = new ModuleManager();
		eventManager = new EventManager();
		
		EventManager.register(this);
	}
	
	public void onShutdown() {
		
		EventManager.unregister(this);
	}
	
	@EventTarget
	public void onTick(EventTick event) {
		if (mc.gameSettings.HUD.isPressed()) {
			mc.displayGuiScreen(new HudConfigScreen());
		}
		
		if (mc.gameSettings.keyBindSprint.isPressed()) {
			moduleManager.toggleSprintModule.toggle();
			moduleManager.fullBrightModule.toggle();
		}
	}

}

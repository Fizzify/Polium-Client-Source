package me.fizzify.polium.module;

import java.util.ArrayList;
import java.util.List;

import me.fizzify.polium.module.mods.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ModuleManager {

    public static List<AbstractModule> modules = new ArrayList();
    public static FPSModule fpsModule = new FPSModule();
    public static ToggleSprintModule toggleSprintModule = new ToggleSprintModule();
    public static FullBrightModule fullBrightModule = new FullBrightModule();

    public ModuleManager() {
    }

    public static void renderOverlay() {
        for (AbstractModule m : modules) {
        	if (m.isEnabled()) {
        		m.render(new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth());
        	}
        }
    }
}

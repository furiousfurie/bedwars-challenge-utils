package com.github.furiousfurie;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.github.furiousfurie.InvisibleShopper.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


@Mod(modid = Bedwars_challenge.MODID, version = Bedwars_challenge.VERSION, modLanguage = "java")
public class Bedwars_challenge {
    public static final String MODID = "bedwars_challenge_utils";
    public static final String VERSION = "1.0";
    public static final String MODNAME = "Bedwars challenge Utils";
    //totally my code that i didn't steal
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.loadConfig(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new InvisibleShopper());
        System.out.println("Bedwars challenge utils initialization finished");
    }
}




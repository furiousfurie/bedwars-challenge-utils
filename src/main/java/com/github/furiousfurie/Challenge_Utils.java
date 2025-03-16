package com.github.furiousfurie;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Challenge_Utils.MODID, version = Challenge_Utils.VERSION, modLanguage = "java")
public class Challenge_Utils {
    public static final String MODID = "bedwars_challenge_utils";
    public static final String VERSION = "1.0";
    public static final String MODNAME = "Bedwars Challenge Utils";

    @EventHandler
    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new InvisibleShopper());
        System.out.println("Initializing "+Challenge_Utils.MODNAME+" v"+Challenge_Utils.VERSION);
    }
}




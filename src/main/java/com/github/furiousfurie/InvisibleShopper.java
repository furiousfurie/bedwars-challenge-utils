package com.github.furiousfurie;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.Int;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class InvisibleShopper {
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    String Regex = "[0-120]";
    Pattern pattern = Pattern.compile(Regex);
    Map<String, Integer> iron_item_list = new HashMap<String, Integer>() {{
        put("wool",4);
        put("clay",12);
        put("glass",12);
        put("endstone",24);
        put("stone sword",10);
        put("chain armor",24);
        put("shears",20);
        put("axe",10);
        put("pickaxe",10);
        put("bedbug",24);
        put("dream_defenders",120);
        put("fireball",40);
        put("pop-up_tower",24);

    }};


    @SubscribeEvent()
    public void chat_recevied_event(ServerChatEvent event){

    }
}


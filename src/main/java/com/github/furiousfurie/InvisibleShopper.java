package com.github.furiousfurie;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class InvisibleShopper {
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;;
    Map<Integer, String> iron_item_list = new HashMap<Integer, String>() {{
        put(4,"wool");
        put(12, "clay/glass");
        put(24, "endstone/chain armor/bedbug/pop-up_tower\"");
        put(20, "shears");
        put(10, "axe/pickaxe/stone sword");
        put(120, "dream_defenders");
        put(40, "fireball");
    }};

    @SubscribeEvent()
    public void chat_received_event(ServerChatEvent event){
        String str = String.valueOf(event);

        Scanner scanner = new Scanner(System.in);


        // Use regex to remove all non-numeric characters
        String numbersOnly = str.replaceAll("[^0-9]", "");

        scanner.close();

        Integer result = Integer.valueOf(numbersOnly);
        if(iron_item_list.containsKey(result)){
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(iron_item_list.get(result)));
        }
    }
}


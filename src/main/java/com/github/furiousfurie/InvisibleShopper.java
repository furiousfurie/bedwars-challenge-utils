package com.github.furiousfurie;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class InvisibleShopper {
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;;
    Map<Integer, String> iron_item_list = new HashMap<Integer, String>() {{
        put(4, new ArrayList<String>() {{
            add("WOOL");
            add("LADDER");
        }});
        put(10,  new ArrayList<String>() {{
            add("STONE_SWORD");
            add("WOODEN_PICKAXE");
            add("WOODEN_AXE");
        }});
        put(12, new ArrayList<String>() {{
            add("HARDENED_CLAY");
            add("GLASS");
        }});
        put(20,  new ArrayList<String>() {{
            add("SHEARS");
        }});
        put(24,  new ArrayList<String>() {{
            add("ENDSTONE");
            add("CHAINMAIL_ARMOR");
            add("BEDBUG");
            add("POPUP_TOWER");
        }});
        put(40,  new ArrayList<String>() {{
            add("FIREBALL");
        }});
        put(120, new ArrayList<String>() {{
            add("DREAM_DEFENDER");
        }});
    }};

    @SubscribeEvent()
    public void chat_receveid_event(ServerChatEvent event){
        String str = String.valueOf(event.message);
        System.out.println(str);
        Scanner scanner = new Scanner(System.in);

        // Use regex to remove all non-numeric characters
        String numbersOnly = str.replaceAll("[^0-9]", "");

        scanner.close();

        Integer result = Integer.valueOf(numbersOnly);
        System.out.println(numbersOnly);
        System.out.println(result);
        if(iron_item_list.containsKey(result)){
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(iron_item_list.get(result)));
            System.out.println(iron_item_list.get(result));
        }
    }
}


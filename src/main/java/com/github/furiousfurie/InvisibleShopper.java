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
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    Map<Integer, ArrayList<String>> iron_items = new HashMap<Integer, ArrayList<String>>() {{
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


    Map<Integer, ArrayList<String>> gold_items = new HashMap<Integer, ArrayList<String>>(){{
        put(2, new ArrayList<String>() {{
            add("ARROW");
        }});
        put(3, new ArrayList<String>(){{
           add("GOLDEN_APPLE");
        }});
        put(4, new ArrayList<String>(){{
            add("WOOD");
        }});
        put(6, new ArrayList<String>(){{
            add("WATER_BUCKET");
            add("SPONGE");
        }});
        put(8, new ArrayList<String>(){{
            add("TNT");
        }});
        put(5, new ArrayList<String>(){{
            add("KNOCKBACK_STICK");
        }});
        put(7, new ArrayList<String>(){{
            add("IRON_SWORD");
        }});
        put(12, new ArrayList<String>(){{
            add("IRON_ARMOR");
            add("BOW");
        }});
        put(20, new ArrayList<String>(){{
            add("POWER_BOW");
        }});
    }};













    @SubscribeEvent()
    public void chat_received_event(ServerChatEvent event){
        Scanner scanner = new Scanner(System.in);
        String msgNumbers = event.message.replaceAll("[^0-9]", ""); // Use regex to remove all non-numeric characters
        scanner.close();

        Integer price = Integer.valueOf(msgNumbers);
        System.out.println(price);
        if(iron_items.containsKey(price)){
            if(gold_items.containsKey(price)){
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(String.join(", ", iron_items.get(price)) + String.join(", ", gold_items.get(price))));
            }else {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(String.join(", ", iron_items.get(price))));
            }
        } else if (gold_items.containsKey(price)) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(String.join(", ", gold_items.get(price))));
        }
    }
}


package com.github.furiousfurie;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.lwjgl.input.Mouse;


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

    @SubscribeEvent
    public void chat_received_event(ServerChatEvent event) {
        Scanner scanner = new Scanner(System.in);
        String msgNumbers = event.message.replaceAll("[^0-9]", ""); // Use regex to remove all non-numeric characters
        scanner.close();

        Integer price = Integer.valueOf(msgNumbers);
        System.out.println(price);
        if(iron_items.containsKey(price)){
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(String.join(", ", iron_items.get(price))));
        }
    }

    @SubscribeEvent
    public void item_clicked_event(GuiScreenEvent.MouseInputEvent.Post event) {
        if (!(event.gui instanceof GuiChest)) {return;}

        GuiChest guiChest = (GuiChest) event.gui;
        Container chest = guiChest.inventorySlots;
        //TODO: galaxymiller: Add other languages support
        List<String> shopkeeperGuis = Arrays.asList("Quick Buy", "Blocks", "Melee", "Armor", "Tools", "Ranged", "Potions", "Utility", "Rotating Items");

        if (!(chest instanceof ContainerChest)) {return;}
        String guiName = ((ContainerChest) chest).getLowerChestInventory().getName();
        if (!shopkeeperGuis.stream().anyMatch(x -> x.equalsIgnoreCase(guiName))) {return;} //? https://stackoverflow.com/a/15269846
        if (!Mouse.isButtonDown(0)) {return;}

        ItemStack heldItem = Minecraft.getMinecraft().thePlayer.inventory.getItemStack();
        if (heldItem == null) {return;}

        System.out.println("Clicked item" + heldItem.getDisplayName());
        //TODO: furiousfurie: Add chat reading system to get item price
    }
}


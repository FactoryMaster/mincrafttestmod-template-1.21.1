package net.justus.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.justus.testmod.Mincrafttestmod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
public static final Item JAKOBS_DILDO = registerItem("jakobs_dildo", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Mincrafttestmod.MOD_ID, name), item);
    }

public static void registerModItems() {
    Mincrafttestmod.LOGGER.info("Registering Mod Items for" + Mincrafttestmod.MOD_ID);


    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
        fabricItemGroupEntries.add(JAKOBS_DILDO);
    });









       }

}

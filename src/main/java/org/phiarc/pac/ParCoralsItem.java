package org.phiarc.pac;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public final class ParCoralsItem {
    private ParCoralsItem() {}
    public static void initialize() {}
    @SuppressWarnings("unused")
    public static final Item SILICATE = register(new Item(new FabricItemSettings()), "silicate");

    public static Item register(Item item, String id) {
        ResourceLocation itemID = new ResourceLocation(ParCorals.MOD_ID, id);
        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }
}

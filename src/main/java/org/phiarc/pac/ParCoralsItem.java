package org.phiarc.pac;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public final class ParCoralsItem {
    private ParCoralsItem() {}

    public static final ResourceKey<CreativeModeTab> PAC_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(ParCorals.MOD_ID, "item_group"));
    public static final CreativeModeTab PAC_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ParCoralsItem.SILICATE))
            .title(Component.translatable("itemGroup.pa-corals"))
            .build();

    public static final Item SILICATE = register(new Item(new FabricItemSettings()), "silicate");

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, PAC_ITEM_GROUP_KEY, PAC_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(PAC_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.accept(ParCoralsItem.SILICATE));
    }

    public static Item register(Item item, String id) {
        ResourceLocation itemID = new ResourceLocation(ParCorals.MOD_ID, id);
        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }
}

package org.phiarc.pac;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ParCoralsBlocks {
    public static final Block NUTRITIOUS_WATER = register(
            "nutritious_water",
            (props) -> new LiquidBlock(ParCoralsFluids.NUTRITIOUS_WATER, props),
            BlockBehaviour.Properties.copy(Blocks.WATER),
            false
    );

    @SuppressWarnings("SameParameterValue")
    private static Block register(String id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceLocation blockID = new ResourceLocation(ParCorals.MOD_ID, id);
        Block block = blockFactory.apply(settings);
        if (shouldRegisterItem) {
            ResourceLocation itemID = new ResourceLocation(ParCorals.MOD_ID, id);
            BlockItem blockItem = new BlockItem(block, new Item.Properties());
            Registry.register(BuiltInRegistries.ITEM, itemID, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockID, block);
    }

    public static void initialize() {
    }
}

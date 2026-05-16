package org.phiarc.pac;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import org.phiarc.pac.fluid.ParCoralsNutritiousWater;

@SuppressWarnings("unused")
public abstract class ParCoralsFluids {
    public static final FlowingFluid  NUTRITIOUS_WATER = register(new ParCoralsNutritiousWater.Source(), "nutritious_water");
    public static final FlowingFluid  FLOWING_NUTRITIOUS_WATER = register(new ParCoralsNutritiousWater.Flowing(), "flowing_nutritious_water");

    private static FlowingFluid register(FlowingFluid fluid, String id) {
        ResourceLocation fluidID = new ResourceLocation(ParCorals.MOD_ID, id);
        return Registry.register(BuiltInRegistries.FLUID, fluidID, fluid);
    }

    public static void initialize() {}
}

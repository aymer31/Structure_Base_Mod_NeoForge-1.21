package net.exterium.exteriummod.item;

import net.exterium.exteriummod.ExteriumMod;
import net.exterium.exteriummod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExteriumMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_BISMUTH.get()))
                    .title(Component.translatable("creativetab.exteriummod.bismuth_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                        output.accept(ModItems.CHISEL);
                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bismuth_block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExteriumMod.MOD_ID,"bismuth_items_tab"))
                    .title(Component.translatable("creativetab.exteriummod.bismuth_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                    }).build());

    public static final Supplier<CreativeModeTab> EXTERIUM_FOOD_TAB = CREATIVE_MODE_TAB.register("food_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RADISH.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExteriumMod.MOD_ID,"bismuth_block_tab"))
                    .title(Component.translatable("creativetab.exteriummod.food"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RADISH);
                        output.accept(ModItems.STARLIGHT_ASHES);
                        output.accept(ModItems.FROSTFIRE_ICE);

                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

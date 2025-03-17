package net.sohpandaa.geometrautils.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sohpandaa.geometrautils.GeometraUtils;
import net.sohpandaa.geometrautils.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GeometraUtils.MOD_ID);

    public static final Supplier<CreativeModeTab> MOSS_BALL_TAB = CREATIVE_MODE_TAB.register("moss_ball_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.MOSS_BALL.get()))
                    .title(Component.translatable("creativetab.geometrautils.moss_ball_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.EMPTY_TEAR);
                        output.accept(ModBlocks.SOUL_MUD);
                        output.accept(ModItems.IRON_CAST);


                    }).build());

    public static final Supplier<CreativeModeTab> REWARDS_TAB = CREATIVE_MODE_TAB.register("rewards_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.SHINY_VOUCHER.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GeometraUtils.MOD_ID, "moss_ball_tab"))
                    .title(Component.translatable("creativetab.geometrautils.rewards_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SHINY_VOUCHER);
                        output.accept(ModItems.ABILITY_VOUCHER);
                        output.accept(ModItems.BALL_VOUCHER);
                        output.accept(ModItems.EVS_VOUCHER);
                        output.accept(ModItems.FRIENDSHIP_VOUCHER);
                        output.accept(ModItems.IVS_VOUCHER);
                        output.accept(ModItems.MOVE_VOUCHER);
                        output.accept(ModItems.NATURE_VOUCHER);
                        output.accept(ModItems.IRON_RIBBON);
                        output.accept(ModItems.GOLD_RIBBON);
                        output.accept(ModItems.DIAMOND_RIBBON);



                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

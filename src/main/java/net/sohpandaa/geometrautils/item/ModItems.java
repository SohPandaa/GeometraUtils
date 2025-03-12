package net.sohpandaa.geometrautils.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sohpandaa.geometrautils.GeometraUtils;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GeometraUtils.MOD_ID);

    public static final DeferredItem<Item> EMPTY_TEAR = ITEMS.register("empty_tear",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> MOSS_BALL = ITEMS.register("moss_ball",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> IRON_CAST = ITEMS.register("iron_cast",
            ()-> new Item(new Item.Properties()) );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



}

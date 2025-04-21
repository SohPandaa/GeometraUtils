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

    public static final DeferredItem<Item> SHINY_VOUCHER = ITEMS.register("shiny_voucher",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> ABILITY_VOUCHER = ITEMS.register("ability_voucher",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> BALL_VOUCHER = ITEMS.register("ball_voucher",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> EVS_VOUCHER = ITEMS.register("evs_voucher",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> IVS_VOUCHER = ITEMS.register("ivs_voucher",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> MOVE_VOUCHER = ITEMS.register("move_voucher",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> NATURE_VOUCHER = ITEMS.register("nature_voucher",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> FRIENDSHIP_VOUCHER = ITEMS.register("friendship_voucher",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> IRON_RIBBON = ITEMS.register("iron_ribbon",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> GOLD_RIBBON = ITEMS.register("gold_ribbon",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> DIAMOND_RIBBON = ITEMS.register("diamond_ribbon",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> GENDER_VOUCHER = ITEMS.register("gender_voucher",
            ()-> new Item(new Item.Properties()) );

    public static final DeferredItem<Item> FORM_VOUCHER = ITEMS.register("form_voucher",
            ()-> new Item(new Item.Properties()) );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



}

package net.sohpandaa.geometrautils.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sohpandaa.geometrautils.GeometraUtils;
import net.sohpandaa.geometrautils.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GeometraUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.EMPTY_TEAR.get());
        basicItem(ModItems.MOSS_BALL.get());
        basicItem(ModItems.IRON_CAST.get());
        basicItem(ModItems.SHINY_VOUCHER.get());
        basicItem(ModItems.BALL_VOUCHER.get());
        basicItem(ModItems.ABILITY_VOUCHER.get());
        basicItem(ModItems.EVS_VOUCHER.get());
        basicItem(ModItems.FRIENDSHIP_VOUCHER.get());
        basicItem(ModItems.IVS_VOUCHER.get());
        basicItem(ModItems.MOVE_VOUCHER.get());
        basicItem(ModItems.NATURE_VOUCHER.get());
        basicItem(ModItems.GENDER_VOUCHER.get());
        basicItem(ModItems.FORM_VOUCHER.get());
        basicItem(ModItems.IRON_RIBBON.get());
        basicItem(ModItems.GOLD_RIBBON.get());
        basicItem(ModItems.DIAMOND_RIBBON.get());

    }
}

package net.sohpandaa.geometrautils.datagen;

import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.sohpandaa.geometrautils.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> BLAZE_SMELTABLES = List.of(Items.MAGMA_BLOCK);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_TEAR.get())
                        .pattern(" G ")
                        .pattern("GDG")
                        .pattern(" G ")
                        .define('G', Items.GLASS)
                        .define('D', Items.DIAMOND)
                        .unlockedBy("has_empty_tear", has(ModItems.EMPTY_TEAR)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,Items.BLAZE_ROD)
                        .pattern("XXX")
                        .pattern("XIX")
                        .pattern("XXX")
                        .define('X', Items.BLAZE_POWDER)
                        .define('I', ModItems.IRON_CAST)
                        .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.IRON_CAST)
                        .pattern("IGI")
                        .pattern("IGI")
                        .pattern("IGI")
                        .define('I',Items.IRON_INGOT)
                        .define('G',Items.GLASS)
                        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(recipeOutput);



        oreBlasting(recipeOutput, BLAZE_SMELTABLES, RecipeCategory.MISC, Items.BLAZE_POWDER, 0.25f,1200,"blaze");



    }
}

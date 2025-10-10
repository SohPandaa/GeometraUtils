package net.sohpandaa.geometrautils.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.sohpandaa.geometrautils.GeometraUtils;
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
        List<ItemLike> BULK_COPPER = List.of(Items.RAW_COPPER_BLOCK);
        List<ItemLike> BULK_IRON = List.of(Items.RAW_IRON_BLOCK);
        List<ItemLike> BULK_GOLD = List.of(Items.RAW_GOLD_BLOCK);


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
        oreBlasting(recipeOutput, BULK_COPPER, RecipeCategory.MISC, Items.COPPER_BLOCK, 0.25f,400,"bulk-smelt");
        oreBlasting(recipeOutput, BULK_IRON, RecipeCategory.MISC, Items.IRON_BLOCK, 0.25f,400,"bulk-smelt");
        oreBlasting(recipeOutput, BULK_GOLD, RecipeCategory.MISC, Items.GOLD_BLOCK, 0.25f,400,"bulk-smelt");

    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, GeometraUtils.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}


package net.roserrosa.titansawoken.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.roserrosa.titansawoken.TitansAwoken;
import net.roserrosa.titansawoken.block.ModBlocks;
import net.roserrosa.titansawoken.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }


    @Override
    protected void buildRecipes() {
        List<ItemLike> TIN_SMELTABLES = List.of(ModItems.RAW_TIN,
                ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE);
        List<ItemLike> TIN_BLOCK_SMELTABLES = List.of(ModBlocks.RAW_TIN_BLOCK);
        List<ItemLike> BRONZE_NUGGET_SMELTABLES = List.of(
                ModItems.BRONZE_SWORD, ModItems.BRONZE_AXE, ModItems.BRONZE_PICKAXE, ModItems.BRONZE_PICK,
                ModItems.BRONZE_SHOVEL, ModItems.BRONZE_HOE, ModItems.BRONZE_SPEAR,
                ModItems.BRONZE_HELMET, ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS);
        List<ItemLike> BRONZE_SMELTABLES = List.of(
                ModItems.BRONZE_GREATSWORD, ModItems.BRONZE_GREATAXE, ModItems.BRONZE_SPADE, ModItems.BRONZE_SCYTHE, ModItems.BRONZE_LANCE);

        shaped(RecipeCategory.MISC, ModItems.BRONZE.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.BRONZE_NUGGET.get())
                .group("bronze")
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output, "titansawoken:bronze_from_bronze_nugget");

        shaped(RecipeCategory.MISC, ModBlocks.BRONZE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.BRONZE.get())
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.TIN.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TIN_NUGGET.get())
                .group("tin")
                .unlockedBy("has_tin", has(ModItems.TIN)).save(output, "titansawoken:tin_from_tin_nugget");

        shaped(RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TIN.get())
                .unlockedBy("has_tin", has(ModItems.TIN)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_TIN.get())
                .unlockedBy("has_raw_tin", has(ModItems.RAW_TIN)).save(output);



        shaped(RecipeCategory.MISC, ModItems.BRONZE_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" + ")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_AXE.get())
                .pattern("## ")
                .pattern("#+ ")
                .pattern(" + ")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_PICKAXE.get())
                .pattern("###")
                .pattern(" + ")
                .pattern(" + ")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_SHOVEL.get())
                .pattern(" # ")
                .pattern(" + ")
                .pattern(" + ")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_HOE.get())
                .pattern("## ")
                .pattern(" + ")
                .pattern(" + ")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);


        shaped(RecipeCategory.MISC, ModItems.BRONZE_SPADE.get())
                .pattern(" ##")
                .pattern(" +#")
                .pattern("+  ")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_PICK.get())
                .pattern(" # ")
                .pattern("  #")
                .pattern(" + ")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_GREATAXE.get())
                .pattern("###")
                .pattern("#+#")
                .pattern(" + ")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_SCYTHE.get())
                .pattern("##+")
                .pattern(" +#")
                .pattern("+  ")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_GREATSWORD.get())
                .pattern(" ##")
                .pattern("##-")
                .pattern("+a-")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .define('a', Items.STRING)
                .define('-', Items.LEATHER)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_LANCE.get())
                .pattern("#  ")
                .pattern(" ##")
                .pattern("-#+")
                .define('#', ModItems.BRONZE.get())
                .define('+', ModItems.BRONZE_SPEAR.get())
                .define('-', Items.STRING)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_SPEAR.get())
                .pattern("#  ")
                .pattern(" + ")
                .pattern("  +")
                .define('#', ModItems.BRONZE.get())
                .define('+', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.BRONZE.get())
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.BRONZE.get())
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.BRONZE.get())
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shaped(RecipeCategory.MISC, ModItems.BRONZE_BOOTS.get())
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.BRONZE.get())
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);


        // SHAPELESS

        shapeless(RecipeCategory.MISC, ModItems.BRONZE.get(), 9)
                .requires(ModBlocks.BRONZE_BLOCK)
                .group("bronze")
                .unlockedBy("has_bronze_block", has(ModItems.BRONZE)).save(output, "titansawoken:bronze_from_bronze_block");

        shapeless(RecipeCategory.MISC, ModItems.BRONZE_NUGGET.get(), 9)
                .requires(ModItems.BRONZE)
                .unlockedBy("has_bronze", has(ModItems.BRONZE)).save(output);

        shapeless(RecipeCategory.MISC, ModItems.TIN.get(), 9)
                .requires(ModBlocks.TIN_BLOCK)
                .group("tin")
                .unlockedBy("has_tin", has(ModItems.TIN)).save(output, "titansawoken:tin_from_tin_block");

        shapeless(RecipeCategory.MISC, ModItems.TIN_NUGGET.get(), 9)
                .requires(ModItems.TIN)
                .unlockedBy("has_tin", has(ModItems.TIN)).save(output);

        shapeless(RecipeCategory.MISC, ModItems.RAW_TIN.get(), 9)
                .requires(ModBlocks.RAW_TIN_BLOCK)
                .unlockedBy("has_raw_tin", has(ModItems.RAW_TIN)).save(output);

        // SMELT

        oreSmelting(output, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN.get(), 0.55f,200, "tin");
        oreSmelting(output, TIN_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get(), 4.95f,1800, "tin_block");
        oreSmelting(output, BRONZE_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE_NUGGET.get(), 0.2f,200, "bronze_nugget");
        oreSmelting(output, BRONZE_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE.get(), 0.2f,200, "bronze");

        // BLAST

        oreBlasting(output, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN.get(), 0.55f,100, "tin");
        oreBlasting(output, TIN_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get(), 4.95f,900, "tin_block");
        oreBlasting(output, BRONZE_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE_NUGGET.get(), 0.2f,100, "bronze_nugget");
        oreBlasting(output, BRONZE_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE.get(), 0.2f,100, "bronze");

    }
        protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTIme, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

        protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTime, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
            for(ItemLike itemlike : pIngredients) {
                SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                        .save(recipeOutput, TitansAwoken.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
            }
        }
    }
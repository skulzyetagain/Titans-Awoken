package net.roserrosa.titansawoken.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.roserrosa.titansawoken.TitansAwoken;
import net.roserrosa.titansawoken.block.ModBlocks;
import net.roserrosa.titansawoken.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TitansAwoken.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.BRONZE_BLOCK.get())
            .add(ModBlocks.TIN_ORE.get())
            .add(ModBlocks.TIN_ORE.get())
            .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
            .add(ModBlocks.RAW_TIN_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_HOE)
                .addTag(BlockTags.EDIBLE_FOR_SHEEP)
                .addTag(BlockTags.FLOWERS)
                .addTag(BlockTags.CROPS);

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BRONZE_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.RAW_TIN_BLOCK.get());

        tag(ModTags.Blocks.NEEDS_BRONZE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BRONZE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BRONZE_TOOL);
    }
}
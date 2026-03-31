package net.roserrosa.titansawoken.datagen;

import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.ItemModels;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import net.roserrosa.titansawoken.TitansAwoken;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.roserrosa.titansawoken.block.ModBlocks;
import net.roserrosa.titansawoken.item.ModItems;
import net.roserrosa.titansawoken.item.custom.ScytheItem;

import java.util.stream.Stream;

import static net.minecraft.client.data.models.ItemModelGenerators.createFlatModelDispatch;

public class ModModelProvider extends ModelProvider{
    public ModModelProvider(PackOutput output) {
        super(output, TitansAwoken.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // ITEMS
        itemModels.generateFlatItem(ModItems.BRONZE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BRONZE_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TIN.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TIN_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.RAW_TIN.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.BRONZE_PICK.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BRONZE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BRONZE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BRONZE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BRONZE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BRONZE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateSpear(ModItems.BRONZE_SPEAR.get());
        itemModels.generateSpear(ModItems.BRONZE_GREATAXE.get());
        itemModels.generateSpear(ModItems.BRONZE_SPADE.get());
        generateScythe(ModItems.BRONZE_SCYTHE.get(), ModelTemplates.FLAT_ITEM.extend()

        // BLOCKS
        blockModels.createTrivialCube(ModBlocks.BRONZE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.TIN_BLOCK.get());

        blockModels.createTrivialCube(ModBlocks.TIN_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_TIN_ORE.get());

        blockModels.createTrivialCube(ModBlocks.RAW_TIN_BLOCK.get());

    }

    public void generateScythe(ScytheItem item, ExtendedModelTemplateBuilder modelTemplate,  ItemModelGenerators itemModels) {
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(ModelTemplates.SPEAR_IN_HAND.create(item, TextureMapping.layer0(TextureMapping.getItemTexture(item, "_in_hand")), itemModels.modelOutput));
        itemModels.itemModelOutput.accept(item, createFlatModelDispatch(itemmodel$unbaked, itemmodel$unbaked1), new ClientItem.Properties(true, false, 1.95F));
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream();
    }
}

package net.roserrosa.titansawoken.datagen;

import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.ItemModels;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import net.roserrosa.titansawoken.TitansAwoken;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.roserrosa.titansawoken.block.ModBlocks;
import net.roserrosa.titansawoken.item.ModArmorMaterials;
import net.roserrosa.titansawoken.item.ModItems;
import net.roserrosa.titansawoken.item.custom.GreatswordItem;
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
        generateScythe(ModItems.BRONZE_SCYTHE.get(), itemModels);
        generateGreatsword(ModItems.BRONZE_GREATSWORD.get(), itemModels);
        generateLance(ModItems.BRONZE_LANCE.get(), itemModels);

        itemModels.generateTrimmableItem(ModItems.BRONZE_HELMET.get(), ModArmorMaterials.BRONZE, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModels.generateTrimmableItem(ModItems.BRONZE_CHESTPLATE.get(), ModArmorMaterials.BRONZE, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModels.generateTrimmableItem(ModItems.BRONZE_LEGGINGS.get(), ModArmorMaterials.BRONZE, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModels.generateTrimmableItem(ModItems.BRONZE_BOOTS.get(), ModArmorMaterials.BRONZE, ItemModelGenerators.TRIM_PREFIX_BOOTS,  false);

        // BLOCKS
        blockModels.createTrivialCube(ModBlocks.BRONZE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.TIN_BLOCK.get());

        blockModels.createTrivialCube(ModBlocks.TIN_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_TIN_ORE.get());

        blockModels.createTrivialCube(ModBlocks.RAW_TIN_BLOCK.get());

    }

    // TEMPLATES

    public void generateScythe(ScytheItem item, ExtendedModelTemplateBuilder modelTemplate,  ItemModelGenerators itemModels) {
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(modelTemplate.build().create(ModelLocationUtils.getModelLocation(item, "_in_hand"), TextureMapping.layer0(TextureMapping.getItemTexture(item, "_in_hand")), itemModels.modelOutput));
        itemModels.itemModelOutput.accept(item, createFlatModelDispatch(itemmodel$unbaked, itemmodel$unbaked1), new ClientItem.Properties(true, false, 1.95F));
    }

    public void generateScythe(ScytheItem item,   ItemModelGenerators itemGenerator) {
        this.generateScythe(item,
                ModelTemplates.FLAT_ITEM.extend()
                        .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, b -> b
                                .rotation(0, 0, 55)
                                .translation(-1.5f, 5.0f, 0.5f)
                                .scale(1.7f, 1.7f, 0.85f)
                        )
                        .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, b -> b
                                .rotation(0 , -90, 25)
                                .translation(1.13f, 3.2f, 1.13f)
                                .scale(1.36f)
                        ),
                itemGenerator);
    }

    public void generateGreatsword(GreatswordItem item, ExtendedModelTemplateBuilder modelTemplate, ItemModelGenerators itemModels) {
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(modelTemplate.build().create(ModelLocationUtils.getModelLocation(item, "_in_hand"), TextureMapping.layer0(TextureMapping.getItemTexture(item, "_in_hand")), itemModels.modelOutput));
        itemModels.itemModelOutput.accept(item, createFlatModelDispatch(itemmodel$unbaked, itemmodel$unbaked1), new ClientItem.Properties(true, false, 1.95F));
    }

    public void generateGreatsword(GreatswordItem item,   ItemModelGenerators itemGenerator) {
        this.generateGreatsword(item,
                ModelTemplates.FLAT_ITEM.extend()
                        .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, b -> b
                                .rotation(0, -90, 55)
                                .translation(0f, 10.0f, 0.5f)
                                .scale(1.7f)
                        )
                        .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, b -> b
                                .rotation(0 , -90, 25)
                                .translation(1.13f, 4.2f, 1.13f)
                                .scale(1.36f)
                        ),
                itemGenerator);
    }

    public void generateLance(Item item, ExtendedModelTemplateBuilder modelTemplate, ItemModelGenerators itemModels) {
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(modelTemplate.build().create(ModelLocationUtils.getModelLocation(item, "_in_hand"), TextureMapping.layer0(TextureMapping.getItemTexture(item, "_in_hand")), itemModels.modelOutput));
        itemModels.itemModelOutput.accept(item, createFlatModelDispatch(itemmodel$unbaked, itemmodel$unbaked1), new ClientItem.Properties(true, false, 1.95F));
    }

    public void generateLance(Item item,   ItemModelGenerators itemGenerator) {
        this.generateLance(item,
                ModelTemplates.FLAT_ITEM.extend()
                        .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, b -> b
                                .rotation(0, -90, -45)
                                .translation(0f, 10.0f, 0.5f)
                                .scale(2.55f, 2.55f, 1.7f)
                        )
                        .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, b -> b
                                .rotation(0 , -90, -45)
                                .translation(1.13f, 4.2f, 1.13f)
                                .scale(2.4f)
                        ),
                itemGenerator);
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

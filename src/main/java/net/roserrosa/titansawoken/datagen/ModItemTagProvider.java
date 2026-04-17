package net.roserrosa.titansawoken.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.roserrosa.titansawoken.TitansAwoken;
import net.roserrosa.titansawoken.item.ModItems;
import net.roserrosa.titansawoken.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TitansAwoken.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Items.BRONZE_REPAIRABLE)
                .add(ModItems.BRONZE.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.BRONZE_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.BRONZE_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.BRONZE_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.BRONZE_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.BRONZE_HOE.get());
        tag(ItemTags.SPEARS)
                .add(ModItems.BRONZE_SPEAR.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BRONZE_HELMET.get())
                .add(ModItems.BRONZE_CHESTPLATE.get())
                .add(ModItems.BRONZE_LEGGINGS.get())
                .add(ModItems.BRONZE_BOOTS.get());

    }
}
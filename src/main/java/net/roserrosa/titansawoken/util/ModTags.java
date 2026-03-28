package net.roserrosa.titansawoken.util;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.roserrosa.titansawoken.TitansAwoken;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = createTag("needs_bronze_tool");
        public static final TagKey<Block> INCORRECT_FOR_BRONZE_TOOL = createTag("incorrect_for_bronze_tool");

        private static TagKey<Block> createTag(String name) {
        return BlockTags.create(Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BRONZE_REPAIRABLE = createTag("bronze_repairable");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, name));
        }
    }
}
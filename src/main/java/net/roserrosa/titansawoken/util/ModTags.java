package net.roserrosa.titansawoken.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> STONE_ORES = TagKey.create(
                // The registry key. The type of the registry must match the generic type of the tag.
                Registries.BLOCK,
                // The location of the tag. This example will put our tag at data/examplemod/tags/blocks/example_tag.json.
                Identifier.fromNamespaceAndPath("titansawoken", "stone_ore")
        );
    }

    public static class Items {

    }
}

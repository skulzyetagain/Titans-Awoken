package net.roserrosa.titansawoken.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.roserrosa.titansawoken.TitansAwoken;
import net.roserrosa.titansawoken.item.ModItems;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TitansAwoken.MOD_ID);


    public static final DeferredBlock<Block> BRONZE_BLOCK = registerBlock("bronze_block",
            registryName -> new Block(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, registryName))
                            .strength(5.0f)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
            )
    );
    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            registryName -> new Block(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, registryName))
                            .strength(4.0f)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
            )
    );
    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            registryName -> new Block(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, registryName))
                            .strength(4.0f)
                            .sound(SoundType.STONE)
                            .requiresCorrectToolForDrops()
            )
    );
    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            registryName -> new DropExperienceBlock(UniformInt.of(1, 3),
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, registryName))
                            .strength(3.0f)
                            .sound(SoundType.STONE)
                            .requiresCorrectToolForDrops()
            )
    );
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            registryName -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, registryName))
                            .strength(4.0f)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()
            )
    );

    public static <T extends Block> void registerBlockItem(String name, Supplier<T> block){
        ModItems.ITEMS.registerSimpleBlockItem(name, block);

    }
    private static <T extends Block> DeferredBlock<Block> registerBlock(String name, Function<Identifier, ? extends T> block){
        DeferredBlock<Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }


    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
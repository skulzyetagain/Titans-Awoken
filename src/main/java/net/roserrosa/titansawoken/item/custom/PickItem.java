package net.roserrosa.titansawoken.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.roserrosa.titansawoken.block.ModBlocks;
import net.roserrosa.titansawoken.item.ModItems;


import java.util.Map;

public class PickItem extends Item {

    private static final Map<Block, Block> PICK_MAP_STONE =
            Map.of(
                    Blocks.COAL_ORE, Blocks.STONE,
                    Blocks.GOLD_ORE, Blocks.STONE,
                    Blocks.DIAMOND_ORE, Blocks.STONE,
                    Blocks.IRON_ORE, Blocks.STONE,
                    Blocks.EMERALD_ORE, Blocks.STONE
            );
    private static final Map<Block, Block> PICK_MAP_STONE_MANY =
            Map.of(
                    Blocks.COPPER_ORE, Blocks.STONE,
                    Blocks.REDSTONE_ORE, Blocks.STONE,
                    Blocks.LAPIS_ORE, Blocks.STONE,
                    ModBlocks.TIN_ORE.get(), Blocks.STONE
            );
    private static final Map<Block, Block> PICK_MAP_DEEPSLATE =
            Map.of(
                    Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE,
                    Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE,
                    Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE,
                    Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE,
                    Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE
            );
    private static final Map<Block, Block> PICK_MAP_DEEPSLATE_MANY =
            Map.of(
                    Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE,
                    Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE,
                    Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.DEEPSLATE,
                    ModBlocks.DEEPSLATE_TIN_ORE.get(), Blocks.DEEPSLATE
            );

    private static final Map<Block, ItemLike> PICK_MAP_STONE_ITEMS =
            Map.of(
                    Blocks.COAL_ORE,  Items.COAL,
                    Blocks.GOLD_ORE, Items.RAW_GOLD,
                    Blocks.DIAMOND_ORE, Items.DIAMOND,
                    Blocks.IRON_ORE, Items.RAW_IRON,
                    Blocks.EMERALD_ORE, Items.EMERALD
            );
    private static final Map<Block, ItemLike> PICK_MAP_STONE_MANY_ITEMS =
            Map.of(
                    Blocks.COPPER_ORE, Items.RAW_COPPER,
                    Blocks.LAPIS_ORE, Items.LAPIS_LAZULI,
                    Blocks.REDSTONE_ORE, Items.REDSTONE,
                    ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()
            );
    private static final Map<Block, ItemLike> PICK_MAP_DEEPSLATE_ITEMS =
            Map.of(
                    Blocks.DEEPSLATE_COAL_ORE,  Items.COAL,
                    Blocks.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD,
                    Blocks.DEEPSLATE_DIAMOND_ORE, Items.DIAMOND,
                    Blocks.DEEPSLATE_IRON_ORE, Items.RAW_IRON,
                    Blocks.DEEPSLATE_EMERALD_ORE, Items.EMERALD
            );
    private static final Map<Block, ItemLike> PICK_MAP_DEEPSLATE_MANY_ITEMS =
            Map.of(
                    Blocks.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER,
                    Blocks.DEEPSLATE_LAPIS_ORE, Items.LAPIS_LAZULI,
                    Blocks.DEEPSLATE_REDSTONE_ORE, Items.REDSTONE,
                    ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get()
            );

    public PickItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(PICK_MAP_DEEPSLATE.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), PICK_MAP_DEEPSLATE.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(2, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                BlockPos blockPos = context.getClickedPos();
                Direction face = context.getClickedFace();

                ItemEntity itemEntity = new ItemEntity(
                        level, blockPos.getX() + .5 + face.getStepX() * .5, blockPos.getY() + .25 + face.getStepY() * .5, blockPos.getZ() + .33 + face.getStepZ() * .5,
                        new ItemStack(PICK_MAP_DEEPSLATE_ITEMS.get(clickedBlock).asItem(), Math.random() < .25 ? 3 : 2)
                );

                level.addFreshEntity(itemEntity);

                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 5.0F);
            }
        }

        if(PICK_MAP_STONE.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), PICK_MAP_STONE.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                BlockPos blockPos = context.getClickedPos();
                Direction face = context.getClickedFace();

                ItemEntity itemEntity = new ItemEntity(
                        level, blockPos.getX() + .5 + face.getStepX() * .5, blockPos.getY() + .25 + face.getStepY() * .5, blockPos.getZ() + .5 + face.getStepZ() * .5,
                        new ItemStack(PICK_MAP_STONE_ITEMS.get(clickedBlock).asItem(), Math.random() < .5 ? 2 : 1)
                );

                level.addFreshEntity(itemEntity);

                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 5.0F);
            }
        }

        if(PICK_MAP_DEEPSLATE_MANY.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), PICK_MAP_DEEPSLATE_MANY.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(2, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                BlockPos blockPos = context.getClickedPos();
                Direction face = context.getClickedFace();

                ItemEntity itemEntity = new ItemEntity(
                        level, blockPos.getX() + .5 + face.getStepX() * .5, blockPos.getY() + .25 + face.getStepY() * .5, blockPos.getZ() + .33 + face.getStepZ() * .5,
                        new ItemStack(PICK_MAP_DEEPSLATE_MANY_ITEMS.get(clickedBlock).asItem(), Math.random() < .33 ? 4 : 3)
                );

                level.addFreshEntity(itemEntity);

                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 5.0F);
            }
        }

        if(PICK_MAP_STONE_MANY.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), PICK_MAP_STONE_MANY.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                BlockPos blockPos = context.getClickedPos();
                Direction face = context.getClickedFace();

                ItemEntity itemEntity = new ItemEntity(
                        level, blockPos.getX() + .5 + face.getStepX() * .5, blockPos.getY() + .25 + face.getStepY() * .5, blockPos.getZ() + .5 + face.getStepZ() * .5,
                        new ItemStack(PICK_MAP_STONE_MANY_ITEMS.get(clickedBlock).asItem(), Math.random() < .5 ? 3 : 2)
                );

                level.addFreshEntity(itemEntity);

                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 5.0F);
            }
        }

        return InteractionResult.SUCCESS;
    }
}

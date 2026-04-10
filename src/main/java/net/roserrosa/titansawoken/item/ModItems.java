package net.roserrosa.titansawoken.item;

import net.minecraft.client.input.InputWithModifiers;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.roserrosa.titansawoken.TitansAwoken;
import net.roserrosa.titansawoken.item.custom.*;

import java.util.List;
import java.util.Optional;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(TitansAwoken.MOD_ID);

    public static final DeferredItem<Item> BRONZE = ITEMS.register("bronze",
            () -> new Item(new  Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM,
                            Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, "bronze")
                    ))
            )
    );
    public static final DeferredItem<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget",
            () -> new Item(new  Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM,
                            Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, "bronze_nugget")
                    ))
            )
    );
    public static final DeferredItem<Item> TIN = ITEMS.register("tin",
            () -> new Item(new  Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM,
                            Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, "tin")
                    ))
            )
    );
    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new  Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM,
                            Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, "raw_tin")
                    ))
            )
    );
    public static final DeferredItem<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new  Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM,
                            Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, "tin_nugget")
                    ))
            )
    );

    public static final DeferredItem<Item> BRONZE_PICK = ITEMS.register("bronze_pick",
            () -> new PickItem(new  Item.Properties()
                    .durability(750)
                    .setId(ResourceKey.create(Registries.ITEM,
                            Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, "bronze_pick")
                    ))
            )
    );

    public static final DeferredItem<Item> BRONZE_SWORD = ITEMS.registerItem("bronze_sword",
            (properties) -> new Item(properties.sword(ModToolTiers.BRONZE, 5, -2.4f)));
    public static final DeferredItem<Item> BRONZE_AXE = ITEMS.registerItem("bronze_axe",
            (properties) -> new Item(properties.axe(ModToolTiers.BRONZE, 7, -3f)));
    public static final DeferredItem<Item> BRONZE_PICKAXE = ITEMS.registerItem("bronze_pickaxe",
            (properties) -> new Item(properties.pickaxe(ModToolTiers.BRONZE, 0, -2.8f)));
    public static final DeferredItem<Item> BRONZE_SHOVEL = ITEMS.registerItem("bronze_shovel",
            (properties) -> new Item(properties.shovel(ModToolTiers.BRONZE, 1, -3f)));
    public static final DeferredItem<Item> BRONZE_HOE = ITEMS.registerItem("bronze_hoe",
            (properties) -> new Item(properties.hoe(ModToolTiers.BRONZE, -4, 0f)));
    public static final DeferredItem<Item> BRONZE_SPEAR = ITEMS.registerItem("bronze_spear",
            (properties -> new Item(properties.spear(ModToolTiers.BRONZE, 1F, 0.8F, 0.6F, 3F,
                    10.0F, 7F, 5.1F, 11F, 4.6F))));

    public static final DeferredItem<GreatswordItem> BRONZE_GREATSWORD = ITEMS.registerItem("bronze_greatsword",
            (properties -> new GreatswordItem(properties.sword(ModToolTiers.BRONZE, 13, -2.8f)
                    .component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(0.66F, 1.5F,
                            List.of(new BlocksAttacks.DamageReduction(20.0F, Optional.empty(), 0.0F, 0.66F)),
                            new BlocksAttacks.ItemDamageFunction(0.0F, 2.0F, 2F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD), Optional.of(SoundEvents.SPEAR_HIT), Optional.of(SoundEvents.ITEM_BREAK)))
                    .component(DataComponents.ATTACK_RANGE, new AttackRange(0.0F, 4.5F, 0.0F,
                            5.0F, 0.0F, 1.0F)))));
    public static final DeferredItem<GreataxeItem> BRONZE_GREATAXE = ITEMS.registerItem("bronze_greataxe",
            (properties) -> new GreataxeItem(properties.axe(ModToolTiers.BRONZE, 11, -3.5f)));
    public static final DeferredItem<SpadeItem> BRONZE_SPADE = ITEMS.registerItem("bronze_spade",
            (properties) -> new SpadeItem(properties.shovel(ModToolTiers.BRONZE, 5, -3.5f)));
    public static final DeferredItem<ScytheItem> BRONZE_SCYTHE = ITEMS.registerItem("bronze_scythe",
            (properties) -> new ScytheItem(properties.hoe(ModToolTiers.BRONZE, -4, 0f)));
    public static final DeferredItem<Item> BRONZE_LANCE= ITEMS.registerItem("bronze_lance",
            (properties -> new Item(properties.spear(ModToolTiers.BRONZE, 1.5F, 3.2F, 0.6F, 4.5F,
                                8.0F, 7F, 4.5F, 13F, 4.6F)
                    .component(DataComponents.ATTACK_RANGE, new AttackRange(2.5f, 6F, 2.5F,
                            6.0F, 0.3F, 1.0F))
                    .component(DataComponents.USE_EFFECTS, new UseEffects( true, true, 1.5f))
                    .component(DataComponents.WEAPON, new Weapon(1, 7.5f)))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

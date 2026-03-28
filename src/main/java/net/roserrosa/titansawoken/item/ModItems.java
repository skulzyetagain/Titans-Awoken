package net.roserrosa.titansawoken.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.roserrosa.titansawoken.TitansAwoken;
import net.roserrosa.titansawoken.item.custom.PickItem;

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
            (properties) -> new Item(properties.sword(ModToolTiers.BRONZE, 4, -2.4f)));
    public static final DeferredItem<Item> BRONZE_PICKAXE = ITEMS.registerItem("bronze_pickaxe",
            (properties) -> new Item(properties.pickaxe(ModToolTiers.BRONZE, 1.0F, -2.8f)));
    public static final DeferredItem<ShovelItem> BRONZE_SHOVEL = ITEMS.registerItem("bronze_shovel",
            (properties) -> new ShovelItem(ModToolTiers.BRONZE, 1.5F, -3.0f, properties));
    public static final DeferredItem<AxeItem> BRONZE_AXE = ITEMS.registerItem("bronze_axe",
            (properties) -> new AxeItem(ModToolTiers.BRONZE, 6.0F, -3.2f, properties));
    public static final DeferredItem<HoeItem> BRONZE_HOE = ITEMS.registerItem("bronze_hoe",
            (properties) -> new HoeItem(ModToolTiers.BRONZE, -3F, -3.0f, properties));
    public static final DeferredItem<Item> BRONZE_SPEAR = ITEMS.registerItem("bronze_spear",
            (properties) -> new Item(properties.spear(ModToolTiers.BRONZE,
                    1F, 1.05f, 0.5f, 3.5f, 8F,
                    7F, 5.1F, 11F, 4.6F)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

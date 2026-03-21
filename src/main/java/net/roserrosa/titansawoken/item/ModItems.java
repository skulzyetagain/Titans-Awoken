package net.roserrosa.titansawoken.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.roserrosa.titansawoken.TitansAwoken;

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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

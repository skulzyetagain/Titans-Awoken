package net.roserrosa.titansawoken.item;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.neoforged.neoforge.common.Tags;
import net.roserrosa.titansawoken.TitansAwoken;
import net.roserrosa.titansawoken.util.ModTags;

import java.util.EnumMap;

public class ModArmorMaterials {// The resource key of the equipment asset used to link
    // the `EquipmentClientInfo` JSON discussed below.
// Points to assets/examplemod/equipment/copper.json
    public static final ResourceKey<EquipmentAsset> BRONZE_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, "bronze"));

    public static final ArmorMaterial BRONZE_ARMOR_MATERIAL = new ArmorMaterial(
            // The durability multiplier of the armor material.
            // ArmorType have different unit durabilities that the multiplier is applied to:
            // - HELMET: 11
            // - CHESTPLATE: 16
            // - LEGGINGS: 15
            // - BOOTS: 13
            // - BODY: 16
            15,
            // Determines the defense value (or the number of half-armors on the bar).
            // Based on ArmorType.
            Util.make(new EnumMap<>(ArmorType.class), attribute -> {
                attribute.put(ArmorType.BOOTS, 3);
                attribute.put(ArmorType.LEGGINGS, 5);
                attribute.put(ArmorType.CHESTPLATE, 7);
                attribute.put(ArmorType.HELMET, 3);
                attribute.put(ArmorType.BODY, 11);
            }),
            // Determines the enchantability of the armor. This represents how good the enchantments on this armor will be.
            // Gold uses 25; we put copper slightly below that.
            18,
            // Determines the sound played when equipping this armor.
            // This is wrapped with a Holder.
            SoundEvents.ARMOR_EQUIP_COPPER,
            // Returns the toughness value of the armor. The toughness value is an additional value included in
            // damage calculation, for more information, refer to the Minecraft Wiki's article on armor mechanics:
            // https://minecraft.wiki/w/Armor#Armor_toughness
            // Only diamond and netherite have values greater than 0 here, so we just return 0.
            0,
            // Returns the knockback resistance value of the armor. While wearing this armor, the player is
            // immune to knockback to some degree. If the player has a total knockback resistance value of 1 or greater
            // from all armor pieces combined, they will not take any knockback at all.
            // Only netherite has values greater than 0 here, so we just return 0.
            0,
            // The tag that determines what items can repair this armor.
            ModTags.Items.BRONZE_REPAIRABLE,
            // The resource key of the EquipmentClientInfo JSON discussed below.
            BRONZE_ASSET
    );
}
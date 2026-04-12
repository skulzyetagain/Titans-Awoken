package net.roserrosa.titansawoken.item;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.roserrosa.titansawoken.TitansAwoken;
import net.roserrosa.titansawoken.util.ModTags;

import java.util.EnumMap;

public class ModArmorMaterials {
    static ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static ResourceKey<EquipmentAsset> BRONZE = ResourceKey.create(ROOT_ID, Identifier.fromNamespaceAndPath(TitansAwoken.MOD_ID, "bronze"));

    public static final ArmorMaterial BRONZE_ARMOR_MATERIAL = new ArmorMaterial(1200,
            Util.make(new EnumMap<>(ArmorType.class), attribute -> {
                attribute.put(ArmorType.BOOTS, 3);
                attribute.put(ArmorType.LEGGINGS, 5);
                attribute.put(ArmorType.CHESTPLATE, 7);
                attribute.put(ArmorType.HELMET, 3);
                attribute.put(ArmorType.BODY, 11);
            }), 16, SoundEvents.ARMOR_EQUIP_COPPER,
            0f, 0f, ModTags.Items.BRONZE_REPAIRABLE, BRONZE);
}
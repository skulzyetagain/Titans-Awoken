package net.roserrosa.titansawoken.util;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import net.roserrosa.titansawoken.item.custom.ScytheItem;

import java.util.function.BiConsumer;

public class ModItemModelGenerators  extends ItemModelGenerators {
    public ModItemModelGenerators(ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
    }

    public void generateScythe(ScytheItem item, ExtendedModelTemplateBuilder modelTemplate) {

    }
}

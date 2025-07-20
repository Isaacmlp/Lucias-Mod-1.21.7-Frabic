package ModItems;

import com.lucias.jesus.x.LuciasMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static Item register (String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {

        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LuciasMod.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);


        return item;
    }

    // Por convencion los nombres de los Item tienen que estar siempre en minusculas
    public static final ToolMaterial LUCINITA = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, ItemTags.NETHERITE_TOOL_MATERIALS); // TODO: Cambiar el itemTag por el del Lucinita
    public static final Item LUCIA_SWORD = register("espada_lucia",Item::new, new Item.Settings().sword(LUCINITA, (float) +64, (float) -2)); //no se jajaj pero a jesus lo joden rapidito
    //no se jajaj pero a jesus lo joden rapidito
    //public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new, new Item.Settings());


    //Create Item Group
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY_LUCIA_MOD = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(LuciasMod.MOD_ID, "lucias_mod"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.LUCIA_SWORD))
            .displayName(Text.translatable("lucias_mod"))
            .build();


    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY_LUCIA_MOD, CUSTOM_ITEM_GROUP);


        //  ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE));
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY_LUCIA_MOD).register((itemGroup) -> itemGroup.add(ModItems.LUCIA_SWORD));

    }
}

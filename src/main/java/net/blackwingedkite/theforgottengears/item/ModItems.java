package net.blackwingedkite.theforgottengears.item;

import net.blackwingedkite.theforgottengears.TheForgottenGears;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheForgottenGears.MOD_ID);

    //声明一个物品：兰粉
    public static final RegistryObject<Item> BLUEPOWDER = ITEMS.register("bluepowder",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.THE_FROGOTTEN_GEARS_TAB)));

    //声明一个物品：优质兰粉
    public static final RegistryObject<Item> FINE_BLUEPOWDER = ITEMS.register("fine_bluepowder",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.THE_FROGOTTEN_GEARS_TAB)));

    //注册模组物品
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}

package net.blackwingedkite.theforgottengears.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab THE_FROGOTTEN_GEARS_TAB = new CreativeModeTab("the_forgotten_gears_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BLUEPOWDER.get());
        }
    };
}

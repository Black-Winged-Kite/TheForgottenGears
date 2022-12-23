package net.blackwingedkite.theforgottengears.block;

import net.blackwingedkite.theforgottengears.TheForgottenGears;
import net.blackwingedkite.theforgottengears.block.custom.BlueLanternBlock;
import net.blackwingedkite.theforgottengears.block.custom.WarningBlock;
import net.blackwingedkite.theforgottengears.item.ModCreativeModeTab;
import net.blackwingedkite.theforgottengears.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheForgottenGears.MOD_ID);

    //声明测试方块
    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",//名称
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)//材质
                    .strength(6f)//挖掘时间
                    .requiresCorrectToolForDrops(),//需要特定工具挖掘
                    UniformInt.of(3, 7)),//掉落3~7经验
            ModCreativeModeTab.THE_FROGOTTEN_GEARS_TAB);//创造模式物品栏

    //声明蓝粉块
    public static final RegistryObject<Block> BLUEPOWDER_BLOCK = registerBlock("bluepowder_block",//名称
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)//材质
                    .strength(6f)//挖掘时间
                    .requiresCorrectToolForDrops()),//需要特定工具挖掘
            ModCreativeModeTab.THE_FROGOTTEN_GEARS_TAB);//创造模式物品栏

    //声明危险方块
    public static final RegistryObject<Block> WARNING_BLOCK = registerBlock("warning_block",//名称
            () -> new WarningBlock(BlockBehaviour.Properties.of(Material.STONE)//材质
                    .strength(6f)//挖掘时间
                    .requiresCorrectToolForDrops()),//需要特定工具挖掘
            ModCreativeModeTab.THE_FROGOTTEN_GEARS_TAB);//创造模式物品栏

    //声明蓝灯方块
    public static final RegistryObject<Block> BlUE_LANTERN = registerBlock("blue_lantern",//名称
            () -> new BlueLanternBlock(BlockBehaviour.Properties.of(Material.STONE)//材质
                    .strength(6f)//挖掘时间
                    .lightLevel(state -> state.getValue(BlueLanternBlock.LIT) ? 15 : 0)//点亮
                    .requiresCorrectToolForDrops()),//需要特定工具挖掘
            ModCreativeModeTab.THE_FROGOTTEN_GEARS_TAB);//创造模式物品栏

    //注册方块
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return  toReturn;
    }

    //注册方块对应的物品
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

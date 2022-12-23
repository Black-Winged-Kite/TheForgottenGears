package net.blackwingedkite.theforgottengears.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HauntedBluepowderItem extends Item {

    public HauntedBluepowderItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){//在服务端且在右手
            //Output a Random Number
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this, 20);
            //Set a Cooldown
//            return InteractionResultHolder.success();
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            components.add(Component.literal("右键生成随机数").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.GOLD));
        }else{
            components.add(Component.literal("按[SHIFT]获取更多信息").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

    private void outputRandomNumber(Player player){
        player.sendSystemMessage(Component.literal("你的数字：" + getRandomNumber()));
    }
    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}

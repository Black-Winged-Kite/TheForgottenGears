package net.blackwingedkite.theforgottengears.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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
    private void outputRandomNumber(Player player){
        player.sendSystemMessage(Component.literal("你的数字：" + getRandomNumber()));
    }
    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}

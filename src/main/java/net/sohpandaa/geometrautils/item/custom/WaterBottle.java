package net.sohpandaa.geometrautils.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.sohpandaa.geometrautils.block.ModBlocks;

import java.util.Map;

public class WaterBottle extends Item {
    private static final Map<Block, Block> MUD_MAP =
            Map.of(
                    Blocks.SOUL_SAND, ModBlocks.SOUL_MUD.get()
            );


    public WaterBottle(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level= context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(MUD_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(),MUD_MAP.get(clickedBlock).defaultBlockState());


                level.playSound(null, context.getClickedPos(), SoundEvents.AMBIENT_UNDERWATER_ENTER, SoundSource.BLOCKS);
            }
        }



        return InteractionResult.SUCCESS;
    }
}

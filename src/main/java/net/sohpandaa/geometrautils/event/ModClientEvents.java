package net.sohpandaa.geometrautils.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sohpandaa.geometrautils.GeometraUtils;
import net.sohpandaa.geometrautils.block.ModBlocks;



@EventBusSubscriber(modid = GeometraUtils.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModClientEvents {

    @SubscribeEvent
    public static void onBlockRightClick(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack heldItem = player.getItemInHand(hand);
        BlockPos pos = event.getPos();
        BlockState clickedBlock = world.getBlockState(pos);

        // Check if the held item is a water bottle
        if (heldItem.getItem() == Potions.WATER) // THIS IS THE LINE I AM HAVING SO MUCH TROUBLE WITH


            // Check if the clicked block is soul sand
                if (clickedBlock.getBlock() == Blocks.SOUL_SAND) {
                    if (!world.isClientSide()) { // isClientSide to check for server side
                        // Replace soul sand with the custom Soul Mud block
                        world.setBlock(pos, ModBlocks.SOUL_MUD.get().defaultBlockState(), 3);

                        // Decrease water bottle stack size or replace with an empty bottle
                        heldItem.shrink(1);
                        player.addItem(new ItemStack(Items.GLASS_BOTTLE));

                    }
                    event.setCanceled(true); // Prevent default action
                }
            }
        }


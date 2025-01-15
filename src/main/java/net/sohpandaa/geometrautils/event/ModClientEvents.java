package net.sohpandaa.geometrautils.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.sohpandaa.geometrautils.item.ModItems;

import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;


@EventBusSubscriber(modid = GeometraUtils.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModClientEvents {

    @SubscribeEvent
    public static void SoulMudConversion(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack heldItem = player.getItemInHand(hand);
        BlockPos pos = event.getPos();
        BlockState clickedBlock = world.getBlockState(pos);

        // Check if the held item is a water bottle
        if (heldItem.getItem() == Items.POTION && heldItem.has(POTION_CONTENTS) && heldItem.get(POTION_CONTENTS).potion().filter(holder -> holder == Potions.WATER).isPresent()) {
            // Check if the clicked block is soul sand
            if (clickedBlock.getBlock() == Blocks.SOUL_SAND) {
                // Replace soul sand with the custom Soul Mud block
                world.setBlock(pos, ModBlocks.SOUL_MUD.get().defaultBlockState(), 3);

                world.playSound(player, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0f,1.0f);

                // Decrease water bottle stack size or replace with an empty bottle
                heldItem.shrink(1);
                player.addItem(new ItemStack(Items.GLASS_BOTTLE));

                event.setCanceled(true); // Prevent default action
            }
        }
    }

    @SubscribeEvent
    public static void TearToGhastTearConversion(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack heldItem = player.getItemInHand(hand);
        BlockPos pos = event.getPos();
        BlockState clickedBlock = world.getBlockState(pos);

        // Check if the held item is the custom modded item EMPTY_TEAR
        if (heldItem.getItem() == ModItems.EMPTY_TEAR.get()) {
            // Check if the clicked block is Soul Mud
            if (clickedBlock.getBlock() == ModBlocks.SOUL_MUD.get()) {
                // Remove the Soul Mud block
                world.removeBlock(pos, false);
                world.playSound(player, pos, SoundEvents.GHAST_AMBIENT, SoundSource.BLOCKS, 0.5f,1.0f);

                //ADD Particle Effect when block is removed

                for(int i=0; i<10; i++){
                    double d0 = (double)pos.getX() + world.random.nextDouble();
                    double d1 = (double)pos.getY() + world.random.nextDouble();
                    double d2 = (double)pos.getZ() + world.random.nextDouble();
                    world.addParticle(ParticleTypes.SOUL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                }

                // Replace EMPTY_TEAR with a Ghast Tear
                heldItem.shrink(1);
                player.addItem(new ItemStack(Items.GHAST_TEAR));

                event.setCanceled(true); // Prevent default action
            }
        }
    }
}


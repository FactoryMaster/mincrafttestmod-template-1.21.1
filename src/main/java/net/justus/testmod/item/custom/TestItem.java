package net.justus.testmod.item.custom;



import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;

public class TestItem extends Item {



    public TestItem(Settings settings) {
        super(settings);
    }


    public static HitResult performRaycast(PlayerEntity player, double maxDistance) {
        Vec3d start = player.getEyePos();
        Vec3d direction = player.getRotationVec(1.0F);
        Vec3d end = start.add(direction.multiply(maxDistance));

        RaycastContext context = new RaycastContext(
                start,
                end,
                RaycastContext.ShapeType.OUTLINE,
                RaycastContext.FluidHandling.NONE,
                player
        );
        BlockHitResult blockHit = player.getWorld().raycast(context);


            return blockHit;
        }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
     if(!world.isClient()) {

HitResult hitResult = performRaycast(user, 50);
if (hitResult.getType() == HitResult.Type.BLOCK) {
    BlockHitResult blockHit = (BlockHitResult) hitResult;
    BlockPos blockPos = blockHit.getBlockPos();

   // double dx = blockPos.getX();
   // double dy = blockPos.getY();
   // double dz = blockPos.getZ();

   // double dtx = 400;
   // double dty = 100;
   // double dtz = -260;

   // user.sendMessage(Text.of("Hitblock"));
   // user.sendMessage(Text.of("x"+dx));
   // user.sendMessage(Text.of("y"+dy));
   // user.sendMessage(Text.of("z"+dz));
  //  user.teleport(dx,  1+dy , dz , false);
    // TP
    user.teleportTo(new TeleportTarget((ServerWorld) world, blockHit.getPos() , user.getVelocity(), user.getYaw(), user.getPitch(), TeleportTarget.NO_OP));

    world.playSound(
            null,
            user.getX(),
            user.getY(),
            user.getZ(),
            SoundEvents.BLOCK_BEACON_DEACTIVATE,
            SoundCategory.BLOCKS,
            1.0F,
            1.0F);

    return TypedActionResult.success(user.getStackInHand(hand));
} //else {
   // user.sendMessage(Text.of("No Hit"));}
          }
return TypedActionResult.pass(user.getStackInHand(hand));
    }
}


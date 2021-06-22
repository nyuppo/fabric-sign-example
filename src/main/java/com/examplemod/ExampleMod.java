package com.examplemod;

import com.examplemod.block.ModSignBlock;
import com.examplemod.block.ModWallSignBlock;
import com.examplemod.mixin.SignTypeAccessor;

// left out all the default Minecraft imports here, but I'm sure you can figure those out lol

public class ExampleMod implements ModInitializer {
    public static final SignType WILLOW_SIGN_TYPE = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("willow"));
    public static final Block WILLOW_SIGN = new ModSignBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.PALE_GREEN).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD), WILLOW_SIGN_TYPE);
    public static final Block WILLOW_WALL_SIGN = new ModWallSignBlock(AbstractBlock.Settings.of(Material.WOOD, MapColor.PALE_GREEN).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD).dropsLike(WILLOW_SIGN), WILLOW_SIGN_TYPE);

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "willow_sign"), WILLOW_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "willow_wall_sign"), WILLOW_WALL_SIGN);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "willow_sign"), (Item)(new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), WILLOW_SIGN, WILLOW_WALL_SIGN)));
    }
}

package com.lapisliozuli.warex;

import com.lapisliozuli.warex.blocks.TupperwareBlock;
import com.lapisliozuli.warex.blocks.TutorialStorageBlock;
import com.lapisliozuli.warex.entities.blockentities.TupperwareBlockEntity;
import com.lapisliozuli.warex.entities.blockentities.TutorialStorageBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WareX implements ModInitializer {
	public static final String MOD_ID = "warex";
	public static final ItemGroup WAREX = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "warex"))
			.icon(() -> new ItemStack(Items.IRON_BLOCK))
			.build();

	public static final TutorialStorageBlock TUTORIAL_STORAGE = new TutorialStorageBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f));
	public static BlockEntityType<TutorialStorageBlockEntity> TUTORIAL_STORAGE_ENTITY;

	public static Block TUPPERWARE_BLOCK;
	public static BlockItem TUPPERWARE_BLOCK_ITEM;
	public static BlockEntityType<TupperwareBlockEntity> TUPPERWARE_BLOCK_ENTITY;
	public static final Identifier TUPPERWARE = new Identifier(MOD_ID, "tupperware_block");
	public static ScreenHandlerType<TupperwareScreenHandler> TUPPERWARE_SCREEN_HANDLER;


	static {
		TUPPERWARE_BLOCK = Registry.register(Registry.BLOCK, TUPPERWARE, new TupperwareBlock(FabricBlockSettings.copyOf(Blocks.CHEST)));
		TUPPERWARE_BLOCK_ITEM = Registry.register(Registry.ITEM, TUPPERWARE, new BlockItem(TUPPERWARE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));

		//The parameter of build at the very end is always null, do not worry about it
		TUPPERWARE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, TUPPERWARE, BlockEntityType.Builder.create(TupperwareBlockEntity::new, TUPPERWARE_BLOCK).build(null));

		//We use registerSimple here because our Entity is not an ExtendedScreenHandlerFactory
		//but a NamedScreenHandlerFactory.
		//In a later Tutorial you will see what ExtendedScreenHandlerFactory can do!
		TUPPERWARE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(TUPPERWARE, TupperwareScreenHandler::new);
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "tut_cardboard_box"), TUTORIAL_STORAGE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "tut_cardboard_box"), new BlockItem(TUTORIAL_STORAGE, new Item.Settings().group(WAREX)));

		TUTORIAL_STORAGE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, MOD_ID + ":tutorial_storage_entity",
				BlockEntityType.Builder.create(TutorialStorageBlockEntity::new, TUTORIAL_STORAGE).build(null));

	}
}

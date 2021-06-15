package com.lapisliozuli.warex;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WareX implements ModInitializer {
	public static final String MOD_ID = "warex";
	public static final ItemGroup WAREX = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "warex"))
			.icon(() -> new ItemStack(Items.IRON_BLOCK))
			.build();

	public static final Block TUTORIAL_STORAGE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "tut_cardboard_box"), TUTORIAL_STORAGE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "tut_cardboard_box"), new BlockItem(TUTORIAL_STORAGE, new Item.Settings().group(WAREX)));
	}
}

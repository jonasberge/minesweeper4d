package net.fabricmc.example;

import ca.weblite.objc.Client;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;

public class ExampleMod implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");

		ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("foo").executes(context -> {
				System.out.println("Called foo with no arguments");
				var player = MinecraftClient.getInstance().player;
				if (player == null) {
					System.out.println("null");
					return 0;
				}
				var mainHandStack = player.getInventory().getMainHandStack();
				System.out.println(mainHandStack);
				player.getInventory().offerOrDrop(new ItemStack(Blocks.LIME_WOOL));
				System.out.println("Done");
				return 1;
			}));

//		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
//            dispatcher.register(CommandManager.literal("foo").executes(context -> {
//				System.out.println("Called foo with no arguments");
//				var player = MinecraftClient.getInstance().player;
//				if (player == null) {
//					System.out.println("null");
//					return 0;
//				}
//				var mainHandStack = player.getInventory().getMainHandStack();
//				System.out.println(mainHandStack);
//				player.getInventory().offerOrDrop(new ItemStack(Blocks.LIME_WOOL));
//				System.out.println("Done");
//				return 1;
//			}));
//        });
	}
}

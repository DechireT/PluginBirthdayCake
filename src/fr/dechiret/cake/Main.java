package fr.dechiret.cake;


import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	public static Main INSTANCE;
	private FireworkManager fireworkManager;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		INSTANCE = this;
		this.fireworkManager = new FireworkManager(this);
		this.fireworkManager.craftEffect();
		getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[Birthday Cake] " + ChatColor.GREEN + "Demarrage");
		getCommand("anniversaire").setExecutor(new Commands(this));
		getCommand("birthday").setExecutor(new Commands(this));
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[Birthday Cake] " + ChatColor.RED+ "Arret");
	}
	
	
	public FireworkManager getFireworkManager() {
		return fireworkManager;
	}
}

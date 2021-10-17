package fr.dechiret.cake;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Commands implements CommandExecutor {

	static Main main;
	
	public Commands(Main varr){
		Commands.main = varr;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {	
	
		if(!(sender instanceof Player)) {
			sender.sendMessage(main.getConfig().getString("birthdaycake.message.no-sender-player"));
			return false;
		}	
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("anniversaire") || cmd.getName().equalsIgnoreCase("anniv") || cmd.getName().equalsIgnoreCase("anniversary") || cmd.getName().equalsIgnoreCase("birthday")){	
			
				if(args.length == 0) {
				player.sendMessage(main.getConfig().getString("birthdaycake.message.usage").replace("&", "§"));
			}
			if(args.length >= 1) {
				
				Random r = new Random();
				  
		        int f = r.nextInt(5);
				
				StringBuilder joueur = new StringBuilder();
				for(String anniv : args) {
					joueur.append(anniv + " ");  
				}
				ItemStack gateauit = new ItemStack(Material.CAKE, 1);
				ItemMeta gateauitM = gateauit.getItemMeta();
				gateauitM.setDisplayName(main.getConfig().getString("birthdaycake.message.meta.name").replace("&", "§").replace("{player}", player.getName()) + joueur.toString());		// joyeux anniversaire					
				gateauitM.setLore(Arrays.asList(main.getConfig().getString("birthdaycake.message.meta.lore1").replace("&", "§").replace("{player}", player.getName()),
						main.getConfig().getString("birthdaycake.message.meta.lore2").replace("&", "§").replace("{player}", player.getName()) +  joueur.toString(),
						main.getConfig().getString("birthdaycake.message.meta.lore3").replace("&", "§").replace("{player}", player.getName()) + joueur.toString()));
				gateauitM.addEnchant(Enchantment.MENDING, 200, true);
				gateauitM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				gateauit.setItemMeta(gateauitM);
				player.getInventory().addItem(gateauit);   
				
				//player.sendMessage(main.getConfig().getString("birthdaycake.message.meta.name").replace("&", "§") + joueur.toString());
				player.sendMessage(main.getConfig().getString("birthdaycake.message.player-executing-command-message").replace("&", "§").replace("{player}", player.getName()));
				
				player.updateInventory();
		        
				
				if(f == 0) {
					Main.INSTANCE.getFireworkManager().spawnFirework(player.getLocation(), "fwe1");
				}else
				if(f == 1) {
					Main.INSTANCE.getFireworkManager().spawnFirework(player.getLocation(), "fwe2");
				}else
				if(f == 2) {
					Main.INSTANCE.getFireworkManager().spawnFirework(player.getLocation(), "fwe3");
				}else
				if(f == 3) {
					Main.INSTANCE.getFireworkManager().spawnFirework(player.getLocation(), "fwe4");
				}else
				if(f == 4) {
					Main.INSTANCE.getFireworkManager().spawnFirework(player.getLocation(), "fwe5");
				}else
				if(f == 5) {
					Main.INSTANCE.getFireworkManager().spawnFirework(player.getLocation(), "fwe6");
				}
				
		        }
				}
				
		return false;
	}
		
}	
/*			
if(cooldowns.containsKey(player.getName())) {

if(cooldowns.get(player.getName()) > System.currentTimeMillis()) {
	
	long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) + (main.getConfig().getInt("birthdaycake.message.cooldowns-time") * 1000);

	player.sendMessage("§cTu dois attendre §e" + timeleft + "§c seconde(s) avant de refaire /anniversaire !");
	return false;
}
}
cooldowns.put(p, System.currentTimeMillis() + (main.getConfig().getInt("birthdaycake.message.cooldowns-time") * 1000));  //, System.currentTimeMillis() / 1000);*/
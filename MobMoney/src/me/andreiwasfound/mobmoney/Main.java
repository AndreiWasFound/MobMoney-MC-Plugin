package me.andreiwasfound.mobmoney;

import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	public Economy eco;
	
	@Override 
	public void onEnable() {
		if (!setupEconomy()) {
			System.out.println(ChatColor.RED + "[MobMoney] You must have Vault and an Economy Plugin installed to use [MobMoney].");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		this.getServer().getPluginManager().registerEvents(new MobKillEvent(this), this);
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economy = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economy != null)
			eco = economy.getProvider();
		return (eco != null);
	}
}

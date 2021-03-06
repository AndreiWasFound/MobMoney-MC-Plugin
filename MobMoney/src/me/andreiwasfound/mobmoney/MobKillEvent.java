package me.andreiwasfound.mobmoney;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobKillEvent implements Listener {

	private Main plugin;
	public MobKillEvent(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onKill(EntityDeathEvent event) {
		if (event.getEntity() instanceof Mob) {
			Player player = event.getEntity().getKiller();
			if (player == null)
				return;
			Random r = new Random();
			int amount = r.nextInt(1000);
			plugin.eco.depositPlayer(player, amount);
			player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "+ $" + amount);
		}
	}
}

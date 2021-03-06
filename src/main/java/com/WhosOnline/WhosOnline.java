package com.WhosOnline;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.WhosOnline.commands.Online;
import com.WhosOnline.commands.Staff;
import com.WhosOnline.events.WhosOnlineMenuEvents;
import com.WhosOnline.events.WhosOnlineStaffMenuEvents;

public class WhosOnline extends JavaPlugin {

	public static PluginManager pm = Bukkit.getPluginManager();
	private static WhosOnline pl;

	public void onEnable() {

		saveDefaultConfig();

		System.out.println("[WhosOnline] has been ENABLED");

		pm.registerEvents(new WhosOnlineMenuEvents(), this);
		pm.registerEvents(new WhosOnlineStaffMenuEvents(), this);

		this.getCommand("online").setExecutor(new Online());
		this.getCommand("who").setExecutor(new Online());
		this.getCommand("list").setExecutor(new Online());
		this.getCommand("users").setExecutor(new Online());
		this.getCommand("whom").setExecutor(new Online());
		
		this.getCommand("staff").setExecutor(new Staff());

	}

	public void onDisable() {

		System.out.println("[WhosOnline] has been DISABLED");

	}

	public WhosOnline() {
		pl = this;
	}

	public static WhosOnline pl() {
		return pl;
	}

}

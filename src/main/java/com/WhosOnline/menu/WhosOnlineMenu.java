package com.WhosOnline.menu;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.WhosOnline.WhosOnline;
import com.WhosOnline.menu.items.WhosOnlineMenuItems;
import com.WhosOnline.util.MessageUtil;

public class WhosOnlineMenu {

	private static FileConfiguration conf = WhosOnline.pl().getConfig();
	public static String OnlineTitle = (MessageUtil.translate(conf.getString("Menu.Title") + " " + "#"));
	private static Boolean enabled = conf.getBoolean("Menu.Staff.Enabled");

	public static Inventory onlinePlayers(Player p, int page) {
		Inventory list = Bukkit.createInventory(null, 54, OnlineTitle + page);

		// Because we only want to list 45 players on any given page.
		// We're going to use an equation to get the start of what
		// skull number needs to be on that page.

		// 45 *(1 - 1) + 1 = 1
		// 45 *(2 - 1) + 1 = 46
		// 45 *(3 - 1) + 1 = 91

		int first = 45 * (page - 1) + 1;
		int last = 45 * page;
		int i = 1;

		for (Player target : Bukkit.getOnlinePlayers()) {
			if (!target.hasPermission("WhosOnline.hidden")) {
				if (p.canSee(target)) {
					if ((i >= first) && (i <= last)) {

						list.addItem(new ItemStack[] { WhosOnlineMenuItems.PlayersHead(target) });
					}
				}
			}
			i++;
		}

		list.setItem(50, WhosOnlineMenuItems.ArrowForward(p));

		if (enabled != null && enabled) {
			list.setItem(49, WhosOnlineMenuItems.StaffMenu(p));
		}
		list.setItem(48, WhosOnlineMenuItems.ArrowBack(p));
		return list;
	}
}

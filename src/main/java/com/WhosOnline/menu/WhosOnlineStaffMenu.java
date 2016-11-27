package com.WhosOnline.menu;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.WhosOnline.WhosOnline;
import com.WhosOnline.menu.items.WhosOnlineMenuItems;
import com.WhosOnline.util.MessageUtil;

public class WhosOnlineStaffMenu {

	public static FileConfiguration conf = WhosOnline.pl().getConfig();
	public static String StaffOnlineTitle = (MessageUtil.translate(conf.getString("Menu.Staff_Title") + " " + "#"));

	public static Inventory onlinePlayers(Player p, int page) {
		Inventory list = Bukkit.createInventory(null, 54, StaffOnlineTitle + page);

		int first = 45 * (page - 1) + 1;
		int last = 45 * page;
		int i = 1;

		for (Player target : Bukkit.getOnlinePlayers()) {
			if (target.hasPermission("WhosOnline.staff")) {
				if (!target.hasPermission("WhosOnline.hidden")) {
					if ((i >= first) && (i <= last)) {

						list.addItem(new ItemStack[] { WhosOnlineMenuItems.PlayersHead(target) });
					}
				}
			}
			i++;
		}

		list.setItem(50, WhosOnlineMenuItems.ArrowForward(p));
		list.setItem(49, WhosOnlineMenuItems.PlayersHead(p));
		list.setItem(48, WhosOnlineMenuItems.ArrowBack(p));
		return list;
	}

}

package com.WhosOnline.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import com.WhosOnline.menu.WhosOnlineMenu;
import com.WhosOnline.menu.WhosOnlineStaffMenu;
import com.WhosOnline.menu.items.WhosOnlineMenuItems;

public class WhosOnlineStaffMenuEvents implements Listener {

	@EventHandler
	public void OnlineMenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		int i = Bukkit.getOnlinePlayers().size();
		int j = (int) Math.ceil(i / 45.0);

		if (ev.getCurrentItem() != null) {
			if (ev.getClickedInventory().getTitle().contains(WhosOnlineStaffMenu.StaffOnlineTitle)) {
				String[] s1 = ChatColor.stripColor(ev.getClickedInventory().getTitle()).split("#");
				String s2 = s1[1];

				if (ev.getCurrentItem().equals(WhosOnlineMenuItems.ArrowForward())) {
					if (Integer.parseInt(s2) + 1 < j) {
						p.openInventory(WhosOnlineStaffMenu.onlinePlayers(p, Integer.parseInt(s2) + 1));
					}
				}

				if (ev.getCurrentItem().equals(WhosOnlineMenuItems.ArrowBack())) {
					if (Integer.parseInt(s2) > 1) {
						p.openInventory(WhosOnlineStaffMenu.onlinePlayers(p, Integer.parseInt(s2) - 1));
					}
				}

				if (ev.getSlot() == 49) {
						p.openInventory(WhosOnlineMenu.onlinePlayers(p, 1));
				}
			}
		}
	}

	@EventHandler
	public void MenuMove(InventoryClickEvent ev) {

		if (ev.getInventory().getName().contains(WhosOnlineStaffMenu.StaffOnlineTitle)) {
			ev.setCancelled(true);
		}
	}

	@EventHandler
	public void MenuDrag(InventoryDragEvent ev) {

		if (ev.getInventory().getName().contains(WhosOnlineStaffMenu.StaffOnlineTitle)) {
			ev.setCancelled(true);
		}
	}

}

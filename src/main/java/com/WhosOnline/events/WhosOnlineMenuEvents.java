package com.WhosOnline.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;

import com.WhosOnline.WhosOnline;
import com.WhosOnline.menu.WhosOnlineMenu;
import com.WhosOnline.menu.items.WhosOnlineMenuItems;

public class WhosOnlineMenuEvents implements Listener {

	public WhosOnline pl;

	public WhosOnlineMenuEvents(WhosOnline instance) {
		this.pl = instance;
	}

	@EventHandler
	public void OnlineMenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		int i = Bukkit.getOnlinePlayers().size();
		int j = (int) Math.ceil(i / 45.0);

		if (ev.getCurrentItem() != null) {
			if (ev.getClickedInventory().getTitle().contains(WhosOnlineMenu.OnlineTitle)) {

				// Lets split the title up. Getting everything past the #
				// Check the page #, if it's less than 100 then open a new page
				String[] s1 = ChatColor.stripColor(ev.getClickedInventory().getTitle()).split("#");
				String s2 = s1[1];

				if (ev.getCurrentItem().equals(WhosOnlineMenuItems.ArrowForward())) {
					if (Integer.parseInt(s2) + 1 < j) {
						p.openInventory(WhosOnlineMenu.onlinePlayers(p, Integer.parseInt(s2) + 1));
					}
				}

				if (ev.getCurrentItem().equals(WhosOnlineMenuItems.ArrowBack())) {
					if (Integer.parseInt(s2) > 1) {
						p.openInventory(WhosOnlineMenu.onlinePlayers(p, Integer.parseInt(s2) - 1));

					}
				}

				// This'll be how we create our action menu
				for (Player target : Bukkit.getOnlinePlayers()) {
					if (ev.getCurrentItem().getItemMeta() != null) {
						if (ev.getCurrentItem().getItemMeta().getDisplayName() != null) {
							if (ev.getCurrentItem().getItemMeta().getDisplayName().equals(target.getDisplayName())) {
								// Open the Action Menu here!
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void MenuMove(InventoryClickEvent ev) {

		if (ev.getInventory().getName().contains(WhosOnlineMenu.OnlineTitle)) {
			ev.setCancelled(true);
		}
	}

	@EventHandler
	public void MenuDrag(InventoryDragEvent ev) {

		if (ev.getInventory().getName().contains(WhosOnlineMenu.OnlineTitle)) {
			ev.setCancelled(true);
		}
	}
}

package com.WhosOnline.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import com.WhosOnline.menu.WhosOnlineActionMenu;
import com.WhosOnline.menu.WhosOnlineMenu;
import com.WhosOnline.menu.items.WhosOnlineMenuItems;

public class WhosOnlineActionMenuEvents implements Listener {
	
	@EventHandler
	public void OnlineMenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		if (ev.getCurrentItem() != null) {
			if (ev.getClickedInventory().getTitle().contains(WhosOnlineActionMenu.ActionTitle)) {
				if(ev.getCurrentItem().equals(WhosOnlineMenuItems.ArrowBack())) {
					p.openInventory(WhosOnlineMenu.onlinePlayers(p, 1));
				}
			}
		}
	}
	
	@EventHandler
	public void MenuMove(InventoryClickEvent ev) {
		
		if (ev.getInventory().getName().contains(WhosOnlineActionMenu.ActionTitle)) {
			ev.setCancelled(true);
		}
	}

	@EventHandler
	public void MenuDrag(InventoryDragEvent ev) {

		if (ev.getInventory().getName().contains(WhosOnlineActionMenu.ActionTitle)) {
			ev.setCancelled(true);
		}
	}
	

}

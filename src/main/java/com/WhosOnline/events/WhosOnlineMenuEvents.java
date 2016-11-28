package com.WhosOnline.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import com.WhosOnline.menu.WhosOnlineMenu;
import com.WhosOnline.menu.WhosOnlineStaffMenu;
import com.WhosOnline.menu.items.WhosOnlineMenuItems;
import com.WhosOnline.util.PermissionUtil;

public class WhosOnlineMenuEvents implements Listener {

	@EventHandler
	public void onlineMenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		int i = Bukkit.getOnlinePlayers().size();
		int j = (int) Math.ceil(i / 45.0);

		if (ev.getCurrentItem() != null) {
			if (ev.getClickedInventory().getTitle().contains(WhosOnlineMenu.OnlineTitle)) {

				// Lets split the title up. Getting everything past the #
				// Check the page #, if it's less than 100 then open a new page
				String[] s1 = ChatColor.stripColor(ev.getClickedInventory().getTitle()).split("#");
				String s2 = s1[1];

				if (ev.getCurrentItem().equals(WhosOnlineMenuItems.ArrowForward(p))) {
					if (Integer.parseInt(s2) + 1 < j) {
						p.openInventory(WhosOnlineMenu.onlinePlayers(p, Integer.parseInt(s2) + 1));
					}
				}

				if (ev.getCurrentItem().equals(WhosOnlineMenuItems.ArrowBack(p))) {
					if (Integer.parseInt(s2) > 1) {
						p.openInventory(WhosOnlineMenu.onlinePlayers(p, Integer.parseInt(s2) - 1));
					}
				}

				if (ev.getCurrentItem().equals(WhosOnlineMenuItems.StaffMenu(p))) {
					if (p.hasPermission("WhosOnline.view.staff")) {
						p.openInventory(WhosOnlineStaffMenu.onlinePlayers(p, 1));
					} else {
						ev.getInventory().setItem(49, WhosOnlineMenuItems.Error("&4&lERROR"));
					}
				}
			}
		}
	}

	@EventHandler
	public void RemovePrevious(InventoryOpenEvent ev) {

		ItemStack air = new ItemStack(Material.AIR);

		if (ev.getInventory().getTitle().equals(WhosOnlineMenu.OnlineTitle + "1")) {
			ev.getInventory().setItem(48, air);
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

	@EventHandler
	public void updateOnJoin(PlayerJoinEvent ev) {

		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.getOpenInventory().getTitle().contains(WhosOnlineMenu.OnlineTitle)) {
				String[] s1 = ChatColor.stripColor(p.getOpenInventory().getTitle()).split("#");
				String s2 = s1[1];

				p.openInventory(WhosOnlineMenu.onlinePlayers(p, Integer.parseInt(s2)));
			}
		}
	}

	@EventHandler
	public void updateOnLeave(PlayerQuitEvent ev) {

		Player quitter = ev.getPlayer();
		PermissionUtil.setPermission(quitter, "WhosOnline.hidden");

		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.getOpenInventory().getTitle().contains(WhosOnlineMenu.OnlineTitle)) {
				String[] s1 = ChatColor.stripColor(p.getOpenInventory().getTitle()).split("#");
				String s2 = s1[1];

				p.openInventory(WhosOnlineMenu.onlinePlayers(p, Integer.parseInt(s2)));
			}
		}
		PermissionUtil.unsetPermission(quitter, "WhosOnline.hidden");
	}
}

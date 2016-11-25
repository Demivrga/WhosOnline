package com.WhosOnline.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.WhosOnline.menu.items.WhosOnlineMenuItems;

public class WhosOnlineActionMenu {
	
	public static String ActionTitle = "Action Menu :: ";
	
	public static Inventory PlayerActionMenu(Player target) {
		Inventory actions = Bukkit.createInventory(null, 54, ActionTitle + target.getName());
		
		actions.setItem(49, WhosOnlineMenuItems.ArrowBack());
		
		return actions;
	}

}

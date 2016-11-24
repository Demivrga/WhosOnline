package com.WhosOnline.util;

import org.bukkit.ChatColor;

public class MessageUtil {
	
	public static String translate(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}	
}

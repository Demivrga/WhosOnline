package com.WhosOnline.menu.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;

import com.WhosOnline.WhosOnline;
import com.WhosOnline.util.MessageUtil;

import me.clip.placeholderapi.PlaceholderAPI;

public class WhosOnlineMenuItems {

	private static FileConfiguration conf = WhosOnline.pl().getConfig();
	private static PluginManager pm = WhosOnline.pm;

	public static ItemStack PlayersHead(Player p) {

		// Create the ItemStack and get the ItemMeta
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();

		// Set Lore/Name/Anything Else here
		skullmeta.setOwner(p.getDisplayName().toString());
		skullmeta.setDisplayName(p.getDisplayName());
		
		// Lore
		if (conf.getStringList("Menu.Player.Lore") != null) {

			// PlaceholderAPI Support
			if (pm.isPluginEnabled("PlaceholderAPI")) {

				List<String> unconverted = conf.getStringList("Menu.Player.Lore");
				List<String> converted = PlaceholderAPI.setPlaceholders(p, unconverted);

				skullmeta.setLore(MessageUtil.listTranslate(converted));
			} else {
				skullmeta.setLore(MessageUtil.listTranslate(conf.getStringList("Menu.Player.Lore")));
			}
		}
		// Append the Meta to the Item
		skull.setItemMeta(skullmeta);

		// Return the Item
		return skull;
	}

	public static ItemStack ArrowBack(Player p) {

		// Create the ItemStack and get the ItemMeta
		ItemStack ArrowBack = new ItemStack(Material.getMaterial(conf.getString("Menu.Previous.Material")));
		ItemMeta ArrowBackMeta = ArrowBack.getItemMeta();

		// Set Lore/Name/Anything Else here
		if (pm.isPluginEnabled("PlaceholderAPI")) {
			String unconverted = conf.getString("Menu.Previous.Name");
			String converted = PlaceholderAPI.setPlaceholders(p, unconverted);
			ArrowBackMeta.setDisplayName(MessageUtil.translate(converted));
		} else {
			ArrowBackMeta.setDisplayName(MessageUtil.translate(conf.getString("Menu.Previous.Name")));
		}

		// Append the Meta to the Item
		ArrowBack.setItemMeta(ArrowBackMeta);

		// Return the Item
		return ArrowBack;
	}

	public static ItemStack ArrowForward(Player p) {

		// Create the ItemStack and get the ItemMeta
		ItemStack ArrowForward = new ItemStack(Material.getMaterial(conf.getString("Menu.Forward.Material")));
		ItemMeta ArrowForwardMeta = ArrowForward.getItemMeta();

		// Set Lore/Name/Anything Else here
		if (pm.isPluginEnabled("PlaceholderAPI")) {
			String unconverted = conf.getString("Menu.Forward.Name");
			String converted = PlaceholderAPI.setPlaceholders(p, unconverted);
			ArrowForwardMeta.setDisplayName(MessageUtil.translate(converted));
		} else {
			ArrowForwardMeta.setDisplayName(MessageUtil.translate(conf.getString("Menu.Forward.Name")));
		}

		// Append the Meta to the Item
		ArrowForward.setItemMeta(ArrowForwardMeta);

		// Return the Item
		return ArrowForward;
	}

	public static ItemStack StaffMenu(Player p) {

		ItemStack StaffMenu = new ItemStack(Material.getMaterial(conf.getString("Menu.Staff.Material")));
		ItemMeta StaffMenuMeta = StaffMenu.getItemMeta();

		// Set Lore/Name/Anything Else here
		if(pm.isPluginEnabled("PlaceholderAPI")) {
			String unconverted = conf.getString("Menu.Staff.Name");
			String converted = PlaceholderAPI.setPlaceholders(p, unconverted);
		StaffMenuMeta.setDisplayName(MessageUtil.translate(converted));
		} else {
			StaffMenuMeta.setDisplayName(MessageUtil.translate(conf.getString("Menu.Staff.Name")));
		}

		// Append the Meta to the Item
		StaffMenu.setItemMeta(StaffMenuMeta);

		// Return the Item
		return StaffMenu;
	}

	public static ItemStack Error(String error) {

		ItemStack Error = new ItemStack(Material.BARRIER);
		ItemMeta ErrorMeta = Error.getItemMeta();

		// Set Lore/Name/Anything Else here
		ErrorMeta.setDisplayName(MessageUtil.translate(error));

		// Append the Meta to the Item
		Error.setItemMeta(ErrorMeta);

		// Return the Item
		return Error;
	}

}

package com.WhosOnline.menu.items;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.WhosOnline.WhosOnline;
import com.WhosOnline.util.MessageUtil;

public class WhosOnlineMenuItems {

	public static FileConfiguration conf = WhosOnline.pl().getConfig();

	public static ItemStack PlayersHead(Player p) {

		// Create the ItemStack and get the ItemMeta
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();

		// Set Lore/Name/Anything Else here
		skullmeta.setOwner(p.getDisplayName().toString());
		skullmeta.setDisplayName(p.getDisplayName());

		// Lore
		if (conf.getStringList("Menu.Player.Lore") != null) {
			skullmeta.setLore(conf.getStringList("Menu.Player.Lore"));	
		}
		// Append the Meta to the Item
		skull.setItemMeta(skullmeta);

		// Return the Item
		return skull;
	}

	public static ItemStack ArrowBack() {

		// Create the ItemStack and get the ItemMeta
		ItemStack ArrowBack = new ItemStack(Material.getMaterial(conf.getString("Menu.Previous.Material")));
		ItemMeta ArrowBackMeta = ArrowBack.getItemMeta();

		// Set Lore/Name/Anything Else here
		ArrowBackMeta.setDisplayName(MessageUtil.translate(conf.getString("Menu.Previous.Name")));

		// Append the Meta to the Item
		ArrowBack.setItemMeta(ArrowBackMeta);

		// Return the Item
		return ArrowBack;

	}

	public static ItemStack ArrowForward() {

		// Create the ItemStack and get the ItemMeta
		ItemStack ArrowForward = new ItemStack(Material.getMaterial(conf.getString("Menu.Forward.Material")));
		ItemMeta ArrowForwardMeta = ArrowForward.getItemMeta();

		// Set Lore/Name/Anything Else here
		ArrowForwardMeta.setDisplayName(MessageUtil.translate(conf.getString("Menu.Forward.Name")));

		// Append the Meta to the Item
		ArrowForward.setItemMeta(ArrowForwardMeta);

		// Return the Item
		return ArrowForward;

	}

}

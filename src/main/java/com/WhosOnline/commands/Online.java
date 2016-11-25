package com.WhosOnline.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.WhosOnline.menu.WhosOnlineMenu;

public class Online implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String lbl, String[] args) {

		Player p = (Player) cs;

		if (lbl.equalsIgnoreCase("online")) {
			if (!(args.length == 1)) {
				p.openInventory(WhosOnlineMenu.onlinePlayers(p, 1));

			} else {
				if (isParsable(args[0])) {
					int x = Integer.parseInt(args[0]);
					p.openInventory(WhosOnlineMenu.onlinePlayers(p, x));
				} else {
					p.sendMessage("ERROR!: Command: /<command> <#>");
				}
			}
		}

		if (lbl.equalsIgnoreCase("who")) {
			if (!(args.length == 1)) {
				p.openInventory(WhosOnlineMenu.onlinePlayers(p, 1));

			} else {
				if (isParsable(args[0])) {
					int x = Integer.parseInt(args[0]);
					p.openInventory(WhosOnlineMenu.onlinePlayers(p, x));
				} else {
					p.sendMessage("ERROR!: /<command> <#>");
				}
			}
		}

		if (lbl.equalsIgnoreCase("list")) {
			if (!(args.length == 1)) {
				p.openInventory(WhosOnlineMenu.onlinePlayers(p, 1));

			} else {
				if (isParsable(args[0])) {
					int x = Integer.parseInt(args[0]);
					p.openInventory(WhosOnlineMenu.onlinePlayers(p, x));
				} else {
					p.sendMessage("ERROR!: /<command> <#>");
				}
			}
		}

		if (lbl.equalsIgnoreCase("users")) {
			if (!(args.length == 1)) {
				p.openInventory(WhosOnlineMenu.onlinePlayers(p, 1));

			} else {
				if (isParsable(args[0])) {
					int x = Integer.parseInt(args[0]);
					p.openInventory(WhosOnlineMenu.onlinePlayers(p, x));
				} else {
					p.sendMessage("ERROR!: /<command> <#>");
				}
			}
		}

		if (lbl.equalsIgnoreCase("whom")) {
			if (!(args.length == 1)) {
				p.openInventory(WhosOnlineMenu.onlinePlayers(p, 1));

			} else {
				if (isParsable(args[0])) {
					int x = Integer.parseInt(args[0]);
					p.openInventory(WhosOnlineMenu.onlinePlayers(p, x));
				} else {
					p.sendMessage("ERROR!: /<command> <#>");
				}
			}
		}
		return false;
	}

	private boolean isParsable(String input) {
		boolean parsable = true;
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			parsable = false;
		}
		return parsable;
	}

}

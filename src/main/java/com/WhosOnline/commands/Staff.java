package com.WhosOnline.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.WhosOnline.menu.WhosOnlineStaffMenu;

public class Staff implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String lbl, String[] args) {
		if (lbl.equalsIgnoreCase("staff")) {

			if (cs.hasPermission("WhosOnline.command.staff")) {
				if ((cs instanceof Player)) {

					Player p = (Player) cs;

					if (!(args.length == 1)) {
						p.openInventory(WhosOnlineStaffMenu.onlinePlayers(p, 1));

					} else {
						if (isParsable(args[0])) {
							int x = Integer.parseInt(args[0]);
							p.openInventory(WhosOnlineStaffMenu.onlinePlayers(p, x));
						} else {
							p.sendMessage("ERROR!: Command: /<command> <#>");
						}
					}
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

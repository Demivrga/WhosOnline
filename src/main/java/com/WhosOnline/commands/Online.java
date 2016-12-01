package com.WhosOnline.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.WhosOnline.menu.WhosOnlineMenu;

public class Online implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String lbl, String[] args) {

		int a = Bukkit.getOnlinePlayers().size();
		List<String> online = new ArrayList<String>();

		for (Player p : Bukkit.getOnlinePlayers()) {
			online.add(p.getName());
		}

		if (lbl.equalsIgnoreCase("online")) {

			if ((cs instanceof Player)) {

				Player p = (Player) cs;

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
			} else {
				System.out.println("Online Players: " + a);
				System.out.println(online);
			}
		}

		if (lbl.equalsIgnoreCase("who")) {

			if ((cs instanceof Player)) {

				Player p = (Player) cs;

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
			} else {
				System.out.println("Online Players: " + a);
				System.out.println(online);
			}
		}

		if (lbl.equalsIgnoreCase("list")) {

			if ((cs instanceof Player)) {

				Player p = (Player) cs;

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
			} else {
				System.out.println("Online Players: " + a);
				System.out.println(online);
			}
		}

		if (lbl.equalsIgnoreCase("users")) {

			if ((cs instanceof Player)) {

				Player p = (Player) cs;

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
			} else {
				System.out.println("Online Players: " + a);
				System.out.println(online);
			}
		}

		if (lbl.equalsIgnoreCase("whom")) {

			if ((cs instanceof Player)) {

				Player p = (Player) cs;

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
			} else {
				System.out.println("Online Players: " + a);
				System.out.println(online);
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

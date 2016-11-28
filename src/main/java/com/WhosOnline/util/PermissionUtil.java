package com.WhosOnline.util;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import com.WhosOnline.WhosOnline;

public class PermissionUtil {
	
	public static void setPermission(Player player, String permission) {
		HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();
		PermissionAttachment attachment = player.addAttachment(WhosOnline.pl());
		perms.put(player.getUniqueId(), attachment);
		PermissionAttachment pperms = perms.get(player.getUniqueId());
		pperms.setPermission(permission, true);
	}
	
	public static void unsetPermission(Player player, String permission) {
		HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();
		PermissionAttachment attachment = player.addAttachment(WhosOnline.pl());
		perms.put(player.getUniqueId(), attachment);
		PermissionAttachment pperms = perms.get(player.getUniqueId());
		pperms.unsetPermission(permission);
	}

}

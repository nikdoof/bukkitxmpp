package com.pleaseignore.BukkitXMPP;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Handle events for all Player related events
 * @author Matalok
 */
public class BukkitXMPPPlayerListener extends PlayerListener {
    private final BukkitXMPP plugin;

    public BukkitXMPPPlayerListener(BukkitXMPP instance) {
        plugin = instance;
    }

    @Override
    public void onPlayerChat(PlayerChatEvent event) {
        Player p = event.getPlayer();
	String msg = event.getMessage();
        try {
            plugin.muc.sendMessage("[" + p.getDisplayName() + "] " + msg);
        } catch (Exception e) {
            // TODO: Error handling
        }

    }
    //Insert Player related code here
}


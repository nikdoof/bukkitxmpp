package com.pleaseignore.BukkitXMPP;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

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
    
    @Override
    public void onPlayerQuit (PlayerQuitEvent event) {
    	Player p = event.getPlayer();
        try {
            plugin.muc.sendMessage(p.getDisplayName() + " has left the server");
        } catch (Exception e) {
            // TODO: Error handling
        }
    }
    
    @Override
    public void onPlayerJoin (PlayerJoinEvent event) {
    	Player p = event.getPlayer();
        try {
            plugin.muc.sendMessage(p.getDisplayName() + " has joined the server");
        } catch (Exception e) {
            // TODO: Error handling
        }
    	
    }
}


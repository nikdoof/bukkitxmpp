package com.pleaseignore.BukkitXMPP;

import org.bukkit.ChatColor;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.muc.DefaultParticipantStatusListener;

public class BukkitParticipantStatusListener extends DefaultParticipantStatusListener {
	
	private final BukkitXMPP plugin;
	
    public BukkitParticipantStatusListener(BukkitXMPP instance) {
        plugin = instance;
    }
    
    @Override
    public void joined(String participant) {
    	plugin.sendMCMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "XMPP" + ChatColor.GRAY + "] " + ChatColor.WHITE + StringUtils.parseResource(participant) + " has joined the channel");
    }
    
    @Override
    public void left(String participant) {
    	plugin.sendMCMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "XMPP" + ChatColor.GRAY + "] " + ChatColor.WHITE + StringUtils.parseResource(participant) + " has left the channel");
    }
    
    @Override
    public void kicked(String participant, String actor, String reason) {
    	left(participant);
    }
    
    @Override
    public void banned(String participant, String actor, String reason) {
    	left(participant);
    }
}

/*
 * The MIT License
 *
 * Copyright (c) 2011 Andrew Williams (Nik_Doof/Matalok)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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

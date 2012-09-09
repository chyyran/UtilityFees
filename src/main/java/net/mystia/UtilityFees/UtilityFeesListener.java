package net.mystia.UtilityFees;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class UtilityFeesListener implements Listener
{
	
HashMap<String, Integer> counter = new HashMap<String, Integer>();
	
@EventHandler(priority = EventPriority.MONITOR)
public void LeverClickEvent(PlayerInteractEvent e){
	if (e.getClickedBlock().getType() == Material.LEVER){
		 
		String player = e.getPlayer().getName();
		Integer newValue = counter.get(player)+1;
		counter.put(player, newValue);
	}
}


}

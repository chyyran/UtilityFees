package net.mystia.UtilityFees;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class UtilityFeesListener implements Listener
{
@EventHandler(priority = EventPriority.MONITOR)
public void LeverClickEvent(PlayerInteractEvent e){
	if (e.getClickedBlock().getType() == Material.LEVER){
		
				 
		String player = event.getPlayer().getName();
		int newValue = counter.get(player)+1;
		counter.put(player, newValue);
	}
}


}

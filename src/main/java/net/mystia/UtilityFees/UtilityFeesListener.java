package net.mystia.UtilityFees;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class UtilityFeesListener implements Listener
{

	private UtilityFeesMain plugin;
	//Initiate a counter to check how many times a player has clicked a lever or stone button
	HashMap<String, Integer> counter = new HashMap<String, Integer>();

	@EventHandler(priority = EventPriority.MONITOR)
	public void TriggerClickEvent(PlayerInteractEvent e)
	{
		//Checks if the player has clicked a lever or a stone button
		if (e.getClickedBlock().getType() == Material.LEVER 
				|| e.getClickedBlock().getType() == Material.STONE_BUTTON)
		{

			String player = e.getPlayer().getName();
			Integer newValue = counter.get(player) + 1;
			counter.put(player, newValue);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void RedstoneBlockPlaceEvent(BlockPlaceEvent e)
	{
		//Checks if a player has placed a redstone torch or plate
		if (e.getBlock().getType() == Material.REDSTONE_TORCH_OFF
				|| e.getBlock().getType() == Material.WOOD_PLATE
				|| e.getBlock().getType() == Material.STONE_PLATE
				)
		{
			String player = e.getPlayer().getName();
			Integer newValue = counter.get(player) + 1;
			counter.put(player, newValue);
		}
	}
	@EventHandler(priority = EventPriority.MONITOR)
	public void RedstoneBlockBreakEvent(BlockBreakEvent e)
	{
		//Checks if a player has broken a redstone torch or plate and remove one count from the counter
		if (e.getBlock().getType() == Material.REDSTONE_TORCH_OFF
				|| e.getBlock().getType() == Material.WOOD_PLATE
				|| e.getBlock().getType() == Material.STONE_PLATE)
		{
			String player = e.getPlayer().getName();
			Integer newValue = counter.get(player) - 1;
			counter.put(player, newValue);
		}
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void WaterBucketEmptyEvent(PlayerBucketEmptyEvent e){
		//Checks if a player has emptied a water bucket
		if (e.getBucket() == Material.WATER_BUCKET){
			String player = e.getPlayer().getName();
			Integer newValue = counter.get(player) + 1;
			counter.put(player, newValue);
		}
		
	}

}

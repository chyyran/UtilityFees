package net.mystia.UtilityFees;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class UtilityFeesListener implements Listener
{

	HashMap<String, Integer> counter = new HashMap<String, Integer>();

	@EventHandler(priority = EventPriority.MONITOR)
	public void TriggerClickEvent(PlayerInteractEvent e)
	{
		if (e.getClickedBlock().getType() == Material.LEVER
				|| e.getClickedBlock().getType() == Material.STONE_BUTTON)
		{

			String player = e.getPlayer().getName();
			Integer newValue = counter.get(player) + 1;
			counter.put(player, newValue);
		}
	}

	public void RedstoneBlockPlaceEvent(BlockPlaceEvent e)
	{
		if (e.getBlock().getType() == Material.REDSTONE_TORCH_OFF
				|| e.getBlock().getType() == Material.WOOD_PLATE
				|| e.getBlock().getType() == Material.STONE_PLATE)
		{
			String player = e.getPlayer().getName();
			Integer newValue = counter.get(player) + 1;
			counter.put(player, newValue);
		}
	}

	public void RedstoneBlockBreakEvent(BlockBreakEvent e)
	{
		if (e.getBlock().getType() == Material.REDSTONE_TORCH_OFF
				|| e.getBlock().getType() == Material.WOOD_PLATE
				|| e.getBlock().getType() == Material.STONE_PLATE)
		{
			String player = e.getPlayer().getName();
			Integer newValue = counter.get(player) - 1;
			counter.put(player, newValue);
		}
	}

}

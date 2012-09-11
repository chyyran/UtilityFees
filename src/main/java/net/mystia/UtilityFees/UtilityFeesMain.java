package net.mystia.UtilityFees;

import java.io.File;

import net.milkbowl.vault.economy.Economy;
import net.mystia.UtilityFees.SLAPI;
import net.mystia.UtilityFees.UtilityFeesListener;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class UtilityFeesMain extends JavaPlugin
{
	public static Economy economy = null;
	private UtilityFeesListener listener;

	public void onEnable()
	{ //Checks if Vault and economy is installed properly
		if (!setupEconomy())
		{
			getLogger().severe("No Vault dependency found, disabling plugin");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		try
		{
			listener.counter = SLAPI.load(this.getDataFolder() + File.separator + "fees.dat");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable()
		{

			public void run()
			{
				for (String player : listener.counter.keySet())
				{
					/*Gets how many times a player has placed or used a 
					 * Redstone torch
					 * Lever
					 * Water
					 * Pressure Plate
					 * and multiplies it by 25
					 * and charges the player that amount
					 */
					int payment = listener.counter.get(player) * 25;
					economy.withdrawPlayer(player, (double) payment);
				}
				;
			}
		}, 60L, 24000L);

	}

	//Sets up economy
	private boolean setupEconomy()
	{
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null)
		{
			economy = economyProvider.getProvider();
		}

		return (economy != null);
	}

	public void onDisable()
	{
		//Saves counter data to file to persist between restarts
		try
		{
			SLAPI.save(listener.counter, this.getDataFolder() + File.separator + "fees.dat");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

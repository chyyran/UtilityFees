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
	{
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

	}

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

package net.mystia.UtilityFees;

import net.mystia.UtilityFees.UtilityFeesListener;
import net.mystia.UtilityFees.SLAPI;

import org.bukkit.plugin.java.JavaPlugin;

public class UtilityFeesMain extends JavaPlugin
{

	private UtilityFeesListener listener;
	private SLAPI SLAPI;

	@SuppressWarnings("static-access") public void onEnable()
	{
		try
		{
			listener.counter = SLAPI.load("fees.dat");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("static-access") public void onDisable()
	{
		try
		{
			SLAPI.save(listener.counter, "fees.dat");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

package com.pitts.nextdrop;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class NextDropPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(NextDropPlugin.class);
		RuneLite.main(args);
	}
}

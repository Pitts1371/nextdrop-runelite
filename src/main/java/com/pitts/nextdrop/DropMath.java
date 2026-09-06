package com.pitts.nextdrop;

final class DropMath
{
	private DropMath()
	{
	}

	static double p(int rate)
	{
		if (rate <= 0)
		{
			return 0;
		}
		return 1.0 / rate;
	}

	static double chanceAtLeastOne(int rate, int trials)
	{
		if (rate <= 0 || trials <= 0)
		{
			return 0;
		}
		return 1.0 - Math.pow(1.0 - p(rate), trials);
	}

	static double stillDryChance(int rate, int kc)
	{
		if (rate <= 0 || kc <= 0)
		{
			return 1.0;
		}
		return Math.pow(1.0 - p(rate), kc);
	}

	static int killsUntil(int rate, double threshold)
	{
		if (rate <= 0 || threshold <= 0)
		{
			return 0;
		}
		if (threshold >= 1.0)
		{
			return Integer.MAX_VALUE;
		}
		return (int) Math.ceil(Math.log(1.0 - threshold) / Math.log(1.0 - p(rate)));
	}

	static String pct(double value)
	{
		if (value <= 0)
		{
			return "0%";
		}
		if (value >= 0.9995)
		{
			return ">99.9%";
		}
		if (value < 0.001)
		{
			return String.format("%.3f%%", value * 100);
		}
		if (value < 0.01)
		{
			return String.format("%.2f%%", value * 100);
		}
		return String.format("%.1f%%", value * 100);
	}

	static String drynessLabel(int kc, int rate)
	{
		if (rate <= 0)
		{
			return "set a drop rate";
		}
		double ratio = (double) kc / rate;
		if (kc == 0)
		{
			return "fresh grind";
		}
		if (ratio < 0.5)
		{
			return "still early";
		}
		if (ratio < 1.0)
		{
			return "approaching rate";
		}
		if (ratio < 2.0)
		{
			return "on rate / a bit dry";
		}
		if (ratio < 3.0)
		{
			return "proper dry";
		}
		if (ratio < 5.0)
		{
			return "cursed";
		}
		return "go touch grass (or keep sending it)";
	}
}

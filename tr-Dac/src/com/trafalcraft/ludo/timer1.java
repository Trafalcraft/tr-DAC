package com.trafalcraft.ludo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class timer1 {
	static JavaPlugin plugin = mainClasse.plugin;
	public static int task;

	public static void startCountdown(final int CAB) {
		task = Bukkit.getScheduler().scheduleSyncDelayedTask(mainClasse.plugin, new Runnable() {

			@Override
			public void run() {
				int time = CAB;

				if (time != 0) {
					time--;
					startCountdown(time);
				}
				if (time == 30) {
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §bla partie commence dans 30 seconds");
				}
				if (time == 20) {
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §bla partie commence dans 20 seconds");
				}
				if (time <= 10 && time != 0) {
					Bukkit.getServer()
							.broadcastMessage("§3§ldé à coudre> §bla partie commence dans " + time + " seconds");
				}

				if (time == 0) {
					Bukkit.getServer().broadcastMessage("§3§ldé à coudre> §bla partie commence");
					Bukkit.getScheduler().cancelTask(task);
					regen.regen();
					gamestart.joueur1Start();
				}

			}

		}, 20);

	}

}

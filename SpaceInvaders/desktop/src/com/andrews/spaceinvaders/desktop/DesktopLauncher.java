package com.andrews.spaceinvaders.desktop;

import com.andrews.spaceinvaders.GameMain;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 600;
		config.width = 800;
		config.resizable = false;
		config.title = "Space Invaders";
		config.addIcon("ship.png", Files.FileType.Internal);
		new LwjglApplication(new GameMain(), config);
	}
}

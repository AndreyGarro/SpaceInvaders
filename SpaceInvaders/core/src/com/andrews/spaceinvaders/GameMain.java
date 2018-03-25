package com.andrews.spaceinvaders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMain extends Game {

	public Screen fondoBatalla;
	
	@Override
	public void create() {
		fondoBatalla = new EscenarioBatalla(this); 
		setScreen(fondoBatalla);
		
	}

}

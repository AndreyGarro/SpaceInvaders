package com.andrews.spaceinvaders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class GameMain extends Game {

	public Screen fondoBatalla;
	
	@Override
	public void create() {
		fondoBatalla = new EscenarioBatalla(this); 
		setScreen(fondoBatalla);
		
	}

}

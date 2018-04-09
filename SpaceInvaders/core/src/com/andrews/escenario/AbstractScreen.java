package com.andrews.escenario;

import com.andrews.spaceinvaders.GameMain;
import com.badlogic.gdx.Screen;

public abstract class AbstractScreen implements Screen {

	protected GameMain main;
	
	public AbstractScreen(GameMain main) {
		this.main = main;
	}
	
	@Override
	public void render(float delta) {
		
	}
	
	@Override
	public void show() {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() { 

	}

	@Override
	public void dispose() {

	}

}

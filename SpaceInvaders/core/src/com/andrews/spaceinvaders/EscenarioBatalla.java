package com.andrews.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EscenarioBatalla extends AbstractScreen {
	
	private SpriteBatch batch;
	private Texture background;
	private NavePrincipal nave;

	public EscenarioBatalla(GameMain main) {
		super(main);
		}

	@Override
	public void show() {
		batch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("background.jpg"));
		nave = new NavePrincipal((Gdx.graphics.getWidth()/2)-25, 20, "ship.png");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		nave.update();
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		nave.draw(batch);
		batch.end();
	}
}

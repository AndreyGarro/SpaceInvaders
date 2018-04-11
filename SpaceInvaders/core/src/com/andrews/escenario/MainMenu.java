package com.andrews.escenario;

import com.andrews.escenario.AbstractScreen;
import com.andrews.spaceinvaders.GameMain;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu extends AbstractScreen{
	
	private SpriteBatch batch;
	private Texture background;
	private Texture background2;
	private Music musicaFondo;
	private boolean musicOn = false;
	private int tempo = 0;
	private int validacion = 0;
	
	public MainMenu(GameMain main) {
		super(main);
	}
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("mainMenu.png"));
		background2 = new Texture(Gdx.files.internal("mainMenu2.png"));
	}


	public void create() {
		musicaFondo = Gdx.audio.newMusic(Gdx.files.internal("musicMainMenu.mp3"));
		musicaFondo.play();
	}
	
	@Override
	public synchronized void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(!musicOn) {
			this.create();
			musicOn = true;
		}
		batch.begin();
		if (tempo == 25 && validacion == 0) {
		 tempo = 50;
		 validacion = 1;
		}
		if(tempo <= 25) {
			batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			tempo ++;
			validacion = 0;
		}
		else {
			batch.draw(background2, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			tempo --;
			if(tempo == 25 && validacion == 1) {
				tempo = 0;
				validacion = 0;
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			main.fondo = new HileraC(main);  //Aqui llama la hilera que necesita
			main.setScreen(main.fondo);
		}
		batch.end();
	}


}

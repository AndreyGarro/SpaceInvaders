package com.andrews.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EscenarioBatalla extends AbstractScreen {
	
	private SpriteBatch batch;
	private Texture background;
	private NavePrincipal nave;
	private ListaSimple<Enemigo> listaEnemigos;

	public EscenarioBatalla(GameMain main, ListaSimple<Enemigo> listaEnemigos) {
		super(main);
		this.listaEnemigos = listaEnemigos;
		}

	@Override
	public void show() {
		batch = new SpriteBatch(); //agrupacion de sprites u objetos que se vayan a dibujar
		background = new Texture(Gdx.files.internal("background.jpg"));
		nave = new NavePrincipal((Gdx.graphics.getWidth()/2)-25, 10, "ship.png");
	}
	
	
	@Override
	public void render(float delta) {
		//Limpia el buffer de dibujo
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		nave.move();
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		nave.draw(batch);
		for(int i = 0; i < listaEnemigos.getTamaño(); i++) {
			listaEnemigos.getDato(i).draw(batch);
			if (listaEnemigos.getDato(i) == listaEnemigos.getDato(0)) {
				System.out.println("izq");
				listaEnemigos.getDato(1).move();
			}
		}
		batch.end();
	}
}

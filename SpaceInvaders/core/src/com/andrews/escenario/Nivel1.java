package com.andrews.escenario;

import java.util.ArrayList;

import com.andrews.spaceinvaders.GameMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;;

@SuppressWarnings("unused")
public class Nivel1 extends AbstractScreen {

	private ArrayList<AbstractScreen> listaHileras;
	public int nivel = 1;
	public int valorEliminar = 0;
	public int puntaje = 0;

	public Nivel1(GameMain main) {
		super(main);
		this.listaHileras = new ArrayList<AbstractScreen>();
		listaHileras.add(new HileraBasica(this.main, this.listaHileras, this));
		listaHileras.add(new HileraB(this.main, this.listaHileras, this));
		listaHileras.add(new HileraA(this.main, this.listaHileras, this));
		listaHileras.add(new HileraBasica(this.main, this.listaHileras, this));
		listaHileras.add(new HileraA(this.main, this.listaHileras, this));
		listaHileras.add(new HileraB(this.main, this.listaHileras, this));
		listaHileras.add(new HileraBasica(this.main, this.listaHileras, this));

	}

	@Override
	public void render(float delta) {
		ArrayList<String> hileras = new ArrayList<String>();
		
		main.fondo = listaHileras.get(0);
		main.setScreen(main.fondo);

	}

}

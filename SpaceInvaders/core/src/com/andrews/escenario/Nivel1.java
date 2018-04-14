package com.andrews.escenario;

import com.andrews.spaceinvaders.GameMain;
import com.badlogic.gdx.graphics.Texture;
import com.andrews.estructuras.*;

import java.util.ArrayList;

import com.andrews.estructuras.*;;

@SuppressWarnings("unused")
public class Nivel1 extends AbstractScreen {
	
	@SuppressWarnings("rawtypes")
	private ArrayList[] listaHileras;
	public int nivel = 1;

	public Nivel1(GameMain main) {
		super(main);              
	}
	
	@Override
	public void render(float delta) {
		if(nivel==1) {
			ArrayList<String> hileras = new ArrayList<String>();
			main.fondo = new HileraB(main, this);
			main.setScreen(main.fondo);
		}
	}
	
}

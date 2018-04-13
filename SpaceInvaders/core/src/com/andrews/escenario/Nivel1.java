package com.andrews.escenario;

import com.andrews.spaceinvaders.GameMain;
import com.badlogic.gdx.graphics.Texture;
import com.andrews.estructuras.*;

import java.util.ArrayList;

import com.andrews.estructuras.*;;

public class Nivel1 extends AbstractScreen {
	
	private String[] listaHileras;
	public String hileraActual = "hileraBasica";

	public Nivel1(GameMain main) {
		super(main);
		String[] hileras = new String[] {"hileraBasica", "hileraA", "hileraB"};              
	}
	
	@Override
	public void render(float delta) {
		if(hileraActual.equals("hileraBasica")) {
			main.fondo = new HileraBasica(main);
			main.setScreen(main.fondo);
			this.hileraActual = "hileraA";
		}
		else if(hileraActual.equals("hileraA")) {
			main.fondo = new HileraA(main);
			main.setScreen(main.fondo);
		}
		else if(hileraActual.equals("hileraB")) {
			main.fondo = new HileraB(main);
			main.setScreen(main.fondo);
		}
	}
	
}

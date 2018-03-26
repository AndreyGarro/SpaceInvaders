package com.andrews.spaceinvaders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class GameMain extends Game {

	public Screen fondoBatalla;
	
	@Override
	public void create() {
		ListaSimple<Enemigo> listaEnemigos = new ListaSimple<Enemigo>();
		int cont = 0;
		int xPos = 20;
		int yPos = 500;
		while(cont < 15) {
			listaEnemigos.agregarAlFinal(new Enemigo(xPos, yPos, "enemySprite.png"));
			cont ++;
			xPos += 50;
		}
		fondoBatalla = new EscenarioBatalla(this, listaEnemigos); 
		setScreen(fondoBatalla);	
	}

}

package com.andrews.spaceinvaders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Clase encargada de hacer la llamada y crear los escenarios y pasar la lista de enemigos
 * correspondientes.
 * @author andrey
 *
 */
public class GameMain extends Game {

	public Screen fondoBatalla;
	
	
	/**
	 * Crea la lista de enemigos y agrega la cantidad necesaria
	 * para mostrarlos en pantalla, y llama al escenario de 
	 * batalla para mostrar todos sus elementos.
	 */
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

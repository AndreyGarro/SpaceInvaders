package com.andrews.spaceinvaders;


import com.andrews.escenario.*;
import com.andrews.estructuras.ListaEnemigoFactory;
import com.andrews.estructuras.ListaSimple;
import com.andrews.sprites.Enemigo;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Clase encargada de hacer la llamada y crear los escenarios y pasar la lista de enemigos
 * correspondientes.
 * @author andrey
 *
 */
public class GameMain extends Game {
	public Screen fondo;
	
	/**
	 * Crea la lista de enemigos y agrega la cantidad necesaria
	 * para mostrarlos en pantalla, y llama al escenario de 
	 * batalla para mostrar todos sus elementos.
	 */
	@Override
	public void create() {
		fondo = new MainMenu(this); 
		setScreen(fondo);
	}
}


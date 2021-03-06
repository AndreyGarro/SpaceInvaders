package com.andrews.sprites;

import com.andrews.escenario.Server;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Ser� la nave principal la cu�l controlar� el jugador
 * 
 * @author andrey
 *
 */
public class NavePrincipal extends Sprite {

	// Atributos
	private float speed = 200;
	private Server server;
	//

	/**
	 * Inicializa el objeto de tipo NavePrincipal
	 * 
	 * @param x
	 *            coordenada en el eje x
	 * @param y
	 *            coordenada en el eje y
	 * @param sprite
	 *            sprite de la nave que se quiere mostrar
	 */
	public NavePrincipal(float x, float y, String sprite) {
		super(x, y, sprite);
		if (Server.getExist()) {
			server = Server.getInstance();
		}
	}
	// Fin del Constructor

	/**
	 * Habilita los movimientos de la nave, en este caso solo se mueve en el eje x.
	 */
	public void move() {
		float delta = Gdx.graphics.getDeltaTime();
		if (server == null) {
			if (Gdx.input.isKeyPressed(Keys.LEFT)) {
				if (colisionIzquierda()) {
					bordes.x -= speed * delta;
				}
			} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
				if (colisionDerecha()) {
					bordes.x += speed * delta;
				}
			}
		} else {
			if(server.getRecibido() == null||server.getRecibido().equals(" ")) {
				return;
			}
			else if (Gdx.input.isKeyPressed(Keys.LEFT) || server.getRecibido().equals("1")) {
				if (colisionIzquierda()) {
					bordes.x -= speed * delta;
				}
			} else if (Gdx.input.isKeyPressed(Keys.RIGHT)|| server.getRecibido().equals("2")) {
				if (colisionDerecha()) {
					bordes.x += speed * delta;
				}
			}
		}
	}

	/**
	 * Detecta cuando la nave colisiona en el lateral derecho.
	 */
	public boolean colisionDerecha() {
		return bordes.x + texture.getWidth() <= Gdx.graphics.getWidth();
	}

	/**
	 * Detecta cuando la nave colisiona en el lateral izquierdo.
	 */
	public boolean colisionIzquierda() {
		return bordes.x >= 0;
	}
}

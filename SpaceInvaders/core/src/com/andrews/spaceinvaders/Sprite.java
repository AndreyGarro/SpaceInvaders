package com.andrews.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Clase abstracta, para la creaci�n de cualquier sprite en pantalla
 * @author andrey
 *
 */
public abstract class Sprite {

	//Atributos
	protected Texture texture;
	protected Rectangle bordes;
	//
	
	/**
	 * Inicializa los componentes para la creaci�n del nuevo sprite
	 * @param x coordenadas en el eje x
	 * @param y coordenadas en el eje y
	 * @param sprite nombre del archivo el cual se desea mostrar como sprite
	 */
	public Sprite(float x, float y, String sprite) {
		this.texture = new Texture(Gdx.files.internal(sprite)); 
		this.bordes = new Rectangle(x, y, this.texture.getWidth(), this.texture.getHeight());
	}
	//Fin del Constructor
	
	/**
	 * Se encarga de dibujar el sprite 
	 * @param batch SpriteBatch para poder dibujar
	 */
	public void draw(SpriteBatch batch) {
		batch.draw(this.texture, bordes.x, bordes.y, this.texture.getWidth(), this.texture.getHeight());
	}
	
	/**
	 * Devuelve los bordes del rectangulo
	 * @return las coordenadas de los bordes
	 */
	public Rectangle getBordes() {
		return bordes;
	}
	
	/**
	 * Verifica si est� colisionando con el lateral derecho
	 * @return true o false
	 */
	protected boolean colisionDerecha() {
		return bordes.x >= Gdx.graphics.getWidth();
	}
	
	/**
	 * Verifica si est� colisionando con el borde izquuierdo.
	 * @return true o false
	 */
	protected boolean colisionIzquierda() {
		return bordes.x <= 0;
	}
	
}

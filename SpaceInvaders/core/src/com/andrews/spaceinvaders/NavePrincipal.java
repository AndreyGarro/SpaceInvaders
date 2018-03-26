package com.andrews.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;


public class NavePrincipal extends Sprite {

	public float speed = 200;
	
	public NavePrincipal(float x, float y, String sprite) {
		super(x, y, sprite);
	}
	
	public void move() {
		float delta = Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			if (colisionIzquierda()){
			bordes.x -= speed*delta; 
			}
		}
		else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if(colisionDerecha()) {
			bordes.x += speed*delta;
			}
		}
	}
	
	public boolean colisionDerecha() {
		return bordes.x + texture.getWidth() <= Gdx.graphics.getWidth();
	}
	
	public boolean colisionIzquierda() {
		return bordes.x >= 0;
	}
}

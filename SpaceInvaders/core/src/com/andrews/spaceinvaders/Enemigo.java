package com.andrews.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemigo extends Sprite {
	
	private float x, y;
	private Animation animation;
	private float tiempo;
	private TextureRegion[] regionMovimiento;
	private TextureRegion frameActual;
	

	public Enemigo(float x, float y, String sprite) {
		super(x, y, sprite);
		TextureRegion[][] temp = TextureRegion.split(super.texture, super.texture.getWidth()/2, super.texture.getHeight());
		regionMovimiento = new TextureRegion[2];
		for(int i = 0; i < 2; i ++) {
			regionMovimiento[i] = temp[0][i];
		}
		animation = new Animation(0.5f, regionMovimiento);
		tiempo = 0f;
	}
	
	@Override
	public void draw(final SpriteBatch batch) {
		tiempo += Gdx.graphics.getDeltaTime();
		frameActual = (TextureRegion) animation.getKeyFrame(tiempo, true);
		batch.draw(frameActual, super.bordes.x, super.bordes.y);
	}
	
	public void move() {
		if (this.colisionIzquierda() == false) {
			bordes.x += 100;
			}
		if(this.colisionDerecha() == false) {
			bordes.x -= 5;
		}
	}
}

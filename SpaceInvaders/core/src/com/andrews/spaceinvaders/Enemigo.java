package com.andrews.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemigo {
	
	private float x, y;
	private Animation animation;
	private float tiempo;
	private TextureRegion[] regionMovimiento;
	private Texture texture;
	private TextureRegion frameActual;
	

	public Enemigo(float x, float y, String sprite) {
		this.x = x;
		this.y = y;
		texture = new Texture(Gdx.files.internal(sprite));
		TextureRegion[][] temp = TextureRegion.split(texture, texture.getWidth()/2, texture.getHeight());
		
		regionMovimiento = new TextureRegion[2];
		for(int i = 0; i < 2; i ++) {
			regionMovimiento[i] = temp[0][i];
		}
		animation = new Animation(0.5f, regionMovimiento);
		tiempo = 0f;
	}
	
	public void draw(final SpriteBatch batch) {
		tiempo += Gdx.graphics.getDeltaTime();
		frameActual = (TextureRegion) animation.getKeyFrame(tiempo, true);
		batch.draw(frameActual, x, y);
		
	}




}

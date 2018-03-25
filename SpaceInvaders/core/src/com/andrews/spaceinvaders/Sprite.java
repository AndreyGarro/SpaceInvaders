package com.andrews.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Sprite {

	protected Texture texture;
	protected Rectangle bordes;
	
	public Sprite(float x, float y, String sprite) {
		this.texture = new Texture(Gdx.files.internal(sprite)); 
		this.bordes = new Rectangle(x, y, this.texture.getWidth(), this.texture.getHeight());
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(this.texture, bordes.x, bordes.y, this.texture.getWidth(), this.texture.getHeight());
	}
	
	public Rectangle getBordes() {
		return bordes;
	}
	
	public abstract void update();
}

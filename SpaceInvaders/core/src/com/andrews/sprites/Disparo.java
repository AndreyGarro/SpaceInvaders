package com.andrews.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;

public class Disparo extends Sprite{
	
	private boolean disparado = false;
	private Sound shootSound;

	public Disparo(float x, float y, String sprite) {
		super(x, y, sprite);
	}
	
	public void move() {
		this.bordes.y += 7;
	}
	
	public void cargarSonido() {
		shootSound = Gdx.audio.newSound(Gdx.files.internal("shipShoot.mp3"));
		shootSound.setVolume(0,1f);
		shootSound.play();
	}
	
	public void disparar(Disparo shot, NavePrincipal nave) {
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			if(!this.disparado){
				cargarSonido();
				this.disparado = true;
				shot.bordes.x = nave.bordes.x + 27;
				shot.bordes.y = nave.bordes.y + 57;
			}	
		}
	}

	public void disparado() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			if (this.bordes.y >= 550) {
				this.disparado = false;	
			}
		}
	}
	
	public Rectangle getBordes() {
		return this.bordes;
	}
}

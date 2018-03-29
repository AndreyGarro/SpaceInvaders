package com.andrews.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Disparo extends Sprite{
	
	private boolean disparado = false;

	public Disparo(float x, float y, String sprite) {
		super(x, y, sprite);
	}
	
	public void move() {
		this.bordes.y += 35;
	}
	
	public void disparar(Disparo shot, Rectangle r, NavePrincipal nave) {
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			if(!this.disparado){
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
	
	/*
	private static final float speed = 1;
	private SpriteBatch batch;
	private Texture texture;
	private Rectangle bordes;
		
	public Disparo(SpriteBatch batch, float x, float y) {
		this.batch = batch;
		this.texture = new Texture(Gdx.files.internal("laser.png"));
		this.bordes = new Rectangle(x, y, this.texture.getWidth(), this.texture.getHeight());
	}
	
	public void move() {
		System.out.println("holi");
		bordes.y += speed; 		
	}

	public void draw(SpriteBatch batch) {
		batch.draw(this.texture, bordes.x, bordes.y, this.texture.getWidth(), this.texture.getHeight());
	}
	
	public Rectangle getBordes() {
		return this.bordes;
	}

	public void dispare(ListaSimple<Enemigo> listaEnemigos) {
		int cont = listaEnemigos.getTamaño()-1;
		while(cont >= 0 && revisaColision(cont, listaEnemigos)) {
			System.out.println(cont);
			//this.move(); ;	
			//this.draw(batch);
			cont --;
		}
	}
	
	public boolean revisaColision(int cont, ListaSimple<Enemigo> listaEnemigos) {
		if(!this.getBordes().overlaps(listaEnemigos.getDato(cont).getBordes())) {
			System.out.println("false");
			return false;
		}
		return true;
	}*/
	
}

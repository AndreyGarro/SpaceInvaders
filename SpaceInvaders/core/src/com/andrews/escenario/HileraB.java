package com.andrews.escenario;

import com.andrews.estructuras.*;
import com.andrews.spaceinvaders.GameMain;
import com.andrews.sprites.Disparo;
import com.andrews.sprites.Enemigo;
import com.andrews.sprites.NavePrincipal;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HileraB extends AbstractScreen {

	// Atributos de la clase
	private SpriteBatch batch;
	private Texture background;
	private NavePrincipal nave;
	private ListaDoble<Enemigo> listaEnemigos;
	private int revisaColision = 1;
	private Disparo shot;
	public int tempo = 0;
	private Sound enemyDeadSound;

	public HileraB(GameMain main) {
		super(main);
		this.tipo = "HileraB";
		this.listaEnemigos = (ListaDoble<Enemigo>) ListaEnemigoFactory.getLista("claseB");
	}

	/**
	 * Se encarga de inicializar el fondo y la nave principal. Tambien crea el
	 * SpriteBatch que se encarga de agrupar los sprites y/o dibujos que se quieran
	 * mostrar.
	 */
	@Override
	public void show() {
		batch = new SpriteBatch(); // agrupacion de sprites u objetos que se vayan a dibujar
		background = new Texture(Gdx.files.internal("background.jpg"));
		nave = new NavePrincipal((Gdx.graphics.getWidth() / 2) - 25, 10, "ship.png");
		shot = new Disparo(500, 900, "laser.png");
		enemyDeadSound = Gdx.audio.newSound(Gdx.files.internal("enemyKilled.mp3"));
	}

	/**
	 * Limpia el buffer de dibujo e inicializa los movimientos de la nave principal,
	 * tambien inicia el batch donde se dibujar�n los distintos elementos y
	 * realizar�n sus acciones correspondientes, al final termina el batch
	 * 
	 * @param delta
	 *            recibe la cantidad de fotogramas por segundo
	 */
	@Override
	public synchronized void render(float delta) {
		// Limpia el buffer de dibujo
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//
		tempo ++;
		nave.move();
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		nave.draw(batch);
		shot.draw(batch);
		shot.disparar(shot, nave);
		shot.move();
		shot.disparado();
		if (!listaEnemigos.isEmpty()) {
			for (int i = 0; i < listaEnemigos.getTama�o(); i++) {
				listaEnemigos.getDato(i).draw(batch);
				try {
					revisaImpacto(i);
					if(tempo == 150) {
						cambioAleatorio();
						tempo = 0;
					}
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			movimientoEnemigos();
		}
		batch.end();
	}

	/**
	 * Realiza el movimiento de los lados y hacia abajo de los enemigos.
	 */
	private void movimientoEnemigos() {
		for (int i = 0; i < listaEnemigos.getTama�o(); i++) {
			if(!listaEnemigos.getDato(0).colisionIzquierda() && revisaColision == 1) {
				listaEnemigos.getDato(i).getBordes().x -= 0.7f;
			}
			else if(listaEnemigos.getDato(0).colisionIzquierda() && revisaColision == 1) {
				for (int x = listaEnemigos.getTama�o()-1; x >= 0;x --) {
					listaEnemigos.getDato(x).getBordes().y -= 40;	
				}
				revisaColision=2;
			}
			if (!listaEnemigos.getDato(listaEnemigos.getTama�o()-1).colisionDerecha() && revisaColision == 2) {
				listaEnemigos.getDato(i).getBordes().x += 0.7f;
			}
			else if(listaEnemigos.getDato(listaEnemigos.getTama�o()-1).colisionDerecha() && revisaColision == 2) {
				for(int x = 0; x < listaEnemigos.getTama�o(); x ++) {
					listaEnemigos.getDato(x).getBordes().y -= 40;
				}
				revisaColision = 1;
			}
			
		}		
	}
	
	private void revisaImpacto(int i){
		if (shot.getBordes().overlaps(listaEnemigos.getDato(i).getBordes())) {
			shot.getTexture().dispose();
			shot = new Disparo(500, 900, "laser.png");
			if (listaEnemigos.getDato(i).isShooted()) {
				if (listaEnemigos.getDato(i).getTipoEnemigo().equals("boss")
						&& listaEnemigos.getDato(i).getResistencia() == 1) {
					// listaEnemigos.eliminarTodo();
					System.out.println("Felicidades");
					return;
				}
				if (listaEnemigos.getDato(i).getResistencia() == 1) {
					enemyDeadSound.play();
					listaEnemigos.eliminarPos(i, listaEnemigos);
				}
			}
		}
	}

	public void cambioAleatorio() {
		int posJefe = 0;
		for(int i=0; i < listaEnemigos.getTama�o(); i++) {
			if(listaEnemigos.getDato(i).getTipoEnemigo().equals("boss")) {
				posJefe = i;
				break;
			}
		}
		int random = (int) (Math.random() * listaEnemigos.getTama�o() - 1);		
		NodoDoble<Enemigo> nuevoEnemigo = new NodoDoble<Enemigo>();
		nuevoEnemigo.setDato(listaEnemigos.getDato(random));
		NodoDoble<Enemigo> nuevoJefe = new NodoDoble<Enemigo>();
		Enemigo enemy = new Enemigo(listaEnemigos.getDato(posJefe).getBordes().x, listaEnemigos.getDato(posJefe).getBordes().y, 1, "enemySprite.png", "enemy");
		Enemigo boss = new Enemigo(listaEnemigos.getDato(random).getBordes().x, listaEnemigos.getDato(random).getBordes().y, 
				listaEnemigos.getDato(posJefe).getResistencia(), "boss1.png", "boss");
		
		nuevoJefe.setDato(boss);
		nuevoEnemigo.setDato(enemy);
		listaEnemigos.reemplazar(random, nuevoJefe);
		listaEnemigos.reemplazar(posJefe, nuevoEnemigo);

		System.out.println("random: " + random);
		System.out.println("jefe: " + posJefe);
	}	
}

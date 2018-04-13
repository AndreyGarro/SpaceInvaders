package com.andrews.escenario;


import com.andrews.estructuras.ListaEnemigoFactory;
import com.andrews.estructuras.ListaSimple;
import com.andrews.estructuras.NodoSimple;
import com.andrews.spaceinvaders.GameMain;
import com.andrews.sprites.Disparo;
import com.andrews.sprites.Enemigo;
import com.andrews.sprites.NavePrincipal;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Crea el escenario de batalla con sus debidos sprites dentro.
 * @author andrey
 *
 */
public class HileraBasica extends AbstractScreen {
	
	//Atributos de la clase
	private Screen siguienteNivel;
	private GameMain GameMain; 
	private SpriteBatch batch;
	private Texture background;
	private NavePrincipal nave;
	private ListaSimple<Enemigo> listaEnemigos;
	private int revisaColision = 1;
	private Disparo shot;
	private Sound enemyDeadSound;
	/**
	 * Inicializa el escenario
	 * @param main objeto de tipo GameMain para inicializar el constructor de la super clase.
	 * @param listaEnemigos lista de los enemigos a mostrar en pantalla.e
	 */
	public HileraBasica(GameMain main) {
		super(main);
		this.tipo = "HileraBasica";
		this.listaEnemigos = (ListaSimple<Enemigo>) ListaEnemigoFactory.getLista("basica");
		}
	//Fin  del constructor
	
	
	/**
	 * Se encarga de inicializar el fondo y la nave principal.
	 * Tambien crea el SpriteBatch que se encarga de agrupar los sprites y/o
	 * dibujos que se quieran mostrar.
	 */
	@Override
	public void show() {
		batch = new SpriteBatch(); //agrupacion de sprites u objetos que se vayan a dibujar
		background = new Texture(Gdx.files.internal("background.jpg"));
		nave = new NavePrincipal((Gdx.graphics.getWidth()/2)-25, 10, "ship.png");
		shot = new Disparo(500, 900, "laser.png");
		enemyDeadSound = Gdx.audio.newSound(Gdx.files.internal("enemyKilled.mp3"));
	}
	
	/**
	 * Limpia el buffer de dibujo e inicializa los movimientos de la nave principal,
	 * tambien inicia el batch donde se dibujar�n los distintos elementos y realizar�n
	 * sus acciones correspondientes, al final termina el batch
	 * @param delta recibe la cantidad de fotogramas por segundo
	 */
	@Override
	public void render(float delta) {
		//Limpia el buffer de dibujo
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//
		nave.move();
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		nave.draw(batch);
		shot.draw(batch);
		shot.disparar(shot, nave);
		shot.move();
		shot.disparado();
		for(int i = 0; i < listaEnemigos.getTama�o(); i++) {
			listaEnemigos.getDato(i).draw(batch);
			revisaImpacto(i);
			try {
				revisaVacia(listaEnemigos);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		movimientoEnemigos();
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
	
	private void revisaVacia(ListaSimple<Enemigo> lista) {
		if (lista.isEmpty()) {
			this.dispose();
			
		}
	}
	
	private void revisaImpacto(int i) {
		if(shot.getBordes().overlaps(listaEnemigos.getDato(i).getBordes())) {
			shot.getTexture().dispose();
			shot = new Disparo(500, 900, "laser.png");
			if(listaEnemigos.getDato(i).isShooted()) {
				if (!listaEnemigos.isEmpty() && listaEnemigos.getDato(i).getResistencia() == 1) {
					enemyDeadSound.play();
					listaEnemigos.eliminarPos(i, listaEnemigos);
				}
			}
		}
	}
}


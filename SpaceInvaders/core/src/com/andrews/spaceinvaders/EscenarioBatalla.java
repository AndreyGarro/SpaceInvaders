package com.andrews.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Crea el escenario de batalla con sus debidos sprites dentro.
 * @author andrey
 *
 */
public class EscenarioBatalla extends AbstractScreen {
	
	//Atributos de la clase
	private SpriteBatch batch;
	private Texture background;
	private NavePrincipal nave;
	private ListaSimple<Enemigo> listaEnemigos;
	private int x = 1;
	private Disparo shot;

	/**
	 * Inicializa el escenario
	 * @param main objeto de tipo GameMain para inicializar el constructor de la super clase.
	 * @param listaEnemigos lista de los enemigos a mostrar en pantalla.
	 */
	public EscenarioBatalla(GameMain main, ListaSimple<Enemigo> listaEnemigos) {
		super(main);
		this.listaEnemigos = listaEnemigos;
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
	}
	
	/**
	 * Limpia el buffer de dibujo e inicializa los movimientos de la nave principal,
	 * tambien inicia el batch donde se dibujar�n los distintos elementos, al final
	 * termina el batch
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
		shot.disparar(shot, listaEnemigos.getDato(0).bordes, nave);
		shot.move();
		shot.disparado();
		for(int i = 0; i < listaEnemigos.getTama�o(); i++) {
			listaEnemigos.getDato(i).draw(batch);
			if(shot.bordes.overlaps(listaEnemigos.getDato(i).bordes)) {
				if(listaEnemigos.getDato(i).isShooted()) {
					shot.texture.dispose();
					shot = new Disparo(500, 900, "laser.png");
					listaEnemigos.eliminarPos(i);
				}
			
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
			if(!listaEnemigos.getDato(0).colisionIzquierda() && x == 1) {
				listaEnemigos.getDato(i).bordes.x -= 1/05f;
			}
			else if(listaEnemigos.getDato(0).colisionIzquierda() && x == 1) {
				for (int x = listaEnemigos.getTama�o()-1; x >= 0;x --) {
					listaEnemigos.getDato(x).bordes.y -= 20;	
				}
				x=2;
			}
			if (!listaEnemigos.getDato(listaEnemigos.getTama�o()-1).colisionDerecha() && x == 2) {
				listaEnemigos.getDato(i).bordes.x += 1/05f;
			}
			else if(listaEnemigos.getDato(listaEnemigos.getTama�o()-1).colisionDerecha() && x == 2) {
				for(int x = 0; x < listaEnemigos.getTama�o(); x ++) {
					listaEnemigos.getDato(x).bordes.y -= 20;
				}
				x = 1;
			}
		}		
	}


}



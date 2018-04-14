package com.andrews.estructuras;

import com.andrews.sprites.Enemigo;

public class ListaEnemigoFactory extends ListaSimple<Enemigo> {


	private ListaEnemigoFactory() {
	};

	public static Lista getLista(String hilera){
		if (hilera.equals("basica")) {
			int cont = 0;
			int xPos = 20;
			int yPos = 500;
			ListaSimple<Enemigo> listaEnemigosBasica = new ListaSimple<Enemigo>();
			while(cont < 10) {
				listaEnemigosBasica.agregarAlFinal(new Enemigo(xPos, yPos, 1, "enemySprite.png", "enemy"));
				xPos += 75;
				cont ++;
			}
			return listaEnemigosBasica;
		
		}else if(hilera.equals("claseA")) {
			ListaSimple<Enemigo> listaEnemigosClaseA = new ListaSimple<Enemigo>();
			int cont = 0;
			int xPos = 40;
			int yPos = 500;
			int random = (int) (Math.random()*10);
			while(cont < 10) {
				if(cont == random) {
					listaEnemigosClaseA.agregarAlFinal(new Enemigo(xPos, yPos, (int) (Math.random()*4 + 1), "boss2.png", "boss"));
					cont ++;
					xPos += 75;
				}
				else {
					listaEnemigosClaseA.agregarAlFinal(new Enemigo(xPos, yPos, 1, "enemySprite.png", "enemy"));
					cont ++;
					xPos += 75;
				}
			}
			return listaEnemigosClaseA;		
		}else if(hilera.equals("claseB")) {
			ListaDoble<Enemigo> listaEnemigosClaseB = new ListaDoble<Enemigo>();
			int cont = 0;
			int xPos = 40;
			int yPos = 500;
			int random = (int) (Math.random()*10);
			while(cont < 10) {
				if(cont == random) {
					int x = (int) (Math.random()*4 + 1);
					System.out.println(x	);
					listaEnemigosClaseB.agregarAlFinal(new Enemigo(xPos, yPos, x, "boss2.png", "boss"));
					cont ++;
					xPos += 75;
				}
				else {
					listaEnemigosClaseB.agregarAlFinal(new Enemigo(xPos, yPos, 1, "enemySprite.png", "enemy"));
					cont ++;
					xPos += 75;
				}
			}
			return listaEnemigosClaseB;
		}else if(hilera.equals("claseC")) {
			ListaCircular<Enemigo> listaEnemigosClaseC = new ListaCircular<Enemigo>();
			int cont = 0;
			int xPos = 40;
			int yPos = 500;
			int random = (int) (Math.random()*10);
			while(cont < 75) {
				if(cont == random) {
					listaEnemigosClaseC.agregarAlFinal(new Enemigo(xPos, yPos, (int) (Math.random()*4 + 2), "boss2.png", "boss"));
					cont ++;
					xPos += 75;
				}
				else {
					listaEnemigosClaseC.agregarAlFinal(new Enemigo(xPos, yPos, 1, "enemySprite.png", "enemy"));
					cont ++;
					xPos += 50;
				}
			}
			return listaEnemigosClaseC;
		}
		return null;
	}
}
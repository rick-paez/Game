package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Clase que maneja los objetos del juego
 * los actualiza y los renderea
 * @author Ricardo Paez
 *
 */
public class Handler {
	//Lista que contiene todos los elementos que estaran en nuestro juego
	LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	/**
	 * Ejecuta los metodos tick de los objetos
	 */
	public void tick() {
		//Iteramos por todos los objetos del juego
		//para ejecutar su tick
		for(int i =0;i<objectList.size();i++) {
			GameObject gameObject = objectList.get(i);
			gameObject.tick();
		}
	}
	/**
	 * Renderiza los Objetos
	 * @param g
	 */
	
	public void render(Graphics g) {
		//Iteramos por todos los objetos del juego
		//para ejecutar su render
		for(int i =0;i<objectList.size();i++) {
			GameObject gameObject = objectList.get(i);
			gameObject.render(g);
		}
	}
	/**
	 * Agrega el objeto parametro
	 * @param object
	 */
	public void addObject(GameObject object) {
		this.objectList.add(object);
	}
	/**
	 * Borra el objeto parametro
	 * @param object
	 */
	public void removeObject(GameObject object) {
		this.objectList.remove(object);
	}
	public void clearEnemies() {
		LinkedList<GameObject> enemies = new LinkedList<GameObject>();
		for(int i =0;i<objectList.size();i++) {
			GameObject gameObject = objectList.get(i);
			if(gameObject.id != ID.Player) {
				enemies.add(gameObject);
			}	
		}
		objectList.removeAll(enemies);
	}
	public void clearAll() {
		
		objectList.clear();
	}
}

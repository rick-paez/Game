package com.tutorial.main;

import java.awt.Graphics;

/**
 * Clase que define todos los objetos de juego
 * @author Ricardo Paez
 *
 */
public abstract class GameObject {
	//Coordenadas en la pantalla
	protected int x;
	protected int y;
	//Id del objeto de juego
	protected ID id;
	//Variables de velocidad
	protected int velX;
	protected int velY;
	/**
	 * Constructor de nuestra clase de objeto
	 * @param x
	 * @param y
	 * @param id
	 */
	public GameObject(int x, int y, ID id) {
		super();
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	/**
	 * Metodo que controla que hace el objeto en un tick
	 */
	public abstract void tick();
	/**
	 * Metodo que controla como se dibuja el onjetop en pantalla
	 * Recibe un parametro Graphics
	 * @param g
	 */
	public abstract void render(Graphics g);

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
		
	
	
}

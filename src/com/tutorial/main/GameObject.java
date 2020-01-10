package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Clase que define todos los objetos de juego
 * @author Ricardo Paez
 *
 */
public abstract class GameObject {
	//Coordenadas en la pantalla
	protected float x;
	protected float y;
	//Id del objeto de juego
	protected ID id;
	//Variables de velocidad
	protected float velX;
	protected float velY;
	//Variables de tamanio
	protected int  width;
	protected int  height;
	
	//Handler
	protected Handler handler;
	
	
	/**
	 * Constructor de nuestra clase de objeto
	 * @param x
	 * @param y
	 * @param id
	 * @param handler
	 */
	
	
	public GameObject(float x, float y, ID id, Handler handler) {
		super();
		this.x = x;
		this.y = y;
		this.id = id;
		
		this.handler = handler;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
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

	public abstract Rectangle getBounds();
	
	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
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

	public float getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
		
	
	
}

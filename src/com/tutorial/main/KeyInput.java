package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Clase que controla la entrada de teclado
 * @author Ricardo Paez
 *
 */
public class KeyInput extends KeyAdapter {
	private Handler handler;
	/**
	 * Constructor de la clase
	 * @param handler
	 */
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	/**
	 * Eventos de teclado al presionar
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(GameObject gameObject: handler.objectList) {
			if(gameObject.getId() == ID.Player) {
				//eventos de teclado para jugador 1
				if(key == KeyEvent.VK_W) {
					gameObject.setVelY(-5);
				}
				if(key == KeyEvent.VK_S) {
					gameObject.setVelY(5);
				}
				if(key == KeyEvent.VK_D) {
					gameObject.setVelX(5);
				}
				if(key == KeyEvent.VK_A) {
					gameObject.setVelX(-5);
				}
				
			}
			
		}
		if(key == KeyEvent.VK_ESCAPE)
			System.exit(1);
	}
	/**
	 * Eventos de soltar teclas
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(GameObject gameObject: handler.objectList) {
			if(gameObject.getId() == ID.Player) {
				//eventos de teclado para jugador 1
				if(key == KeyEvent.VK_W) {
					gameObject.setVelY(0);
				}
				if(key == KeyEvent.VK_S) {
					gameObject.setVelY(0);
				}
				if(key == KeyEvent.VK_D) {
					gameObject.setVelX(0);
				}
				if(key == KeyEvent.VK_A) {
					gameObject.setVelX(0);
				}
				
			}
			
		}
	}
	
}

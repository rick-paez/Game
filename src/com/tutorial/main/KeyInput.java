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
	 * Para arreglar el problema de las teclas 
	 */
	private boolean[] keyDown = new boolean[4];
	
	
	/**
	 * Constructor de la clase
	 * @param handler
	 */
	public KeyInput(Handler handler) {
		this.handler = handler;
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	/**
	 * Eventos de teclado al presionar
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i =0;i<handler.objectList.size();i++) {
			GameObject gameObject = handler.objectList.get(i);
			if(gameObject.getId() == ID.Player) {
				//eventos de teclado para jugador 1
				if(key == KeyEvent.VK_W) {
					gameObject.setVelY(-5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_S) {
					gameObject.setVelY(5);
					keyDown[1] = true;
				}
				if(key == KeyEvent.VK_D) {
					gameObject.setVelX(5);
					keyDown[2] = true;
				}
				if(key == KeyEvent.VK_A) {
					gameObject.setVelX(-5);
					keyDown[3] = true;
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
					keyDown[0] = false;
				}
				if(key == KeyEvent.VK_S) {
					keyDown[1] = false;
				}
				if(key == KeyEvent.VK_D) {
					keyDown[2] = false;
				}
				if(key == KeyEvent.VK_A) {
					keyDown[3] = false;
				}
				//Movimiento vertical
				if(!keyDown[0] && !keyDown[1]) {
					gameObject.setVelY(0);
				}
				//Movimiento horizontal
				if(!keyDown[2] && !keyDown[3]) {
					gameObject.setVelX(0);
				}
			}
			
		}
	}
	
}

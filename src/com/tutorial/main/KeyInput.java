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
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
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
			if(gameObject.getId() == ID.Player2) {
				//eventos de teclado para jugador 1
				if(key == KeyEvent.VK_UP) {
					gameObject.setVelY(-5);
				}
				if(key == KeyEvent.VK_DOWN) {
					gameObject.setVelY(5);
				}
				if(key == KeyEvent.VK_RIGHT) {
					gameObject.setVelX(5);
				}
				if(key == KeyEvent.VK_LEFT) {
					gameObject.setVelX(-5);
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
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
			if(gameObject.getId() == ID.Player2) {
				//eventos de teclado para jugador 1
				if(key == KeyEvent.VK_UP) {
					gameObject.setVelY(0);
				}
				if(key == KeyEvent.VK_DOWN) {
					gameObject.setVelY(0);
				}
				if(key == KeyEvent.VK_RIGHT) {
					gameObject.setVelX(0);
				}
				if(key == KeyEvent.VK_LEFT) {
					gameObject.setVelX(0);
				}
			}
		}
	}
	
}

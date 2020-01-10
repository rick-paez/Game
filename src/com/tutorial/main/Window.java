package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
/**
 * Clase que se encarga de dibujar la ventana de juego
 * @author Ricardo Paez
 */
public class Window extends Canvas{

	
	private static final long serialVersionUID = -240840600533728354L;
	/**
	 * Constructor de la ventana
	 * @param width		ancho
	 * @param height	alto
	 * @param title		titulo
	 * @param game 		juego4
	 * 
	 */
	public Window (int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		/**
		 * Estableciendo los tamaños de la ventana
		 */
		frame.setPreferredSize(new Dimension (width, height));
		frame.setMaximumSize(new Dimension (width, height));
		frame.setMinimumSize(new Dimension (width, height));
		
		/**
		 * Estableciendo el comportamiento por default
		 * 		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		//Agregando la clase Game en el frame
		frame.add(game);
		frame.setVisible(true);
		System.out.println("a punto de entrar al juego");
		game.start();
	}

}

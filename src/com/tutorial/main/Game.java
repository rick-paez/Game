package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


/**
 * Clase Principal de juego
 * @author Ricardo Paez
 *
 */
public class Game extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7580815534084638412L;
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 640/12 * 9;
	private static final String TITLE = "Construyamos un juego";
	private Thread thread;
	private boolean running = false;
	
	private Random rnd;
	private Handler handler;
	/**
	 * Constructor de la clase
	 */
	public Game() {
		new Window(WIDTH, HEIGHT, TITLE, this);
		handler = new Handler();
		rnd = new Random();
		for(int i =0; i<50; i++) {
//			handler.addObject(new Player(rnd.nextInt(WIDTH),rnd.nextInt(HEIGHT),ID.Player));
			handler.addObject(new Player(0,0,ID.Player));
		}
		
	}
	
	/**
	 * Comienza el thread del juego
	 */
	public synchronized void start() {
		System.out.println("Juego Comenzado");
		thread = new Thread(this);
		
		thread.start();
		running = true;
		System.out.println(running);
		
	}
	/**
	 * Detiene el thread del juego
	 */
	public synchronized void stop() {
		System.out.println("Juego terminado");
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		System.out.println("Entrando al metodo run");
		long lastTime = System.nanoTime();
		double amountofTicks = 60.0;
		double ns = 1000000000 /amountofTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: "+frames);
				frames = 0;
			}
		}
		stop();
	}
	/**
	 * Dibuja
	 */
	private void render() {
		// Creando la estrategia de buffer para renderizar
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	/*
	 * hace la logica del programa por tick
	 */
	private void tick() {
		handler.tick();
	}

	/**
	 * Metodo principal del programa
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("comenzando el juego");
		new Game();
	}

	

	
	
}
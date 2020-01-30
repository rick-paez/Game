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
	
	static final int WIDTH = 640;
	static final int HEIGHT = 640/12 * 9;
	private static final String TITLE = "Construyamos un juego";
	private Thread thread;
	private boolean running = false;
	private Random rnd;
	private HUD hud;
	private Handler handler;
	private Spawn spawn;
	private Menu menu;
	
	public enum STATE {
		Menu,
		Help,
		Game,
		End
	};
	public STATE gameState = STATE.Menu;
	/**
	 * Constructor de la clase
	 */
	public Game() {
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		new Window(WIDTH, HEIGHT, TITLE, this);
		
		
		rnd = new Random();
		
		spawn = new Spawn(handler, hud);
		if(gameState == STATE.Game) {
			HUD.HEALTH = 100;
			hud.setScore(0);
			hud.setLevel(1);
			handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player,handler));
			handler.addObject(new BasicEnemy(rnd.nextInt(WIDTH-50),rnd.nextInt(HEIGHT-50),ID.BasicEnemy, handler));
		}else {
			generarParticulasMenu();
		}
	}

	private void generarParticulasMenu() {
		for (int i = 0; i < 20 ; i++) {
			handler.addObject(new MenuParticle(rnd.nextInt(WIDTH),rnd.nextInt(HEIGHT),ID.MenuParticle, handler));
		}
	}
	
	/**
	 * Comienza el thread del juego
	 */
	public synchronized void start() {
//		System.out.println("Juego Comenzado");
		thread = new Thread(this);
		
		thread.start();
		running = true;
//		System.out.println(running);
		
	}
	/**
	 * Detiene el thread del juego
	 */
	public synchronized void stop() {
//		System.out.println("Juego terminado");
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
//		System.out.println("Entrando al metodo run");
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 /amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				if(running) {
					render();
					frames++;
				}
				delta--;
			}
			
			
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
//				System.out.println("Timer: "+timer);
				//System.out.println("FPS: "+frames);
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
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		if(gameState == STATE.Game) {
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End){
			menu.render(g);
		}
		g.dispose();
		bs.show();
	}
	/*
	 * hace la logica del programa por tick
	 */
	private void tick() {
		handler.tick();
		if(gameState == STATE.Game) {
			hud.tick();
			spawn.tick();
			if(HUD.HEALTH <= 0) {
				handler.clearAll();
				this.gameState = STATE.End;
				generarParticulasMenu();
			}
		}else if (gameState == STATE.Menu || gameState == STATE.End) {
			menu.tick();
		}
	}

	/**
	 * Metodo principal del programa
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("comenzando el juego");
		new Game();
	}
	/**
	 * MAntiene una variable dentrop de los limites
	 * @param var
	 * @param min
	 * @param max
	 * @return
	 */
	public static float clamp (float var, float min, float max) {
		if (var >= max)
			return max;
		else 
			if (var <= min)
				return min;
			else 
				return var;
	}

	
	
}

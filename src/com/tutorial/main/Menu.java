package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Menu extends MouseAdapter{
	
    private Game game;
    private Handler handler;
    private Random rnd = new Random();
    private HUD hud;
    
    public Menu(Game game, Handler handler, HUD hud) {
    	this.game = game;
    	this.handler = handler;
    	this.hud = hud;
    }
	
	private static final int OPTION_PLAY_HEIGHT = 64;
	private static final int OPTION_PLAY_WIDTH = 200;
	private static final int OPTION_PLAY_Y = 150;
	private static final int OPTION_PLAY_X = 210;
	
	private static final int OPTION_HELP_HEIGHT = 64;
	private static final int OPTION_HELP_WIDTH = 200;
	private static final int OPTION_HELP_Y = 250;
	private static final int OPTION_HELP_X = 210;
	
	private static final int OPTION_HELP_BACK_HEIGHT = 64;
	private static final int OPTION_HELP_BACK_WIDTH = 200;
	private static final int OPTION_HELP_BACK_Y = 350;
	private static final int OPTION_HELP_BACK_X = 210;
	
	private static final int OPTION_END_BACK_HEIGHT = 64;
	private static final int OPTION_END_BACK_WIDTH = 300;
	private static final int OPTION_END_BACK_Y = 350;
	private static final int OPTION_END_BACK_X = 170;
	
	private static final int OPTION_EXIT_HEIGHT = 64;
	private static final int OPTION_EXIT_WIDTH = 200;
	private static final int OPTION_EXIT_Y = 350;
	private static final int OPTION_EXIT_X = 210;

	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		if(game.gameState == Game.STATE.Menu) {
			//boton jugar
			if(mouseOver(mouseX, mouseY, OPTION_PLAY_X, OPTION_PLAY_Y, OPTION_PLAY_WIDTH, OPTION_PLAY_HEIGHT)){
				HUD.HEALTH = 100;
				hud.setScore(0);
				hud.setLevel(1);
				game.gameState = Game.STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(rnd.nextInt(Game.WIDTH-50),rnd.nextInt(Game.HEIGHT-50),ID.BasicEnemy, handler));
				
			}
			//boton ayuda
			if(mouseOver(mouseX, mouseY, OPTION_HELP_X, OPTION_HELP_Y, OPTION_HELP_WIDTH, OPTION_HELP_HEIGHT)){
				game.gameState = Game.STATE.Help;
				
			}
			//boton salir
			if(mouseOver(mouseX, mouseY, OPTION_EXIT_X, OPTION_EXIT_Y, OPTION_EXIT_WIDTH, OPTION_EXIT_HEIGHT)){
				System.exit(1);
			}
		}else if(game.gameState == Game.STATE.Help) {
			//boton regresar
			if(mouseOver(mouseX, mouseY, OPTION_HELP_BACK_X, OPTION_HELP_BACK_Y, OPTION_HELP_BACK_WIDTH, OPTION_HELP_BACK_HEIGHT)){
				game.gameState = Game.STATE.Menu;
				
			}
		}else if(game.gameState == Game.STATE.End) {
			//boton regresar
			if(mouseOver(mouseX, mouseY, OPTION_HELP_BACK_X, OPTION_HELP_BACK_Y, OPTION_HELP_BACK_WIDTH, OPTION_HELP_BACK_HEIGHT)){
				game.gameState = Game.STATE.Menu;
				
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mouseX, int mouseY, int x, int y , int width, int height) {
		if( mouseX > x && mouseX < x + width && 
			mouseY > y && mouseY < y +height) {
				return true;
		}
		return false;
	}
	
	public void tick() {
		
	}
	
	public void render (Graphics g) {
		if(game.gameState == Game.STATE.Menu) {

			Font font = new Font("arial",1,50);
			Font font2 = new Font("arial",1,30);

			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Menu", 240, 70);



			g.setColor(Color.white);
			g.drawRect(OPTION_PLAY_X, OPTION_PLAY_Y, OPTION_PLAY_WIDTH, OPTION_PLAY_HEIGHT);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Jugar", 270, 190);

			g.setColor(Color.white);
			g.drawRect(OPTION_HELP_X, OPTION_HELP_Y, OPTION_HELP_WIDTH, OPTION_HELP_HEIGHT);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Ayuda", 270, 290);

			g.setColor(Color.white);
			g.drawRect(OPTION_EXIT_X, OPTION_EXIT_Y, OPTION_EXIT_WIDTH, OPTION_EXIT_HEIGHT);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Salir", 270, 390);
		}else if(game.gameState == Game.STATE.Help) {


			Font font = new Font("arial",1,50);
			Font font2 = new Font("arial",1,30);


			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Ayuda", 240, 70);

			g.setColor(Color.white);
			g.drawRect(OPTION_HELP_BACK_X, OPTION_HELP_BACK_Y, OPTION_HELP_BACK_WIDTH, OPTION_HELP_BACK_HEIGHT);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Usa las teclas WASD para mover al jugador", 5, 190);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString(" y evitar enemigos.", 5, 230);



			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Regresar", 240, 390);
		}else if(game.gameState == Game.STATE.End) {


			Font font = new Font("arial",1,50);
			Font font2 = new Font("arial",1,30);


			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Juego Terminado", 120, 70);

			g.setColor(Color.white);
			g.drawRect(OPTION_END_BACK_X, OPTION_END_BACK_Y, OPTION_END_BACK_WIDTH, OPTION_END_BACK_HEIGHT);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Has perdido con puntuacion: "+ hud.getScore(), 50, 190);


			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Intentar de nuevo", 200, 390);
		}
	}

}

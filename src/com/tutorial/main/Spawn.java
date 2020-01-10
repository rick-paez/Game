package com.tutorial.main;

import java.util.Random;

/**
 * Clase que controla la generacion de enemigos
 * @author Ricardo Paez
 *
 */
public class Spawn {
	private Handler handler;
	private HUD hud;
	private Random rnd;
	
	private int scoreKeep = 0;
	
	public Spawn(Handler  handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		this.rnd = new Random();
		
	}
	public void tick() {
		scoreKeep++;
		if(scoreKeep >= 250) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);
			if(hud.getLevel()==2) {
				handler.addObject(new BasicEnemy(rnd.nextInt(Game.WIDTH-50),rnd.nextInt(Game.HEIGHT-50),ID.BasicEnemy, handler));
			}else if(hud.getLevel()==3) {
				handler.addObject(new BasicEnemy(rnd.nextInt(Game.WIDTH-50),rnd.nextInt(Game.HEIGHT-50),ID.BasicEnemy, handler));
				
			}else if(hud.getLevel()==4) {
				handler.addObject(new FastEnemy(rnd.nextInt(Game.WIDTH-50),rnd.nextInt(Game.HEIGHT-50),ID.FastEnemy, handler));
				
			}else if(hud.getLevel()==5) {
				handler.addObject(new SmartEnemy(rnd.nextInt(Game.WIDTH-50),rnd.nextInt(Game.HEIGHT-50),ID.SmartEnemy, handler));
				
			}else if(hud.getLevel()==6) {
				handler.addObject(new FastEnemy(rnd.nextInt(Game.WIDTH-50),rnd.nextInt(Game.HEIGHT-50),ID.SmartEnemy, handler));
				
			}else if(hud.getLevel()==7) {
				handler.addObject(new FastEnemy(rnd.nextInt(Game.WIDTH-50),rnd.nextInt(Game.HEIGHT-50),ID.SmartEnemy, handler));
			}else if(hud.getLevel()==10) {
				handler.clearEnemies();
				handler.addObject(new EnemyBoss((Game.WIDTH/2)-48,-120,ID.EnemyBoss, handler));
			}
			
		}
		
	}
}

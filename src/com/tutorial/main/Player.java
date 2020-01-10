package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Clase que controla al jugador
 * @author Ricardo Paez
 *
 */
public class Player extends GameObject {
	
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id,handler);
		width  = 32;
		height = 32;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH-37);
		y = Game.clamp(y, 0, Game.HEIGHT-60);
		collision();
		handler.addObject(new Trail(x,y,ID.Trail,Color.white,width,height, 0.09f,handler));
	}

	@Override
	public void render(Graphics g) {
		if(id == ID.Player)
			g.setColor(Color.white);
		g.fillRect((int)x, (int)y, width, height);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,width,height);
	}
	/**
	 * Controla las colisiones con los enemigos
	 */
	private void collision() {
		for(int i =0;i<handler.objectList.size();i++) {
			GameObject gameObject = handler.objectList.get(i);
			if(	gameObject.getId() == ID.BasicEnemy || 
				gameObject.getId() == ID.FastEnemy ||
				gameObject.getId() == ID.SmartEnemy ||
				gameObject.getId() == ID.EnemyBoss ||
				gameObject.getId() == ID.EnemyBossBullet){
				if(getBounds().intersects(gameObject.getBounds())) {
					//codigo de colision
					HUD.HEALTH -= 2;
				}
				
			}
		}
	}

}

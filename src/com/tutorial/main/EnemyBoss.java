package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
/**
 * Clase que controla el comportamiento de el primer enemigo
 * @author Ricardo Paez
 *
 */
public class EnemyBoss extends GameObject {
	Random rnd = new Random();
	private int timer = 100;
	private int timer2 = 50;
	public EnemyBoss(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		velX = 0;
		velY = 2;
		width = 96;
		height = 96;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		
		if(timer <= 0 ) {
			velY = 0;
			timer2--;
		}else {
			timer--;
		}
		if(timer2<=0) {
			if(velX == 0) {
				velX = 2;
			}else if(velX < 0) {
				velX -= 0.01f;
			}else if(velX > 0) {
				velX += 0.01f;
			} 
			velX = Game.clamp(velX, -10, 10);
			int spawn = rnd.nextInt(10);
			if(spawn ==0 ) {
				handler.addObject(new EnemyBossBullet(x+48, y+48, ID.EnemyBossBullet, handler));
			}
		}
		
//		if (y <=0 || y>= Game.HEIGHT -height ) {
//			velY *=-1;
//		}
		if (x <=0 || x>= Game.WIDTH - width ) {
			velX *=-1;
		}
		//handler.addObject(new Trail(x,y,ID.Trail,Color.red,width,height, 0.05f,handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y,width, height);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,width,height);
	}
	

}

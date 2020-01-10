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
public class EnemyBossBullet extends GameObject {

	Random rnd = new Random();
	public EnemyBossBullet(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		velX = (rnd.nextInt(5 - -5)+-5);
		velY = 5;
		width = 16;
		height = 16;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(y >= Game.HEIGHT) {
			handler.removeObject(this);
		}
		
		handler.addObject(new Trail(x,y,ID.Trail,new Color(rnd.nextInt(55)+200,0,rnd.nextInt(100)),width,height, 0.05f,handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(rnd.nextInt(55)+200,0,rnd.nextInt(100)));
		g.fillRect((int)x, (int)y,width, height);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,width,height);
	}
	

}

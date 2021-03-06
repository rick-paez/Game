package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Clase que controla el comportamiento de el primer enemigo
 * @author Ricardo Paez
 *
 */
public class FastEnemy extends GameObject {

	public FastEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		velX = 2;
		velY = 9;
		width = 16;
		height = 16;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if (y <=0 || y>= Game.HEIGHT -height ) {
			velY *=-1;
		}
		if (x <=0 || x>= Game.WIDTH -width ) {
			velX *=-1;
		}
		handler.addObject(new Trail(x,y,ID.Trail,Color.cyan,width,height, 0.05f,handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int)x, (int)y,width, height);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,width,height);
	}
	

}

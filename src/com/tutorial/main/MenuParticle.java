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
public class MenuParticle extends GameObject {

	Random rnd = new Random(); 
	Color  color;
	
	public MenuParticle(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		
		width = 16;
		height = 16;
		velX = (rnd.nextInt(7 - -7)+-7);
		velY = (rnd.nextInt(7 - -7)+-7);
		
		if(velX == 0)
			velX=1;
		if(velY == 0)
			velY=1;
		
		color = new Color(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
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
		handler.addObject(new Trail(x,y,ID.Trail,color,width,height, 0.05f,handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y,width, height);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,width,height);
	}
	

}

package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Clase que controla el comportamiento de el primer enemigo
 * @author Ricardo Paez
 *
 */
public class SmartEnemy extends GameObject {

	private GameObject player;
	public SmartEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		velX = 5;
		velY = 5;
		for(int i =0;i<handler.objectList.size();i++) {
			if(handler.objectList.get(i).getId() == ID.Player)
				player = handler.objectList.get(i);
		}
		width = 16;
		height = 16;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() -8;
		float diffY = y - player.getY() -8;
		float distance = (float) Math.sqrt( Math.pow(x - player.getX(), 2d) + Math.pow(y - player.getY(), 2d) );
		
		velX =  (float) ((-1.0/distance) * diffX);
		velY =  (float) ((-1.0/distance) * diffY);
		/*if (y <=0 || y>= Game.HEIGHT -width ) {
			velY *=-1;
		}
		if (x <=0 || x>= Game.WIDTH -height ) {
			velX *=-1;
		}*/
		handler.addObject(new Trail(x,y,ID.Trail,Color.green,width,height, 0.05f,handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y,width, height);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,width,height);
	}
	

}

package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 * clase que genera una cola en los objetos
 * @author Ricardo Paez
 *
 */
public class Trail extends GameObject{
	private float alpha = 1;
	private Color color;
	
	private float width;
	private float height;
	private float life;

	public Trail(float x, float y, ID id, Color color, float width, float height,float life, Handler handler) {
		super(x, y, id,handler);
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
		
	}

	@Override
	public void tick() {
		if(alpha > life) {
			alpha -= life -0.001f;
		}else
			handler.removeObject(this);
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; 
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		//Importante resetear la transparencia a 1
		g2d.setComposite(makeTransparent(1));
		
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
		
	}

	@Override
	public Rectangle getBounds() {
		
		return null;
	}

}

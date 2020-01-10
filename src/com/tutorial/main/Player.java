package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
/**
 * Clase que controla al jugador
 * @author Ricardo Paez
 *
 */
public class Player extends GameObject {
	
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH-37);
		y = Game.clamp(y, 0, Game.HEIGHT-60);
	}

	@Override
	public void render(Graphics g) {
		if(id == ID.Player)
			g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle (x,y,32,32);
	}

}

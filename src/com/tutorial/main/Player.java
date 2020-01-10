package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
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
	}

	@Override
	public void render(Graphics g) {
		if(id == ID.Player)
			g.setColor(Color.white);
		if(id == ID.Player2)
			g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);
		
	}

}

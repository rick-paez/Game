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
	
	private Random rnd;
	public Player(int x, int y, ID id) {
		super(x, y, id);
		rnd = new Random();
		velX = rnd.nextInt(5)+1;
		velY = rnd.nextInt(5);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
	}

}

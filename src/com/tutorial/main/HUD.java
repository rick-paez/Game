package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Clase que controla la HUD que muestra la vida, score etc
 * @author Ricardo Paez
 *
 */
public class HUD {
	//Controla la vida
	public static float HEALTH = 100;
	//el valor de verde
	private float greenValue = 255;
	
	private int score = 0;
	private int level =1;
	public void tick() {
		HEALTH =  Game.clamp(HEALTH, 0, 100);
		greenValue = HEALTH *2;
		greenValue = Game.clamp(greenValue, 0, 255);
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(150,(int)greenValue,0));
		g.fillRect(15, 15,(int) HEALTH *2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: "+score, 15,64);
		g.drawString("Level: "+level, 15,80);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}

package com.tutorial.main;

/**
 * enumerador que identifica las ID's de los 
 * objetos de juego
 * @author Ricardo Paez
 *
 */
public enum ID {
	/**
	 * ID para el jugador
	 */
	Player(),
	/**
	 * ID para las estelas
	 */
	Trail(),
	/**
	 * ID para los enemigos
	 */
	BasicEnemy(),
	/*
	 * ID para enemigos rapidos
	 */
	FastEnemy(),
	/**
	 * ID enemigos inteligentes
	 */
	SmartEnemy(), 
	/**
	 * ID para el jefe
	 */
	EnemyBoss(),
	/**
	 * ID para las balas
	 * del jefe
	 */
	EnemyBossBullet(), 
	MenuParticle();
}

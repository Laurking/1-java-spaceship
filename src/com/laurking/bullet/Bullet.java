package com.laurking.bullet;

import java.awt.Graphics;

import com.laurking.display.Assets;
import com.laurking.entity.Entity;
import com.laurking.game.Game;
import com.laurking.spaceship.SpaceShip;
public class Bullet implements Entity {
	private int x, y;
	private final int WIDTH=12,HEIGHT=20;
	private Game game;
	public Bullet(int x, int y,Game game) {
		this.game=game;
		this.x = x;
		this.y = y;
		Assets.init();
		
	}

	public void tick() {
		y-=7;
	}

	public void render(Graphics g) {
		g.drawImage(Assets.bullet,x,y,WIDTH, HEIGHT, null);

	}

	public int getX() {

		return x;
	}

	public int getY() {

		return y;
	}

	public void setY(int y) {
		this.y=y;
	}

	public void setX(int x) {
		this.x=x;
	}
	public int setWidth(){
		return WIDTH;
	}
	public int getHeight(){
		return HEIGHT;
	}

}

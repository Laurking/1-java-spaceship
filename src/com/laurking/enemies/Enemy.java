package com.laurking.enemies;

import java.awt.Graphics;
import java.util.Random;

import com.laurking.display.Assets;
import com.laurking.entity.Entity;
import com.laurking.game.Game;

public class Enemy implements Entity {
	private Game game;
	private final int WIDTH=40,HEIGHT=40;
	private Random rand=new Random();
	private int x, y;

	public Enemy(int x) {
		this.x=x;
		this.y=y;
		Assets.init();
		
	}

	public void tick() {
		y +=rand.nextInt(7);
		if(y>700){
			y=-5;
			x=rand.nextInt(1000);
		}

	}

	public void render(Graphics g) {
		g.drawImage(Assets.enemy, x, y, 40, 40, null);

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

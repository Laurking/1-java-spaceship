package com.laurking.spaceship;

import java.awt.Graphics;
import com.laurking.display.Assets;
import com.laurking.entity.Entity;
import com.laurking.game.Game;

public class SpaceShip implements Entity {
	
	private int x,y;
	private int velX=0,velY=0;
	private Game game;
	public SpaceShip(int x,int y,Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
		Assets.init();
		
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		if(y>game.getHeight()){
			y=50;
		}
		else if(y<0){
			y=game.getHeight()-50;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.spaceship_up,x,y,100,100,null);
	}

	@Override
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
}

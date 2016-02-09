package com.laurking.collision;

import java.util.ArrayList;
import java.util.Random;

import com.laurking.bullet.Bullet;
import com.laurking.enemies.Enemy;
import com.laurking.game.Game;
public class Collision  {
	
	private ArrayList<Enemy> enemy;
	private ArrayList<Bullet> bullet;
	private Enemy enemies;
	private Bullet bullets;
	private Game game;
	private Random rand=new Random();
	public Collision( ArrayList<Enemy> enemy,ArrayList<Bullet> bullet,Game game) {
		this.enemy=enemy;
		this.bullet=bullet;
		this.game=game;
	}
	
	public void tick(){
		for(int i=0;i<enemy.size();i++){
			enemies=enemy.get(i);
			for(int j=0;j<bullet.size();j++){
				bullets=bullet.get(j);
				if(((bullets.getX()>=enemies.getX() && bullets.getX()<=enemies.getX()+enemies.getHeight())&&(bullets.getY()>=enemies.getY()+enemies.getHeight()))){
					enemy.remove(i);
					game.getController().removeEntity(enemies);
					
				}
			}
		}
		
	}
	
	
	

}

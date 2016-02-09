package com.laurking.controller;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.laurking.enemies.Enemy;
import com.laurking.entity.Entity;
import com.laurking.game.Game;

public class Controller {
	private ArrayList<Entity> entity=new ArrayList<Entity>();
	private Random rand=new Random();
	Entity entities;
	private Game game;
	public Controller(Game game) {
		this.game=game;
	}
	public void tick(){
		for(int i=0;i<entity.size();i++){
			entities=entity.get(i);
			entities.tick();
		}
	}
	public void render(Graphics g){
		for(int i=0;i<entity.size();i++){
			entities=entity.get(i);
			entities.render(g);
		}
	}
	public void createEnemy(int count){
		for(int i=0;i<count;i++){
			addEntity(new Enemy(rand.nextInt(game.getWidth())));
		}
	}
	public void addEntity( Entity entities){
		entity.add(entities);
	}
	public void removeEntity( Entity entities){
		entity.remove(entities);
	}

}

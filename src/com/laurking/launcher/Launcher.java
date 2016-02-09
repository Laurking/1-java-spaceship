package com.laurking.launcher;

import com.laurking.game.Game;

public class Launcher {
	
	public static void main(String args[]){
		Game game=new Game("SpaceShip",1000,650);
		game.start();
	}

}

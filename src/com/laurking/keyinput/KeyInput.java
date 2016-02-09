package com.laurking.keyinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.laurking.game.Game;

public class KeyInput implements KeyListener {
	private Game game;
	public KeyInput(Game game) {
		this.game=game;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		game.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
		
	}

}

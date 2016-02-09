package com.laurking.mouseinput;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.laurking.game.Game;
import com.laurking.game.Game.STATE;

public class MouseInput implements MouseListener {
	private Game game;

	public MouseInput(Game game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int pagex = e.getX(), pagey = e.getY();
		System.out.println(pagex+" pagex and +pagey "+pagey);
		if ((pagex >= 400 && pagex <= 550)) {
			if ((pagey >= 150 && pagey < 230)) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException em) {
					em.printStackTrace();
				}
				game.setState(STATE.GAME);
			}
		}
		
		 if ((pagex >= 400 && pagex <= 550)) {
			if ((pagey >= 350 && pagey <=430)) {
				System.exit(1);
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

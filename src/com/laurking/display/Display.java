package com.laurking.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
	private JFrame window;
	private Canvas canvas;
	private int WIDTH,HEIGHT;
	private String TITLE;
	
	public Display(String title,int width, int height){
		TITLE=title;
		WIDTH=width;
		HEIGHT=height;
		createDisplay();
	}

	private void createDisplay() {
		window=new JFrame();
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		canvas.setFocusable(true);
		window.add(canvas);
		window.pack();
		window.setSize(WIDTH, HEIGHT);
		window.setTitle(TITLE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setAlwaysOnTop(true);
		window.setVisible(true);
		
		
	}
	public JFrame getWindow(){
		return window;
	}
	public Canvas getCanvas(){
		return canvas;
	}
	

}

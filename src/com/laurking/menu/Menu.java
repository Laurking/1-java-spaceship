package com.laurking.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.laurking.display.Assets;
import com.laurking.game.Game;

public class Menu {
	
		private Rectangle play= new Rectangle(400,150,150,80);
		private Rectangle help=new Rectangle(400,250,150,80);
		private Rectangle quit=new Rectangle(400,350,150,80);
		
		public void render(Graphics g){
			Graphics2D graph=(Graphics2D)g;
			g.drawImage(Assets.menu_background,0,0,1000,700, null);
			Font font=new Font("Arial",Font.BOLD,70);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("MY SPACE",300,100);
			
			Font font1=new Font("Arial",Font.BOLD,50);
			g.setFont(font1);
			g.setColor(Color.green);
			g.drawString("Play",play.x+20,play.y+50);
			graph.draw(play);
			g.drawString("Help",help.x+20,help.y+50);
			graph.draw(help);
			g.drawString("Quit",quit.x+20,quit.y+50);
			graph.draw(quit);
			
			
		}
		
		
		
}

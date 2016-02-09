package com.laurking.display;

import java.awt.image.BufferedImage;

import com.laurking.display.imageloader.ImageLoader;
import com.laurking.display.spritesheet.SpriteSheet;

public class Assets {
	
	public static BufferedImage menu_background,background,spriteImage,spaceship_up,spaceship_right,spaceship_left,spaceship_down,bullet,enemy;
	private static SpriteSheet sheet;
	public static void init(){
		menu_background=ImageLoader.Load("/menu.jpg");
		background=ImageLoader.Load("/background.png");
		spriteImage=ImageLoader.Load("/spritesheet.png");
		sheet=new SpriteSheet(spriteImage);
		spaceship_up=sheet.crop(0,0, 32, 32);
		spaceship_right=sheet.crop(32,0, 32, 32);
		spaceship_down=sheet.crop(64,0, 36, 32);
		spaceship_left=sheet.crop(0,32, 36, 36);
		bullet=sheet.crop(70,32, 36, 36);
		enemy=sheet.crop(32,32, 36, 36);
		
		
	}

}

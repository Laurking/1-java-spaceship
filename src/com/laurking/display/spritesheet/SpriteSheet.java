package com.laurking.display.spritesheet;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage image;
	
	public SpriteSheet(BufferedImage img){
		image=img;
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
		return image.getSubimage(x, y, width, height);
	}
}

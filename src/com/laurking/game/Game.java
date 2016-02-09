package com.laurking.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

import com.laurking.bullet.Bullet;
import com.laurking.collision.Collision;
import com.laurking.controller.Controller;
import com.laurking.display.Assets;
import com.laurking.display.Display;
import com.laurking.enemies.Enemy;
import com.laurking.keyinput.KeyInput;
import com.laurking.menu.Menu;
import com.laurking.mouseinput.MouseInput;
import com.laurking.spaceship.SpaceShip;

public class Game implements Runnable {
	private Display view;
	private String TITLE;
	private int WIDTH;
	private int HEIGHT;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	private KeyInput keyinput;
	private MouseInput mouseinput;
	private SpaceShip ship;
	private String ship_direction = "UP";
	private Controller controller;
	private Menu menu;
	private Enemy enemies;
	private Bullet bullets;
	private Random rand = new Random();
	private  ArrayList<Enemy> enemy = new ArrayList<Enemy>();
	private ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	private Collision collision;
	private int enemySize;
	private int number=40;

	public static enum STATE {
		GAME, MENU
	};

	public static STATE state = STATE.MENU;

	public Game(String title, int width, int height) {
		TITLE = title;
		WIDTH = width;
		HEIGHT = height;

	}

	public Game(String title, int width) {
		this.TITLE = title;
		this.WIDTH = width;
		this.HEIGHT = 600;

	}

	public Game(String title) {
		this.TITLE = title;
		this.WIDTH = 800;
		this.HEIGHT = 600;

	}

	private void init() {
		view = new Display(TITLE, WIDTH, HEIGHT);
		menu = new Menu();
		Assets.init();
		keyinput = new KeyInput(this);
		mouseinput = new MouseInput(this);
		view.getCanvas().addKeyListener(keyinput);
		view.getCanvas().addMouseListener(mouseinput);
		ship = new SpaceShip(WIDTH / 2 - 50, HEIGHT - 150, this);
		controller = new Controller(this);
		enemies = new Enemy(rand.nextInt(WIDTH));
		enemySize+=number;
		for(int i=0;i<enemySize;i++){
			enemies = new Enemy(rand.nextInt(WIDTH));
			controller.addEntity(enemies);
			enemy.add(enemies);
		}
		collision = new Collision(enemy, bullet, this);

	}

	private void tick() {
		if (state == STATE.GAME) {
			ship.tick();
			controller.tick();
			
		}
	}

	private void render() {
		bs = view.getCanvas().getBufferStrategy();
		if (bs == null) {
			view.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		if (state == STATE.GAME) {
			g.drawImage(Assets.background, 0, 0, this.WIDTH, this.HEIGHT, null);
			ship.render(g);
			controller.render(g);
		} else if (state == STATE.MENU) {
			menu.render(g);
		}

		bs.show();
		bs.dispose();
	}

	public void run() {
		init();
		int fps = 60;
		double timePerTicks = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTicks;
			timer += now - lastTime;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}

		}
		stop();
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public void keyPressed(KeyEvent e) {
		if (state == STATE.GAME) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_UP) {
				ship.setVelY(-10);
				ship_direction = "UP";
			} else if (key == KeyEvent.VK_RIGHT) {
				ship.setVelX(10);
				ship_direction = "RIGHT";
			} else if (key == KeyEvent.VK_DOWN) {
				ship.setVelY(10);
				ship_direction = "DOWN";
			} else if (key == KeyEvent.VK_LEFT) {
				ship.setVelX(-10);
				ship_direction = "LEFT";
			} else if (key == KeyEvent.VK_SPACE) {
				bullets = new Bullet(ship.getX() + 45, ship.getY(), this);
				controller.addEntity(bullets);
				bullet.add(bullets);
				collision.tick();
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		if (state == STATE.GAME) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_UP) {
				ship.setVelY(0);

			} else if (key == KeyEvent.VK_RIGHT) {
				ship.setVelX(0);

			} else if (key == KeyEvent.VK_DOWN) {
				ship.setVelY(0);

			} else if (key == KeyEvent.VK_LEFT) {
				ship.setVelX(0);

			}
		}

	}

	public String getShip_direction() {
		return ship_direction;
	}

	public void setShip_direction(String ship_direction) {
		this.ship_direction = ship_direction;
	}

	public static STATE getState() {
		return state;
	}

	public static void setState(STATE state) {
		Game.state = state;
	}

	public Controller getController() {
		return controller;
	}
	
	
	public void setEnemySize(int x){
		number=x;
	}
	public int getEnemySize(){
		return number;
	}
}

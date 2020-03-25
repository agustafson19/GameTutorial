import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.util.Random;

public class HardEnemy extends GameObject {
	
	private Handler handler;
	
	private BufferedImage enemy_image;
	
	private Random r = new Random();
	
	public HardEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 5f;
		velY = 5f;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		enemy_image = ss.grabImage(48, 0, 16, 16);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if (x <= 0f || x >= Game.WIDTH - 16f) {if (velX<0) velX = r.nextInt(7)+1; else velX = (r.nextInt(7)+1)*-1;}
		if (y <= 0f || y >= Game.HEIGHT - 32f) {if (velY<0) velY = r.nextInt(7)+1; else velY = (r.nextInt(7)+1)*-1;}
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.YELLOW, 16f, 16f, 0.02f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(Math.round(x), Math.round(y), 16, 16);
		//g.drawImage(enemy_image, Math.round(x), Math.round(y), null);
	}
	
}
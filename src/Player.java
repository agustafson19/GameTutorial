import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.util.Random;

public class Player extends GameObject {
	
	Random  r = new Random();
	private Handler handler;
	
	private BufferedImage player_image;
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		player_image = ss.grabImage(0, 0, 32, 32);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0f, Game.WIDTH - 37f);
		y = Game.clamp(y, 0f, Game.HEIGHT - 60f);
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.WHITE, 32f, 32f, 0.05f, handler));
		
		collision();
		
	}
	
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
				// tempobject is now an enemy
				if (getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.WHITE);
		//g.fillRect(Math.round(x), Math.round(y), 32, 32);
		g.drawImage(player_image, Math.round(x), Math.round(y), null);
	}
	
}
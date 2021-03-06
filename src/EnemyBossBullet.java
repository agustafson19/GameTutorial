import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private Handler handler;
	Random r = new Random();
	
	public EnemyBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = r.nextFloat() * 10f - 5f;
		velY = r.nextFloat() * 10f;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		//if (x <= 0f || x >= Game.WIDTH - 16f) velX *= -1f;
		//if (y <= 0f || y >= Game.HEIGHT - 32f) velY *= -1f;
		
		if (y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16f, 16f, 0.02f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(Math.round(x), Math.round(y), 16, 16);
	}
	
}
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.util.Random;

public class EnemyBoss extends GameObject {
	
	private Handler handler;
	Random r = new Random();
	
	private int timer = 80;
	private int timer2 = 50;
	
	public EnemyBoss(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0f;
		velY = 2f;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if (timer <= 0) velY = 0;
		else timer--;
		
		if (timer <= 0) timer2--;
		if (timer2 <= 0) {
			if (velX == 0) velX = 2;
			if (velX > 0) velX += 0.05f;
			if (velX < 0) velX -= 0.05f;
			
			velX = Game.clamp(velX, -10f, 10f);
			
			int spawn = r.nextInt(10);
			if (spawn == 0) handler.addObject(new EnemyBossBullet(Math.round(x + 48f), Math.round(y + 48f), ID.BasicEnemy, handler));
		}
		
		if (x <= 0f || x >= Game.WIDTH - 96f) velX *= -1f;
		//if (y <= 0f || y >= Game.HEIGHT - 96f) velY *= -1f;
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 96f, 96f, 0.01f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(Math.round(x), Math.round(y), 96, 96);
	}
	
}
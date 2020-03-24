import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject {
	
	private Handler handler;
	
	private BufferedImage enemy_image;
	
	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 5f;
		velY = 5f;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		enemy_image = ss.grabImage(32, 0, 16, 16);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if (x <= 0f || x >= Game.WIDTH - 16f) velX *= -1f;
		if (y <= 0f || y >= Game.HEIGHT - 32f) velY *= -1f;
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16f, 16f, 0.02f, handler));
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.RED);
		//g.fillRect(Math.round(x), Math.round(y), 16, 16);
		g.drawImage(enemy_image, Math.round(x), Math.round(y), null);
	}
	
}
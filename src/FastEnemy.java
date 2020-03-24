import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject {
	
	private Handler handler;
	
	private BufferedImage enemy_image;
	
	public FastEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 2f;
		velY = 9f;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		enemy_image = ss.grabImage(48, 16, 16, 16);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if (x <= 0f || x >= Game.WIDTH - 16f) velX *= -1f;
		if (y <= 0f || y >= Game.HEIGHT - 32f) velY *= -1f;
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, 16f, 16f, 0.02f, handler));
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.CYAN);
		//g.fillRect(Math.round(x), Math.round(y), 16, 16);
		g.drawImage(enemy_image, Math.round(x), Math.round(y), null);
	}
	
}
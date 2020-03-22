import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {
	
	private Handler handler;
	
	public FastEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 2f;
		velY = 9f;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if (x <= 0f || x >= Game.WIDTH - 16f) velX *= -1f;
		if (y <= 0f || y >= Game.HEIGHT - 32f) velY *= -1f;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, 16f, 16f, 0.02f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(Math.round(x), Math.round(y), 16, 16);
	}
	
}
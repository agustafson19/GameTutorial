import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {
	
	private Handler handler;
	
	Random r = new Random();
		
	private Color col;
	
	public MenuParticle(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = r.nextInt(14) - 7;
		velY = r.nextInt(14) - 7;
		if (velX == 0) velX = 1;
		if (velY == 0) velY = 1;
		
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if (x <= 0f || x >= Game.WIDTH - 16f) velX *= -1f;
		if (y <= 0f || y >= Game.HEIGHT - 32f) velY *= -1f;
		
		handler.addObject(new Trail(x, y, ID.Trail, col, 16f, 16f, 0.02f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(Math.round(x), Math.round(y), 16, 16);
	}
	
}
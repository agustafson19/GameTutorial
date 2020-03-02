import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
	
	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}
	
	public void tick() {
		int diffX = player.getX() + 8 - x;
		int diffY = player.getY() + 8 - y;
		int distance = (int) Math.round(Math.sqrt(diffX*diffX+diffY*diffY));
		
		if (distance != 0) {
			velX = diffX / distance;
			velY = diffY / distance;
		}
		
		x += velX;
		y += velY;
		
		if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.GREEN, 16, 16, 0.02f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 16, 16);
	}
	
}
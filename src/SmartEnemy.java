import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SmartEnemy extends GameObject {
	
	private Handler handler;
	private GameObject player;
	
	private BufferedImage enemy_image;
	
	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}
		
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		enemy_image = ss.grabImage(32, 16, 16, 16);
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), 16, 16);
	}
	
	public void tick() {
		float diffX = player.getX() + 8 - x;
		float diffY = player.getY() + 8 - y;
		float distance = (float) Math.sqrt(diffX*diffX+diffY*diffY);
		
		if (distance == 0f) {
			velX = 0;
			velY = 0;
		}
		else {
			velX = diffX / distance;
			velY = diffY / distance;
		}
		
		x += velX;
		y += velY;
		
		if (x <= 0f || x >= Game.WIDTH - 16f) velX *= -1f;
		if (y <= 0f || y >= Game.HEIGHT - 32f) velY *= -1f;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.GREEN, 16f, 16f, 0.02f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(Math.round(x), Math.round(y), 16, 16);
		//g.drawImage(enemy_image, Math.round(x), Math.round(y), null);
	}
	
}
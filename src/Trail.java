import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
	
	private float alpha = 1f;
	
	private Handler handler;
	private Color color;
	
	private float width, height;
	private float life;
	
	//life = 0.01 - 0.1
	
	public Trail(float x, float y, ID id, Color color, float width, float height, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}
	
	public void tick() {
		if (alpha > life) {
			alpha -= (life - 0.0001f);
		}
		else {
			handler.removeObject(this);
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect(Math.round(x), Math.round(y), Math.round(width), Math.round(height));
		
		//Resets transparency for other objects
		g2d.setComposite(makeTransparent(1));
		
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, alpha);
	}
	
	public Rectangle getBounds() {
		return null;
	}
	
}
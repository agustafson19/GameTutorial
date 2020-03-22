import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	private int greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		HEALTH = Math.round(Game.clamp((float) HEALTH, 0f, 100f));
		greenValue = Math.round(Game.clamp((float) greenValue, 0f, 255f));
		
		greenValue = HEALTH * 2;
		
		score++;
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
}
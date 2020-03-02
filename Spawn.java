import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if (scoreKeep == 100) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			if (hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextFloat()*(Game.WIDTH - 50f), r.nextFloat()*(Game.HEIGHT - 50f), ID.BasicEnemy, handler));
			}
			else if (hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextFloat()*(Game.WIDTH - 50f), r.nextFloat()*(Game.HEIGHT - 50f), ID.BasicEnemy, handler));
			}
			else if (hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(r.nextFloat()*(Game.WIDTH - 50f), r.nextFloat()*(Game.HEIGHT - 50f), ID.FastEnemy, handler));
			}
			else if (hud.getLevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextFloat()*(Game.WIDTH - 50f), r.nextFloat()*(Game.HEIGHT - 50f), ID.SmartEnemy, handler));
			}
			else if (hud.getLevel() == 6) {
				handler.addObject(new FastEnemy(r.nextFloat()*(Game.WIDTH - 50f), r.nextFloat()*(Game.HEIGHT - 50f), ID.FastEnemy, handler));
			}
			else if (hud.getLevel() == 7) {
				handler.addObject(new FastEnemy(r.nextFloat()*(Game.WIDTH - 50f), r.nextFloat()*(Game.HEIGHT - 50f), ID.FastEnemy, handler));
			}
			else if (hud.getLevel() == 10) {
				handler.clearEnemies();
				handler.addObject(new EnemyBoss((Game.WIDTH / 2f), -101f, ID.EnemyBoss, handler));
			}
			
			
		}
	}
	
}
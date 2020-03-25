import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public int speed = 5;
	
	public void tick() {
		try {
			for (int i = 0; i < object.size(); i++) {
				GameObject tempObject = object.get(i);
				
				tempObject.tick();
			}
		}catch(Exception e){}
	}
	
	public void render(Graphics g) {
		try {
			for (int i = 0; i < object.size(); i++) {
				GameObject tempObject = object.get(i);
			
				tempObject.render(g);
			}
		}catch(Exception e){}
	}
	
	public void clearEnemies() {
		try {
			for (int i = object.size() - 1; i >= 0; i--) {
				GameObject tempObject = object.get(i);
				if (tempObject.getId() == ID.Player) {
					object.clear();
					if (Game.gameState != Game.STATE.End) {
						addObject(new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
					}
				}
			}
		}catch(Exception e){}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}
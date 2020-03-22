import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		try {
			for (int i = 0; i < object.size(); i++) {
				GameObject tempObject = object.get(i);
				
				tempObject.tick();
			}
		}catch(Exception e){System.out.println("Problem with object's tick");}
	}
	
	public void render(Graphics g) {
		try {
			for (int i = 0; i < object.size(); i++) {
				GameObject tempObject = object.get(i);
			
				tempObject.render(g);
			}
		}catch(Exception e){System.out.println("Problem rendering object");}
	}
	
	public void clearEnemies() {
		try {
			for (int i = object.size() - 1; i >= 0; i--) {
				GameObject tempObject = object.get(i);
				if (tempObject.getId() == ID.Player) {
					object.clear();
					addObject(new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
				}
			}
		}catch(Exception e){System.out.println("Problem clearing enemies.");}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}
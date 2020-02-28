import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Player) {
				//key events for player 1
				
				if (key == KeyEvent.VK_W) {
					tempObject.setY(tempObject.getY() - 1);
				}
				
			}
				
			if (tempObject.getId() == ID.Player2) {
				//key events for player 2
				
				if (key == KeyEvent.VK_UP) {
					tempObject.setY(tempObject.getY() - 1);
				}
				
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	}
	
}
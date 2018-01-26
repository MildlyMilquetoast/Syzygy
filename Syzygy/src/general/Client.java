package general;

import java.awt.*;

import buttons.*;
import buttons.Button;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class Client extends PApplet{
	
	//// Fields
	
	public Board board = new Board(this);
	public ButtonHandler buttons = new ButtonHandler();
	
	public int SCREEN_WIDTH;
	public int SCREEN_HEIGHT;
	
	//// Required Methods
	
	public static void main(String[] args) {
		PApplet.main(Client.class.getName());
	}
	
	// Setup
	
	public void settings() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		SCREEN_WIDTH = (int) screenSize.getWidth();
		SCREEN_HEIGHT = (int) screenSize.getHeight();
		
		fullScreen();
		
	}
	
	public void setup() {
		
		// TODO: figure out keycodes
		
		// Add Buttons
		buttons.add(new Button(ButtonType.KEY, "EXIT-GAME", 27)); // esc
		buttons.add(new Button(ButtonType.KEY, "DRAW-KEY", 32)); // space (or enter) (or both)
		buttons.add(new Button(ButtonType.MOUSE, "L-MOUSE", 37)); // Left mouse
		buttons.add(new Button(ButtonType.MOUSE, "R-MOUSE", 39)); // Right mouse
		buttons.add(new Button(ButtonType.MOUSE, "ZOOM-OUT", 1)); // Wheel down
		buttons.add(new Button(ButtonType.MOUSE, "ZOOM-IN", -1)); // wheel up
		
	}
	
	// Loop
	
	public void draw() {
				
		buttons.update();
		
		board.update();
		
		board.display();
		
		if(buttons.isPressed("EXIT-GAME")) System.exit(0);
		
	}
	
	//// Other Methods
	
	//// Input Methods
	
	public void keyPressed() {		
		buttons.changeKeyState(keyCode, true);
	}
	
	public void keyReleased() {
		buttons.changeKeyState(keyCode, false);
	}
	
	public void mousePressed() {
		buttons.changeMouseState(mouseButton, true);
	}
	
	public void mouseReleased() {
		buttons.changeMouseState(mouseButton, false);
	}
	
	public void mouseWheel(MouseEvent e) {
		buttons.changeMouseState(e.getCount(), true);
		buttons.changeMouseState(e.getCount(), false);
	}
	
}

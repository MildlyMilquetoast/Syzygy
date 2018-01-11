package general;

import java.awt.Rectangle;

import buttons.ButtonHandler;
import buttons.KeyButton;
import buttons.MouseButton;
import buttons.ScreenButton;
import processing.core.PApplet;

public class Client extends PApplet{
	
	//// Fields
	
	public Board board;
	public ButtonHandler buttons = new ButtonHandler();
	
	//// Required Methods
	
	public static void main(String[] args) {
		
	}
	
	// Setup
	
	public void settings() {
		
	}
	
	public void setup() {
		
		// TODO: figure out keycodes
		
		// Add Buttons
		buttons.add(new KeyButton("EXIT-GAME", 0)); // esc
		buttons.add(new KeyButton("DRAW-KEY", 1)); // space (or enter) (or both)
		buttons.add(new ScreenButton("DRAW-SCREEN", new Rectangle())); // in bottom right
		buttons.add(new MouseButton("L-MOUSE", 2)); // Left mouse
		buttons.add(new MouseButton("R_MOUSE", 3)); // Right mouse
		buttons.add(new MouseButton("ZOOM-OUT", 4)); // Wheel down
		buttons.add(new MouseButton("ZOOM-IN", 5)); // wheel up
		
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
	
}

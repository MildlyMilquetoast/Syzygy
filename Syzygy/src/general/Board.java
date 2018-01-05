package general;

import java.awt.Point;
import java.awt.Rectangle;

import buttons.*;
import tiles.*;

public class Board {
	
	//// Fields
	
	private ButtonHandler buttons = new ButtonHandler();
	private TileHandler tiles = new TileHandler();
	
	private Tile heldTile = null;
	
	private Point oldMouse;
	
	//// Constructors
	
	
	
	private void init() {
		
		buttons.add(new ScreenButton("DRAW", new Rectangle()));
		buttons.add(new MouseButton("LEFT-MOUSE", 0)); // TODO: figure out keycodes
		buttons.add(new MouseButton("ZOOM-OUT", -1));
		buttons.add(new MouseButton("ZOOM-IN", 1));
		
	}
	
	//// Methods
	
	public void display() {
		
	}
	
	public void update() {
		
		handleButtons();
		
		
		
	}
	
	private void handleButtons() {
		
		buttons.update();
		
		
		
	}
	
}

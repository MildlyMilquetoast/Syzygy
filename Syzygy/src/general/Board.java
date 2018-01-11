package general;

import java.awt.Point;
import java.awt.Rectangle;

import buttons.*;
import processing.core.PApplet;
import tiles.*;

public class Board {
	
	//// Fields
	
	private Client parent;
	private TileHandler tiles = new TileHandler();
	private TileDrawer pile = new TileDrawer();
	private Tile heldTile = null;
	private Point oldMouse;
	
	private double zoom = 1.0d;
	private double zoomInc = 1.5;
	
	private boolean done = false;
	
	//// Constructors
	
	public Board(Client parent) {
		this.parent = parent;
	}
	
	//// Methods
	
	public void display() {
		
		tiles.display();
		
	}
	
	public void update() {
		
		if(parent.buttons.isPressed("ZOOM-IN")) zoom *= zoomInc;
		if(parent.buttons.isPressed("ZOOM-OUT")) zoom /= zoomInc;
		
		if(heldTile != null) {
			
			tiles.MoveTiles(heldTile, (parent.mouseX - oldMouse.x), (parent.mouseY - oldMouse.y));
			
		}
						
		if((parent.buttons.isClicked("DRAW-KEY")
				|| parent.buttons.isClicked("DRAW-SCREEN"))
				&& checkValid()) {
			
			if(tiles.placeNew(pile.draw())) done = true;
			
		}
		
		oldMouse = new Point(parent.mouseX, parent.mouseY);
		
	}
	
	public boolean checkValid() {
		return true; // TODO: check if the board is valid so we can draw a tile
	}
	
}

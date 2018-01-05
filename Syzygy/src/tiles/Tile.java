package tiles;

import java.awt.Point;

public class Tile {
	
	//// Fields
	
	// Values that we need to keep track of
	private Point pos;
	private char letter; // 0 for wild (note: 0 != '0')
	
	//// Constructors
	
	public Tile(char letter, Point pos){
		this.pos = pos;
		this.letter = letter;
	}
	
	public Tile(char letter){
		this(letter, new Point(0, 0));
	}
	
	//// Methods
	
	public void translate(int dx, int dy) {
		this.pos.translate(dx, dy);
	}
	
	/**
	 * Displays the tile on the screen
	 */
	public void display(){
		// TODO: write this or figure out where this code should go
	}
	
}

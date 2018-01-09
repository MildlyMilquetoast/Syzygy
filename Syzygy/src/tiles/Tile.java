package tiles;

import java.awt.Point;

public class Tile {
	
	//// Fields

	public static int TILE_SIZE = 20;
	public static int TILE_CORNER = 7;
	public static 

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

		fill(color(0, 0, 0));
		rect(pos.x, pos.y, Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_CORNER);


	}
	
}

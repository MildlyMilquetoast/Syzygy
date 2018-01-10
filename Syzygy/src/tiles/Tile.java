package tiles;

import java.awt.Point;

public class Tile {
	
	//// Fields

	public static int TILE_SIZE = 20;
	public static int TILE_CORNER = 7;
	public static int[] TILE_RGB = new int[] {63, 63, 255};
	public static boolean CAPS = true;

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
		
		// Draw rectangle
		fill(Tile.TILE_RGB[0], Tile.TILE_RGB[1], Tile.TILE_RGB[2]);
		rectMode(CENTER);
		rect(pos.x, pos.y, Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_CORNER);
		
		// Draw the letter
		
		fill(0, 0, 0);
		// text size based on the box size
		textAlign(CENTER, CENTER);
		text(getDisplayCharacter(), pos.x, pos.y);
		
	}
	
	private String getDisplayChar() {
		String s = ((letter == 0) ? '?' : letter);
		return (Tile.CAPS ? s.toUpperCase() : s.toLowerCase());
	}
	
}

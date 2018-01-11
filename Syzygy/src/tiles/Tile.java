package tiles;

import java.awt.Point;

import processing.core.PApplet;

public class Tile {
	
	//// Fields

	public static PApplet pApp;
	public static int TILE_SIZE = 30;
	public static int TILE_CORNER = 7;
	public static int TILE_RGB = 0x4040FF; // ~light blue
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
		pApp.fill(Tile.TILE_RGB);
		pApp.rectMode(pApp.CENTER);
		pApp.rect(pos.x, pos.y, Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_CORNER);
		
		// Draw the letter
		
		pApp.fill(0, 0, 0);
		
		pApp.textAlign(pApp.CENTER, pApp.CENTER);
		pApp.text(getDisplayCharacter(), pos.x, pos.y);
		
	}
	
	public int contrastingTextRGB(int backgroundRGB) {
		
		return ((((backgroundRGB >> 16) & 0xFF) * 0.299
				+ ((backgroundRGB >> 8) & 0xFF) * 0.587
				+ ((backgroundRGB) & 0xFF) * 0.114) > 186)
				? 0x000000
				: 0xFFFFFF;
		
	}
	
	private String getDisplayCharacter() {
		String s = "" + ((letter == 0) ? '?' : letter);
		return (Tile.CAPS ? s.toUpperCase() : s.toLowerCase());
	}
	
}

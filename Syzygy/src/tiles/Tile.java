package tiles;

import java.awt.Point;

import processing.core.PApplet;

public class Tile {
	
	//// Fields

	public static PApplet pApp;
	public static int TILE_SIZE = 40;
	public static int MIN_TILE_SIZE = 18;
	public static int TILE_CORNER = 5;
	public static int TILE_RGB = 0xFF4040FF; // ~light blue
	public static boolean CAPS = true;
	
	public int timer = 0;
	
	// Values that we need to keep track of
	public Point pos;
	public char letter;
	
	//  0
	// 3T1
	//  2
	public boolean[] connections = new boolean[4];
	
	//// Constructors
	
	public Tile(Tile t) {
		this.pos = t.pos;
		this.letter = t.letter;
		this.connections = t.connections;
	}
	
	public Tile(char letter, Point pos){
		this.pos = pos;
		this.letter = letter;
	}
	
	public Tile(char letter){
		this(letter, new Point(0, 0));
	}
	
	//// Methods
	
	public void setPApp(PApplet pApp) {
		this.pApp = pApp;
	}
	
	public void translate(int dx, int dy) {
		this.pos.translate(dx, dy);
	}
	
	public void setPos(Point pos) {
		this.pos = pos;
	}
	
	/**
	 * Displays the tile on the screen
	 */
	public void display(){
		
		timer = Math.max(0, timer - 1);
		
		// Draw rectangle
		pApp.fill(Tile.TILE_RGB + ((timer / 5) * 2 * 2 * 2 * 2));
		pApp.rectMode(pApp.CENTER);
		pApp.rect(pos.x, pos.y, Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_CORNER);
		
		// Draw the letter
		
		pApp.fill(0, 0, 0);
		pApp.textSize(Tile.TILE_SIZE * 5 / 6);
		pApp.textAlign(pApp.CENTER, pApp.CENTER);
		pApp.text(getDisplayCharacter(), pos.x, pos.y - (Tile.TILE_SIZE / 12));
		
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

package general;

import java.awt.Point;
import java.awt.Rectangle;

import buttons.*;
import processing.core.PApplet;
import tiles.*;

public class Board {

	//// Fields

	private Client parent;
	public TileHandler tiles;
	private TileDrawer pile = new TileDrawer();
	private Tile heldTile = null;
	private Point oldMouse;

	private long startTime;
	private long endTime;
	
	private boolean moveTogether = true;

	private SpellChecker checker = new SpellChecker("AllowedWords");

	private double zoom = 1.0d;
	private double zoomInc = 1.25;

	private boolean done = false;

	//// Constructors

	public Board(Client parent) {
		this.parent = parent;
		this.tiles = new TileHandler(parent);
		setup();

		startTime = System.currentTimeMillis();

	}

	//// Methods

	public void setup() {

		tiles.placeNew(pile.draw(), new Point(300, 300));
		tiles.placeNew(pile.draw(), new Point(300, 400));
		tiles.placeNew(pile.draw(), new Point(300, 500));
		tiles.placeNew(pile.draw(), new Point(400, 300));
		tiles.placeNew(pile.draw(), new Point(400, 400));
		tiles.placeNew(pile.draw(), new Point(400, 500));
		tiles.placeNew(pile.draw(), new Point(500, 300));
		tiles.placeNew(pile.draw(), new Point(500, 400));
		tiles.placeNew(pile.draw(), new Point(500, 500));

	}

	public void display() {

		parent.background(0x40FF40);

		tiles.display();
		
		parent.text(pile.remainingChars.size() + " tiles left", 200, parent.SCREEN_HEIGHT - 50);
		
		if(done) {
			parent.text("Congrats! You win!\nYou're time was " + ((endTime - startTime) / 1000) + " seconds"
					, parent.SCREEN_WIDTH / 2, parent.SCREEN_HEIGHT / 2);
		} else {
			parent.text((int) ((System.currentTimeMillis() - startTime) / 1000),
					parent.SCREEN_WIDTH - 100, parent.SCREEN_HEIGHT - 50);
		}
		
	}

	public void update() {

		if(!done) {

			if(parent.buttons.isOn("ZOOM-IN")) zoom *= zoomInc;
			if(parent.buttons.isOn("ZOOM-OUT")) zoom /= zoomInc;

			if(heldTile != null) {

				int dx = (parent.mouseX - oldMouse.x);
				int dy = (parent.mouseY - oldMouse.y);

				if(moveTogether) {
					tiles.moveTiles(heldTile, dx, dy);
				} else {
					heldTile.translate(dx, dy);
				}

			}

			if(parent.buttons.isActivated("L-MOUSE") && heldTile == null) {
				moveTogether = true;
				heldTile = tiles.findTile(new Point(parent.mouseX, parent.mouseY));
			}

			if(parent.buttons.isDeactivated("L-MOUSE") && heldTile != null && moveTogether) {
				tiles.snap(heldTile);
				heldTile = null;
			}

			if(parent.buttons.isActivated("R-MOUSE") && heldTile == null) {
				moveTogether = false;
				heldTile = tiles.findTile(new Point(parent.mouseX, parent.mouseY));
				if(heldTile != null) tiles.disconnect(heldTile);
			}

			if(parent.buttons.isDeactivated("R-MOUSE") && heldTile != null && !moveTogether) {
				tiles.snap(heldTile);
				heldTile = null;
			}

			//		if(parent.buttons.isActivated("ZOOM-IN")) {
			//			
			//			Tile.TILE_SIZE *= zoomInc;
			//			
			//			
			//			
			//		}
			//		
			//		if(parent.buttons.isActivated("ZOOM-OUT")
			//				&& Tile.TILE_SIZE * zoomInc > Tile.MIN_TILE_SIZE) {
			//			
			//			Tile.TILE_SIZE /= zoomInc;
			//			
			//			
			//			
			//		}

			if(parent.buttons.isActivated("DRAW-KEY") && checkValid()) {

				if(tiles.placeNew(pile.draw())) {
					done = true;
					endTime = System.currentTimeMillis();
				}

			}

			oldMouse = new Point(parent.mouseX, parent.mouseY);

		}
		
	}

	public boolean checkValid() {
		// If there are fewer than a certain # of tiles, make sure you can draw more
		if(tiles.tiles.size() < 9) return true;
		return checker.valid(tiles);
	}

}

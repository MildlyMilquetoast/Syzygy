package tiles;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;

public class TileHandler {

	//// Fields

	private PApplet pApp;

	private final int SNAP_RANGE = 30;

	public ArrayList<Tile> tiles = new ArrayList<Tile>();

	//// Constructors

	public TileHandler(PApplet pApp) {
		this.pApp = pApp;
	}

	//// Methods

	public ArrayList<Tile> cloneList(ArrayList<Tile> original){
		ArrayList<Tile> clone = new ArrayList<Tile>();
		for(Tile t : original) clone.add(new Tile(t));
		return clone;
	}

	public Tile findTile(Point pos) {
		for(Tile t : tiles) {
			if(Math.abs(pos.x - t.pos.x) < Tile.TILE_SIZE / 2
					&& Math.abs(pos.y - t.pos.y) < Tile.TILE_SIZE / 2) return t;
		}
		return null;
	}

	public boolean snap(Tile t) {

		ArrayList<Tile> eligible = cloneList(tiles);
		ArrayList<Tile> connected = cloneList(getConnectedTiles(t));

		for(Tile tile : connected) eligible.remove(tile);

		boolean snapFound = false;

		for(Tile target : eligible) {
			for(Tile subject : connected) {

				if(snapFound) {
					
					int direction = isSnapPos(subject, target.pos);
					
					if(direction >= 0 && subject.connections[direction] == false
							&& target.connections[(direction + 2) % 4] == false) {
						
						subject.connections[direction] = true;
						target.connections[(direction + 2) % 4] = true;
						
					}
					
				} else {

					Point snapPos = shouldConnect(subject, target);

					if(snapPos != null) {

						setTilesPos(subject, snapPos);

						snapFound = true;

					}

				}
			}
		}

		return snapFound;

	}

	public int isSnapPos(Tile t, Point snapPos) {

		if(new Point(t.pos.x, t.pos.y - Tile.TILE_SIZE).equals(snapPos)) return 0;
		if(new Point(t.pos.x + Tile.TILE_SIZE, t.pos.y).equals(snapPos)) return 1;
		if(new Point(t.pos.x, t.pos.y + Tile.TILE_SIZE).equals(snapPos)) return 2;
		if(new Point(t.pos.x - Tile.TILE_SIZE, t.pos.y).equals(snapPos)) return 3;
		return -1;
		
	}

	public Point shouldConnect(Tile subject, Tile target) {

		Rectangle snapBox = new Rectangle(target.pos.x - SNAP_RANGE, target.pos.y - SNAP_RANGE, 2 * SNAP_RANGE, 2 * SNAP_RANGE);

		Point[] offsets = new Point[] {new Point(0, -Tile.TILE_SIZE), new Point(Tile.TILE_SIZE, 0),
				new Point(0, Tile.TILE_SIZE), new Point(-Tile.TILE_SIZE, 0)};

		for(int i = 0; i < 4; i++) {

			if(!target.connections[i] && !subject.connections[(i + 2) % 4]) {

				Rectangle r = new Rectangle(snapBox);
				r.translate(offsets[i].x, offsets[i].y);

				if(r.contains(subject.pos)) {
					target.connections[i] = true;
					subject.connections[(i + 2) % 4] = true;
					return new Point(r.x + (r.width / 2), r.y + (r.height / 2));
				}
			}

		}

		return null;
	}

	public void disconnect(Tile t) {

		Point[] snappedPos = new Point[] {
				new Point(t.pos.x,                  t.pos.y - Tile.TILE_SIZE),
				new Point(t.pos.x + Tile.TILE_SIZE, t.pos.y),
				new Point(t.pos.x,                  t.pos.y + Tile.TILE_SIZE),
				new Point(t.pos.x - Tile.TILE_SIZE, t.pos.y)};

		for(Tile possible : tiles) {

			for(int i = 0; i < 4; i++) {

				if(t.connections[i] && possible.connections[(i + 2) % 4]
						&& snappedPos[i].equals(possible.pos)) {

					t.connections[i] = false;
					possible.connections[(i + 2) % 4] = false;

				}

			}

		}
	}

	public ArrayList<Tile> getConnectedTiles(Tile tile) {
		ArrayList<Tile> connected = new ArrayList<Tile>();
		connected.add(tile);

		Point[] snappedPos = new Point[] {
				new Point(0,               -Tile.TILE_SIZE),
				new Point(Tile.TILE_SIZE,  0),
				new Point(0,               Tile.TILE_SIZE),
				new Point(-Tile.TILE_SIZE, 0)};



		for(int j = 0; j < connected.size(); j++) {

			Tile t = connected.get(j);

			for(Tile possible : tiles) {

				for(int i = 0; i < 4; i++) {
					if(t.connections[i]	&& possible.connections[(i + 2) % 4]
							&& (new Point(snappedPos[i].x + t.pos.x, snappedPos[i].y + t.pos.y).equals(possible.pos))) {

						boolean inConnected = false;

						for(Tile c : connected) {

							if(possible.pos.equals(c.pos)) inConnected = true;

						}

						if(!inConnected) connected.add(possible);

					}
				}

			}

		}

		return connected;
	}

	public void setTilesPos(Tile t, Point pos) {

		moveTiles(t, pos.x - t.pos.x, pos.y - t.pos.y);

	}

	public void moveTiles(Tile t, int dx, int dy) {

		for(Tile a : getConnectedTiles(t)) {
			a.translate(dx, dy);

			// TODO: move `a` to the top of `tiles`

		}

	}

	public boolean placeNew(Tile t, Point pos) {

		if(t == null) return true;

		t.setPApp(pApp);
		t.setPos(pos);

		tiles.add(t);

		return false;

	}
	
	public boolean placeNew(Tile t) {
		return placeNew(t, new Point(100, 100));
	}
	
	public void display() {
		for(Tile t : tiles) {
			t.display();
		}
	}

}

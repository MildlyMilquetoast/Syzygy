package tiles;

import java.util.ArrayList;

public class TileHandler {
	
	//// Fields
	
	private final int SNAP_RANGE = 10;
	private final int TILE_SIZE = 50;
	
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	//// Constructors
	
	
	
	//// Methods
	
	public void snapTo(Tile subject, Tile target) {
		
		ConnectionDirection side = shouldConnect(subject, target);
		
		if(side != null) {
			
			
			
		}
		
	}
	
	public ConnectionDirection shouldConnect(Tile a, Tile b) { return null; }
	
	public ArrayList<Tile> getConnectedTiles(Tile t) { return new ArrayList<Tile>(); }
	
	public void MoveTiles(Tile t, int dx, int dy) {
		
		for(Tile a : getConnectedTiles(t)) {
			a.translate(dx, dy);
		}
		
	}
	
	public void placeNew(Tile t) {
		
		
		
	}
	
	public void display() {}
	
}

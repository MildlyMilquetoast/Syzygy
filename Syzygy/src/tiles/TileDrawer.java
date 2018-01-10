package tiles;

// Finished?

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class TileDrawer {
	
	//// Fields
	
	public static final int[] DEFAULT_DISTRIBUTION = new int[]{
	//      a   b   c   d   e   f   g   h   i   j   k   l   m   n   o   p   q   r   s   t   u   v   w   x   y   z   ?		
			26, 6 , 6 , 12, 34, 6 , 12, 7 , 25, 3 , 3 , 12, 6 , 17, 23, 7 , 3 , 18, 13, 16, 12, 6 , 6 , 3 , 6 , 4 , 12};
	
	public ArrayList<Character> remainingChars = new ArrayList<Character>();
	
	//// Constructors / startup Methods
	
	public TileDrawer(int[] distribution){
		
		addDistribution(distribution);
		Collections.shuffle(remainingChars);
		
	}
	
	public TileDrawer(){
		this(DEFAULT_DISTRIBUTION);
	}
	
	private void addDistribution(int[] distribution){
		if(distribution.length != 27) throw new IllegalArgumentException("distribution must be of length 27, not " + distribution.length);
		
		// For the first 26, add distribution[i] number of ith characters
		for(int i = 0; i < 26; i++){
			for(int j = 0; j < distribution[i]; j++) remainingChars.add((char) (65 + i));
		}
		
		// For the last number, add that many null bytes (wilds)
		for(int i = 0; i < distribution[26]; i++) remainingChars.add((char) 0);
		
	}
	
	//// Methods
	
	/**
	 * Returns a tile corresponding with a random character from the remaining, which is removed.
	 * 
	 * null is returned if the pole is empty
	 * 
	 * @return A random Tile from the distribution. Null if it is empty
	 */
	public Tile draw() {
		try {
			return new Tile((char) remainingChars.remove(remainingChars.size() - 1), new Point(0, 0));
		} catch  (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
}

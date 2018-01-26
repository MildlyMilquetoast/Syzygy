package tiles;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SpellChecker {
	
	public ArrayList<String> words = new ArrayList<String>();
	
	public SpellChecker(String wordFileName) {
		
		File wordFile = new File(wordFileName);
		
		Scanner in = null;
		
		try {
			in = new Scanner(wordFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(in.hasNextLine()) {
			
			String s = in.nextLine().trim().toLowerCase();

			Pattern p = Pattern.compile("[^a-z]");
			
			if(!p.matcher(s).find()) words.add(s);
			
		}
		
		Collections.sort(words);
		
	}
	
	public boolean valid(TileHandler tHandler) {
		
		// If there are 2 or more groups, not valid
		if(tHandler.getConnectedTiles(tHandler.tiles.get(0)).size() < tHandler.tiles.size()) return false;
		
		ArrayList<Tile> rowStarters = new  ArrayList<Tile>();
		ArrayList<Tile> colStarters = new  ArrayList<Tile>();
		
		for(Tile t : tHandler.tiles) {
			
			if(!t.connections[0] && t.connections[2]) colStarters.add(t);
			if(!t.connections[3] && t.connections[1]) rowStarters.add(t);
			
		}
		
		// Test rows
		
		for(Tile t : rowStarters) {
			
			Tile current = t;
			String s = "";
			
			ArrayList<Tile> letters = new ArrayList<Tile>();
			
			while(current.connections[1]) {
				
				s += current.letter;
				letters.add(current);
				
				for(Tile possible : tHandler.tiles) {
					
					if(new Point(current.pos.x + Tile.TILE_SIZE, current.pos.y).equals(possible.pos)) {
						current = possible;
						break;
					}
					
				}
				
			}
			
			s += current.letter;
			letters.add(current);
			
			s = s.toLowerCase();
			
			if(!words.contains(s)) {
				
				for(Tile x : letters) { 
					x.timer = 50;
				}
				
				return false;
			}
			
		}
		
		// Test columns
		
		for(Tile t : colStarters) {
			
			Tile current = t;
			String s = "";
			
			ArrayList<Tile> letters = new ArrayList<Tile>();
			
			while(current.connections[2]) {
				
				s += current.letter;
				letters.add(current);
				
				for(Tile possible : tHandler.tiles) {
					
					if(new Point(current.pos.x, current.pos.y  + Tile.TILE_SIZE).equals(possible.pos)) {
						current = possible;
						break;
					}
					
				}
				
			}
			
			s += current.letter;
			letters.add(current);
			
			s = s.toLowerCase();
			
			if(!words.contains(s)) {
				
				for(Tile x : letters) { 
					x.timer = 50;
				}
				
				return false;
			}
			
		}
		
		return true;
		
	}
	
}

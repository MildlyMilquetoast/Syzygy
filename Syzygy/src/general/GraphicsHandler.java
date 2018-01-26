package general;

import processing.core.PApplet;

public class GraphicsHandler {
	
	//// Fields
	
	// static variables
	
	private static PApplet pApp;
	
	// 
	
	//// Constructors
	
	
	
	//// Methods
	
	// called from the PApplet
	public void loop() {
		
		
		
	}
	
	// Drawing stuff
	
	
	
	// Helpful color related methods
	
	public int contrastingTextRGB(int backgroundRGB) {
		
		return ((((backgroundRGB >> 16) & 0xFF) * 0.299
				+ ((backgroundRGB >> 8) & 0xFF) * 0.587
				+ ((backgroundRGB) & 0xFF) * 0.114) > 186)
				? 0x000000
				: 0xFFFFFF;
		
	}
	
	public int[] hexToRGB(int rgb) {
		return new int[] {(rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, (rgb) & 0xFF};
	}
	
}

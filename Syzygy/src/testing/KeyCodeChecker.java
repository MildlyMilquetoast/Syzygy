package testing;

import processing.core.PApplet;
import processing.event.MouseEvent;

import java.awt.*;

public class KeyCodeChecker extends PApplet{
	
	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	
	public static void main(String[] args) {
		PApplet.main(KeyCodeChecker.class.getName());
	}
	
	public void settings() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		SCREEN_WIDTH = (int) screenSize.getWidth();
		SCREEN_HEIGHT = (int) screenSize.getHeight();
		
		size(SCREEN_WIDTH - 500, SCREEN_HEIGHT - 500);

	}
	
	public void setup() {
		rectMode(CENTER);
	}
	
	public void draw() {
		background(255, 255, 255);
		fill(0x4040FF);
		rect(50, 70, 30, 20, 7);
	}
	
	public void keyPressed() {
		System.out.println("pressed key:\t" + keyCode);
	}
	
	public void keyReleased() {
		System.out.println("released key:\t" + keyCode);
	}
	
	public void mousePressed() {
		System.out.println("pressed mouse:\t" + mouseButton);
	}
	
	public void mouseReleased() {
		System.out.println("released mouse:\t" + mouseButton);
	}
	
	public void mouseWheel(MouseEvent e) {
		System.out.println("mouse wheel:\t" + e.getCount());
	}
	
}

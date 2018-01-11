package buttons;

import java.util.ArrayList;

public class ButtonHandler {
	
	public enum Type{
		KEY,
		MOUSE,
		SCREEN
	}
	
	//// Fields
	
	private ArrayList<Button> buttons = new ArrayList<Button>();
	
	//// Constructors
	
	public ButtonHandler(){}
	
	//// Methods
	
	public void press(Type type, int keyCode) {
		
	}
	
	/**
	 * Updates all the buttons
	 */
	public void update(){
		for(Button b : buttons){
			b.update();
		}
	}
	
	/**
	 * Displays all the ScreenButtons on the screen
	 */
	public void display(){
		for(Button b : buttons){
			if(b instanceof ScreenButton) ((ScreenButton) b).display();
		}
	}

	public boolean isPressed(String name){
		return get(name).isPressed();
	}
	
	public boolean wasPressed(String name){
		return get(name).wasPressed();
	}
	
	public boolean isClicked(String name) {
		return get(name).isClicked();
	}
	
	/**
	 * Given the name of a Button, returns it
	 * 
	 * @throws IllegalArgumentException if there is no Button defined with the given name
	 * @param name The name of the button, given when adding the button to the handler using {@link buttons.ButtonHandler#add(Button)}.
	 * @return The Button specified by the name.
	 */
	public Button get(String name){
		
		for(Button b : buttons){
			if(b.name.equals(name)) return b;
		}
		
		throw new IllegalArgumentException("No Button is defined with the name " + name);
		
	}
	
	/**
	 * Adds a Button to the list of defined Buttons
	 * 
	 * @throws IllegalArgumentException if a Button with the given name is already defined
	 * @param button The Button to add to the list of defined Buttons
	 */
	public void add(Button button){
		
		for(Button b : buttons){
			if(b.name.equals(button.name)) throw new IllegalArgumentException("A button is already defined with the name " + b.name);
		}
		
		buttons.add(button);
	}
	
}

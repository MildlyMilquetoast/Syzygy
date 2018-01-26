package buttons;

import java.util.ArrayList;

public class ButtonHandler {
	
	//// Fields
	
	public ArrayList<Button> buttons = new ArrayList<Button>();
	
	//// Constructors
	
	public ButtonHandler(){}
	
	//// Methods
	
	public void changeKeyState(int code, boolean on) {
		
		for(Button b : buttons) {			
			if(b.type == ButtonType.KEY && b.keyCode == code) {
				b.changeState(on);				
			}
		}
		
	}
	
	public void changeMouseState(int code, boolean on) {
		
		for(Button b : buttons) {
			if(b.type == ButtonType.MOUSE && b.keyCode == code) b.changeState(on);
		}
		
	}
	
	// TODO: changeScreenState(stuff)
	
	/**
	 * Updates all the buttons
	 */
	public void update(){
		for(Button b : buttons){
			b.update();
		}
	}

	public PressType[] getTicks(String name){
		return get(name).getTicks();
	}
	
	public boolean isHeld(String name) { return getTicks(name)[0] == PressType.HELD; }
	public boolean isPressed(String name) { return getTicks(name)[0] == PressType.PRESS; }
	public boolean isReleased(String name) { return getTicks(name)[0] == PressType.RELEASE; }
	public boolean isClicked(String name) { return getTicks(name)[0] == PressType.CLICK; }
	public boolean isNone(String name) { return getTicks(name)[0] == PressType.NONE; }
	
	public boolean isOn(String name) { return (isHeld(name) || isPressed(name) || isClicked(name)); }
	public boolean isActivated(String name) { return (isPressed(name) || isClicked(name)); }
	public boolean isDeactivated(String name) { return (isReleased(name) || isClicked(name)); }
	
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

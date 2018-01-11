package buttons;

public class Button {
	
	//// Fields
	
	
	// Identifying name - used in get("name");
	protected String name;
	
	// pressed values
	protected boolean isPressed;
	protected boolean wasPressed;
	
	protected boolean pressedThisFrame;
	
	//// Methods
	
	public void press() { pressedThisFrame = true; }
	public void release() { pressedThisFrame = false; }
	
	public boolean isPressed() { return isPressed; }
	public boolean wasPressed() { return wasPressed; }
	public boolean isClicked() { return (isPressed && !wasPressed); }
	
	public void update() {
		wasPressed = isPressed;
		isPressed = pressedThisFrame;
	}
	
}

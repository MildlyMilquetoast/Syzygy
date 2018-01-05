package buttons;

public abstract class Button {
	
	//// Fields
	
	
	// Identifying name - used in get("name");
	protected String name;
	
	// pressed values
	protected boolean isPressed;
	protected boolean wasPressed;
	
	//// Methods
	
	public boolean isPressed() { return isPressed; }
	
	public boolean wasPressed() { return wasPressed; }
	
	public abstract boolean update();
	
}

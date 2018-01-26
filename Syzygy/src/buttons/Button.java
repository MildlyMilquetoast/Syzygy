package buttons;

public class Button {
	
	//// Fields
	
	public int keyCode;
	
	public ButtonType type;
	
	// Identifying name - used in get("name");
	protected String name;
	
	// pressed values
	protected PressType[] pressedTicks = new PressType[] {PressType.NONE, PressType.NONE, PressType.NONE};
	
	// updated when a button is pressed
	protected boolean on;
	protected boolean everPressed; // only used to decide between NONE and CLICK
	
	// updated at the beginning of every frame - use for doing things
	protected boolean onLast;
	protected boolean onNow;
	protected boolean onMid;
	
	public Button(ButtonType type, String name, int keyCode) {
		this.type = type;
		this.name = name;
		this.keyCode = keyCode;
	}
	
	//// Methods
	
	public void press() {
		on = true;
		everPressed = true;
	}
	
	public void release() {
		on = false;
	}
	
	public void changeState(boolean on) {		
		if(on) press(); else release();
	}
	
	public PressType[] getTicks() {
		return pressedTicks;
	}
	
	public void update() {
		
		onLast = onNow;
		onMid = everPressed;
		onNow = on;
		
		everPressed = false;
		
		for(int i = pressedTicks.length - 2; i >= 0; i--) {
			pressedTicks[i + 1] = pressedTicks[i];
		}
		
		pressedTicks[0] = PressType.determineType(onLast, onMid, onNow);
		
	}
	
}

package buttons;

import buttons.ButtonHandler.Type;

public class KeyButton extends Button{
	
	//// Fields
	
	public final Type type = Type.KEY;
	
	private int keyCode;
	
	//// Constructors
	
	public KeyButton(String name, int keyCode){
		this.name = name;
		this.keyCode = keyCode;
	}
	
	//// Methods

}

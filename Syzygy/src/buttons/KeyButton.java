package buttons;

public class KeyButton extends Button{
	
	//// Fields
	
	private int keyCode;
	
	//// Constructors
	
	public KeyButton(String name, int keyCode){
		this.name = name;
		this.keyCode = keyCode;
	}
	
	//// Methods
	
	@Override
	public boolean update() {
		// TODO: Figure out how to get input in here
	}

}

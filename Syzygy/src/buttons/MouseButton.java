package buttons;

public class MouseButton extends Button{
	
	//// Fields
	
	private int keyCode;
	
	//// Constructors
	
	public MouseButton(String name, int keyCode){
		this.name = name;
		this.keyCode = keyCode;
	}
	
	//// Methods
	
	@Override
	public boolean update() {
		// TODO: Figure out how to get input in here
	}

}

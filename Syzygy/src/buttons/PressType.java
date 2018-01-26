package buttons;

public enum PressType {
	HELD,	 // --|-----|--
	PRESS,	 //   |  o--|--
	RELEASE, // --|--o  |  
	CLICK,	 //   | o-o |  
	NONE;	 //   |     |  
	
	public static PressType determineType(boolean onLast, boolean onMid, boolean onNow) {
		
		if(onLast && onNow) return HELD;
		if(!onLast && onNow) return PRESS;
		if(onLast && !onNow) return RELEASE;
		if(!onLast && !onNow && onMid) return CLICK;
		return NONE;
		
	}
	
}

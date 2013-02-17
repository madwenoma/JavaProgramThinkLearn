package learn.enumdemo;

enum SpaceShip{
	SCOUT, CARGO, TRANSPORT, BATTLESHIP, MOTHERSHIP;
	@Override
	public String toString(){
		String id 	 = name();//·µ»Øscout
		String lower = id.substring(1).toLowerCase();
		
		return id.charAt(0) + lower;
	}
}

public class EnumToStringDemo {
	public static void main(String[] args) {
		
		System.out.println(SpaceShip.SCOUT.name());
		System.out.println(SpaceShip.BATTLESHIP.toString());
	}
}

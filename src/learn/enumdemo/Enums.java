package learn.enumdemo;

import java.util.Random;

/**
 * p596
 * @author Administrator
 *
 */
enum Activity{
	SITTING,LYING,STANDING,HOPPING,RUNNING,DODGING,JUMPING,FAILING,FLYING
}

public class Enums {
	private static Random r = new Random(47);
	
	public static <T extends Enum<T>> T random(Class<T> enumClass){
		
		return random(enumClass.getEnumConstants());
	}
	
	public static <T> T random(T[] values){
		return values[r.nextInt(values.length)];
	}
	
	public static void main(String[] args) {
		int i = 0;
		for(;;){
			System.out.println(Enums.random(Activity.class));
			if(i++ > 30)
				break;
		}
	}
	
	
}

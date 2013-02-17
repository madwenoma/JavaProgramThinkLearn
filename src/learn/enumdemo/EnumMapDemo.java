package learn.enumdemo;

import java.util.EnumMap;
import java.util.Map;

/**
 * enumMap的用法
 * p602
 * @author Administrator
 *
 */


public class EnumMapDemo {
	interface Command{
		void action();
	}
	
	public static void main(String[] args) {
		EnumMap<AlarmPoints, Command> map = new EnumMap<AlarmPoints, EnumMapDemo.Command>(AlarmPoints.class);
		map.put(AlarmPoints.KITCHEN, new Command(){
			@Override
			public void action() {
				System.out.println("the kitchen is fired");	
			}});
		map.put(AlarmPoints.BATHROOM, new Command(){
			@Override
			public void action() {
				System.out.println("the bathroom is fired");	
			}});
		
		for (Map.Entry<AlarmPoints, Command> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":");
			entry.getValue().action();
		}
		
		try {
			map.get(AlarmPoints.OFFICE1).action();/*取一个不存在调用会报空指针*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}

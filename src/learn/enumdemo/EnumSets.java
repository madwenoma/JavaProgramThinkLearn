package learn.enumdemo;

import java.util.EnumSet;

/**
 * EnumSet的用法 P601
 * 
 * @author Administrator
 * 
 */
/* 大楼警报传感器位置 */
enum AlarmPoints {
	STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY, KITCHEN
}

public class EnumSets {
	public static void main(String[] args) {
		EnumSet<AlarmPoints> enumSet = EnumSet.noneOf(AlarmPoints.class);
		System.out.println(enumSet);
		enumSet.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.LOBBY));
		System.out.println(enumSet);
		enumSet = EnumSet.allOf(AlarmPoints.class);
		System.out.println(enumSet);
		enumSet.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));/*删除从某个enum开始至结束enum*/
		System.out.println(enumSet);
		
		enumSet = EnumSet.complementOf(enumSet);
		System.out.println(enumSet);
	}
	
}

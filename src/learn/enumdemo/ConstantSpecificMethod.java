package learn.enumdemo;

import java.util.EnumSet;

/**
 * 常量相关的方法
 * @author biGpython
 *
 */
public enum ConstantSpecificMethod {
	DATE_TIME{
		@Override
		String getInfo(){
			return "18:23:00";
		}
	},
	SYS_CHARSET{
		@Override
		String getInfo(){
			return System.getProperty("file.encoding");
		}
	},
	CLASSPATH{
		@Override
		String getInfo(){
			return System.getenv("CLASSPATH");
		}
	},
	JAVA_HOME{
		@Override
		String getInfo(){
			return System.getenv("JAVA_HOME");
		}
	},
	JAVA_VERSION{
		@Override
		String getInfo(){
			return System.getProperty("java.version");
		}
	};
	/**
	 * 每个实例实现了该抽象方法
	 * @return
	 */
	abstract String getInfo();
	
	public static void main(String[] args) {
		System.out.println(ConstantSpecificMethod.CLASSPATH.getInfo());
		EnumSet<ConstantSpecificMethod> es = EnumSet.allOf(ConstantSpecificMethod.class);
		System.out.println(es.size());
		System.out.println(es);
		for (ConstantSpecificMethod constantSpecificMethod : es) {
			System.out.println(constantSpecificMethod.getInfo());
		}
		
		
	}
	
	
	
	
}

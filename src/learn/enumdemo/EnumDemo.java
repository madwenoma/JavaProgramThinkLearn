package learn.enumdemo;
/**
 * ���˼�� p592
 * @author Administrator
 *
 */
enum Fruit{
	APPLE("ƻ��"),ORANGE("����"),PEAR("����");
	
	private String name;
	
	private Fruit(String name){
		this.setName(name);
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
}
public class EnumDemo {
	public static void main(String[] args) {
		for (Fruit f: Fruit.values()) {
//			f.setName("ˮ��");
			System.out.println(f.ordinal() + "----" + f.name() + "----" + f.getName());
		}
	
		for (String s: "APPLE ORANGE PEAR".split(" ")) {
			Fruit f = Enum.valueOf(Fruit.class, s);
			System.out.println(f.getName());
		}
		
		
	
	}
	
	
	
	
	
	
	
	
}

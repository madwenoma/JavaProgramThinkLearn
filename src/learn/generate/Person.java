package learn.generate;
/**
 * ∑∫–Õ¿‡ 
 * @author biGpython
 *
 */
public class Person<T extends Info> {
	private T info;
	public Person(T info){
		this.info = info;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	
	@Override
	public String toString(){
		return info.toString();
	}
	
	public static void main(String[] args) {
		
	}
}

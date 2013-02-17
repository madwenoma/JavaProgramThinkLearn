package learn.others;
/**
 * ∂‡Ã¨
 * @author biGpython
 *
 */

class DuoTaiFather{
	public void draw(){
		System.out.println("father draw");
	}
	public DuoTaiFather(){
		System.out.println("father constructor before");
		draw();
		System.out.println("father constructor after");
	}
}
public class DuoTai extends DuoTaiFather{
	private int flag = 1;
	@Override
	public void draw(){
		System.out.println("DuoTai draw.flag=" + flag);
	}
	public DuoTai(int r){
		flag = r;
		System.out.println(flag);
	}
	public static void main(String[] args) {
		new DuoTai(55);
	}
}

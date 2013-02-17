/*package learn.generate;

import java.util.List;






class FirstService extends ServiceT{
	public FirstService(){
		System.out.println("FirstService constructor invoked");
	}
	
	@Override
	public void sayHello(){
		System.out.println("hello first!");
	}

	@Override
	protected List getDataList() {
		// TODO Auto-generated method stub
		return null;
	}

}

class SecondService extends ServiceT{
	public SecondService(){
		System.out.println("SecondService constructor invoked");
	}
	@Override
	public void sayHello(){
		System.out.println("hello seconde");
	}
	@Override
	protected List getDataList() {
		// TODO Auto-generated method stub
		return null;
	}
}


*//**
 * 第二个controller 为了省事写在这里，不在新建class了 
 * @author Administrator
 *
 *//*
class SecondController extends Controller<SecondService>{
	public SecondController() throws Exception{
		getCurrentService(SecondService.class).sayHello();
	}
}

public class FirstController extends Controller<FirstService>{
	public FirstController() throws Exception{
		getCurrentService(FirstService.class).sayHello();
	}
	
	public static void main(String[] args) throws Exception{
		new FirstController();
		new SecondController();
	}
}
*/
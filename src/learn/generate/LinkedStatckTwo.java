package learn.generate;


public class LinkedStatckTwo<T> {
	private static class Node<U> {
		U item;
		Node<U> next;

		Node() {
			item = null;
			next = null;
		}

		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	private Node<T> top = new Node<T>();

	public void push(T item) {
		top = new Node<T>(item, top);
	}

	public T pop(){
		T result = top.item;
		if(!top.end()){
			top = top.next;
		}
		return result;
	}
	public static void main(String[] args) {
		LinkedStatckTwo<String> lss = new LinkedStatckTwo<String>();
		for (String string : "this is some".split(" ")) {
			lss.push(string);
		}
		String s;
		while((s = lss.pop()) != null){
			System.out.println(s);
		}
		
	
		try {
			Class.forName("learn.generate.HoldTestDemo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		HoldTestDemo htd = new HoldTestDemo();
		htd.push("123");
		htd.push("234");
		
		htd.pop();
		htd.pop();
		htd.pop();
	}
}

class TestDemo{
	String str;
	TestDemo next;
	
	TestDemo(){
		str = null;
		next = null;
	}
	
	TestDemo(String str,TestDemo td){
		this.str = str;
		this.next = td;
	}
	boolean isend(){
		return str == null && next == null;
	}
	
}


class HoldTestDemo{
	TestDemo td = new TestDemo();
	
	public HoldTestDemo(){
		System.out.println("初始化HostTestDemo" + td);
	}
	
	void push(String str){
		System.out.println(str + "入栈");
		td = new TestDemo(str, td);
	}
	
	String pop(){
		String result = td.str;
		if(!td.isend()){
			td = td.next;
		}else{
			System.out.println("栈已空");
			return "栈已空";
		}
		System.out.println(result + "出栈");
		return result;
	}
	
	
}









package learn.generate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class LinkedStack<T> {
	public static class Node<U> {
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

	public Node<T> top = new Node<T>();

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
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String string : "this is some".split(" ")) {
			lss.push(string);
		}
		String s;
		while((s = lss.pop()) != null){
			System.out.println(s);
		}
		
		// 获取Class实例  
        Class<? extends LinkedStack> class1 = lss.getClass();  
        // 根据属性名取得该属性对应的Field对象  
        Field mapField = class1.getDeclaredField("top");  
        // 示范第一个方法：直接通过getType()取出Field的类型，只对普通类型的Field有效  
        Class<?> class2 = mapField.getType();  
        // 输出查看  
        System.out.println("属性名为map的属性类型为："+class2);  
          
        // 示范第二种方法：  
        Type mapMainType = mapField.getGenericType();  
        // 为了确保安全转换，使用instanceof  
        if (mapMainType instanceof ParameterizedType) {  
            // 执行强制类型转换  
            ParameterizedType parameterizedType = (ParameterizedType)mapMainType;  
            // 获取基本类型信息，即Map  
            Type basicType = parameterizedType.getRawType();  
            System.out.println("基本类型为："+basicType);  
            // 获取泛型类型的泛型参数  
            Type[] types = parameterizedType.getActualTypeArguments();  
            for (int i = 0; i < types.length; i++) {  
                System.out.println("第"+(i+1)+"个泛型类型是："+types[i]);  
            }  
        } else {  
            System.out.println("获取泛型类型出错!");  
        }  
	}
	
}

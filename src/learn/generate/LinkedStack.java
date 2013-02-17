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
		
		// ��ȡClassʵ��  
        Class<? extends LinkedStack> class1 = lss.getClass();  
        // ����������ȡ�ø����Զ�Ӧ��Field����  
        Field mapField = class1.getDeclaredField("top");  
        // ʾ����һ��������ֱ��ͨ��getType()ȡ��Field�����ͣ�ֻ����ͨ���͵�Field��Ч  
        Class<?> class2 = mapField.getType();  
        // ����鿴  
        System.out.println("������Ϊmap����������Ϊ��"+class2);  
          
        // ʾ���ڶ��ַ�����  
        Type mapMainType = mapField.getGenericType();  
        // Ϊ��ȷ����ȫת����ʹ��instanceof  
        if (mapMainType instanceof ParameterizedType) {  
            // ִ��ǿ������ת��  
            ParameterizedType parameterizedType = (ParameterizedType)mapMainType;  
            // ��ȡ����������Ϣ����Map  
            Type basicType = parameterizedType.getRawType();  
            System.out.println("��������Ϊ��"+basicType);  
            // ��ȡ�������͵ķ��Ͳ���  
            Type[] types = parameterizedType.getActualTypeArguments();  
            for (int i = 0; i < types.length; i++) {  
                System.out.println("��"+(i+1)+"�����������ǣ�"+types[i]);  
            }  
        } else {  
            System.out.println("��ȡ�������ͳ���!");  
        }  
	}
	
}

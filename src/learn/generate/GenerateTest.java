package learn.generate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenerateTest {

    
//    private Map<String , Integer> map = new HashMap<String, Integer>();  
      private LinkedStack<String> map = new LinkedStack<String>();
    public static void main(String[] args) throws SecurityException, NoSuchFieldException {  
        // ��ȡClassʵ��  
        Class<GenerateTest> class1 = GenerateTest.class;  
        // ����������ȡ�ø����Զ�Ӧ��Field����  
        Field mapField = class1.getDeclaredField("map");  
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
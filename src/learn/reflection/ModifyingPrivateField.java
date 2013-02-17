package learn.reflection;

import java.lang.reflect.Field;

class WithPrivateFinalField{
    private int i           = 9;
    private final String s  = "i am totally safe!";
    private String s2       = " am i safety?";
    @Override
	public String toString(){
        return "i:" + i + ",s:" + s + ",s2:" + s2;
    }
}

public class ModifyingPrivateField {
	public static void main(String[] args) throws Exception{
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);
        //˽���򲢲���ȫ
        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println(f.getInt(pf));//�������Ͷ��ж�Ӧ�ķ���
        f.setInt(pf, 47);
        System.out.println(pf);
        //˽��final �޷����ı�ֵ
        Field s = pf.getClass().getDeclaredField("s");
        s.setAccessible(true);
        System.out.println(s.get(pf));//String�����������Ա�������ø÷���get(Object,Object)��
        s.set(pf, "not, you are not");
        System.out.println(pf);
        //
        Field s2 = pf.getClass().getDeclaredField("s2");
        s2.setAccessible(true);
        System.out.println(s2.get(pf));
        s2.set(pf, "no you are not!");
        System.out.println(pf);

    }
}

package learn.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList���̰߳�ȫ�ġ�
 * ���ã�������Զ����д�����ĳ������绺��
 * �ײ�ԭ��ͨ���Եײ�������������ƣ�����������д��������
 */
public class CopyOnWriteArrayListDemo {
	public static void main(String[] args) {
		//��ͨlist �쳣 �������õ���������ʱɾ��
/*		List<String> list1 = new ArrayList<String>();
		list1.add("one");
		list1.add("two");
		list1.add("three");
		
		for (String string : list1) {
			//list1.add("ad"); ����addһ�����쳣������������û��add����,��ʹ��list.add�����while��ѭ����һֱ��list��Ԫ��
			//list1.remove(0); ɾ���쳣�����õ�������ɾ��
			System.out.println(list1.size());
		}
		*/
		
		//CopyOnWriteArrayList foreach���Բ��� iterator������remove��set
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		for (String string : list) {
			list.remove(0); 	//����ɾ��
			list.add("test");	//�������
			System.out.println(list.size());
		}
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
//			it.remove(); //����CopyOnWriteArrayList �ǲ������ڵ����������ɾ������
			list.add("test"); //������ѭ����һֱ���Ԫ�أ�while����������ֹ
		}
		System.out.println(list.size());
		
	}
}

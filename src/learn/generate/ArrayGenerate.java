package learn.generate;
/**
 * ���鷺�� �����κ����͵�
 * ֧�ֲ�ѯ����
 * @author biGpython
 *
 */
public class ArrayGenerate<T> {
	private T everything;

	public T getEverything() {
		return everything;
	}

	public void setEverything(T everything) {
		this.everything = everything;
		
	}
	
	
	
	
	public static void main(String[] args) {
		Integer[] is = {1,1,2,3,};
		ArrayGenerate<Integer[]> a = new ArrayGenerate<Integer[]>();
		a.setEverything(is);
		
		String[] s = {"aa","bb","dd"};
		ArrayGenerate<String[]> aString = new ArrayGenerate<String[]>();
		aString.setEverything(s);
		
		
		ArrayGenerate<String> ag = new ArrayGenerate<String>();
		ArrayGenerate<Object> ago = null;
		//ago = ag;  //������� �޷�ת�� ������ag �ķ�Χ
		
		ArrayGenerate<Integer> agi = new ArrayGenerate<Integer>();
		//���÷��ͷ���
		agi = give(30);
		System.out.println(agi.getEverything());
		
		
		//addAG(ag); //����
		addAG(agi);
		
		addAg(1);
		
		
	}
	
	public static <T extends Number> ArrayGenerate<T> give(T param){
		ArrayGenerate<T> ag = new ArrayGenerate<T>();
		ag.setEverything(param);
		return ag;
		
		
		
	}
	
	public static void addAG(ArrayGenerate<? extends Number> list){
		System.out.println("addAG() invoked");
	}
	
	
	public static <T extends Number> void addAg(T param){
		System.out.println(1111111111);
	}


}

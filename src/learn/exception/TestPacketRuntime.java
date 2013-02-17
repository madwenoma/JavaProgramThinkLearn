package learn.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * �������Ĺر��쳣���� ��װ��runtime exception
 * 
 * @author biGpython
 * 
 */
public class TestPacketRuntime {
	private BufferedReader reader = null;

	public TestPacketRuntime() throws Exception  {
		try {
			reader = new BufferedReader(new FileReader("d:\\BigFoot.ini"));
			//��һЩ�������� �׳�Exception�쳣
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			throw e;
		} catch (Exception e){
			try {
				reader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			} //���������쳣�ر���
			throw e;
		}
	}

	public String getLine() {
		String s = "";
		try {
			if (reader != null) {
				 s = reader.readLine();
			}
		} catch (IOException e) {
			throw new RuntimeException("��ȡһ���ı�����");
		}
		return s;
	}
	
	//�ͷ���Դ
	public void dispose(){
		try {
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("�ر�������");
		}
	}
	
	public static void main(String[] args) {
		try {
			TestPacketRuntime tpr = new TestPacketRuntime();
			try{
				System.out.println(tpr.getLine());
			} catch (Exception e){
				e.printStackTrace(System.out);
				
			}finally{
				tpr.dispose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}

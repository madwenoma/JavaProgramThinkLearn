package learn.others;

import java.security.MessageDigest;//�����װ��md�ļ��ܷ���

import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;


/**
 * ���ܹ�����
 * @author soft01
 *
 */
public class MD5Demo {
	public static String md5(String str){
		//ʹ��JDK�ṩ��
		try {
			MessageDigest md = MessageDigest.getInstance("md5");//md5����"SHA" md5�ǲ������
			byte[] dist = md.digest(str.getBytes());//���صȳ���
			//distתΪString�������ܺ������ʹ��base64 �㷨��ʾ��ת��Ϊ64��Ԫ�ַ��� base64�ǿ����
			//��վ�������붼������һ�������� ���޷�����ԭ���� So������
			BASE64Encoder baseEncode = new BASE64Encoder();
			return baseEncode.encode(dist);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		} 
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String str = MD5Demo.md5("4220282as");
	
		
		System.out.println(str);
	}
}

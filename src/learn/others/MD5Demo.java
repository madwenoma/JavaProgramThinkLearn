package learn.others;

import java.security.MessageDigest;//该类封装了md的加密方法

import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;


/**
 * 加密工具类
 * @author soft01
 *
 */
public class MD5Demo {
	public static String md5(String str){
		//使用JDK提供的
		try {
			MessageDigest md = MessageDigest.getInstance("md5");//md5或者"SHA" md5是不可逆的
			byte[] dist = md.digest(str.getBytes());//返回等长的
			//dist转为String：将加密后的数组使用base64 算法表示（转化为64个元字符） base64是可逆的
			//网站重设密码都是设置一个新密码 ，无法给出原密码 So～～～
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

package learn.thread;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Lock {

	/**
	 * ����Ƿ�����
	 * @return true������ ,false����
	 * */
	public abstract boolean isLocked() throws FileNotFoundException;

	/**
	 * ��ȡ����Դ
	 * @return true�ɹ�����Ŀ����Դ ,false��������ʧ��
	 * */
	public abstract boolean obtain() throws IOException;

	/**
	 * �ͷ���
	 * */
	public abstract void unlock();

}  
 
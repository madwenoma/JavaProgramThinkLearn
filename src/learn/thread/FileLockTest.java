package learn.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
public class FileLockTest {
  public static void main(String[] args) throws InterruptedException {
    File fdir=new File("D:\\1.txt");
    try {
      RandomAccessFile ranStream=new RandomAccessFile(fdir, "rw");
      FileChannel channel=ranStream.getChannel();
      FileLock lock=channel.tryLock();
      String str=null;
      for(int i = 0; i < 1000; i++){
    	  ranStream.writeUTF("httpd" + " i " + Thread.currentThread().getName());
    	  Thread.sleep(300);
    	  System.out.println("httpd");
      }
/*      while( ( str=( ranStream.readLine() ) ) != null){
      str= new String(str.getBytes("ISO-8859-1"),"gb2312"); 
      System.out.println(str);
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
   }*/
    lock.release();
    ranStream.close();
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  }
 }
}
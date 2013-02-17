package leanr.io.nio;
import java.util.*;
import java.nio.charset.Charset;


public class CharsetDemo {
	public static void main(String[] args) {
		SortedMap<String,Charset> charsets = Charset.availableCharsets();
        Iterator<String> it = charsets.keySet().iterator();
        while (it.hasNext()){
            String csName = it.next();
            System.out.print(csName);
            Iterator<String> i = charsets.get(csName).aliases().iterator();
            if (i.hasNext()){
                System.out.print(":");
               
                        
            }
            while (i.hasNext()){
                System.out.print(i.next());
                if(i.hasNext()){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        
	}
}

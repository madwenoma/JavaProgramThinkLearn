package leanr.io;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * p564
 * @author biGpython
 *
 */

public class TextFile extends ArrayList<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = "";
			try {
				while ((line = br.readLine()) != null) {
					sb.append(line);
					sb.append("\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				br.close();
			}

		} catch (IOException e) {
			throw new RuntimeException();
		}
		return sb.toString();
	}


    public void write(String fileName, String text){
    
    }

    public void write(String fileName){
    
    }

    public TextFile(String fileName, String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals(""))
            remove(0);
    }

    public TextFile(String fileName){
    
    }
    
    public static void main(String[] args){
        TextFile tf = new TextFile("C:\\Documents and Settings\\Administrator\\桌面\\自卑与超越.txt","——");
        System.out.println(tf.size());
    }



















}

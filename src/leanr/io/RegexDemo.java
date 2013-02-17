package leanr.io;

import java.util.Scanner;

public class RegexDemo {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    
    String reg = "^(\\d+,){3}\\d+$";
    // "23,45,233,553"
    while(true){
      System.out.print(" ‰»Î ˝æ›£∫");
      String str = console.nextLine();
      boolean match = str.matches(reg);
      if(match){
        String[] data = str.split(",");
        int n = Integer.parseInt(data[0]);
        System.out.println(n);
        break;
      }
    }

  }

}

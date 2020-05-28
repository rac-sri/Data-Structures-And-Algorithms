package threestar;

import java.io.*;
import java.util.*;

public class TimeConversion {

  static String timeConversion(String s) {
    String ss = s.substring(s.length() - 2);
    String hr = s.substring(0, 2);
    s = s.substring(2, s.length() - 2);
    int n = Integer.parseInt(hr);
    if (ss.equals("PM") && n < 12) {
      n += 12;
      hr = Integer.toString(n);
    } else if (ss.contentEquals("AM") && n == 12) hr = "00";
    s = hr + s;
    System.out.println(s);
    return s;
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(
      new FileWriter("TimeConversion.txt")
    );
    String s = scan.nextLine();
    String result = timeConversion(s);
    bw.write(result);
    bw.newLine();
    bw.close();
  }
}

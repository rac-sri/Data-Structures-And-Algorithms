import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    int underscore = sc.nextInt();
    int mismatch = sc.nextInt();

    int size1 = s1.length();

    String s3 = "";

    for (int x = 0; x < size1; x++) {
      int charFetch = s1.charAt(x);
      boolean matched = false;

      for (int y = 0; y < s2.length(); y++) {
        if (charFetch == s2.charAt(y)) {
          matched = true;
          s3 += s2.charAt(y);
          s2 = s2.substring(0, y) + s2.substring(y + 1);
          break;
        }
      }

      if (!matched) {
        s3 += '_';
      }
    }

    for (int y = 0; y < s2.length(); y++) {
      s3 += "_";
      s2 = s2.substring(0, y) + s2.substring(y + 1);
    }
    System.out.println(s3);
    int score = 0;

    for (int x = 0; x < size1; x++) {
      if (s1.charAt(x) != s3.charAt(x)) {
        if (s3.charAt(x) == '_') {
          score += underscore;
        } else score += mismatch;
      }
    }

    System.out.println(score);
  }
}
// draw
// dew
// 2
// 3

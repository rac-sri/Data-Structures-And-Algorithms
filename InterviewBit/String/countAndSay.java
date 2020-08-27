// Count And Say
// Asked in:
// Facebook
// Amazon
// The count-and-say sequence is the sequence of integers beginning as follows:

// 1, 11, 21, 1211, 111221, ...
// 1 is read off as one 1 or 11.
// 11 is read off as two 1s or 21.

// 21 is read off as one 2, then one 1 or 1211.

// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

// Example:

// if n = 2,
// the sequence is 11.

public class Solution {

  public String countAndSay(int A) {
    int count = 0;

    String s = "1";
    String temp = "";

    if (A == 1) return s;

    s = "11";

    if (A == 2) return s;

    count = 0;

    char value = '1';

    for (int x = 3; x <= A; x++) {
      int y = 0;
      for (; y < s.length(); y++) {
        if (value == s.charAt(y)) {
          count++;
        } else {
          temp += String.valueOf(count) + value;
          //  System.out.println(temp + " ok temp is this");
          value = s.charAt(y);
          count = 0;
          //    System.out.println(value + "hehhheeyy");
          y--;
        }
      }

      // now y = a.length()  - 1
      if (count > 0) {
        temp += String.valueOf(count) + value;
      }

      s = temp;
      temp = "";
      value = s.charAt(0);
      //    System.out.println(s + " " + value);
      count = 0;
    }

    return s;
  }
}

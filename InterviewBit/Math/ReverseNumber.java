// Reverse integer
// Asked in:
// HCL
// Bloomberg
// Reverse digits of an integer.

// Example1:

// x = 123,

// return 321
// Example2:

// x = -123,

// return -321

// Return 0 if the result overflows and does not fit in a 32 bit signed integer

public class Solution {

  public int reverse(int A) {
    StringBuffer s = new StringBuffer(String.valueOf(A));
    try {
      if (A > 0) {
        s.reverse();
        return Integer.parseInt(s.toString());
      }
      if (A < 0) {
        s.deleteCharAt(0);
        s.reverse();
        return -1 * Integer.parseInt(s.toString());
      }
    } catch (Exception e) {
      return 0;
    }

    return 0;
  }
}

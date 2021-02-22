public class Solution {

  public int numSetBits(long a) {
    StringBuilder s = new StringBuilder();

    while (a > 0) {
      long d = a % 2;
      a = a / 2;
      s.insert(0, d);
    }

    int count = 0;
    for (int x = 0; x < s.length(); x++) {
      if (s.charAt(x) == '1') {
        count++;
      }
    }
    return count;
  }
}

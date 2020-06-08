import java.io.*;
import java.util.*;

class checkTwoArrays {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long t = sc.nextLong();
    while (t-- > 0) {
      int n = sc.nextInt();
      long a[] = new long[n];
      long b[] = new long[n];

      for (int i = 0; i < n; i++) {
        a[i] = sc.nextLong();
      }

      for (int i = 0; i < n; i++) {
        b[i] = sc.nextLong();
      }
      System.out.println(check(a, b, n) == true ? 1 : 0);
    }
  }

  public static boolean check(long arr[], long brr[], int n) {
    //Your code here
    HashMap<Long, Integer> h1 = new HashMap<Long, Integer>();
    HashMap<Long, Integer> h2 = new HashMap<Long, Integer>();
    for (Long i : arr) {
      Integer c = h1.get(i);

      if (h1.get(i) == null) {
        h1.put(i, 1);
      } else {
        h1.put(i, ++c);
      }
    }

    for (Long i : brr) {
      Integer c = h2.get(i);

      if (h2.get(i) == null) {
        h2.put(i, 1);
      } else {
        h2.put(i, ++c);
      }
    }

    if (h1.equals(h2)) return true; else return false;
  }
}

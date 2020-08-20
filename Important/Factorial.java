// https://www.youtube.com/watch?v=2fYZERB2Yng

public class Solution {

  public int uniquePaths(int A, int B) {
    int n = A + B;
    System.out.print(fact(A));
    // long ans = fact(n)/(fact(A)*fact(n-A));
    return 0;
  }

  String fact(int n) {
    int arr[] = new int[1000];

    Arrays.fill(arr, 0);
    arr[0] = 1;
    int len = 1;
    int q = 2; // number to multiply
    int counter = 0;
    int num = 0;

    while (q <= n) {
      num = 0;
      counter = 0;
      while (counter < len) {
        arr[counter] *= q;
        arr[counter] += num;
        num = arr[counter] / 10;
        arr[counter] = arr[counter] % 10;
        counter++;
      }

      while (num != 0) {
        arr[len] = num % 10;
        num = num / 10;
        len++;
      }

      q++;
    }
    String s = "";
    while (len >= 0) {
      s += arr[len];
      len--;
    }
    return s;
  }
}

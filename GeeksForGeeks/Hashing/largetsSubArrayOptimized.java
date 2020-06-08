package GeeksForGeeks.Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class largetsSubArrayOptimized {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int length = sc.nextInt();
    int arr[] = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = sc.nextInt();
    }

    /*
    prefix(i) = arr[0] + arr[1] +...+ arr[i]
    prefix(j) = arr[0] + arr[1] +...+ arr[j], j>i
    ifprefix(i) == prefix(j) then prefix(j) - prefix(i) = 0 that means arr[i+1] + .. + arr[j] = 0,
    So a sub-array has zero sum , and the length of that sub-array is j-i+1
    */
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    int sum = 0;
    int maxLength = 0;

    for (int x = 0; x < length; x++) {
      sum += arr[x];

      if (arr[x] == 0 && maxLength == 0) {
        maxLength = 1;
      }

      if (sum == 0) {
        maxLength = x + 1;
      }

      Integer exist = hash.get(sum);
      if (exist != null) {
        hash.put(sum, Math.max(maxLength, x - exist + 1));
      } else {
        hash.put(sum, x);
      }
    }
  }
}

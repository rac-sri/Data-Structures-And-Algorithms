package GeeksForGeeks.Hashing;

import java.util.Scanner;

public class largetsSubArray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int length = sc.nextInt();
    int arr[] = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = sc.nextInt();
    }
    int max = 0;
    for (int i = 0; i < length; i++) {
      int sum = 0;
      for (int j = i; j < length; j++) {
        sum += arr[j];
        if (sum == 0) {
          max = Math.max(sum, j - i + 1);
        }
      }
    }
    sc.close();
    System.out.println(max);
  }
}

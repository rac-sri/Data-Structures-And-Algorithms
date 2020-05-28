package threestar;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class GameOfTwoStacks {

  /*
   * Complete the twoStacks function below.
   */
  static int twoStacks(int x, int[] a, int[] b) {
    int sum = 0;
    int counter = 0;
    boolean aa = false;
    int aCounter = 0;
    int bCounter = 0;
    while (sum < x) {
      counter++;
      System.out.print("run");
      if (a[aCounter] < b[bCounter]) {
        sum = sum + a[aCounter];
        if (aCounter < a.length - 1) aCounter++; else {
          aa = true;
          break;
        }
      } else if (a[aCounter] > b[bCounter]) {
        sum = sum + b[bCounter];
        if (bCounter < b.length - 1) bCounter++; else {
          aa = true;
          break;
        }
      } else {
        int i = which(a, b, aCounter, bCounter);
        if (i == 1) {
          sum = sum + a[aCounter];
          if (aCounter < a.length - 1) aCounter++; else {
            aa = true;
            break;
          }
        }
        if (i == 0) {
          sum = sum + b[bCounter];
          if (bCounter < b.length - 1) bCounter++; else {
            aa = true;
            break;
          }
        }
      }
      System.out.println(sum);
    }
    if (!aa) counter--;

    return counter;
  }

  public static int which(int a[], int b[], int aCounter, int bCounter) {
    int x;
    if (aCounter < a.length - 1) aCounter++;
    if (bCounter < b.length - 1) bCounter++;
    if (a[aCounter] < b[bCounter]) x = 1; else if (
      a[aCounter] > b[bCounter]
    ) x = 0; else {
      x = which(a, b, aCounter, bCounter);
    }
    return x;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
      new FileWriter("GameOfTwostacks.txt")
    );

    int g = Integer.parseInt(scanner.nextLine().trim());

    for (int gItr = 0; gItr < g; gItr++) {
      String[] nmx = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nmx[0].trim());

      int m = Integer.parseInt(nmx[1].trim());

      int x = Integer.parseInt(nmx[2].trim());

      int[] a = new int[n];

      String[] aItems = scanner.nextLine().split(" ");

      for (int aItr = 0; aItr < n; aItr++) {
        int aItem = Integer.parseInt(aItems[aItr].trim());
        a[aItr] = aItem;
      }

      int[] b = new int[m];

      String[] bItems = scanner.nextLine().split(" ");

      for (int bItr = 0; bItr < m; bItr++) {
        int bItem = Integer.parseInt(bItems[bItr].trim());
        b[bItr] = bItem;
      }

      int result = twoStacks(x, a, b);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();
  }
}

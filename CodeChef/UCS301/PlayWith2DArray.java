import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class PlayWith2DArray {
  static int count = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    count = 0;
    int n = sc.nextInt();
    int arr[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < n ; i++) {
      row(arr, n, i);
      column(arr, n, i);
    }
    System.out.println(count);
    // for (int i = 0; i < n; i++) {
    //   for (int j = 0; j < n; j++) {
    //     System.out.print(arr[i][j] + " ");
    //   }
    // }
  }

  static void row(int arr[][], int n, int row) {
    int x, y, min, yHold = 0;
    
    for (x = 0; x < n; x++) {
      boolean yes = false;
      min = arr[row][x];
      
      for (y = row; y < n; y++) {
        if (arr[y][x] < min) {
          min = arr[y][x];
          yHold = y;
          yes = true;
        }
      }
      if (yes) {
        int temp = arr[row][x];
        arr[row][x] = min;
        arr[yHold][x] = temp;
        count++;
      }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
         System.out.print(arr[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println("row done");

  }

  static void column(int arr[][], int n, int column) {
    int x, y, min, yHold = 0;
    for (x = 0; x < n; x++) {
      boolean yes = false;
      min = arr[x][column];
      for (y = column; y < n; y++) {
        if (arr[x][y] < min) {
          min = arr[x][y];
          yHold = y;
          yes = true;
        }
      }
      if (yes) {
        int temp = arr[x][column];
        arr[x][column] = min;
        arr[x][yHold] = temp;
        count++;
      }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
         System.out.print(arr[i][j] + " ");
        } System.out.println();
      }
      System.out.println("column done");
  }
}

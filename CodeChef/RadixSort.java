import java.io.*;
import java.util.*;
import java.util.Scanner;

class RedixSort {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    redixSort(arr, n);
    for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
  }

  static void redixSort(int arr[], int n) {
    int max = getMax(arr);
    for (int pos = 1; max / pos > 0; pos *= 10) {
      CountSort(arr, n, pos);
    }
  }

  static void CountSort(int arr[], int n, int pos) {
    int Count[] = new int[10];
    int output[] = new int[n];
    Arrays.fill(Count, 0);
    for (int i = 0; i < n; i++) {
      ++Count[(arr[i] / pos) % 10];
    }
    for (int i = 1; i < 10; i++) {
      Count[i] = Count[i] + Count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
      output[--Count[(arr[i] / pos) % 10]] = arr[i];
    }

    for (int i = 0; i < n; i++) {
      arr[i] = output[i];
    }
  }

  static int getMax(int arr[]) {
    int max = arr[0];
    for (int i : arr) {
      if (i > max) max = i;
    }
    return max;
  }
}

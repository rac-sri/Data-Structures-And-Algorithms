// Relative Sorting
// Given two integer arrays. Sort the first array such that all the relative positions of the elements in the first array are the same as the elements in the second array.
// See example for better understanding.

// Input:
// The first line of input contains the number of test cases. For each testcase, the first line of input contains the length of arrays N and M and the next two lines contain N and M elements respectively.

// Output:
// For each testcase, in a new line, print the elements of A1 sorted relatively according to A2.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function sortA1ByA2() which takes the array A1[], array A2[] and their respective size N and M as inputs and sorts the array A1[] such that the relative positions of the elements in A1[] are same as the elements in A2[]. For the elements not present in A2[] but in A1[], it appends them at the last in increasing order.

// Expected Time Complexity: O(NlogN).
// Expected Auxiliary Space: O(N).

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N,M  ≤ 106
// 1 ≤ A1[], A2[] <= 106

// Example:
// Input:
// 2
// 11 4
// 2 1 2 5 7 1 9 3 6 8 8
// 2 1 8 3
// 11 4
// 2 1 2 5 7 1 9 3 6 8 8
// 99 22 444 56

// Output:
// 2 2 1 1 8 8 3 5 6 7 9
// 1 1 2 2 3 5 6 7 8 8 9

// Explanation:
// Testcase 1: Array elements of A1[] are sorted according to A2[]. So 2 comes first, then 1 comes, then comes 8, then finally 3 comes, now we append remaining elements in sorted order.
// Testcase 2: No A2 elements are in A1 so we cannot sort A1 according to A2. Hence we sort the elements in non-decreasing order.

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class relativeSorting {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int a1[] = new int[n];
      int a2[] = new int[m];

      for (int i = 0; i < n; i++) {
        a1[i] = sc.nextInt();
      }

      for (int i = 0; i < m; i++) {
        a2[i] = sc.nextInt();
        sortA1byA2(a1, n, a2, m);
      }
    }
    sc.close();
  }

  public static void sortA1byA2(int A1[], int N, int A2[], int M) {
    TreeMap<Integer, Integer> mapL = new TreeMap<Integer, Integer>();
    Arrays.sort(A1);
    for (int x = 0; x < N; x++) {
      if (mapL.get(A1[x]) == null) {
        mapL.put(A1[x], 1);
      } else {
        mapL.put(A1[x], mapL.get(A1[x]) + 1);
      }
    }

    int arr[] = new int[N];
    int position = 0;

    for (int x = 0; x < M; x++) {
      int key = A2[x];
      if (mapL.get(key) != null) {
        int count = mapL.get(key);
        for (int i = 0; i < count; i++) {
          arr[position] = key;
          position++;
        }
        mapL.put(key, null);
      }
    }

    for (int x = 0; x < N; x++) {
      int key = A1[x];
      if (mapL.get(key) != null) {
        int count = mapL.get(key);
        for (int i = 0; i < count; i++) {
          arr[position] = key;
          position++;
        }
        mapL.put(key, null);
      }
    }

    System.out.println();
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}

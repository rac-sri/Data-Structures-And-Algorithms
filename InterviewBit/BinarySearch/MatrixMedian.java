// Given a matrix of integers A of size N x M in which each row is sorted.

// Find an return the overall median of the matrix A.

// Note: No extra memory is allowed.

// Note: Rows are numbered from top to bottom and columns are numbered from left to right.



// Input Format

// The first and only argument given is the integer matrix A.
// Output Format

// Return the overall median of the matrix A.
// Constraints

// 1 <= N, M <= 10^5
// 1 <= N*M  <= 10^6
// 1 <= A[i] <= 10^9
// N*M is odd
// For Example

// Input 1:
//     A = [   [1, 3, 5],
//             [2, 6, 9],
//             [3, 6, 9]   ]
// Output 1:
//     5
// Explanation 1:
//     A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
//     Median is 5. So, we return 5.

// Input 2:
//     A = [   [5, 17, 100]    ]
// Output 2:
//     17 ``` Matrix=

public class Solution {

  public int findMedian(int[][] A) {
    int m = A.length, n = A[0].length;
    int min = 0, max = 0;

    for (int i = 0; i < m; i++) {
      min = Math.min(min, A[i][0]);
      max = Math.max(max, A[i][n - 1]);
    }

    int median = (1 + m * n) / 2;

    while (min < max) {
      int count = 
      int mid = min + (max - min) / 2;

      for (int i = 0; i < m; i++) {
        int found = Arrays.binarySearch(A[i], mid);

        if (found < 0) {
          // insertion value returned in this case ( Read the docs)

          found = Math.abs(found) - 1;
        } else {
          // there is no gaurantee that its the only recurrence or its the first recurrence

          while (found < n && A[i][found] == mid) {
            found++;
          }
        }

        count += found;
      }

      if (count < median) min = mid + 1; else max = mid;
    }

    return min;
  }
}

// Search for a Range
// Asked in:
// Google
// Microsoft
// Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

// Your algorithm’s runtime complexity must be in the order of O(log n).

// Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].

// Input Format

// The first argument given is the integer array A.
// The second argument given is the integer B.
// Output Format

//  Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
// Constraints

// 1 <= N <= 10^6
// 1 <= A[i], B <= 10^9
// For Example

// Input 1:
//     A = [5, 7, 7, 8, 8, 10]
//     B = 8
// Output 1:
//     [3, 4]
// Explanation 1:
//     First occurence of 8 in A is at index 3
//     Second occurence of 8 in A is at index 4
//     ans = [3, 4]

// Input 2:
//     A = [5, 17, 100, 111]
//     B = 3
// Output 2:
//     [-1, -1]

public class Solution {

  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  public int[] searchRange(final int[] A, int B) {
    int start = 0;
    int end = A.length;
    int mid;

    mid = Arrays.binarySearch(A, B);

    if (mid < 0) {
      int Arr[] = { -1, -1 };
      return Arr;
    }

    int temp, temp2;
    temp = temp2 = mid;
    int count = 0;

    while (true) {
      if (++mid < A.length && A[mid] == B) {
        count++;
      } else {
        end = count + temp;
        break;
      }
    }

    count = 0;

    while (true) {
      if (--temp >= 0 && A[temp] == B) {
        count++;
      } else {
        start = temp2 - count;
        break;
      }
    }

    int Arr[] = { start, end };
    return Arr;
  }
}

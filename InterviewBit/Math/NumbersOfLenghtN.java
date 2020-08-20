// Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

//  NOTE: All numbers can only have digits from the given set.
// Examples:

// 	Input:
// 	  0 1 5
// 	  1
// 	  2
// 	Output:
// 	  2 (0 and 1 are possible)

// 	Input:
// 	  0 1 2 5
// 	  2
// 	  21
// 	Output:
// 	  5 (10, 11, 12, 15, 20 are possible)
// Constraints:

//     1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9

public class Solution {

  public int solve(int[] A, int B, int C) {
    if (A.length == 0) return 0;

    int temp1 = C;
    int count = 0;
    int ans = 0;

    while (temp1 > 0) {
      count++;
      temp1 = temp1 / 10;
    }

    if (count < B) {
      return 0;
    } else if (count > B) {
      if (A[0] > 0) {
        ans = (int) Math.pow(A.length, B);
      } else {
        ans = (A.length - 1) * (int) Math.pow(A.length, B - 1);
      }

      if (B == 1 && A[0] == 0) {
        ans++;
      }

      return ans;
    } else {
      if (B == 1) {
        for (int x = 0; x < A.length; x++) {
          if (A[x] < C) {
            ans++;
          }
        }
        return ans;
      } else {
        int[] temp = new int[B];
        for (int i = B - 1; i >= 0; i--) {
          temp[i] = C % 10;
          C = C / 10;
        }
        // now we have the C stored as array.

        count = 0;
        for (int x = 0; x < A.length; x++) {
          if (A[x] == 0) {
            continue;
          }
          if (A[x] > temp[0]) {
            break;
          }
          count++;
        }

        ans += (count) * Math.pow(A.length, B - 1);

        //System.out.println(ans+ " is the ans");
        // now we have all numbers who have the same length and start with the same digit or smaller digit

        int flag = 0, k = 0; // k to keep track of digit in c

        // is my first digit == temp[0] i.e first digit so need furthur calculation. eg. if 24 is in array and c is 23. Then we need to remove 24;

        for (int j = 0; j < A.length; j++) {
          if (A[j] == temp[k]) {
            flag = 1;
          }
        }

        k++;

        while (flag == 1 && k <= B - 1) {
          flag = 0;
          int count2 = 0;
          for (int x = 0; x < A.length; x++) {
            if (A[x] > temp[k]) {
              count2++;
            }
            if (A[x] == temp[k]) {
              flag = 1;
            }
          }
          ans -= ((count2) * (Math.pow(A.length, B - k - 1)));
          k++;
        }
        if (k == B && flag == 1) {
          ans--;
        }
        // to remove the value which is equal to c
      }
    }

    return ans;
  }
}

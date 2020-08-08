// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// You need to do this in place.

// Note that if you end up using an additional array, you will only receive partial score.

// Example:

// If the array is

// [
//     [1, 2],
//     [3, 4]
// ]
// Then the rotated array becomes:

// [
//     [3, 1],
//     [4, 2]
// ]

// ***************************************************
// mark down array as suppose 3*3
// 1 2 3
// 4 5 6
// 7 8 9
// so when rotate 90 clockwise
// 7 4 1
// 8 5 2
// 9 6 3

// so what i notice is that after transposing
// 1 4 7
// 2 5 8
// 3 6 9

// **************************************************

public class Solution {

  public void rotate(ArrayList<ArrayList<Integer>> a) {
    int n = a.size();

    for (int x = 0; x < n; x++) {
      for (int y = x; y < n; y++) {
        int temp = a.get(x).get(y);
        a.get(x).set(y, a.get(y).get(x));
        a.get(y).set(x, temp);
      }
    }

    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n / 2; y++) {
        int temp = a.get(x).get(y);
        a.get(x).set(y, a.get(x).get(n - 1 - y));
        a.get(x).set(n - 1 - y, temp);
      }
    }
  }
}

// Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

// Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.

// Input Format:

// The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
// Output Format:

// Return a 2-d matrix that satisfies the given conditions.
// Constraints:

// 1 <= N, M <= 1000
// 0 <= A[i][j] <= 1
// Examples:

// Input 1:
//     [   [1, 0, 1],
//         [1, 1, 1],
//         [1, 1, 1]   ]

// Output 1:
//     [   [0, 0, 0],
//         [1, 0, 1],
//         [1, 0, 1]   ]

// Input 2:
//     [   [1, 0, 1],
//         [1, 1, 1],
//         [1, 0, 1]   ]

// Output 2:
//     [   [0, 0, 0],
//         [1, 0, 1],
//         [0, 0, 0]   ]

public class Solution {

  public void setZeroes(ArrayList<ArrayList<Integer>> a) {
    ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();

    for (int index = 0; index < a.size(); index++) {
      b.add(new ArrayList<Integer>(a.get(index)));
    }
    //  b.get(0).set(0,10);
    //  System.out.println(a);
    //  System.out.println(b);

    for (int r = 0; r < a.size(); r++) {
      for (int c = 0; c < a.get(0).size(); c++) {
        if (a.get(r).get(c) == 0) {
          rowZero(b, r, c);
          columnZero(b, r, c);
        }
      }
    }

    a = b;
    System.out.println("a is " + a);
    System.out.println("b is" + b);
  }

  public void rowZero(ArrayList<ArrayList<Integer>> a, int row, int column) {
    for (int c = 0; c < a.get(row).size(); c++) {
      a.get(row).set(c, 0);
    }
  }

  public void columnZero(ArrayList<ArrayList<Integer>> a, int row, int column) {
    for (int r = 0; r < a.size(); r++) {
      a.get(r).set(column, 0);
    }
  }
}

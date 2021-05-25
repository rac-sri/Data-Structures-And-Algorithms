public class Solution {

  public ArrayList<ArrayList<String>> solveNQueens(int a) {
    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    ArrayList<String> cur = new ArrayList<String>();
    StringBuilder line = new StringBuilder();
    // creating one line of dots
    for (int i = 0; i < a; i++) {
      line.append(".");
    }

    // creating a matrix of dots
    for (int i = 0; i < a; i++) {
      cur.add(new String(line.toString()));
    }

    solveNQueensHelper(a, 0, cur, res);
    return res;
  }

  void solveNQueensHelper(
    int a,
    int col,
    ArrayList<String> cur,
    ArrayList<ArrayList<String>> res
  ) {
    if (col >= a) {
      // base case
      res.add(new ArrayList<String>(cur));
    } else {
      // for each choices
      for (int row = 0; row < a; row++) {
        // choose
        if (isSafe(row, col, cur)) {
          place(cur, row, col, 'Q');

          // explore
          solveNQueensHelper(a, col + 1, cur, res);

          // unchoose
          place(cur, row, col, '.');
        }
      }
    }
  }

  void place(ArrayList<String> cur, int row, int col, char ch) {
    StringBuilder sb = new StringBuilder(cur.get(row));
    sb.setCharAt(col, ch);
    cur.set(row, sb.toString());
  }

  boolean isSafe(int row, int col, ArrayList<String> cur) {
    // check rows
    for (int i = 0; i < col; i++) {
      if (cur.get(row).charAt(i) == 'Q') return false;
    }

    // check upper diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (cur.get(i).charAt(j) == 'Q') return false;
    }

    // check lower diagonal
    for (int i = row, j = col; i < cur.size() && j >= 0; i++, j--) {
      if (cur.get(i).charAt(j) == 'Q') return false;
    }

    return true;
  }
}

public class Solution {

  public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    for (int k = 0; k < A; k++) {
      ArrayList<Integer> row = new ArrayList<>();
      for (int m = 0; m < A; m++) {
        row.add(0);
      }
      matrix.add(row);
    }

    ArrayList<Integer> results = new ArrayList<>();
    int[] dx = new int[] { 1, 0, -1, 0 };
    int[] dy = new int[] { 0, 1, 0, -1 };

    int x = 0, y = 0;
    int steps = 1;
    int cnt = 1;
    int limit = A * A;
    for (int r = 0; r < A / 2; r++) {
      for (int d = 0; d < 4; d++) {
        for (int i = 0; i < A - steps; i++) {
          matrix.get(y).set(x, cnt++);
          x += dx[d];
          y += dy[d];
          if (cnt > limit) break;
        }
        if (cnt > limit) break;
      }
      if (cnt > limit) break;
      steps += 2;
      x += 1;
      y += 1;
    }
    if (A % 2 != 0 && cnt <= limit) {
      x = A / 2;
      y = x;
      for (int i = 0; i <= A - steps; i++) {
        matrix.get(y).set(x, cnt++);
        x++;
        if (cnt > limit) break;
      }
    }
    return matrix;
  }
}

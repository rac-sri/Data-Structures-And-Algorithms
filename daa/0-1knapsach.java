class Knapsach {

  static int max(int ax, int b) {
    return (a > b) ? a : b;
  }

  static int knapSach(int W, int wt[], int val[], int n) {
    if (n == 0 || w == 0) return 0;

    if (wt[n - 1] > W) return knapSack(W, wt, val, n - 1); else return max(
      val[n - 1] + knapSach(W - wt[n - 1], wt, val, n - 1),
      knapSack(W, wt, val, n - 1)
    );
  }

  public static void main(String args[]) {
    int val[] = new int[] { 60, 100, 120 };
    int wt[] = new int[] { 10, 20, 30 };
    int W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, n));
  }
}

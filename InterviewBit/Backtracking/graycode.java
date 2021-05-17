public class Solution {
  static int num;

  public ArrayList<Integer> grayCode(int a) {
    ArrayList<Integer> res = new ArrayList<Integer>();

    // num is passed by reference to keep track of current code
    num = 0;
    grayCodeUtil(res, a);
    return res;
  }

  static void grayCodeUtil(ArrayList<Integer> res, int n) {
    // base case when we run out of bits to process.
    if (n == 0) {
      res.add(num);
      return;
    }

    // ignore the bit
    grayCodeUtil(res, n - 1);

    //invert the bit
    num = num ^ (1 << (n - 1));
    grayCodeUtil(res, n - 1);
  }
}

public class Solution {

  public int threeSumClosest(ArrayList<Integer> A, int B) {
    Collections.sort(A);
    double result = A.get(0) + A.get(1) + A.get(A.size() - 1);

    for (int i = 0; i < A.size() - 2; i++) {
      int low = i + 1;
      int high = A.size() - 1;
      while (low < high) {
        double sum = A.get(i) + A.get(low) + A.get(high);
        if (sum > B) {
          high--;
        } else {
          low++;
        }

        if (Math.abs(result - B) > Math.abs(sum - B)) {
          result = sum;
        }
      }
    }
    return (int) result;
  }
}

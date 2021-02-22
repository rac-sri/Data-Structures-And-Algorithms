public class Solution {

  public int maxArea(ArrayList<Integer> A) {
    int low = 0;
    int high = A.size() - 1;
    int maxArea = 0;

    while (low < high) {
      if (A.get(low) < A.get(high)) {
        maxArea = Math.max(maxArea, A.get(low) * (high - low));
        low++;
      } else {
        maxArea = Math.max(maxArea, A.get(high) * (high - low));
        high--;
      }
    }

    return maxArea;
  }
}
